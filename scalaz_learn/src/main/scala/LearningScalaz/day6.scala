package LearningScalaz

import CommonPlay.ChapterApp

import scala.annotation.tailrec

/**
  * Created by archeg on 12/24/2015.
  */
object day6 extends ChapterApp {
  import scalaz._
  import Scalaz._
  --------------("for syntax again")

  // Haskell's do notation:
  // foo = do
  // x <- Just 3
  // y <- Just "!"
  // Just (show x ++ y)

  def foo = for {
    x <- 3.some
    y <- "!".some
  } yield x.shows + y

  // Notice the difference, in scala yield type is the value, and then for expression wraps it in monad Maybe
  // When in Haskell you write 'Just (show x ++ y)' explicitly mentioning monad Just

  // But what if there's a function that returns monadic value?
  // Haskell:
  // in3 start = do
  // first <- moveKnight start
  // second <- moveKnight first
  // moveKnight second

  // Can't do that in scala. But we can extract the value from moveKnight second, and re-wrapping it using yield:
  case class KnightPos(c: Int, r: Int) {
    def move: List[KnightPos] =
      for {
        ci <- List(-2, -1, 1, 2)
        cj <- List(-2, -1, 1, 2) if math.abs(ci) != math.abs(cj)
        KnightPos(c2, r2) = KnightPos(c + ci, r + cj)
        if ((1 |-> 8) contains c2) && ((1 |-> 8) contains r2)
      } yield KnightPos(c2, r2)

    // See this:
    def in3: List[KnightPos] =
      for {
        first <- move
        second <- first.move
        third <- second.move
      } yield third

    def canReachIn3(end: KnightPos): Boolean = in3 contains end
  }

  =============================================("Writer? I hardly knew her!")

  // LYAHFGG:
  // Whereas the Maybe monad is for values with an added context of failure,
  // and the list monad is for nondeterministic values, Writer monad is for values
  // that have another value attached that acts as a sort of log value.

  {
    def isBigGang(x: Int): (Boolean, String) =
      (x > 9, "Compared gang size to 9.")

    implicit class PairOps[A](pair: (A, String)) {
      def applyLog[B](f: A => (B, String)): (B, String) = {
        val (x, log) = pair
        val (y, newlog) = f(x)
        (y, log ++ newlog)
      }
    }

    out((3, "Smallish gang.") applyLog isBigGang)
  }

  // Here's how we can generalize the log to a Monoid:

  {
    def isBigGang(x: Int): (Boolean, String) =
      (x > 9, "Compared gang size to 9.")

    implicit class PairOps[A, B: Monoid](pair: (A, B)) {
      def applyLog[C](f: A => (C, B)): (C, B) = {
        val (x, log) = pair
        val (y, newlog) = f(x)
        (y, log |+| newlog)
      }
    }

    out((3, "Smallish gang.") applyLog isBigGang)
  }

  --------------("Writer")

  {
    // LYAHFGG:
    // To attach a monoid to a value, we just need to put them together in a
    // tuple. The `Writer w a` type is just `a newtype` wrapper for this.

    // In Scalaz, the equivalent is called Writer:
    type Writer[+W, +A] = WriterT[Id, W, A]

    // Here's the simplified version of WriterT:
    sealed trait WriterT[F[+_], +W, +A] { self =>
      val run: F[(W, A)]

      def written(implicit F: Functor[F]): F[W] =
        F.map(run)(_._1)
      def value(implicit F: Functor[F]): F[A] =
        F.map(run)(_._2)
    }
  }

  {
    // Writer is created like this:
    out(3.set("Smallish gang."))

    // The operator in question is part of WriterOps:
    final class WriterOps[A](self: A) {
      def set[W](w: W): Writer[W, A] = WriterT.writer(w -> self)

      def tell: Writer[A, Unit] = WriterT.tell(self)
    }
  }

  {
    out(3.set("something"))
    out("something".tell)            // Writer with log with no value

    // What if we want to get hte identity value like
    // return 3 :: Writer String Int?
    // Monad[F[_]] expects a type constructor with one parameter,
    // but Writer[+W, +A] takes two.
    // There's ahelper type in Scalaz called MonadTell (in scalaz 7.0 it was MonadWriter), to help us out:

    // Doesn't look like it works anymore. MonadTell is now of F[_]
//    out(MonadTell[Writer, String])
//    out(MonadTell[Writer, String].point(3).run)
  }

  --------------("Using for syntax with Writer")

  {
    // LYAHFGG:
    // Now that we have a Monad instance, we're free to use do notation for Writer values.

    def logNumber(x: Int): Writer[List[String], Int] =
      x.set(List("Got number: " + x.shows))

    def multWithLog: Writer[List[String], Int] = for {
      a <- logNumber(3)
      b <- logNumber(5)
    } yield a * b

    out(multWithLog run)

    def gcd(a: Int, b: Int): Writer[List[String], Int] =
      if (b == 0) for {
        _ <- List("Finished with " + a.shows).tell
      } yield a
      else
        List(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell >>= { _ => gcd(b, a % b) }

    // Explained:
    def gcd2(a: Int, b: Int): Writer[List[String], Int] =
      if (b == 0) for {
        _ <- List("Finished with " + a.shows).tell
      } yield a
      else
        for {
          _ <- List(a.shows + " mod " + b.shows + " = " + (a % b)).tell           // The same as 3.set(List(....)), but 3 is ignored.
          r <- gcd2(b, a % b)
        }
        yield r
        //gcd(b, a % b).ap(List(a.shows + " mod " + b.shows + " = " + (a % b).shows))

    out(gcd(8, 3).run)
    out(gcd2(8, 3).run)
  }

  --------------("Inefficient List construction")

  {
    // LYAHFGG:
    // When using the Writer monad, you have to be careful which monoid to use,
    // because using lists can sometimes turn out to be very slow.
    // That's because lists use ++ for mappend and using ++ to add something
    // to the end of a lis tis low if that list is really long.

    // In scala we can use Vector:

    def gcd(a: Int, b: Int): Writer[Vector[String], Int] =
      if (b == 0)
        for {
          _ <- Vector("Finished with " + a.shows).tell
        } yield a
      else
        for {
          _ <- Vector(a.shows + " mod " + b.shows + " = " + (a % b).shows).tell
          result <- gcd(b, a % b)
        } yield result

    out(gcd(8, 3).run)
  }

  --------------("Comparing performance")

  {
    // Like the book let's write a microbenchmark to compare the performance:

    def vectorFinalCountDown(x: Int): Writer[Vector[String], Unit] = {
      @tailrec
      def doFinalCountDown(x: Int, w: Writer[Vector[String], Unit]): Writer[Vector[String], Unit] =
        x match {
          case 0 => w >>= { _ => Vector("0").tell }
          case x => doFinalCountDown(x - 1, w >>= { _ => Vector(x.shows).tell })
        }

      val t0 = System.currentTimeMillis
      val r = doFinalCountDown(x, Vector[String]().tell)
      val t1 = System.currentTimeMillis
      r >>= { _ => Vector((t1 - t0).shows + " msec").tell }
    }

    def listFinalCountDown(x: Int): Writer[List[String], Unit] = {
      @tailrec
      def doFinalCountDown(x: Int, w: Writer[List[String], Unit]): Writer[List[String], Unit] =
        x match {
          case 0 => w >>= { _ => List("0").tell }
          case x => doFinalCountDown(x - 1, w >>= { _ => List(x.shows).tell })
        }

      val t0 = System.currentTimeMillis
      val r = doFinalCountDown(x, List[String]().tell)
      val t1 = System.currentTimeMillis
      r >>= { _ => List((t1 - t0).shows + " msec").tell }
    }

    val vectorRun = vectorFinalCountDown(10000).run
    val listRun = listFinalCountDown(10000).run
    out(vectorRun)
    out(vectorRun._1.last)
    out(listRun)
    out(listRun._1.last)
  }

  =============================================("Reader")

  {
    // LYAHFGG:
    // In the chapter about applicatives, we saw that the function, (->)
    // r is an isntance of Functor

    val f = (_: Int) * 5
    val g = (_: Int) + 3
    out((g map f)(8))
  }

  {
    // We've also seen that functions are applicative functors.
    // They allow us to operate on the eventual results of functions as if we already had their results.

    val f = ({(_: Int) * 2} |@| {(_: Int) + 10}) {_ + _}
    out(f(3))
  }

  {
    // Not only is the function type (->) r a functor and an applicative
    // functor, but it's also a monad. Just like other monadic values that we've
    // met so far, a function can also be considered a value with a ontext.
    // The context for functions is that that value is not present yet and that
    // we have to apply that funciton to something in order to get its result value.

    val addStuff: Int => Int =
      for {
        a <- (_: Int) * 2
        b <- (_: Int) + 10
      } yield a + b

    out(addStuff(3))

    // Both (*2) and (+10) get applied to the number 3 in this case
    // return (a+b) does as well, but it ignores it and always presents a+b
    // as the result. For this reason, the function monad is also called
    // the reader monad.
    // All the functions read from a common source.
  }
}

package LearningScalaz

import CommonPlay.ChapterApp



/**
  * Created by archeg on 1/12/2016.
  */
object day8 extends ChapterApp {
  import scalaz._
  import Scalaz._

  // LYHFGG:
  // In this section, we're going to explore a few functions that either operate on monadic values or
  // return monadic values as their results (or both!). Such functions are usually referred to as monadic functions

  // Monad extends Applicative, so there's no question that all monads are functions.
  // we can use map or <*> operator

  --------------("join method")

  // LYAHFGG:
  // It turns out that any nested monadic value can be flattened and that
  // this is actually a property unique to monads. For this, the join function exists

  // In scalaz join has also symbolc alias μ
  // Introduced by Bind
  {
    import scalaz.syntax.Ops
    import scalaz.Liskov.<~<

    import scalaz.Bind
    abstract class _BindOps[F[_], A](implicit val F: Bind[F]) extends Ops[F[A]] {
      def join[B](implicit ev: A <~< F[B]): F[B] = F.bind(self)(ev(_))
      def μ[B](implicit ev: A <~< F[B]): F[B] = F.bind(self)(ev(_))
    }
  }

  {
    out((Some(9.some): Option[Option[Int]]).join) ==== 9.some
    out((Some(none): Option[Option[Int]]).join) ==== none
    out((none : Option[Option[Int]]).join) ==== none

    out(List(List(1, 2, 3), List(4, 5, 6)).join) ==== List(1, 2, 3, 4, 5, 6)
    out(List(List(List(1, 2, 3))).join) ==== List(List(1, 2, 3))
    out(List(List(List(1, 2, 3))).join.join) ==== List(1, 2, 3)

    out(9.right[String].right[String].join) ==== 9.right[String]

    out("boom".left[Int].right[String].join) ==== "boom".left[Int]
  }

  --------------("filterM method")

  {
    // LYAHFGG:
    // The filterM function from Control.Monad does just what we want!...
    // The predicate returns a monadic value whose result is a Bool

    import scalaz.syntax.Ops
    import scalaz.std.{list => l}
    abstract class _ListOps[A](val self: List[A]) extends Ops[List[A]] {
      final def filterM[M[_]: Monad](p: A => M[Boolean]): M[List[A]] = l.filterM(self)(p)
    }
  }

  {

    out(List(1, 2, 3) filterM {x => true.some}) ==== List(1, 2, 3).some
    out(List(1, 2, 3) filterM {x => (x % 2 != 0).some}) ==== List(1, 3).some
    out(List(1, 2, 3) filterM {x => List(true, false)}) ==== List(List(1, 2, 3), List(1, 2), List(1, 3), List(1), List(2, 3), List(2), List(3), List())

    out(List(1, 2, 3) filterM {x => List(true)})
    out(List(1, 2, 3) filterM {x => List(true, true)})
  }

  --------------("foldLeftM method")

  {
    // LYAHFGG:
    // The monadic counterpart to foldl is foldm

    // In scalaz this is implemented in Foldable as foldLeftM and foldRightM:

    def binSmalls(acc: Int, x: Int): Option[Int] = {
      if (x > 9) none[Int] else (acc + x).some
    }

    out(List(2, 8, 3, 1).foldLeft(0.some) {case (aggr: Option[Int], i) => aggr.map(_ + i)})
    out(List(2, 8, 3, 1).foldLeftM(0) {binSmalls}) ==== 14.some
    out(List(2, 11, 3, 1).foldLeftM(0) {binSmalls}) ==== none
  }

  =============================================("Making a safe RPN calculator")

  {
    // LYAHFGG:
    // When we were solving the problem of implementing a RPN calculator,
    // we noted that it worked fine as long as the input that it got made sense.

    {
      def foldingFunction(list: List[Double], next: String): List[Double] =
        (list, next) match {
          case (x :: y :: ys, "*") => (y * x) :: ys
          case (x :: y :: ys, "+") => (y + x) :: ys
          case (x :: y :: ys, "-") => (y - x) :: ys
          case (xs, numString) => numString.toInt :: xs
        }

      def solveRPN(s: String): Double =
        s.split(' ').toList.foldLeft(Nil: List[Double]) {foldingFunction}.head

      out(solveRPN("10 4 3 + 2 * -")) ==== -4.0
    }

    {
      // .parseInt returns Validation[NumberFormatException, Int]
      out("1".parseInt.toOption) ==== 1.some
      out("Hello".parseInt.toOption) ==== none
      out(List(1).point[Option]) ==== List(1).some
      out(List.empty[Int].point[Option]) ==== List.empty[Int].some
    }

    // Now with foldLeftM:

    {
      def foldingFunction(list: List[Double], next: String): Option[List[Double]] =
        (list, next) match {
          case (x :: y :: ys, "*") => ((y * x) :: ys).some
          case (x :: y :: ys, "+") => ((y + x) :: ys).some
          case (x :: y :: ys, "-") => ((y - x) :: ys).some
          case (xs, numString) => numString.parseDouble.toOption map {_ :: xs}
        }

      def solveRPN(s: String): Option[Double] =
        for {
          List(x) <- s.split(' '). toList.foldLeftM(List.empty[Double]) (foldingFunction)
        } yield x


      out(solveRPN("10 4 3 + 2 * -")) ==== (-4.0).some
      out(solveRPN("1 2 * 4")) ==== none
      out(solveRPN("1 8 garbage")) ==== none
    }
  }

  =============================================("Composing monadic functions")

  {
    // LYAHFGG:
    // When we were learning about the monad laws, we said that the <=<
    // function is just like composition, only instead of working for normal
    // functions like a -> b, it works for monadic functions like a -> m b.
  }

  --------------("Kleisli")

  {
    object Kleisli extends KleisliInstances {
      def apply[M[+_], A, B](f: A => M[B]): Kleisli[M, A, B] = ???
    }

    sealed trait Kleisli[M[+_], -A, +B] { self =>
      def run(a: A): M[B]

      // alias for `andThen`
      def >=>[C](k: Kleisli[M, B, C])(implicit b: Bind[M]): Kleisli[M, A, C] = Kleisli((a: A) => b.bind(this(a))(k(_)))
      def andThen[C](k: Kleisli[M, B, C])(implicit b: Bind[M]): Kleisli[M, A, C] = this >=> k

      /** alias for `compose` */
      def <=<[C](k: Kleisli[M, C, A])(implicit b: Bind[M]): Kleisli[M, C, B] = k >=> this
      def compose[C](k: Kleisli[M, C, A])(implicit b: Bind[M]): Kleisli[M, C, B] = k >=> this

      def apply(a: A) = ???
    }
  }

  {
    // Kleisli object should be used to construct it:
    val f = Kleisli { (x: Int) => (x + 1).some }     // Kleisli accepts f: A => M[B]
    val g = Kleisli { (x: Int) => (x * 100).some }

    out(4.some >>= (f <=< g)) ==== 401.some
    out(4.some >>= (f compose g)) ==== 401.some


    out(4.some >>= (f >=> g)) ==== 500.some
    out(4.some >>= (f andThen g)) ==== 500.some
  }

  {
    // Scalaz defined Reader as a special case of Kleisli as follows:
    type ReaderT[F[+_], E, A] = Kleisli[F, E, A]
    type Reader[E, A] = ReaderT[Id, E, A]

    object Reader {
      def apply[E, A](f: E => A): Reader[E, A] = Kleisli[Id, E, A](f)
    }
  }

  // So, from day 6 we had:

  {
    val addStuff: Int => Int =
      for {
        a <- (_: Int) * 2
        b <- (_: Int) + 10
      } yield a + b
  }

  {
    // We can now write:
    val addStuff: Reader[Int, Int] = for {
      a <- Reader { (_: Int) * 2 }
      b <- Reader { (_: Int) + 10 }
    } yield a + b

    out(addStuff(3)) ==== 19
  }

  =============================================("Making monads")

  // LYAHFGG:
  // In this section, we're going to look at an example of how a type gets
  // made, identified as a monad and then given the appropriate Monad instance.
  // What if we wanted to model a non-deterministic value like [3, 5, 9]
  // but we wanted to express that 3 has a 50% change of happening and
  // 5 and 9 both have a 25% change of happening

  {
    class Prob[A](val list: List[(A, Double)]) {
      override def toString = list.toString
    }

    object Prob extends ProbInstances {
      def apply[A](list: List[(A, Double)]) = new Prob(list)
    }

    trait ProbInstances {
      implicit def probShow[A]: Show[Prob[A]] = Show.showFromToString

      implicit val probInstance = new Functor[Prob] with Monad[Prob] {
        def point[A](a: => A): Prob[A] = Prob((a, 1.0) :: Nil)
        def bind[A, B](fa: Prob[A])(f: A => Prob[B]): Prob[B] = flatten(map(fa)(f))
        override def map[A, B](fa: Prob[A])(f: A => B): Prob[B] =
          Prob(fa.list map { case (x, p) => (f(x), p) })
      }

      // Implement flatten
      def flatten[B](xs: Prob[Prob[B]]): Prob[B] = {
        def multall(innerxs: Prob[B], p: Double) =
          innerxs.list map { case (x, r) => (x, p * r)}

        Prob(xs.list flatMap { case (innerxs, p) => multall(innerxs, p)})
      }
    }

    // The List is a functor, so this should be a functor as well, because it is essntially a list

    // Implement a Coin example with this:

    sealed trait Coin
    case object Heads extends Coin
    case object Tails extends Coin

    implicit val coinEqual: Equal[Coin] = Equal.equalA

    def coin: Prob[Coin] = Prob(Heads -> 0.5 :: Tails -> 0.5 :: Nil)
    def loadedCoin: Prob[Coin] = Prob(Heads -> 0.1 :: Tails -> 0.9 :: Nil)

    {
      def flipThree: Prob[Boolean] = for {
        a <- coin
        b <- coin
        c <- loadedCoin
      } yield { List(a, b, c) all {_ === Tails}}

      out(flipThree)
    }
  }
}

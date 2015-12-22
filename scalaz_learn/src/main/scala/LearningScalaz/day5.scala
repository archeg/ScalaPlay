package LearningScalaz

import CommonPlay.ChapterApp
import shapeless.test.illTyped

/**
  * Created by archeg on 12/22/2015.
  */
object day5 extends ChapterApp {
  import scalaz._
  import Scalaz._

  =============================================("A fist full of Monads")

  {
    // LYAHFGG:
    // Monads are a natural exension applicative functors, and they provide a solution to the following problem:
    // If we have a value with context, `m a`, how do we apply it to a function that takes a normal `a` and returns `a`
    // value with a context

    // so, m a -> (a -> m b) -> m b

    trait Monad[F[_]] extends Applicative[F] with Bind[F] { self =>

    }
  }

  --------------("Bind")

  {
    // Let's take a look at Bind
    trait Bind[F[_]] extends Apply[F] {self =>
      def bind[A, B](fa: F[A])(f: A => F[B]): F[B]
    }

    // BindOps introduces flatMap operator, and its symblic aliases >>= and *

    out(3.some flatMap {x => (x + 1).some}) === 4.some
    out(none[Int] flatMap {x => (x + 1).some}) === none[Int]
  }

  --------------("Monad")

  {
    // point creates monad. In haskell its `return` or `pure` functions
    out(Monad[Option].point("WHAT")) === "WHAT".some
    out(9.some flatMap {x => Monad[Option].point(x * 10)})
    out(none[Int] flatMap {x => Monad[Option].point(x * 10)})
  }

  =============================================("Walk the line")

  {
    // LYAHFGG:
    // Let's say that [Pierre] keeps his balance if the number of birds on the
    // left side of the pole and on the right side of the pole is within three.
    // So if there's one bird on the right side and four birds on the left side,
    // he's okay. But if a fifth bird lands on the left side, then he loses his
    // balance and takes a dive.

    type Birds = Int
    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Pole = copy(left = left + n)
      def landRight(n: Birds): Pole = copy(right = right + n)
    }

    // Let's try:
    out(Pole(0, 0).landLeft(2)) === Pole(2, 0)
    out(Pole(1, 2).landRight(1)) === Pole(1, 3)
    out(Pole(1, 2).landRight(-1)) === Pole(1, 1)
    out(Pole(0, 0).landLeft(1).landRight(1).landLeft(2)) === Pole(3, 1)

    // But:
    out(Pole(0, 0).landLeft(1).landRight(4).landLeft(-1).landRight(-2)) === Pole(0, 2)
  }

  // The intermediate value have failed, but the calculation kept going.
  // Now let's introduce Option[Pole]:
  {
    type Birds = Int
    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Option[Pole] =
        if (math.abs((left + n) - right) < 4)
          copy(left = left + n).some
        else
          none

      def landRight(n: Birds): Option[Pole] =
        if (math.abs(left - (right + n)) < 4)
          copy(right = right + n).some
        else
          none
    }

    out(Pole(0, 0).landRight(1) flatMap {_.landLeft(2)}) === Pole(2, 1).some
    out(none[Pole] flatMap {_.landLeft(2)}) === none
    out(Monad[Option].point(Pole(0, 0)) flatMap {_.landRight(2)} flatMap {_.landLeft(2)} flatMap {_.landRight(2)}) === Pole(2, 4).some

    // We could use >>= alias to make it look mor monadic:
    out(Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)}) === Pole(2, 4).some

    // Just for fun:
    out(for {
      pole1 <- Monad[Option].point(Pole(0, 0))
      pole2 <- pole1.landRight(2)
      pole3 <- pole2.landLeft(2)
      pole4 <- pole3.landRight(2)
    } yield pole4) === Pole(2, 4).some

    // Let's see if Monadic chaining simulates the pole balancing better:

    out(Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)} >>= {_.landRight(4)} >>= {_.landLeft(-1)} >>= {_.landRight(-2)}) === none
  }

  --------------("Banana on wire")

  object bananaOnWire
  {
    // LYAHFGG:
    // We may also devise a function that ignores the current number of birds
    // on the balancing pole and just makes Pierre slip and fall. We can call it banana

    type Birds = Int
    case class Pole(left: Birds, right: Birds) {
      def landLeft(n: Birds): Option[Pole] =
        if (math.abs((left + n) - right) < 4)
          copy(left = left + n).some
        else
          none

      def landRight(n: Birds): Option[Pole] =
        if (math.abs(left - (right + n)) < 4)
          copy(right = right + n).some
        else
          none

      def banana: Option[Pole] = none
    }

    out(for {
      pole1 <- Monad[Option].point(Pole(0, 0))
      pole2 <- pole1.landLeft(1)
      pole3 <- pole2.banana
      pole4 <- pole3.landRight(1)
    } yield pole4) === none

    // LYAHFGG:
    // Instead of making functions that ignore their input and just return a predetermined monadic value,
    // we can use the >> function

    out(none[Int] >> 3.some) === none
    out(3.some >> 4.some) === 4.some
    out(3.some >> none[Int]) === none

    // Let's try replacing banana with >> (none[Pole]) :
    illTyped("Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)} >> (none: Option[Pole]) >>= {_.landRight(1)}")

    // The type inference broke down here.
    // The precendence of >> is higher than of >>= in scala, because >>= ends on =
    // which forces {_.landLeft(1)} >> (none: Option[Pole]) to evaluate first
    out(Monad[Option].point(Pole(0, 0)).>>=({_.landLeft(1)}).>>(none: Option[Pole]).>>=({_.landRight(1)})) === none
    out((Monad[Option].point(Pole(0, 0)) >>= {_.landLeft(1)}) >> (none: Option[Pole]) >>= {_.landRight(1)}) === none
  }

  bananaOnWire

  --------------("for syntax")

  {
    // LYAHFGG:
    // Monads in Haskell are so useful that they got their own special syntax called do notation

    out(3.some >>= { x => "!".some >>= { y => (x.shows + y).some } }) === "3!".some

    // Any part of this calculation can fail:
    out(3.some >>= { x => (none: Option[String]) >>= { y => (x.shows + y).some } }) === none
    out((none: Option[Int]) >>= { x => "!".some >>= { y => (x.shows + y).some } }) === none
    out(3.some >>= { x => "!".some >>= { y => (none: Option[String]) } }) === none

    // So we can use for:
    out(for {
      x <- 3.some
      y <- "!".some
    } yield x.shows + y) === "3!".some

    // LYAHFGG:
    // In a do expression, every line that isn't a let line is a monadic value.
    // Looks to be true for Scala's for syntax too.
    // Accept if I guess? Define line? The generators in for expression are monadic
  }

  --------------("Pierre returns")

  {
    import bananaOnWire.Pole

    // LYAHFGG:
    // Our tightwalker's routine can also be expressed with do notation

    // Already did that above. But for completion:
    def routine: Option[Pole] =
      for {
        start <- Monad[Option].point(Pole(0, 0))
        first <- start.landLeft(2)
        second <- first.landRight(2)
        third <- second.landLeft(1)
      } yield third

    out(routine) === Pole(3, 2).some

    // LYAHFGG:
    // If we want to throw the Pierre a banana peel in do notation, we can do the following

    def routine2: Option[Pole] =
      for {
        start <- Monad[Option].point(Pole(0, 0))
        first <- start.landLeft(2)
        _ <- none[Pole]               // This call is still translated into flatMap, which results in none, see conversion
        second <- first.landRight(2)
        third <- second.landLeft(2)
      } yield third

    out(routine2) === none[Pole]

    // Converting to chaining
    def routine3: Option[Pole] =
      Monad[Option].point(Pole(0, 0)).flatMap { case start =>
        start.landLeft(2).flatMap { case first =>
          none[Pole].flatMap { case _ =>
            for {second <- first.landRight(2)
                  third <- second.landLeft(2)
          } yield third
          }
        }
      }
  }

  --------------("Pattern matching and failure")

  {
    // LYAHFGG:
    // In do notation, when we bind monadic values to names, we can utilize
    // pattern matching, just like in let expressions and function parameters.

    def justH: Option[Char] =
      for {
        (x :: xs) <- "hello".toList.some
      } yield x

    out(justH) === 'h'.some

    // LYAHFGG:
    // When pattern matching fails in a do expression, the fail function is called.
    // It's part fo the Monad type class and it enables failed pattern matching to
    // result in a failure in the context of the current monad
    // instead of making our program crash.

    def wopwop: Option[Char] =
      for {
        (x :: xs) <- "".toList.some
      } yield x

    out(wopwop) === none

    // translation:

    def wopwop2: Option[Char] =
      "".toList.some.map { case (x :: xs) => x }
    error(wopwop2)   // translation throws when the pattern is not matched

    // so for expression != map.flatMap chain calls
  }

  --------------("List Monad")

  {
    // LYAHFGG:
    // On the other hand, a value like [3, 8, 9] contains several resuts, so we
    // can view it as one value that is actually many values at the same time
    // Using lists as applicative functors showcases this non-determinism nicely

    // Let's look at using List as Applicatives again:
    out(^(List(1, 2, 3), List(10, 100, 100)) { _ * _ }) === List(10, 100, 100, 20, 200, 200, 30, 300, 300)

    out(List(3, 4, 5) >>= {x => List(x, -x)}) === List(3, -3, 4, -4, 5, -5)

    out(for {
      n <- List(1, 2)
      ch <- List('a', 'b')
    } yield (n, ch)) === List((1, 'a'), (1, 'b'), (2, 'a'), (2, 'b'))
  }

  =============================================("MonadPlus and the guard function")

  {
    // Scala's for notation allows filtering:
    out(for {
      x <- 1 |-> 50 if x.shows contains '7'
    } yield x) === List(7, 17, 27, 37, 47)

    // LYAHFGG:
    // The MonadPlus type class is for monads that can also act as monoids.

    // TypeClasses Contract:
    trait MonadPlus[F[_]] extends Monad[F] with ApplicativePlus[F] {

    }
  }

  {
    // It extends ApplicativePlus:

    trait ApplicativePlus[F[_]] extends Applicative[F] with PlusEmpty[F] {
    }

    trait PlusEmpty[F[_]] {
      def empty[A]: F[A]
    }

    trait Plus[F[_]] {
      def plus[A](a: F[A], b: => F[A]): F[A]
    }

    // Plus introduces <+> operator to append two contains

    // Plus with PlusEmpty is basically a Monoid, but at the type-class level
  }

  --------------("MonadPlus again")

  {
    // MonadPlus introduces filter operation
    out((1 |-> 50) filter {x => x.shows contains '7'})

  }

  =============================================("A knight's quest")

  {
    // LYAHFGG:
    // Here's a problem that really lends itself to being solved with non-determinism
    // Say you have a chess board and only one knight piece on it.
    // We want to find out if the knight can reach a certain position in three moves

    case class KnightPos(c: Int, r: Int) {
      def move: List[KnightPos] =
        for {
          ci <- List(-2, -1, 1, 2)
          cj <- List(-2, -1, 1, 2) if math.abs(ci) != math.abs(cj)
          KnightPos(c2, r2) = KnightPos(c + ci, r + cj)
          if ((1 |-> 8) contains c2) && ((1 |-> 8) contains r2)
        } yield KnightPos(c2, r2)

      // Awesome!
      def in3: List[KnightPos] =
        for {
          first <- move
          second <- first.move
          third <- second.move
        } yield third

      def canReachIn3(end: KnightPos): Boolean = in3 contains end
    }

    out(KnightPos(6, 2) canReachIn3 KnightPos(6, 1)) === true
    out(KnightPos(6, 2) canReachIn3 KnightPos(7, 3)) === false
  }

  =============================================("Monad laws")

  {
    +++("Left Identity")

    // LYAHFGG:
    // The first monad law states that if we take a value, put it in a default context with return
    // and then feed it to a function by using >>=, it's the same as just taking the value and applying the function to it

    out(Monad[Option].point(3) >>= { x => (x + 100000).some }) === (3 |> { x => (x + 100000).some })

    +++("Right identity")

    // The second law states that if we have a monadic value and we use >>=
    // ti feed ut ti return, the result is our original monadic value.

    out("move on up".some flatMap {Monad[Option].point(_)}) === "move on up".some

    +++("Associativity")

    // The final monad law says that when we have a chain of monadic function applications
    // with >>=, it shouldn't matter how they're nested

    import bananaOnWire.Pole

    out(Monad[Option].point(Pole(0, 0)) >>= {_.landRight(2)} >>= {_.landLeft(2)} >>= {_.landRight(2)}) === Pole(2, 4).some

    out(Monad[Option].point(Pole(0, 0)) >>= {
      x => x.landRight(2) >>= {
        y => y.landLeft(2) >>= {
          z => z.landRight(2)
        }
      }
    }) === Pole(2, 4).some
  }

  {
    // Scalaz 7 expresses these laws as the following:
    trait MonadLaw[F[_]] extends day4.ApplicativeLawExample[F] with Bind[F] {
      /** Lifted `point` is a no-op. */
      def rightIdentity[A](a: F[A])(implicit FA: Equal[F[A]]): Boolean = FA.equal(bind(a)(point(_: A)), a)
      /** Lifted `f` applied to pure `a` is just `f(a)`. */
      def leftIdentity[A, B](a: A, f: A => F[B])(implicit FB: Equal[F[B]]): Boolean = FB.equal(bind(point(a))(f), f(a))
      /**
        * As with semigroups, monadic effects only change when their
        * order is changed, not when the order in which they're
        * combined changes.
        */
      def associativeBind[A, B, C](fa: F[A], f: A => F[B], g: B => F[C])(implicit FC: Equal[F[C]]): Boolean =
        FC.equal(bind(bind(fa)(f))(g), bind(fa)((a: A) => bind(f(a))(g)))
    }

    // Check in console:
    // monad.laws[Option].check
  }
}

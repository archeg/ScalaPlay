package LearningScalaz

import CommonPlay.ChapterApp

/**
  * Created by archeg on 12/21/2015.
  */
object day4 extends ChapterApp {
  import scalaz._
  import Scalaz._
  =============================================("Functor laws")

  {
    // LYAHFGG:
    // All functors are expected to exhibit certain kinds of functor-like
    // properties and behaviors. ... The first functor law states that if we map the id function over a functor,
    // the functor that we get back should be the same as the original functor.

    out(List(1, 2, 3) map identity) ==== List(1, 2, 3)

    // The second law says that composing two functions and then mapping the resulting function over a functor
    // should be the same as first mapping mapping one function over the functor and then mapping the other one.

    out(List(1, 2, 3) map {
      {(_: Int) * 3} map {(_: Int) + 1}
    }) ==== (List(1, 2, 3) map {(_: Int) * 3} map {(_: Int) + 1})
    // A bit hard to read this: it's A map (B map C) == A map B map C

    trait FunctorLawExample[F[_]] extends Functor[F] {
      /** The identity function, lifted, is a no-op. */
      def identity[A](fa: F[A])(implicit FA: Equal[F[A]]): Boolean = FA.equal(map(fa)(x => x), fa)

      /**
        * A series of maps may be freely rewritten as a single map on a
        * composed function.
        */
      def associative[A, B, C](fa: F[A], f1: A => B, f2: B => C)(implicit FC: Equal[F[C]]): Boolean = FC.equal(map(map(fa)(f1))(f2), map(fa)(f2 compose f1))
    }

    // These laws not something checked by Scalaz automatically
    // But there exists FunctorLaw

    // We can check it manually directly.
    out(Functor[List].functorLaw.identity(List(1, 2, 3))) ==== true
    out(Functor[List].functorLaw.composite(List(1, 2, 3), (x: Int) => x * 3, (x: Int) => x + 1)) ==== true
  }

  // Or we can test it in sbt test:console:

  // Cannot import this because it requires test:
//  {
//    import scalacheck.ScalazProperties._
//    import scalacheck.ScalazArbitrary._
//    import scalacheck.ScalaCheckBinding._
//
//    functor.laws[List].check
//  }

  --------------("Breaking the law")

  object firstLawBreak
  {
    sealed trait COption[+A] {}
    case class CSome[A](counter: Int, a: A) extends COption[A]
    case object CNone extends COption[Nothing]

    implicit def coptionEqual[A]: Equal[COption[A]] = Equal.equalA
    implicit val coptionFunctor = new Functor[COption] {
      def map[A, B](fa: COption[A])(f: A => B): COption[B] = fa match {
        case CNone => CNone
        case CSome(c, a) => CSome(c + 1, f(a))
      }
    }

    out((CSome(0, "ho"): COption[String]) map {(_: String) + "ha"}) ==== CSome(1, "hoha")
    out((CSome(0, "ho"): COption[String]) map {identity}) ==== CSome(1, "ho")    // A map {identity} != A, breaking first law
  }

  firstLawBreak

  // In the SBT:
  // test:console

//  scala> import LearningScalaz.day4.firstLawBreak._
//  import LearningScalaz.day4.firstLawBreak._
//
//  scala> functor.laws[COption].check
//  <console>:29: error: could not find implicit value for parameter af: org.scalacheck.Arbitrary[LearningScalaz.day4.firstLawBreak.COption[Int]]
//    functor.laws[COption].check

  // Scalacheck requires arbitrary implicit for it to work. Let's add it

  // In the SBT test:console:
//  scala> import org.scalacheck.{Gen, Arbitrary}
//  import org.scalacheck.{Gen, Arbitrary}
//
//  scala> implicit def COptionArbitrary[A](implicit a: Arbitrary[A]): Arbitrary[COption[A]] = a map { CSome(0, _): COption[A] }
//  COptionArbitrary: [A](implicit a: org.scalacheck.Arbitrary[A])org.scalacheck.Arbitrary[LearningScalaz.day4.firstLawBreak.COption[A]]

  // Cool! ScalaCheck on its own does not ship map method, but Scalaz has injected it as a Functor[Arbitrary]!

//  functor.laws[COption].check
//  CSome(1,hoha)
//  CSome(1,ho)
//  ! functor.invariantFunctor.identity: Falsified after 0 passed tests.
//  > ARG_0: CSome(0,1)
//  ! functor.invariantFunctor.composite: Falsified after 0 passed tests.
//  > ARG_0: CSome(0,1)
//  > ARG_1: <function1>
//  > ARG_2: <function1>
//    > ARG_3: <function1>
//      > ARG_4: <function1>
//        ! functor.identity: Falsified after 0 passed tests.
//        > ARG_0: CSome(0,-1)
//        ! functor.composite: Falsified after 0 passed tests.
//        > ARG_0: CSome(0,-1)
//        > ARG_1: <function1>


  // And the test fails as expected

  --------------("Applicative laws")

  // Here are the laws for Applicative:

    trait ApplicativeLawExample[F[_]] extends Applicative[F] {
      /** `point(identity)` is a no-op. */
      def identityAp[A](fa: F[A])(implicit FA: Equal[F[A]]): Boolean =
        FA.equal(ap(fa)(point((a: A) => a)), fa)

      /** `point` distributes over function applications. */
      def homomorphism[A, B](ab: A => B, a: A)(implicit FB: Equal[F[B]]): Boolean =
        FB.equal(ap(point(a))(point(ab)), point(ab(a)))

      /** `point` is a left and right identity, F-wise. */
      def interchange[A, B](f: F[A => B], a: A)(implicit FB: Equal[F[B]]): Boolean =
        FB.equal(ap(point(a))(f), ap(f)(point((f: A => B) => f(a))))

      /** `map` is like the one derived from `point` and `ap`. */
      def mapLikeDerived[A, B](f: A => B, fa: F[A])(implicit FB: Equal[F[B]]): Boolean =
        FB.equal(map(fa)(f), ap(fa)(point(f)))
    }

  --------------("Semigroup Laws")

  trait SemigroupLawExample[F] extends Semigroup[F] {
    def associative(f1: F, f2: F, f3: F)(implicit F: Equal[F]): Boolean =
      F.equal(append(f1, append(f2, f3)), append(append(f1, f2), f3))
  }

  --------------("Monoid Laws")

  trait MonoidLawExample[F] extends SemigroupLawExample[F] with Monoid[F] {
    def leftIdentity(a: F)(implicit F: Equal[F]) = F.equal(a, append(zero, a))
    def rightIdentity(a: F)(implicit F: Equal[F]) = F.equal(a, append(a, zero))
  }

  // This law is simple, we can |+| (mappend) identity value to either left hand side
  // or right hand side.

  out(1 * 2) ==== 2
  out(2 * 1) ==== 2

  // With Scalaz

  out(Monoid[Int @@ Tags.Multiplication].zero |+| Tags.Multiplication(2)) ==== 2
  out(Tags.Multiplication(2) |+| Monoid[Int @@ Tags.Multiplication].zero) ==== 2

  =============================================("Option as Monoid")

  {
    // LYAHFGG:
    // One way is to treat Maybe as a monoid only if its type parameter a is
    // a monoid as well and then implement mappend in such a way that it uses
    // the mappend operation of the values that are wrapped with Just

    // Let's see if this is how Scalaz does it. See std/Option.scala:

    {
      implicit def optionMonoid[A: Semigroup]: Monoid[Option[A]] = new Monoid[Option[A]] {
        def append(f1: Option[A], f2: => Option[A]) = (f1, f2) match {
          case (Some(a1), Some(a2)) => Some(Semigroup[A].append(a1, a2))
          case (Some(a1), None) => f1
          case (None, sa2@Some(a2)) => sa2
          case (None, None) => None
        }

        def zero: Option[A] = None
      }
    }

    // The implementation is nica and simple. Bound A: Semigroup says that A must support |+|

    out(none[String] |+| "andy".some) ==== "andy".some
    out((Ordering.LT: Ordering).some |+| none[Ordering]) ==== Ordering.LT.some

    // works!
  }

  {
    // LYAHFGG:
    // But if we don't know if the contents are monoids, we can't use mappend between them,
    // so what are we to do? Well, one thing we can do is to just discard the second value
    // and keep the first one. For this, the 'First a' type exists


    // Haskell is using newtype to implement First type constructor.
    // Scalaz 7 does it using mightly Tagged type:

    out(Tags.First('a'.some) |+| Tags.First('b'.some)) ==== Tags.First('a'.some)
    out(Tags.First(none[Char]) |+| Tags.First('b'.some)) ==== Tags.First('b'.some)
    out(Tags.First('a'.some) |+| Tags.First(none[Char])) ==== Tags.First('a'.some)
    out(Tags.First(none[Char]) |+| Tags.First(none[Char])) ==== Tags.First(none[Char])

    // LYAHFGG:
    // If we want a monoid on 'Maybe a' such that the second parameter is kept if both
    // parameters of mappend are `Just` values, Data.Monoid provides `a` the `Last a` type

    out(Tags.Last('a'.some) |+| Tags.Last('b'.some)) ==== Tags.Last('b'.some)
    out(Tags.Last(none[Char]) |+| Tags.Last('b'.some)) ==== Tags.Last('b'.some)
    out(Tags.Last('a'.some) |+| Tags.Last(none[Char])) ==== Tags.Last('a'.some)
    out(Tags.Last(none[Char]) |+| Tags.Last(none[Char])) ==== Tags.Last(none[Char])
  }

  =============================================("Foldable")

  {
    // LYAHFGG:
    // Because there are so many data structures that work nicely with folds,
    // the Foldable type class was introduced. Much like Functor is for things
    // that can be mapped over, Foldable is for things that can be folded up!

    {
      trait Foldable[F[_]] { self =>
        /** Map each element of the structure to a [[scalaz.Monoid]], and combine the results. */
        def foldMap[A, B](fa: F[A])(f: A => B)(implicit F: Monoid[B]): B

        /** Right-associative fold of a structure. */
        def foldRight[A, B](fa: F[A], z: => B)(f: (A, => B) => B): B

      }

      // The operators are in FoldableOps ....
    }

    {
      // From original scala library:
      out(List(1, 2, 3).foldRight(1){_ * _}) ==== 6
      // From scalaz FoldableOps:
      out(9.some.foldLeft(2){_ + _}) ==== 11
    }

    {
      // Let's try the foldMap operator
      // Monoid[A] gives us zero and |+|, so that's enough information
      // to fold things over.
      // Since we can't assume that Foldable contains a monoid, we need a function to change
      // from A => B, where [B: Monoid]

      out(List(1, 2, 3) foldMap identity) ==== 6
      out(List(true, false, true, true) foldMap {Tags.Disjunction.apply}) ==== true
    }
  }
}

package LearningScalaz

import CommonPlay.ChapterApp
import shapeless.test.illTyped

import scalaz.syntax.Ops

/**
  * Created by archeg on 12/16/2015.
  */
object day3 extends ChapterApp {
  import scalaz._
  import Scalaz._
  --------------("Kinds and some type-foo")

  {
    // LYHFGG:
    // Types are little albels that values carry so that we can reason about the values.
    // But types have their own little labesl, called kind. A kind is more or lesss the type of a type.
    // What are kinds and what are they good for?
    // Well, let's examine the kind of a type by using the :k command in GHCI

    // For REPL :k command should be used.
    out(kind[Int])          // Proper type.
    out(kind[Option[_]])  // Option is type constructor
    out(kind[Either[_, _]]) // Either is type constructor
    out(kind[Equal[_]])
    out(kind[Functor[List]])  // A higher kinded type

    // Here it goes:
    // Proper type is a simple type with just which you can make a value. Int is one of the proper types
    // Type constructor is the type, that requires another type to construct a value.
    //           List is a type constructor
    //      when List[Int] is a proper type (although both kind and :k in REPL ignores the second type)
    // can be also called 1st-order-kinded type

    // A higher kinded type is which requires another type constructor to contruct a type
    // Functor is a higher kinded type (it is Functor[F[_]])
    // it requires a List to construct a proper type

    // The same hierarchy for values can be build:
    // 5 is a value
    // (_: Int) + 5 is a 1st order value or value constructor or function
    // (y: List[Int], x: (Int => Int)) => y map x is a higher kinded value or higher order function

    // Scala encodes the notion of type class using type constructor,
    // and the terminology tend get jumbled up.
    // For example, the data structure List forms a functor,
    // in the sense that an instance Functor[List] can be derived for List (using implicits?)
    // Since there should be only one instance for List, we can say that List is a functor
    // Jessica Kerr: In FP, "is-a" means "an instance can be derived from."

    // Since List is F[+A], it's easy to remember that F relates to a functor.
    // Except, the typeclass definition Functor needs to wrap F[A] around, so
    // its kind is X[F[A]].
    // To add to the confusion, the fact that Scala can treat type constructor
    // as a first class variable was novel enough, that the compiler calls first-order kinded type as
    // "higher-kinded type":

    trait Test { type F[_] }
    // Generates a warning: higher-kinded type should be enabled ...

    // Normally you don't have to worry about this if you are using injected operators like:
    out(List(1, 2, 3).shows)
    // But if you want to use Show[A].shows, you have to know it's
    // Show[List[Int]], not Show[List]
    // Similarly, if you want to lift a function, you need to know that
    // it's Functor[F]:

    out(Show[List[Int]].shows(List(1, 2, 3)))
    // but:
    out(Functor[List].lift((_: Int) + 2))

    // This is because Show is 1st order kinded,
    // when Functor is higher-kinded type

    // In the cheat sheet autor started originally had type parameters for Equal
    // written as Equal[F], which is the same as Scalaz 7s source code.
    // Adam Rosien pointed out to him that it should be Equal[A]
    // because F is a convention for Functor
  }

  --------------("Tagged type")

  {
    // LYAHFGG:
    // The newtype keyword in Haskell is made exactly for these cases when we want to just
    // take one type and wrap it in something to present it as another type

    // Miles Sabin wrote a gist:
    {
      type Tagged[U] = { type Tag = U }
      type @@[T, U] = T with Tagged[U]
    }

    // Suppose we want a way to express mass using kilogram,
    // because kg is the internation standard of unit
    // Normally we would pass in Double and call it a day, but
    // we can't distinguish that from other Double values.

    {
      case class KiloGram(value: Double)
    }

    // It adds type safety, but it's not fun to use because we have to call x.value
    // every time we need to extract the value out of it.
    // Tagged type to the rescue

    sealed trait KiloGram
    def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

    val mass = KiloGram(20.0)
    out(2 * Tag.unwrap(mass))

    // We can now define a function that calculates relativistic energy
    sealed trait JoulePerKiloGram

    def JoulePerKiloGram[A](a: A): A @@ JoulePerKiloGram = Tag[A, JoulePerKiloGram](a)

    def energyR(m: Double @@ KiloGram): Double @@ JoulePerKiloGram =
      JoulePerKiloGram(299792458.0 * 299792458 * Tag.unwrap(m))

    out(energyR(mass))
    illTyped("""out(energyR(10))""")
  }

  --------------("About those Monoids")

  {
    // LYAHFGG:
    // It seems that both * together with 1 and ++ along with [] share some
    // common properties:
    // - The function takes two parameters
    // - The parameters and the returned value have the same type
    // - There exists such a value that doesn't change other values when used with the binary function

    // Let's check
    out(4 * 1) === 4
    out(1 * 9) === 9
    out(List(1, 2, 3) ++ Nil) === List(1, 2, 3)
    out(Nil ++ List(0.5, 2.5)) === List(0.5, 2.5)

    // LYAHFGG:
    // It doesn't matter if we do (3 * 4) * 5 or 3 * (4 * 5). Either way it's 60
    // The same goes for ++. We call this property associativity.
    // * is associative and so is ++
    // but - for example is not.

    out((3 * 4) * 5) === 3 * (4 * 5)
    out(List("la") ++ (List("di") ++ List("da"))) === (List("la") ++ List("di")) ++ List("da")
  }

  --------------("Monoid")

  {
    // LYAHFGG:
    // A monoid is when you have an associative binary function and a value
    // which acts as an identity with respect to that function

    // Monoid typeclass contract
    trait Monoid[A] extends Semigroup[A] { self =>
      def zero: A
    }

    // Semigroup typeclass :
    trait Semigroup[A] { self =>
      def append(a1: A, a2: => A): A
    }

    class SemigroupOps[A](val self: A)(implicit val A: Semigroup[A])  extends Ops[A] {
      final def |+|(other: => A): A = A.append(self, other)
      final def mappend(other: => A): A = A.append(self, other)
      final def ⊹(other: => A): A = A.append(self, other)
    }

    // This defines mappend operator with alias |+| and ⊹

    // mappend is a binary function
    // it takes two values of the same type and returns a value of that type as well.

    // LYAHFGG also warns that just because it's named mappend it does not
    // mean it's appending something, like in the case of *

    out(List(1, 2, 3) mappend List(4, 5, 6)) === List(1, 2, 3, 4, 5, 6)
    out("one" mappend "two") === "onetwo"

    // The idiomatic Scalaz way is to use |+|:
    out(List(1, 2, 3) |+| List(4 ,5, 6)) === List(1, 2, 3, 4, 5, 6)
    out("one" |+| "two") === "onetwo"
  }

  --------------("Back to Monoid")

  {
    // LYAHFGG:
    // mempty represents the identity value for a particular monoid.

    // Scalaz calls this zero instead

    out(Monoid[List[Int]].zero) === Nil
    out(Monoid[String].zero) === ""
    out(Monoid[Int].zero) === 0
  }

  --------------("Tags.Multiplication")

  {
    // LYAHFGG:
    // So now that there are two equally valid ways for numbers (addition and multiplication)
    // to be monoids, which was do choose? Well, we don't have to

    // This is where Scalaz 7.1 uses tagged type. The built-in tags are Tags
    // There are 8 tags for Monoids and 1 named Zip for Applicative

    out(Tags.Multiplication(10) |+| Monoid[Int @@ Tags.Multiplication].zero)

    out(Tags.Multiplication(10) |+| Tags.Multiplication(20)) === 200

    out(10 |+| 30)
  }

  --------------("Tags.Disjunction and Tags.Conjunction")

  {
    // LYAHFGG:
    // Another type which can act like a monoid in two distinct but equally valid ways is Bool
    // The first way is to have the or function || act as the binary function
    // along with False as the identity value
    // The other way for Bool to be an instance of Monoid is to kind of do the opposite:
    // have && be the binary function and then make True the identity value

    // In scala these are called:
    type firstWay = Boolean @@ Tags.Disjunction
    type secondWay = Boolean @@ Tags.Conjunction

    out(Tags.Disjunction(true) |+| Tags.Disjunction(false)) === true
    out(Monoid[Boolean @@ Tags.Disjunction].zero |+| Tags.Disjunction(true)) === true

    illTyped("""out(Tags.Disjunction(true) |+| Tags.Conjunction(false))""")
  }

  --------------("Ordering as Monoid")

  {
    // LYAHFGG:
    // With Ordering we have to look a bit harder to recognize a monoid,
    // but it turns out that its Monoid instance is just as intuitive as the ones
    // we've met so far and also quite useful

    illTyped("""Ordering.LT |+| Ordering.GT""") // Not yet

    out((Ordering.LT: Ordering) |+| (Ordering.GT: Ordering)) === Ordering.LT
    out((Ordering.GT: Ordering) |+| (Ordering.LT: Ordering)) === Ordering.GT
    out((Ordering.EQ: Ordering) |+| (Ordering.GT: Ordering)) === Ordering.GT
    out((Ordering.EQ: Ordering) |+| (Ordering.LT: Ordering)) === Ordering.LT
    out((Ordering.EQ: Ordering) |+| (Ordering.EQ: Ordering)) === Ordering.EQ

    +++("lengthCompare")

    // LYAHFGG:
    // OK, so how is this monoid useful? Let's say you were writing a function
    // that takes two strings, compares their lengths and returns an Ordering
    // But if the strings are of the same length, then instead of
    // returning EQ right away, we want to compare them alphabetically.

    def lengthCompare(lhs: String, rhs: String): Ordering =
      (lhs.length ?|? rhs.length) |+| (lhs ?|? rhs)
    // A but hard to figure it out
    // both lhs.length ?|? rhs.length and lhs ?|? rhs return orders
    // now |+| combines them, using left order only if it is not EQ


    out(lengthCompare("zen", "ants")) === Ordering.LT
    out(lengthCompare("zen", "ant")) === Ordering.GT
  }
}

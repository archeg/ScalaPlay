package LearningScalaz

import CommonPlay.ChapterApp

/**
  * Created by archeg on 12/15/2015.
  */
object day0 extends ChapterApp {
  --------------("What is a polymorphism?")

  {
    +++("Parametric polymorphism")

    def head[A](xs: List[A]): A = xs.head
    // head is polymorphic around A. This is called parametric polymorphism
    // A - is type variable.

    out(head(1 :: 2 :: Nil)) ==== 1
    case class Car(make: String)

    out(head(Car("Civic") :: Car("CR-V") :: Nil)) ==== Car("Civic")

    +++("Subtype polymorphism")

    // Depending on type A, we need provide different definition for what it means to add things:
    def plus[A](a1: A, a2: A) = ???

    trait Plus[A] {
      def plus(a2: A): A
    }

    def plus2[A <: Plus[A]](a1: A, a2: A) = a1.plus(a2)

    // But this is not flexible since trait Plus needs to be mixed in at the time of defining the datatype.
    // So it can't work for Int and String

    +++("Ad-hoc polymorphism")

    // Implicits:
    trait Plus2[A] {
      def plus(a1: A, a2: A): A
    }

    def plus3[A: Plus2](a1: A, a2: A):A = implicitly[Plus2[A]].plus(a1, a2)

    // With this we can provide definitions for Int and String.
    // The function definitions can be enabled or disabled in different scopes
  }

  --------------("sum function")

  object sumFunction
  {
    // Let's demonstrate ad-hoc polymorphism by gradually making sum function more general,
    // starting from a simple function that adds up a list of Ints:
    def sum(xs: List[Int]): Int = xs.foldLeft(0) {_ + _}
    out(sum(List(1, 2, 3, 4))) ==== 10

    +++("Monoid")

    // Let's define a monoid.
    // This thing has two operations:
    //    mappends - performs an operation in the set
    //    mzero    - defines a zero for this operations
    object IntMonoid {
      def mappend(a: Int, b: Int): Int = a + b
      def mzero: Int = 0
    }

    def sum2(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)
    out(sum2(List(1, 2, 3, 4))) ==== 10

    // Now abstract it:
    trait Monoid[A] {
      def mappend(a1: A, a2: A): A
      def mzero: A
    }

    object IntMonoid2 extends Monoid[Int] {
      override def mappend(a1: Int, a2: Int): Int = a1 + a2
      override def mzero: Int = 0
    }

    def sum3(xs: List[Int], m: Monoid[Int]): Int = xs.foldLeft(m.mzero)(m.mappend)
    out(sum3(List(1, 2, 3, 4), IntMonoid2)) ==== 10

    // and not let's abstract sum:
    def sum4[A](xs: List[A], m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)
    out(sum4(List(1, 2, 3, 4), IntMonoid2)) ==== 10

    // and let's make the monoid implicit

    def sum5[A : Monoid](xs: List[A]) = implicitly[Monoid[A]] match {
      case ev => xs.foldLeft(ev.mzero)(ev.mappend)
    }

    implicit val intMonoid = IntMonoid2
    out(sum5(List(1, 2, 3, 4))) ==== 10 // Perfect!

    // Now we can write a few other monoids:
    object Monoid {
      // Remember to define explicitly types for the implicit values.
      implicit val StringMonoid: Monoid[String] = new Monoid[String] {
        override def mappend(a1: String, a2: String): String = a1 + a2
        override def mzero: String = ""
      }

      implicit val DoubleMonoid: Monoid[Double] = new Monoid[Double]{
        override def mappend(a1: Double, a2: Double): Double = a1 + a2
        override def mzero: Double = 0.0
      }
    }

    import Monoid._
    out(sum5(List("Hello", " ", "world"))) ==== "Hello world"
    out(sum5(List(2.0, 7.5))) ==== 9.5

    // Monoid is not only about +. You can have different monoids:
    object Mult extends Monoid[Int] {
      override def mappend(a1: Int, a2: Int): Int = a1 * a2
      override def mzero: Int = 1
    }

    out(sum5(List(2, 5, 3))(Mult)) ==== 30
  }
  sumFunction

  --------------("FoldLeft")

  {
    import sumFunction.Monoid
    import sumFunction.Monoid._

    // What we wanted was a function that generalized on List.
    // ... So we want to generalize on foldLeft operation.

    object FoldLeftList {
      def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
    }

    def sum[A: Monoid](xs: List[A]): A = {
      val m = implicitly[Monoid[A]]
      FoldLeftList.foldLeft(xs, m.mzero, m.mappend)
    }
  }

  +++("FoldLeft abstraction")

  // Now we can apply the same abstraction to pull out FoldLeft typeclass.
  {
    import sumFunction.Monoid
    import sumFunction.Monoid._

    out(sum(List(1, 2, 3, 4))) ==== 10
    out(sum(List("a", "b", "c", "d"))) ==== "abcd"

    // Ok, now we we are talking. HKT
    trait FoldLeft[F[_]] {            // FoldLeft is a typeClass/typeConstructor
      def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
    }

    object FoldLeft {
      implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
        def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
      }
    }

    def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
      val m = implicitly[Monoid[A]]
      val fl = implicitly[FoldLeft[M]]
      fl.foldLeft(xs, m.mzero, m.mappend)
    }

    out(sum(List(1, 2, 3, 4))) ==== 10
    out(sum(List("a", "b", "c", "d"))) ==== "abcd"

    // The traits Monoid and FoldLeft correspond to Haskell' typeclass. Scalaz provides many typeclasses.
    // All this is broken down into just hte pieces you need.
    // So it's a bit like ultimate ducktyping because you define in your function definition that
    // this is what you need and nothing more.
  }


  --------------("Method injection (enrich my library)")

  {
    import sumFunction.Monoid
    import sumFunction.Monoid._
    def plus[A: Monoid](a: A, b: A): A = implicitly[Monoid[A]].mappend(a, b)
    out(plus(3, 4)) ==== 7

    // What if we ant to provide an operator?
    // But we don't want to enrich just one type,
    // but enrich all types that has an instance for Monoid.
    // Scalaz 7 style:

    trait MonoidOp[A] {
      val F: Monoid[A]
      val value: A
      def |+|(a2: A) = F.mappend(value, a2)
    }

    // For any A for which Monoid exists, we define MonoidOp._ operations
    implicit def toMonoidOp[A: Monoid](a: A): MonoidOp[A] = new MonoidOp[A] {
      val F = implicitly[Monoid[A]]
      val value = a
    }

    out(3 |+| 4) ==== 7
    out("a" |+| "b") ==== "ab"
  }

  {
    // Using the same technique Scalaz also provides method injections
    // for standard library types like Option and Boolean:
    import scalaz._
    import Scalaz._
    out(1.some | 2) ==== 1
    out(Some(1).getOrElse(2)) ==== 1
    out((1 > 10)? 1 | 2) ==== 2
    out(if (1 > 10) 1 else 2) ==== 2

  }
}

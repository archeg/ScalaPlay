package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/21/2016.
  */
object day2_1_MakingOurOwnTypesAndTypeClasses extends ChapterApp {

  import scalaz._
  import Scalaz._
  =============================================("The Functor typeclass")

  // Here are we finally at the point where the main story started in LearningScalaz

  {
    // We've seen already scalaz implementation of functor:

    trait Functor_[F[_]] extends InvariantFunctor[F] {
      def map[A, B](fa: F[A])(f: A => B): F[B]    // fmap in Haskell.
      // Haskell's signature is fmap :: (a -> b) -> f a -> f b
      // in scalaz it is almost the same, but rather f a -> (a -> b) -> f b
    }

    // It is also very different than Equal, because Equal signature was Equal[F], when Functor is Functor[F[_]]
    // Now F is a type constructor comapred to the concrete type in Equal

    // In haskell functor is defined for lists:
    // instance Functor [] where            ([] is a type constructor here which was not obvious to me)
    //     fmap = map

    // Let's try it:
    val listFunctor = Functor[List]
    out(listFunctor.map(2 :: 4 :: 6 :: Nil)(_ * 2)) ==== List(4, 8, 12)

    // This example is a bit more precise than the one in LearningScalaz - this uses functor explicitly, while the one
    // from LearningScalaz actually didn't use it at all (embeded in list)

    // There is one that's defined for Maybe and Option:
    out(Functor[Option].map("Something serious. ".some)(_ + "HEY GUYS IM INSIDE THE JUST")) ==== "Something serious. HEY GUYS IM INSIDE THE JUST".some
    out(Functor[Option].map(none[String])(_ + "HEY GUYS IM INSIDE THE JUST")) ==== none

    out(Functor[Maybe].map(Maybe.just("Something serious. "))(_ + "HEY GUYS IM INSIDE THE JUST")) ==== Maybe.just("Something serious. HEY GUYS IM INSIDE THE JUST")
    out(Functor[Maybe].map(Maybe.empty[String])(_ + "HEY GUYS IM INSIDE THE JUST")) ==== Maybe.empty

    {
      // Or we could define the one ourselves
      case class Test[T](val value: T)
      implicit val functorInst = new Functor[Test]{
        override def map[A, B](fa: Test[A])(f: (A) => B): Test[B] =
          new Test(f(fa.value))

        override def xmap[A, B](ma: Test[A], f: (A) => B, g: (B) => A): Test[B] =
          new Test(f(ma.value))
      }

      out(Functor[Test].map(Test(5))(_*15)) ==== Test(75)
    }

    {
      val either = 5.left[String]

      // In scalaz library there are two maps, almost like Haskell propose, but they have different names
      out(either.map("!" + _)) ==== 5.left[String]
      out(either.leftMap(_*2)) ==== 10.left[String]

      // What about Functor?
      val value : Either[String, Int] = Right(5)
      out(Functor[({type λ[α] = Either[String, α]})#λ].map(value)(_ * 2.5)) ==== Right(12.5)

      // But if we do not use functor explicitly, it almost shine
      // (map is still used from Functor, because native implementation doesn't have map implementation
      // (but it's LeftProjection amd RightProjection have)
      val eitherVal = Right(5): Either[String, Int]
      out(eitherVal.map(_*2.5)) ==== Right(12.5)
      out(eitherVal.leftMap(_ + "!!!!")) ==== Right(5)
      import scala.reflect.runtime.universe.reify
      out(reify((Right(5) : Either[String, Int]).map(_*2.5)))

      // Let's try the same with \/
      out(5.left[String].map(_*2))
      // \/ has map method, so functor is not used.
      out(reify(5.left[String].strengthL(10)))
      // The functor is called \/.DisjunctionInstances1 as it is seen from reify

      out(\/.DisjunctionInstances1[String].map(5.right[String])(_*2.5)) ==== 12.5.right[String]
      // Hooray!!!!!
    }

    --------------("Kinds and some type-foo")

    {
        // Scala repl:
//      :k -v Maybe
//      scalaz.Maybe's kind is F[A]
//      * -> *
//      This is a type constructor: a 1st-order-kinded type.

      // Although it doesn't work always as expected:
//      :k -v Maybe[Int]
//      scalaz.Maybe's kind is F[A]
//      * -> *
//      This is a type constructor: a 1st-order-kinded type.

      // In Haskell it's kind will be *

//      :k -v Either
//      scala.util.Either's kind is F[+A1,+A2]
//      * -(+)-> * -(+)-> *
//      This is a type constructor: a 1st-order-kinded type.


      // Just a nice copypaste from learnyouahaskell:
//      class Tofu t where
//          tofu :: j a -> t a j
//      Man, that looks weird. How would we make a type that could be an instance of that strange typeclass?
      // Well, let's look at what its kind would have to be. Because j a is used as the type of a value that
      // the tofu function takes as its parameter, j a has to have a kind of *. We assume * for a and so we can
      // infer that j has to have a kind of * -> *. We see that t has to produce a concrete value too and that
      // it takes two types. And knowing that a has a kind of * and j has a kind of * -> *, we infer that t
      // has to have a kind of * -> (* -> *) -> *. So it takes a concrete type (a), a type constructor that takes
      // one concrete type (j) and produces a concrete type. Wow.

    }
  }
}

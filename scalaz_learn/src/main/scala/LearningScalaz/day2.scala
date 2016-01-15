package LearningScalaz

import CommonPlay.ChapterApp
import shapeless.test.illTyped

import scalaz.syntax.Ops

/**
  * Created by archeg on 12/16/2015.
  */
object day2 extends ChapterApp {
  import scalaz._
  import Scalaz._
  --------------("Functor")

  // LYAHFGG:
  // And now, we're going to take a look at the Functor typeclass,
  // which is basically for things that can be mapped over.
  {
    +++("Here is how it's implemented:")
    // TypeConstructor:
    trait Functor[F[_]] {
      self =>
      def map[A, B](fa: F[A])(f: A => B): F[B]
    }

    // Injected operators:
    trait FunctorOps[F[_], A] extends Ops[F[A]] {

      import scalaz.Leibniz.===

      implicit def F: Functor[F]

      final def map[B](f: A => B): F[B] = F.map(self)(f)
    }

    // This defines map method, which accepts a function A => B and returns F[B]

    out(List(1, 2, 3) map {_ + 1}) ==== List(2, 3, 4)
    // Scalaz defines Functor instances for Tuples:

    // note: https://groups.google.com/forum/#!topic/scalaz/lkrDLUV6HN4
    out((1, 2, 3) map {_ + 1}) ==== (1, 2, 4)
  }


  --------------("Function as Functors")

  {
    val f = ((x: Int) => x + 1) map {_ * 7}
    out(f(3)) ==== 28

    // map gives us a way to compose functions, except that the order is in reverse from f compose g
    // scalaz provides an alias ∘ if nao

    out((f ∘ {_ + 5})(10)) ==== 82

    // Another way of looking at Function1 is that it's an infinite map from the domain to the range

    // In haskell we have type:
    // fmap :: (a -> b) -> (r -> a) -> (r -> b)
    // fmap - functor map
    // this type accepts (a -> b) function and (r -> a) function and returns (r -> b) function
    // Function composition!

    // > fmap (*3) (+100) 1               // (1 + 100) * 3
    // 303
    // > (*3) . (+100) $ 1
    // 303

    // In Haskell the fmap seems to be working as the same order as f compose g.
    // Let's check in Scala using the same numbers:

    out((((_: Int) * 3) map {_ + 100}) (1)) ==== 103 //????  //1 * 3 + 100

    // Haskell's fmap:
    // fmap :: (a -> b) -> f a -> f b

    // final def map[B](f: A => B): F[B] = F.map(self)(f)
    // The order is different
    // > fmap (*3) [1, 2, 3]
    out(List(1, 2, 3) map {3*}) ==== List(3, 6, 9)

    +++("Lifting a function")
    // fmap takes a function a -> b, and returns a new function    in Haskell
    // that accepts a functor and returns a functor: f a -> f b
    // this is called "lifting a function"
    // Scala reverses the order, by taking a functor and then a -> b

    // lift function in scala:

    val g = Functor[List].lift {(_: Int) * 2} // so we take function a -> b, and apply a functor to both.
    out(g(5 :: 6 :: Nil))   // Type is (List[Int]) => List[Int]

    // Functor also enables some additional operators,
    // that overrides the values in the data structure like
    // >|, as, fpair, strengthL, strengthR and void:
    out(List(1, 2, 3) >| "x") ==== List("x", "x", "x")
    out(List(1, 2, 3) as "x") ==== List("x", "x", "x")
    out(List(1, 2, 3).fpair) ==== List((1, 1), (2, 2), (3, 3))
    out(List(1, 2, 3).strengthL("x")) ==== List(("x", 1), ("x", 2), ("x", 3))
    out(List(1, 2, 3).strengthR("x")) ==== List((1, "x"), (2, "x"), (3, "x"))
    out(List(1, 2, 3).void) ==== List((), (), ())
  }

  --------------("Applicative")

  {
    // LYAHFGG:
    // So far, when we were mapping functions over functors, we usually
    // mapped functions that take only one parameter.
    // But what happens when we map a function like *, which takes two parameters over a functor?

    illTyped("List(1, 2, 3, 4) map {(_: Int) * (_: Int)}")       // Naturally scala doesn't accept this.

    // We can try to curry it down:
    val currF = List(1, 2, 3, 4) map {(_: Int) * (_: Int)}.curried
    out(currF map {_(9)}) ==== List(9, 18, 27, 36)

    // This is I guess because haskell curries functions automatically

    // LYAHFGG:
    // Meet the Applicative typeclass. It lies in the Control.Applicative module
    // and it defines two methods, pure and <*> (bind?)

    // Let's see the contract for Scalaz's Applicative:
    {
      trait Applicative[F[_]] extends Apply[F] { self =>
        def point[A](a: => A): F[A]

        def pure[A](a: => A):F[A] = point(a) // Alias for point
      }

      // LYAHFGG:
      // pure should take a value of any type, and return an applicative value with that value inside it.
      // a better way of thinking about pure would be to say that it takes a value and puts it in some sort of default
      // (or pure) context - a minimal context that still yields that value.

      // I understand pure as a wrapper for applicative - constructor, that takes A, and returns F[A]
      // Scalaz likes the name point instead of pure, and it seems like it's basically a constructor that takes value A
      // and returns F[A]. It doesn't introduce an operator, but it introduces point method and it's symbolic alias
      // η to all data types

      out(1.point[List]) ==== List(1)
      out(1.point[Option]) ==== Some(1)
      out(1.point[Option] map {_ + 2}) ==== Some(3)
      out(1.point[List] map {_ + 2}) ==== List(3)

      // This is cool that we can abstract out and use point[T] for any T
    }

    --------------("Apply")

    {
      // LYAHFGG:
      // You can think of <*> as a sort of a beefed-up fmap
      // Whereas fmap takes a function and a functor and applies
      // the function inside the functor value,
      // <*> takes a functor that has a function in it and another functor
      // and extract that function from the first functor and then maps it over the second one.

      {
        trait Apply[F[_]] extends Functor[F] { self =>
          def ap[A, B](fa: => F[A])(f: => F[A => B]): F[B]
        }

        // Comparing to Functor and map:

        // def ap [A, B](fa: => F[A])(f: => F[A => B]): F[B]
        // def map[A, B](fa: F[A])   (f: A => B)      : F[B]

        // Using ap, Apply enabled <*>, *> and <* operators:
        out(9.some <*> {(_: Int) + 3}.some) ==== 12.some
        // F[_] = Option[_]
        // F[A] = 9.some
        // A = Int
        // F[A => B] = {(_: Int) + 3}.some = Option[A => B]. Some(_ + 3)
        // F[B] = 12.some

        out(9.some <*> {(_: Int) * 2.5}.some) ==== 22.5.some

        // *> and <* are variations that returns only the rhs or lhs
        out(1.some <* 2.some) ==== Some(1)
        out(none <* 2.some) ==== None
        out(1.some *> 2.some) ==== 2.some
        out(none *> 2.some) ==== none
      }

      --------------("Option as Apply")

      {
        out(9.some <*> {(_: Int) + 3}.some) ==== 12.some

        // We can curry 2-arity function:
        out(3.some <*> ( 9.some <*> {(_: Int) + (_: Int)}.curried.some)) ==== 12.some
      }

      {
        +++("Curried")

        val f: (Int, Int) => Int = _ + _

        out(f)
        val g: Int => Int => Int = f.curried

        out(g)
        val c: Int => Int = g(3)

        out(c)
        out(c(5)) ==== 8
      }

      --------------("Applicative Style")

      {
        out(^(3.some, 5.some) {_ + _}) ==== 8.some
        out(^(3.some, none[Int]) {_ + _}) ==== none
        // The same:
        out(3.some <*> ( 5.some <*> {(_: Int) + (_: Int)}.curried.some)) ==== 8.some
        out(3.some <*> ( none[Int] <*> {(_: Int) + (_: Int)}.curried.some)) ==== none

        // ^ extracts from contains and applies the function
        // The new ^ has some problems thouth. It doesn't handle Applicatives with n-arity type parameters.

        val f: Int => Int = _ + 5
        val g: Int => Int = _ * 3

        illTyped("out(^(f, g) {_ + _})")      // ^ won't work with function1
        val fg = (f |@| g) {_ + _}
        out(fg(5)) ==== 25
      }

      --------------("Lists as Apply")

      {
        // LYAHFGG:
        // Lists (actually the lis tytpe constructor, []) are applicative functors
        // What a surprise!

        // Let's use <*> and |@|:

        out(List(1, 2, 3) <*> List((_: Int) * 0, (_: Int) + 100, (x: Int) => x * x)) ==== List(0, 0, 0, 101, 102, 103, 1, 4, 9)

        out(List("3", "4") <*> { List("1", "2") <*> List({(_: String) + "+" + (_: String)}.curried, {(_: String) + "*" + (_: String)}.curried, {(_: String) + "-" + (_: String)}.curried)})

        out(List(3, 4) <*> { List(1, 2) <*> List({(_: Int) + (_: Int)}.curried, {(_: Int) * (_: Int)}.curried, {(_: Int) - (_: Int)}.curried)}) ====
          List(1+3, 1+4, 2+3, 2+4, 1*3, 1*4, 2*3, 2*4, 1-3, 1-4, 2-3, 2-4)

        out((List("a", "b", "c") |@| List("1", "2", "3")) {_ + _}) ==== List("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3")

        out(^(List(1, 2), List(3, 5)){_ + _}) ==== List(1 + 3, 1 + 5, 2 + 3, 2 + 5)
      }


      --------------("Zip Lists")

      {
        // LYAHFGG:
        // However [(+3), (*2)] <*> [1, 2] could also work in such a way that
        // the first function in the left list gets applied to the fifrst value in the right
        // one, the second function gets applied to the second value, and so on.
        // That would result in a list with two values, namely [4, 4]. You could look at it as
        // [1 + 3, 2 * 2]

        // This can be done in Scalaz, but not easily

        //val s = streamZipApplicative.ap(Tags.Zip(Stream(1, 2)))(Tags.Zip(Stream({(_: Int) + 3}, {(_: Int) * 2})))
//        val s = streamZipApplicative.ap(Tags.Zip(Stream(1, 2)))(Tags.Zip(Stream({(_: Int) + 3}, {(_: Int) * 2})))
//
//        out(s.toList) === List(4, 4)
        // This doesn't work for some reason, not sure why, I am yet too newbie to figure this out. Later
      }

      --------------("Useful functions for Applicatives")

      {
        // LYAHFGG:
        // Control.Applicative defines a function that's called liftA2, which has a type of
        // liftA2 :: (Applicative f) => (a -> b -> c) -> f a -> f b -> f c .

        val liftA2Result = Apply[Option].lift2((_: Int) :: (_: List[Int]))
        // lift2: (Int, List[Int]) => List[Int]
        // result: (Option[Int], Option[List[Int]]) => Option[List[Int]]
        out(liftA2Result(3.some, List(4).some)) ==== List(3, 4).some

        // LYAHFGG:
        // Let's try implementing a function that takes a list of applicatives and
        // returns an applicative that has a list as its result value.
        // We'll call it sequenceA

        // > sequenceA :: (Applicative f) => [f a] -> f [a]
        // > sequence [] = pure []
        // > sequence (x:xs) = (:) <$> x <*> sequenceA xs

        def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] =
          list match {
            case Nil => (Nil: List[A]).point[F]
            case x :: xs => (x |@| sequenceA(xs)) { _ :: _}
          }

        out(sequenceA(List(1.some, 2.some))) ==== List(1, 2).some

        out(sequenceA(List(3.some, none, 1.some))) ==== none
        out(sequenceA(List(List(1, 2, 3), List(4, 5, 6)))) ====
          List(List(1, 4), List(1, 5), List(1, 6), List(2, 4), List(2, 5), List(2, 6), List(3, 4), List(3, 5), List(3, 6))

        type Function1Int[A] = ({type l[A] = Function1[Int, A]})#l[A]

        // Looks to be too much for IntelliJ Idea to handle
        val f = sequenceA(List((_: Int) + 3, (_: Int) + 2, (_: Int) + 1): List[Function1Int[Int]])
        out(f(3)) ==== List(6, 5, 4)

      }
    }

  }
}

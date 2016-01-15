package LearningScalaz

import CommonPlay.ChapterApp
import shapeless.test.illTyped

/**
  * Created by archeg on 12/24/2015.
  */
object day7 extends ChapterApp {
  import scalaz._
  import Scalaz._
  =============================================("Applicative Builder")

  // |@| is Applicative Builder
  // On day 2 we introduced ^(f1, f2) {...} syntax
  // but this doesn't seem to work for functions or any type constructor with two parameters.

  out(^(3.some, 5.some) {_ + _})
  out((3.some |@| 5.some) {_ + _})

  =============================================("Tasteful stateful computations")

  // LYAHFGG:
  // Haskell features a thing called the state monad, which makes dealing
  // with stateful problems a breeze while still keeping everything nice and pure

  {
    // Stack implementaiton
    type Stack = List[Int]
    def pop(stack: Stack): (Int, Stack) = stack match {
      case x :: xs => (x, xs)
    }

    def push(a: Int, stack: Stack): (Unit, Stack) =
      ((), a :: stack)

    def stackManip(stack: Stack): (Int, Stack) = {
      val (_, newStack1) = push(3, stack)
      val (a, newStack2) = pop(newStack1)
      pop(newStack2)
    }

    out(stackManip(List(5, 8, 2, 1)))
  }

  --------------("State and StateT")

  object ourStackImpl
  {
    // LYAHFGG:
    // We'll say that a stateful computation is a function that takes some state
    // and returns a value along with some new state. That function would have
    // the following type:
    // s -> (a, s)

    // As with Writer State[S, +A] is a type alias of StateT[Id, S, A]

    // The important thing to note is that unlike the general monads, we've seen,
    // State specifically wraps functions.

    out(State[List[Int], Int] { case x :: xs => (xs, x) })

    // Let's try implementing the stack using State:

    type Stack = List[Int]

    val pop = State[Stack, Int] {
      case x :: xs => (xs, x)
    }

    def push(a: Int) = State[Stack, Unit] {
      case xs => (a :: xs, ())
    }

    def stackMunip: State[Stack, Int] =
      for {
        _ <- push(3)
        a <- pop
        b <- pop
      } yield b

    out(stackMunip(List(5, 8, 2, 1)))
  }

  ourStackImpl

  --------------("Getting and setting state")

  {
    // LYAHFGG:
    // The Control.Monad.State module provides a type class that's called
    // MonadState and it features two pretty useful functions, namely get and put

    // The State object extends StateFunctions trait which defines a few helper functions:
    trait StateFunctions {
      def constantState[S, A](a: A, s: => S): State[S, A] =
        State((_: S) => (s, a))
      def state[S, A](a: A): State[S, A] =
        State((_ : S, a))
      def init[S]: State[S, S] = State(s => (s, s))

      // Retrieve some state into the value
      def get[S]: State[S, S] = init
      def gets[S, T](f: S => T): State[S, T] = State(s => (s, f(s)))

      // Put in this context means to put some value into the state
      def put[S](s: S): State[S, Unit] = State(_ => (s, ()))
      def modify[S](f: S => S): State[S, Unit] = State(s => {
        val r = f(s);
        (r, ())
      })

      // delta seems to be no longer there
//      def delta[A](a: A)(implicit A: Group[A]): State[A, A] = State{
//        (prevA) =>
//          val diff = A.minus(a, prevA)
//          (diff, a)
//      }
    }

  }

  {
    import ourStackImpl._

    // example:
    def stackyStack: State[Stack, Unit] =
      for {
        stackNow <- get
        r <- if (stackNow === List(1, 2, 3))
                put(List(8, 3, 1))
             else
                put(List(9, 2, 1))
      } yield r

    out(stackyStack(List(1, 2, 3))) ==== (List(8, 3, 1), ())
    out(stackyStack(List(1, 2, 4))) ==== (List(9, 2, 1), ())

    // We can also implement a pop and push using get and put:

    def pop2: State[Stack, Int] =
      for {
        s <- get[Stack]
        (x :: xs) = s
        _ <- put(xs)
      } yield x

    def push2(x: Int): State[Stack, Unit] =
      for {
        xs <- get[Stack]
        r <- put(x :: xs)
      } yield r
  }

  =============================================("\\/")

  {
    // LYAHFGG:
    // The `Either e` a type on the other hand, allows us to incorporate a context
    // of possible failure to our values while also being able to attach values
    // to the failure, so that they can describe what went wrong or provide some other useful
    // info regarding the failure.

    // We know Either[A, B] from the standard library, but Scalaz 7 implements its own Either
    // equivalent named \/

    // \/ has two realizations: -\/ and \/-, which are left and right

    // Left is usually an error, when right is a value

    out(1.right[String]) ==== \/-(1)
    out("error".left[Int]) ==== -\/("error")

    // The Either type in scala is not a monad on its own, which means it does not implement
    // flatMap method with or without Scalaz:
    illTyped("""Left[String, Int]("boom") flatMap { x => Right[String, Int](x + 1) }""")

    // you have to call right method to turn it into RIghtProjection:
    out(Left[String, Int]("boom").right flatMap {x => Right[String, Int](x + 1)})

    // Scalaz's \/ assumes that you'd mostly want right projection:
    out("boom".left[Int] >>= {x => (x + 1).right})
  }

  {
    // Let's try using it in for syntax:
    out(for {
      e1 <- "event 1 ok".right
      e2 <- "event 2 failed!".left[String]
      e3 <- "event 3 failed!".left[String]
    } yield e1 |+| e2 |+| e3)

    // How do we get the value out of \/?
    out("event 1 ok".right | "something bad")
    out("event 1 ok".left | "something bad")

    out(~"event 2 failed!".left[String] | "something good")  // If we swapped values

    out("event 1 ok".right map {_ + "!"})

    out("event 1 failed!".left ||| "retry event 1 ok".right)
    out("1!".right ||| "2!".right)
    out("1!".left ||| "2!".left)
  }

  =============================================("Validation")

  {
    // Another data structure that's compared to Either in Scalaz is Validation:
    sealed trait Validation[+E, +A] {
      def isSuccess: Boolean = this match {
        case Success(_) => true
        case Failure(_) => false
      }

      def isFailure: Boolean = !isSuccess
    }

    final case class Success[E, A](a: A) extends Validation[E, A]
    final case class Failure[E, A](e: E) extends Validation[E, A]
  }

  {
    // At the first glance Validation looks similar to \/.
    // They can even be converted back and forth using validation method
    // and disjunction method.

    // ValidationOps introduces success[X], successNel[X], failure[X], failureNel[X]
    // methods to all data types (don't worry about the Nel thing for now)

    out("event 1 ok".success[String])
    out("event 1 failed!".failure[String])

    // What's different about Validation is that it is not a monad, but it's an applicative functor
    // Instead of chaining the result from first event to the next, Validation validates all events.

    out(("event 1 ok".success[String] |@| "event 2 failed!".failure[String] |@| "event 3 failed!".failure[String]){_ + _ + _})

    // Unlike \/ monad that cuts calculation after first fail, Validation keeps going and reports back all failures.
  }

  --------------("NonEmptyList")

  {
    def nel[A](h: A, t: List[A]): NonEmptyList[A] =
      ???

    // The problem, however, is that the error messages are mushed together into one string. Shouldn't it be something like a list?
    sealed trait NonEmptyList[+A] {
      val head: A
      val tail: List[A]
      def <::[AA >: A](b: AA): NonEmptyList[AA] = nel(b, head :: tail)
    }


    // This is a wrapper trait for plain list thats guaranteed to be non-empty.
    // Since there's at least one item in the list, head always works.
    // IdOps adds wrapNel to all data types to create a Nel.
  }

  {
    out(1.wrapNel)

    out("event 1 ok".successNel[String])
    out("event 1 failed!".failureNel[String])
    out(("event 1 ok".successNel[String] |@| "event 2 failed!".failureNel[String] |@| "event 3 failed!".failureNel[String]) {_ + _ + _})
  }
}

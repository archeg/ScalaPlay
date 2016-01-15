/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ShortGrounds

import CommonPlay.ChapterApp

/**
  * Created by archeg on 11/25/2015.
  */
object Functors extends ChapterApp {

//    m :: * -> *                                      // In scala:
//  class Monad m where
//    (>>=)  :: m a -> (a -> m b) -> m b               // flatMap
//    (>>)   :: m a -> m b -> m b
//    return :: a -> m a                               // apply()
//    fail   :: String -> m a                          // Exception?
//  class Functor f where
//    fmap   :: (a -> b) -> f a -> f b                 //  map


  // In haskell:
  // class Monad m where
  //  (>>=)  :: m a -> (a -> m b) -> m b
  //
  // m - container (F[_])
  //  (>>=)  :: F[A] -> (A -> F[B]) -> F[B]
  // in scala bind method is called flatMap

  // ---------------- Here and below F is category  -------------------------

  trait Monad[F[_]]{                               // Monad type class (haskell way)
    def flatMap[A, B](f: A => F[B]): F[A] => F[B]         // F[A] - this.
  }

  trait Monad2[F[A]]{                               // Monad (scala way)
    def flatMap[A, B](f: A => F[B]): F[B]           // this now is F[A] from the previous post
  }

  trait Functor[F[_]] {                             // Functor
    def map[A, B](f : A => B): F[A] => F[B]
  }

  trait Functor2[F[A]] {
    def map[A, B](f : A => B): F[B]
  }

  trait Applicative[F[_]] {
    def apply[A, B](f: F[A => B]): F[A] => F[B]
  }

  trait Applicative2[F[A]] {
    def apply[A, B](f: F[A => B]): F[B]
  }

  // In scala Option is Maybe monad.

  object OptionMonad extends Monad[Option] {          // Type class
    override def flatMap[A, B](f: (A) => Option[B]):
      (Option[A]) => Option[B] = x => if (x.isEmpty) None else f(x.get)
  }

  case class User(id: Int)
  def getUserById(userId: Int): Option[User] = userId match {
    case 2 => Some(User(userId))
    case _ => None
  }

  case class Phone(user: User)
  def getPhone(user: User): Option[Phone] = Some(Phone(user))

  // I can easily write function getPhoneByUserId(userId: Int) since Option is a monad:
  def getPhoneByUserId(userId: Int): Option[Phone] =
    getUserById(userId).flatMap(user => getPhone(user))

  // Or use the monad separately (same):
  def getPhoneByUserId2(userId: Int): Option[Phone] = {
    val map = OptionMonad.flatMap[User, Phone](user => getPhone(user))
    map(getUserById(userId))
  }

  class MyOption[A] extends  Monad2[MyOption] {
    // Monad (scala way)
    override def flatMap[A, B](f: (A) => MyOption[B]): MyOption[B] = ???
  }

  // In Scala monad (any monad) allows for foreach to be used
  for (x <- Some(2)) println("X is 2: " + x)    // Results in 2
  for (x <- None) println("Prints nothing " + x)

  // Even better:
  val res : Option[Int] = for (x <- Some(2)) yield x * 2
  println("res is now Some(4): " + res)
  // this was translated into:
  println(Some(2).flatMap(x => Some(x * 2)))

  // Another option:
  println("Prints None: ")
  println(for (x <- Some(2) if x % 2 != 0) yield x * 2)
  println("Prints None: ")
  println(Some(2).flatMap(x => if (x % 2 != 0) Some(x*2) else None))


  --------------("Usual monad implementations.")

  // Monad type class (haskell way)
  // Maybe monad returns the value only if both arguments (F[A] and F[B]) has the result (has A and B)
  object MaybeMonad extends Monad[Option]{
    override def flatMap[A, B](f: (A) => Option[B]):
      (Option[A]) => Option[B] = self => if (self.isEmpty) None else f(self.get)
  }

  // Class IO holds a value - monadic wrapper???
  case class IO[+A](val ra: () => A) {
    override def equals(o: Any) = o match {
      case IO(r: (() => A)) => r() == ra()
      case _ => false
    }

    override def toString: String = "() => " + ra().toString
  }

  // IO monad just computes a value one by one.
  object IOMonad extends Monad[IO] {
    // Monad type class (haskell way)
    override def flatMap[A, B](f: (A) => IO[B]): (IO[A]) => IO[B] =
      self => f(self.ra())   // Computes self, then f
  }

  out(IOMonad.flatMap[Int, Int](x => IO(() => x * 2))(IO(() => 3))) ==== IO(() => 6)


  // List monad computes all possible results from the second computation that applied to each of the first computation

  object ListMonad extends Monad[List]{
    // Monad type class (haskell way)
    override def flatMap[A, B](f: (A) => List[B]): (List[A]) => List[B] =
      self => for (x <- self; y <- f(x)) yield y                           // Yeah, I'm using the monad of List[A] from scala library here. Whatever.
  }

  // S is the state type - something that we want to store
  // A is the return value of the operation performed by State (see end of paragraph)
  case class State[S, +A](val ra: S => (S, A)){   // S is the type of the state
    def apply(s: S) = ra(s)

    def flatMap[B](f: A => State[S, B]): State[S, B] =    // Monad side.
      new StateMonad[S].flatMap(f)(this)

    def map[B](f: A => B): State[S, B] =                  // Functor side.
      new State(s => { val (s1, a) = apply(s); (s1, f(a))})
  }                                                // A is the type of the value to decorate.

  class StateMonad[S] extends Monad[({type f[x]=State[S, x]})#f]{
    // Monad type class (haskell way)
    override def flatMap[A, B](f: (A) => State[S, B]): (State[S, A]) => State[S, B] =
      self => State(r => {
        val (s, x) = self(r)
        f(x)(s)
      })
  }

  val state : State[List[Int], Int] = State { case x :: xs => (xs, x) }

  // implement a stack using State:
  type Stack = List[Int]
  val pop = State[Stack, Int] {
    case x :: xs => (xs, x)
  }
  def push(a: Int) = State[Stack, Unit] {
    case xs => (a :: xs, ())
  }
  def stackManip: State[Stack, Int] = for {
    _ <- push(3)                   // Should be applicative? because _ is not used.
    a <- pop                       // Should be applicative? because a is not used.
    b <- pop
  } yield b

  // stackManip desugares into:
  def stackManip2: State[Stack, Int] =
    (push(3)).flatMap { case _ => (pop).flatMap { case a => (pop).map { case b => b } } }

  // Though you could just:
  def stackManip3: State[Stack, Int] =
    (push(3)).flatMap { case _ => (pop).flatMap { case a => pop } }

  out(stackManip(List(5, 8, 2, 1)))
  out(stackManip2(List(5, 8, 2, 1)))
  out(stackManip3(List(5, 8, 2, 1)))
  --------------("Applicative functor")

  // An applicative functor has more structure than a functor but less than a monad.
  trait MyApplicative[F[_]] {
    def apply[A, B](f: F[A => B]): F[A] => F[B]                           // In scalaz is called |@|
  }

  // Literally: we take a box that transforms apples to plumps and give it a box of apples.

  val f = (x: Int) => x + 1                     // Functor
  out(Option(5) map f) ==== Some(6)
  val g = (x: Int) => (y: Int) => x + y
  out(Option(5) map g) ==@ "Some(<function1>)"  // We received an applicative.

  val applicative = Option(5) map g
  // In scala Option is not an applicative. But if it was, we could have done this:
  //Option(10).apply(applicative) === Some(15)

  // In scalaz:
  // (Applicative[Option] apply (Functor[Option] map g)(Option(5)))(Option(10))

  // -------------------------- Why do we need applicatives?

  def longComputation: Option[Symbol] = Some('b)
  def longComputation2: Option[Int] = Some(7)
  case class Foo(s: Symbol, n: Int)
  val maybeFoo = for {                // When we write this it looks like longComputation and longComputation2 could have been executed in parallel
    s <- longComputation
    n <- longComputation2
  } yield Foo(s, n)

  // But they never are:
  // If it is desugared, s is not used in longComputation2 vvvvvvvvvvvvvvvv
  // But it still have to be done after s is received
  val maybeFoo2 = (longComputation).flatMap { case s => (longComputation2).map { case n => Foo(s, n) } }

  // In case if we use applicative, compiler might optimize (but scalac doesn't do that yet):

  // We are explicitly stating that there's no dependency between the two computations.
  //val maybeFoo3 = (longComputation |@| longComputation2)(Foo(_, _))
}

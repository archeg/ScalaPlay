package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/24/2016.
  */
object day3_FunctorsApplicativeFunctorsAndMonoids extends ChapterApp {
  import scalaz._
  import Scalaz._


  // We've been here before
  {
    // scalaz functor has map method instead of fmap:

    abstract class Functor[F[_]]{
      def map[A, B](fa: F[A])(f: A => B): F[B]
    }
  }

  {
    // For Either we should fix the first type argument for it to be Functor
    // fmap :: (b -> c) -> Either a b -> Either a c

    // In scalaz Either monad is right biased, so it works
    out(5.right[String].map(x => x + 1)) ==== \/-(6)
  }

  {
    import scalaz.effect._

    val main = for {
      line <- IO.readLn map {_.reverse}            // We can use map over IO[_] because IO is a Functor!
      _ <- IO.putStrLn(s"You said $line backwards!")
    } yield ()

    //main.unsafePerformIO()
  }

  {
    // -> r is also a Functor in Haskell
    // This corresponds to scala A => ?
    // or Function1[A, ?]

    val fun = (x: Int) => x * x
    val fun2 = fun map (x => x + 1)
    out(fun2(5)) ==== 26

    import scala.reflect.runtime.universe.reify

    //out(reify(fun map (x => x + 1)))
    //Expr[Int => Int](Scalaz.ToFunctorOpsUnapply(fun)(Unapply.unapplyMAB2(Scalaz.function1Covariant)).map(((x) => x.$plus(1))))

    val funFunctor = Unapply.unapplyMAB2(Scalaz.function1Covariant[Int])
    out(Functor[funFunctor.M].map(fun)(x => x + 1)(5)) ==== 26
    val implicitFun = implicitly[Functor[funFunctor.M]].map(fun)(x => x + 1)
    out(implicitFun(5)) ==== 26
  }

  {
    // Functor laws (Identity law)
    // fmap id = id
    out(Functor[List].functorLaw.identity(List(1, 2, 3))) ==== true

    // Functor laws (Distributive law)
    // fmap (f . g) = fmap f . fmap g
    out(Functor[List].functorLaw.composite(List(1, 2, 3), (x: Int) => x * 3, (x: Int) => x + 1)) ==== true
    out(Functor[Option].functorLaw.composite(3.some, (x: Int) => x * 3, (x: Int) => x + 1)) ==== true
  }

  {
    // Let's see what happens if we do not obey the laws
    sealed abstract class CMaybe[+T]
    case object CNothing extends CMaybe[Nothing]
    case class CJust[T](counter: Int, v: T) extends CMaybe[T]

    implicit val cMaybeFailedFunctor = new Functor[CMaybe] {
      override def map[A, B](fa: CMaybe[A])(f: (A) => B): CMaybe[B] = fa match {
        case CNothing => CNothing
        case CJust(counter, v) => CJust(counter + 1, f(v))
      }
    }

    implicit def cMaybeEq[T] = new Equal[CMaybe[T]] {
      override def equal(a1: CMaybe[T], a2: CMaybe[T]): Boolean = a1 == a2
    }

    out(Functor[CMaybe].functorLaw.identity(CJust(3, 3))) ==== false

    // This makes this type class not intuitive as a functor, so it's not a functor.
  }

  // http://learnyouahaskell.com/functors-applicative-functors-and-monoids
  // Ctrl+F Applicative functors

  =============================================("Applicative functors")

  {
    // partially apply function to Just(3)
    // fmap (*) (Just 3)
    // Looks weird in scala, because scala does not curry functions by default. So we need to translate * into a curried one.
    val curriedMultOp = (y: Int) => (x: Int) => x * y
    val curriedMultOp2 = ((x: Int, y: Int) => x * y).curried
    val partialJust: Maybe[Int => Int] = Maybe.just(3) map curriedMultOp
    // This is 'Just (something)' value, it needs something to be *
    // So it is Just (* 3)
    // or Just(x => x * 3)

    // And what can we do with that?
    // We can apply some value to it:
    out(partialJust map {x => x(4)}) ==== Maybe.Just(12)

    // But what if we have functor like partialJust and a value also wrapped in functor, like Just 4?

    // Applicative to the rescue!
//    class (Functor f) => Applicative f where
//    pure :: a -> f a                 // In scalaz it's point
//      (<*>) :: f (a -> b) -> f a -> f b

    val f = 3.point[Maybe]
    out(f) ==== Maybe.just(3)

    out(3.some <*> ((x: Int) => x + 3).some)          // <*> is a symbol for ap function, but ap exists only in F

    // Maybe in Haskell
    //    instance Applicative Maybe where
    //      pure = Just
    //      Nothing <*> _ = Nothing
    //      (Just f) <*> something = fmap f something

    // We can do something much more cooler:

    //out(((x: Int, y: Int) => x + y).curried.pure[Option] <*> 3.some <*> 5.some) ==== 8.some
    // We have different order than in scala:

    //pure (+) <*> Just 3 <*> Just 5
    out(5.some <*> (3.some <*> ((x: Int, y: Int) => x + y).curried.some)) ==== 8.some
    // or:
    out(^(5.some, 3.some) {_ + _}) ==== 8.some

    // or:
    out((5.some |@| 3.some) {_ + _}) ==== 8.some
    // This one called applicative builder, and accepts n-arity:
    out((5.some |@| 3.some |@| 4.some) {_ + _ + _}) ==== 12.some
  }

  --------------("Other applicatives")

  {
    // List are applicative functors.

    out(3.pure[List]) ==== List(3)

    out(3.pure[List] <*> (4.pure[List] <*> ((x: Int, y: Int) => x + y).curried.pure[List])) ==== List(7)
    out(List(3) <*> (List(4) <*> List(((x: Int, y: Int) => x + y).curried))) ==== List(7)

    out((List(3, 4) |@| List(5, 6)) {_ + _}) ==== List(8, 9, 9, 10)
    out((List(3, 4) |@| List(5, 6) |@| List(10, 11)) {_ + _ + _}) ==== List(18, 19, 19, 20, 19, 20, 20, 21)

    //[(*0),(+100),(^2)] <*> [1,2,3]
    out(List(1, 2, 3) <*> List[Int => Int](_ * 0, _ + 100, x => x * x))==== List(0, 0, 0, 101, 102, 103, 1, 4, 9)

    // Haskell is more fun with it's type inference:
    // pure "Hey" :: [String]
    // pure "Hey" :: Maybe String


    // In Haskell it looks awesome. Unfortunately not so awesome in scalaz
    // [(+),(*)] <*> [1,2] <*> [3,4]
    out(List(3, 4) <*> (List(1, 2) <*> List[(Int, Int) => Int](_+_, _*_).map(_.curried))) ==== List(4, 5, 5, 6, 3, 4, 6, 8)

    // [ x*y | x <- [2,5,10], y <- [8,10,11]]
    out(for (
      x <- List(2, 5, 10);
      y <- List(8, 10, 11)
    ) yield x * y) ==== List(16, 20, 22, 40, 50, 55, 80, 100, 110)

    // ghci> [(*)] <*> [2,5,10] <*> [8,10,11]
    out(List(8, 10, 11) <*> (List(2, 5, 10) <*> List[(Int, Int) => Int](_*_).map(_.curried)))  ==== List(16, 20, 22, 40, 50, 55, 80, 100, 110)
    // ghci> (*) <$> [2,5,10] <*> [8,10,11]
    out(List(8, 10, 11) <*> List(2, 5, 10).map(x => (y: Int) => x * y))  ==== List(16, 20, 22, 40, 50, 55, 80, 100, 110)
  }

  {
    // IO is also an applicative
    // instance Applicative IO where
    //    pure = return
    //    a <*> b = do
    //      f <- a
    //    x <- b
    //    return (f x)

    import scalaz.effect.IO

    val action1: IO[String] = for {
      x <- IO.readLn
      y <- IO.readLn
    } yield x + y   // asks for two string and concatenates them, returning as IO[String]

    val action2: IO[String] = IO.readLn <*> IO.readLn.map(x => (y: String) => x + y)  // same
    // It still looks much cleaner in Haskell:
    // (++) <$> getLine <*> getLine
    // or:
    // main = do
    //    a <- (++) <$> getLine <*> getLine
    //    putStrLn $ "The two lines concatenated turn out to be: " ++ a
  }

  {
    // Functions are also applicatives

    val r: Int => Int = ((x: Int) => x + 1) <*> ((x: Int) => (y: Int) => x + y)
    out(r(5)) ==== 11

    // f <*> g = \x -> f x (g x)
    // f = x + y
    // g = x + 1
    // f <*> g = x + (x + 1)

//    ghci> (\x y z -> [x,y,z]) <$> (+3) <*> (*2) <*> (/2) $ 5
//    [8.0,10.0,2.5]

    out((((x: Double) => x / 2) <*> (((x: Double) => x * 2) <*> ((x: Double) => x + 3).map(x => (y: Double) => (z: Double) => (x, y, z))))(5)) ====
      (8.0, 10.0, 2.5)

    // So for functions <*> sequences it with another function, reducing the arity of the last one
    // f = x + y
    // g = z + 1
    // f <*> g = x + (x + 1)
  }

  // http://learnyouahaskell.com/functors-applicative-functors-and-monoids
  // Ctrl+F Same here. We create a function that will call the function


}

package LYAHFGG

import CommonPlay.ChapterApp
import shapeless.test.illTyped

import scala.reflect.ClassTag
import scalaz.Alpha.T

/**
  * Created by archeg on 1/18/2016.
  */
object day1_3_makingOurOwnTypesAndTypeClasses extends ChapterApp {
  import scalaz._
  import Scalaz._

  // Algebraic data types

  // I guess the correct representation is:
  {
    sealed abstract class Bool
    case object False extends Bool
    case object True extends Bool

    // But this is not how Bool is defined in scala.
  }

  {
    sealed abstract class Shape
    case class Circle(x: Double, y: Double, r: Double) extends Shape
    case class Rectangle(x1: Double, y1: Double, x2: Double, y2: Double) extends Shape

    // imports just for fun
    import math.{Pi => pi, pow => ^, abs}
    def surface(shape: Shape) = shape match {
      case Circle(_, _, r) => pi * ^(r, 2)
      case Rectangle(x1, y1, x2, y2) => abs(x2 - x1) * abs(y2 - y1)
    }

    out(surface(Circle(10, 20, 10))) ==~ 314.1
    out(surface(Rectangle(0, 0, 100, 100))) ==~ 10000.0

    illTyped("""out(Circle(10, 20, 10).shows)""")
  }

  {
    sealed abstract class Shape
    case class Circle(x: Double, y: Double, r: Double) extends Shape
    case class Rectangle(x1: Double, y1: Double, x2: Double, y2: Double) extends Shape


    // This makes Circle part of Show type-class
    implicit val showImplicit = Show.showFromToString[Circle]
    out(Circle(10, 20, 10).show)

  }

 {
    //http://learnyouahaskell.com/making-our-own-types-and-typeclasses
    // ctrl+f Type parameters

    // In scala we can make polymorphic types with Nothing.
    out(1 :: 2 :: 3 :: 4 :: 5 :: Nil)
    // This works because Nil is List[Nothing], where List[Nothing] <: List[Int], because Nothing <: Int and List[T] is List[+T]
    out(Nil : List[Int])

    // This corresponds to haskell 'Nothing' being 'Maybe a', although haskell seem to use very different mechanics
    out(None.asInstanceOf[Option[Int]]) ==== None
    // For example because Maybe[T] is invariant, this won't work:

    // Here empty is empty[Nothing]
    out(Maybe.empty)

    // Here Empty() (the same as empty) is empty[Int], because of type inference
    out(Maybe.Empty() : Maybe[Int]) ==== Maybe.empty[Int]
    // Notice that Nil and Maybe.empty are very different, because Nil extends Option[Nothing], but Empty[T] extends Maybe[T]

    // P.S. This is actually a very interesting topic in scala
   }

  {
    // In haskell:
    // data Car a b c = Car { company :: a
                        //    , model :: b
                         //    , year :: c
                        //  } deriving (Show)

    case class Car[A, B, C](company: A, model: B, year: C)
    implicit val car = Show.showFromToString[Car[String, String, Int]]
    out(Car[String, String, Int]("Mercedes", "X", 2005).show)
  }

  {
    // Making a Car belong to Equal typeclass
    case class Car(company: String, model: String)
    implicit val eq = Equal.equalA[Car]
    out(Car("Hello", "W") === Car("Hello", "W"))

    // What if one of arguments do not belong to Equal typeclass?

    case class A(c: String)
    case class B(name: String, a: A)
    implicit val eq2 = Equal.equalA[B]
    out(B("1", A("2")) === B("1", A("3")))
    out(B("1", A("2")) === B("1", A("2")))
    // Weirdly it can process that?
    // This is because equalA is implemented with ==, which is defined for any case class. It uses Bs ==

    // This is different than in Haskell, which won't process that because A does not belong to Equal:
    // data A = A { s::String }
    // data B = B { s:: String, a::A } deriving (Equal)
    // ---- error

    implicit val ord = Order.order[A]((f, s) => Ordering.EQ)
    out(A("1").gte(A("2")))

    import scala.reflect.runtime.universe.reify
    out(reify(A("1").gte(A("2")))) ==@ "Expr[Boolean](Scalaz.ToOrderOps(A.apply(\"1\"))(ord).gte(A.apply(\"2\")))"
  }

  {
    // Algebraic types are more complicated in Scala than in Haskell, but not THAT complicated
    object DayModule {

      abstract class Day(val dayNumber: Int)
      case class Monday() extends Day(1)
      case class Tuesday() extends Day(2)
      case class Wednesday() extends Day(3)
      case class Thursday() extends Day(4)
      case class Friday() extends Day(5)
      case class Saturday() extends Day(6)
      case class Sunday() extends Day(7)
    }

    {
      import DayModule._
      illTyped("(Wednesday() : Day) === Friday()") // Eq
      illTyped("(Wednesday() : Day) gt Friday()")  // Ord
      illTyped("(Wednesday() : Day).show")         // Show
      // scalaz doesn't have read
      illTyped("implicitly[Enum[Day]].min") // Bounded
      illTyped("(Monday():Day) |-> Friday()") // Enum
    }

    {
      import DayModule._
      implicit val eq = Equal.equalA[Day]  // Eq
      implicit val ord = Order.order[Day]((x, y) => x.dayNumber cmp y.dayNumber)  // Ord
      implicit val show = Show.showA[Day] // Show
      implicit val showMonday = show.contramap[Monday](x => x)    // So show would work with Monday type as well. ????
      // scalaz doesn't have read

      implicit val enum = new Enum[Day] {
        override def succ(a: DayModule.Day): DayModule.Day = a match {
          case Monday() => Tuesday()
          case Tuesday() => Wednesday()
          case Wednesday() => Thursday()
          case Thursday() => Friday()
          case Friday() => Saturday()
          case Saturday() => Sunday()
          case Sunday() => Monday()
        }

        override def pred(a: DayModule.Day): DayModule.Day =  a match {
          case Monday() => Sunday()
          case Tuesday() => Monday()
          case Wednesday() => Tuesday()
          case Thursday() => Wednesday()
          case Friday() => Thursday()
          case Saturday() => Friday()
          case Sunday() => Saturday()
        }

        override def order(x: DayModule.Day, y: DayModule.Day): Ordering = x.dayNumber cmp y.dayNumber

        override def min: Option[Day] =
          Monday().some
        override def max: Option[Day] =
          Sunday().some
      }


      def checkEq(x: Day, y: Day) = x === y
      out((Monday() : Day) === (Friday(): Day)) ==== false
      out((Monday() : Day) === (Monday(): Day)) ==== true

      out(checkEq(Monday(), Friday())) ==== false
      out(checkEq(Monday(), Monday())) ==== true

      out((Monday() : Day) lt (Friday() : Day)) ==== true

      out((Monday() : Day).show)
      out(Monday().show)

      out((Monday() : Day).succ)
      out((Monday():Day) |-> Friday())
      out(implicitly[Enum[Day]].min)
    }

    {
      // Partially apply functions:
      def fun(a: Int, b: Int)(c: String, d: String) = a + b + c + d

      out(fun(2, 3)_)
      out((x: String) => fun(2, 3)(x, "H"))

      // Partially applied types:
      abstract class Test[A, B] {def test(a: A): B}
      type T[X] = Test[Int, X]
      class Test1 extends T[Int] {
        override def test(a: Int): Int = ???
      }
    }

    {
      // Scalaz Either
      def test(a: Int): Int \/ String =
        if (a > 0) a.left[String] else a.toString.right[Int]

      println(test(5))
      println(test(-5))
    }

    {
      // Binary search tree
      sealed abstract class Tree[+T]
      case object EmptyTree extends Tree[Nothing]
      case class Node[T](value: T) extends Tree[T]

      implicit def show[T] = Show.showA[Tree[T]]

      out((EmptyTree : Tree[Int]).show)
      out(EmptyTree.showMy)                   // But this doesn't work without the next line. Problem :(

      implicit class MyShowOps[A, T <: Tree[A]](t: T) {
        def showMy(implicit ev: Show[Tree[A]]): String = ev.shows(t)
      }
    }

    {
      // This is a proper way to solve subclass typing ADT problem:
      sealed abstract class Tree[+T]
      object Tree {
        private[this] case object EmptyTree extends Tree[Nothing]
        private[this] case class Node[T](value:T) extends Tree[T]

        val emptyTree: Tree[Nothing] = EmptyTree
        def node[T](value: T): Tree[T] = Node(value)

        implicit def show[T]: Show[Tree[T]] = Show.showA[Tree[T]]
      }

      // Now I can do a proper:
      out(Tree.emptyTree.show)

      // This problem has a simpler example:
      illTyped("""List(1, 2, 3).foldLeft(Some(0))((acc, i) => acc.map(_ + i))""")
      // Because foldLeft bases itself on Some(0), it's infered type is Some[Int], which does not conform to Option[Int] that map returns
      // scalaz is designed to solve this issue:
      out(List(1, 2, 3).foldLeft(0.some)((acc, i) => acc.map(_ + i)))
    }


  }
}

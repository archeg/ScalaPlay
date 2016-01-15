package LearningScalaz

import CommonPlay.ChapterApp
import shapeless.test.illTyped

import scala.collection.immutable.NumericRange
import scala.util.Try

/**
  * Created by archeg on 12/15/2015.
  */
object day1 extends ChapterApp {
  // A typeclass is a sort of interface that defines some behavior.
  // If a type is a part of a typeclass, that means that it supports and implements the behavior
  // the typeclass describes.

  import scalaz._
  import Scalaz._

  --------------("Equal")

  {
    // LYAHFGG: Eq is used for types that support equality testing. The functions its members implement are == and /=
    // Scalaz equivalent for the Eq typeclass is called Equal:
    out(1 === 1) ==== true
    illTyped("""1 === "foo"""")
    // but:
    out(1 == "foo")  // type mismatch; found   : String("foo") required: Int
    // So === allows us to fail in compile time if we compare two different types

    out(1.some =/= 2.some) ==== true
    out(Try(out(1 assert_=== 2)))

    // /== should not be used, and =/= should be used instead.
    // because /== has a bad precendence:
    illTyped("""1 /== 2 && false""", "value && is not a member of Int")
    out(1 =/= 2 && false) ==== false
  }

  --------------("Order")

  {
    // LYAHFGG: Ord is for types that have an ordering. Ord covers all the standard
    // comparing functions such as >, <, >= and <=

    // Scalaz equivalent for the Ord typeclass is Order:

    out(1 > 2.0) ==== false
    illTyped("""1 gt 2.0""")   // type mismatch; found: Double(2.0) required: Int

    out(1.0 ?|? 2.0) ==== scalaz.Ordering.LT

    out(1.0 max 2.0) ==== 2.0

    // Order enabled ?|? which returns Ordering: LT, GT and EQ.
    // similar to Equal comparing Int and Double fails compilation
  }

  --------------("Show")

  {
    // LYAHFGG: Members of Show can be presented as strings.
    // Scalaz equivalent for the Show typeclass is Show:

    out(3.show)
    out(3.shows) ==== "3"
    "hello".println

    // Cord apparently is a purely function data structure for potentially long Strings.
  }

  --------------("Read")

  {
    // LYAHFGG: Read is sort of the opposite typeclass of Show. The read function takes a
    // string and returns a type which is a member of Read.

  }

  --------------("Enum")

  {
    // LYAHFGG: Enum members are sequentially ordered types - they can be
    // enumerated. The main advantage of the Enum typeclass is that we can use
    // its types in list ranges. They also have defined successors and predecessors
    // which you can get with the succ and pred functions.

    out('a' to 'e') ==== NumericRange('a', 'f', 1.toChar)

    out('a' |-> 'e') ==== List('a', 'b', 'c', 'd', 'e')

    out('a' |=> 'e') ==% "scalaz.EphemeralStream"

    out('b'.succ) ==== 'c'

    out('a' -+- 5) ==== 'f'
    out('f' --- 5) ==== 'a'
    out('f' from)
    out(('f' from).take(2).toList) ==== List('f', 'g')

    out(2 |--> (2, 5)) ==== List(2, 4)
  }

  --------------("Bounded")

  {
    // Bounded members have an upper and a lower bound.

    out(implicitly[Enum[Char]].min)
    out(implicitly[Enum[Char]].max)
    out(implicitly[Enum[Char]].min.map(_.toInt)) ==== Some(0)
    out(implicitly[Enum[Char]].max.map(_.toInt)) ==== Some(65535)

    out(implicitly[Enum[Int]].max) ==== Some(Int.MaxValue)
  }

  --------------("Num")

  {
    // Num is a numeric typeclass. Its members have the property of being
    // able to act like numbers
  }

  --------------("typeclasses 102")

  {
    // A traffic light data type
    // Haskel:
    // > data TrafficLight = Red | Yellow | Green

    sealed trait TrafficLight
    case object Red extends TrafficLight
    case object Yellow extends TrafficLight
    case object Green extends TrafficLight

    // Now let's define an instance for Equal
    implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)

    illTyped("Red === Yellow")
    // So apparently Equal[TrafficLight] doesn't get picked up because
    // Equal has nonvariant subtyping: Equal[F]. If I turned TrafficLight
    // to a case class then Red and Yellow would have the same type,
    // but then I lose the tight pattern matching from sealed #fail.

    case class TrafficLight2(name: String)
    val red = TrafficLight2("red")
    val yellow = TrafficLight2("yellow")
    val green = TrafficLight2("green")

    implicit val TrafficLightEqual2: Equal[TrafficLight2] = Equal.equal(_ == _)

    out(red === yellow) ==== false
    // But pattern match works worse now.
  }

  --------------("a Yes-No typeclass")

  {
    // Let's see if we can make our own truthy value typeclass in the style of scalaz
    // Scalaz calls three or four different things using the name of the typeclass like Show, show and show which is a bit confusing.
    // We can prefix the typeclass name with Can borrowing from CanbuildFrom instead.
    // and name its method as verb + s, borrowing from sjson/sbinary
    // Since yesno doesn't make much sense, let's call ours truthy.
    // Eventual goal is to get 1.truthy to return true.

    trait CanTruthy[A] {
      def truthys(a: A): Boolean
    }

    object CanTruthy {
      def apply[A: CanTruthy]: CanTruthy[A] = implicitly[CanTruthy[A]]

      def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
        def truthys(a: A) = f(a)
      }
    }

    trait CanTruthyOps[A] {
      def self: A
      def F: CanTruthy[A]            // I haven't figured out why author needed implicit here.
      final def truthy: Boolean = F.truthys(self)
    }

    implicit class CanTruthyOpsImpl[A : CanTruthy](a: A) extends CanTruthyOps[A] {
      override def self: A = a
      override def F: CanTruthy[A] = implicitly[CanTruthy[A]]
    }

    // Here is how we can define typeclass instances for Int:
    implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
      case 0 => false
      case _ => true
    })

    out(10.truthy) ==== true
    out(0.truthy) ==== false

    +++("Next is for List[A]")

    implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys({
      case Nil => false
      case _ => true
    })

    out(List("foo").truthy) ==== true
    illTyped("""Nil.truthy === false""")
    // We need to treat Nil specially because of the nonvariance.

    {
      implicit val nilCanTruthy: CanTruthy[Nil.type] = CanTruthy.truthys(_ => false)
      out(Nil.truthy) ==== false
    }

    implicit val booleanCanTruthy: CanTruthy[Boolean] = CanTruthy.truthys(identity)
    out(false.truthy) ==== false
    out(true.truthy) ==== true

    // Using CanTruthy typeclass let's define truthy If like LYAHFGG:
    // Now let's make a function that mimics the if statement, but that works with YesNo values

    def truthyIf[A: CanTruthy, B, C](cond: A)(ifyes: => B)(ifno: => C) =
      if (cond.truthy) ifyes else ifno

    out(truthyIf(0) {"Test"} {"Papata"}) ==== "Papata"
    out(truthyIf(1) {"Test"} {"Papata"}) ==== "Test"
  }
}

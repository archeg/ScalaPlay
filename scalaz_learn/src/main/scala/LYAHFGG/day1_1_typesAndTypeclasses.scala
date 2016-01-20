package LYAHFGG

import CommonPlay.ChapterApp
import shapeless.test.illTyped

/**
  * Created by archeg on 1/15/2016.
  */
object day1_1_typesAndTypeclasses extends ChapterApp {
  import scalaz._
  import Scalaz._

  // :t <expression> works in scala interpreter as well.
  // Note that scala does not support x -> y -> z notation. Probably because in scala carry is not implicit, like in Haskell
  // (I guess later on that?)
  out(().getClass) ==@ "void"

  --------------("Eq|Equal typeclass")

  out(1 === 2) ==== false
  out(1 =/= 2) ==== true
  illTyped("""1 === "Hello world" """)

  2 assert_=== 2

  out(5.some =/= 10.some) ==== true
  out(1 =/= 2 && false) ==== false

  --------------("Ord|Order typeclass")

  //trait Order[F] extends Equal[F]
  out(5 gt 2) ==== true
  out(5 > 2) ==== true
  val ordering = 5 cmp 2
  out(ordering) ==== Ordering.GT

  --------------("Show")
  // scalaz and haskell toString
  out(3.show)
  //scalaz.Cord = "hello“ // the following line doesn’t compile here

  illTyped("""new Thread().show""")           // Can't compile that because Thread does not belong to Show typeclass.

  {
    // With this we can make Thread to be part of Show TypeClass

    implicit val showThread = Show.shows[Thread] { _.getName }
    out(new Thread().show)
  }

  // With the same mechanic we can make another typeclass bindings:
  class A

  {
    illTyped("""(new A) gt (new A)""")
    illTyped("""new A === new A""")
  }

  {
    // This actually violtates ordering rules, but seems to work ok nevertheless.
    implicit val orderA = Order.order[A]((x, y) => Ordering.GT)
    out(new A gt new A) ==== true

    out(new A === new A)       // Order.order also defines Equals typeclass
  }

  {
    // Another way of doing this:
    implicit val orderA = new Order[A] {
      override def order(x: A, y: A): Ordering = Ordering.GT
    }

    out(implicitly[Order[A]].greaterThan(new A, new A)) ==== true
  }

  --------------("Read")

  // Read seem to be missing in scalaz, this was stated in LearningScalaz
  // This actually weird, becuase it seem to be a nice typeclass.
  // This type class looks to maintain parse functionality
  // It's type is (Read a) => String -> a

  --------------("Enum")

  out(().pred) ==== ()      // funny.
  out(0.pred) ==== -1
  out(Integer.MAX_VALUE.succ) ==== Integer.MIN_VALUE // probably just overflow
  out(true.pred) ==== false            // Does !
  out(true.pred.pred) ==== true

  out(().from.take(3).toList) ==== List((), (), ())
  out(Integer.MAX_VALUE.pred.from.take(3).toList) ==== List(Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MIN_VALUE)

  // |-> and |--> return Lists
  out(2 |-> 5) ==== List(2, 3, 4, 5)
  out(2 |--> (2, 10)) ==== List(2, 4, 6, 8, 10)

  // |=> and |==> return EphemeralStream
  out(2 |=> 5) ==% "scalaz.EphemeralStream"

  out('z' --- 5) ==== 'u'
  out('u' -+- 5) ==== 'z'

  --------------("Bounded")

  // We need implicit calls here:
  // It also looks to be a part of Enum rather than Bounded
  out(implicitly[Enum[Int]].min) ==== Integer.MIN_VALUE.some

  out(implicitly[Enum[Unit]].min) ==== ().some

  {
    sealed abstract trait Counter
    case object First extends Counter
    case object Second extends Counter
    case object Third extends Counter

    implicit val enumCounter: Enum[Counter] = new Enum[Counter] {
      override def succ(a: Counter): Counter = a match {
        case First => Second
        case Second => Third
        case Third => First
      }

      override def pred(a: Counter): Counter = a match {
        case First => Third
        case Second => First
        case Third => Second
      }

      override def order(x: Counter, y: Counter): Ordering = {
        val map = Map[Counter, Int](First -> 0, Second -> 1, Third -> 2)
        implicitly[Order[Int]].order(map(x), map(y))
      }

      // These aren't required to override but needed if you want Enum to be Bounded.
      override def min = First.some
      override def max = Third.some
    }

    // Implicits work only with end class, so we need to specify this:

    out(First.asInstanceOf[Counter].succ)
    out(implicitly[Enum[Counter]].min)
    //out(First |=> Third)
  }

  --------------("Num typeclass")
  // Doesn't look like scalaz have Num or Integral, but original scala has Integral, Numeric

  def test[A : Numeric](a: A, b: A): A = {
    val num = implicitly[Numeric[A]]
    import num._
    a + b
  }

  out(test(2, 3))

  // fromIntegral - scala doesn't need that
  out(2 + 3.2) ==== 5.2

  (for {x <- 1.from if x*x % 2 == 0} yield x).take(10000).toList.sum

  2.abs

  //http://learnyouahaskell.com/modules
}

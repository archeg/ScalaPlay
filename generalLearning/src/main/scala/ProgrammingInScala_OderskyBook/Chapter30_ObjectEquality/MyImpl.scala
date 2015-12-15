/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter30_ObjectEquality

import scala.reflect.ClassTag
import scala.xml.Equality

/**
 * Created by archeg on 10/10/2015.
 */
object MyImpl extends App {
  trait Equality[T] extends Equals {
    val ttag: ClassTag[T]
    def Key: Seq[Any]

    def canEqual(other: Any): Boolean = other match {
      case that: Equality[_] if that.ttag == ttag => true
      case _ => false
    }

    override def equals(other: Any): Boolean =
     other match {
       case that: Equality[T] => canEqual(that) && Key == that.Key
       case _ => false
     }

    override def hashCode = Key.foldLeft(1)((x, y) => 41 * x + y.hashCode)
  }

  object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
  }

  class Point(val x: Int, val y: Int)(implicit val ttag: ClassTag[Point]) extends Equality[Point]{
    override def Key: Seq[Any] = Seq(x, y)
  }

  class ColorPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {
    override def Key = super.Key :+ color
  }

  assert(new Point(1, 2) == new Point(1, 2))
  assert(new Point(1, 2) != new Point(2, 2))
  assert(new ColorPoint(1, 2, Color.Red) != new Point(1, 2))

  val p = new Point(1, 2)
  val cp = new ColorPoint(1, 2, Color.Red)
  assert(!(p equals cp))
  assert(!(cp equals p))

  val p2 = new Point(1, 2)
  val redp = new ColorPoint(1, 2, Color.Red)
  val bluep = new ColorPoint(1, 2, Color.Blue)
  assert(p2 != redp)
  assert(redp != bluep)
  assert(redp != p2)

  val pAnon = new Point(1, 1) { override val y = 2 }
  assert(pAnon == p2)
}

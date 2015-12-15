/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter30_ObjectEquality

import CommonPlay.ChapterApp

import scala.collection.immutable.HashSet

/**
 * Created by archeg on 10/10/2015.
 */
object Main extends ChapterApp {
  val l1 = List(1, 2, 3)
  val l2 = List(1, 2, 3)

  println(l1 == l2, true)                            // Object equality
  println(l1 eq l2, false)                           // Reference equality
  println(l1 equals l2, true)                        // Object equality, the same as ==. Should not be used though, as it behaves weird sometimes.

  // Default implementation uses reference eq as object equality:
  class AnyMy {
    final def == (that: AnyMy): Boolean =             // == is final and should not be overriden. You should override equals, but use == in the code.
      if (null eq this) { null eq that } else { this equals that}
  }

  class C { override def equals(other: Any) = true }        // Actually it is exactly the same method as Java bool equals(Object obj)

  var hashSet = new HashSet[C]                              // uses hashing
  val c = new C()
  hashSet += c
  println(new C() == new C(), true)                         // but:
  println(hashSet.contains(new C()), false)                 // hashCode was not overriden.

  class Point(val x: Int, val y: Int) {
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y   // means also that != null
      case _ => false
    }
  }

  // To override equals:
  // 1) override def equals(other: Any): Boolean
  // 2) override def hashCode: Int                          // If two objects equals - the must have the same hashcode. If they are unequal, they may or may not have the same hashcode
  // 3) Do not base equals on mutable fields
  // 4) Equals should be:
  //    a) Reflexive, meaning x.equals(x) should return true
  //    b) Symmetric, meaning x.equals(y) should return if and only if y.equals(x) for any x, y non-null
  //    c) Transitive, meaning if x.equals(y) and y.equals(z) then x.equals(z) for any x,y,z non-null
  //    d) Consistent, meaning x.equals(y) should consistently return true or consistently return false, if KEY is not modified.
  //    e) x.equals(null) should return false

  object Color extends Enumeration {
    val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
  }

  // No need to override hashCode, as it is overriden in Point, and equals is strictier
  // But it is broken at symmetry
  class ColoredPoint(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y) {
    override def equals(other: Any) = other match {
      case that: ColoredPoint =>
        this.color == that.color && super.equals(that)
      case _ => false
    }
  }

  // But if you try to mix Point and ColoredPoint, the contract becomes broken:
  val p = new Point(1, 2)
  val cp = new ColoredPoint(1, 2, Color.Red)
  println(p equals cp, true)
  println(cp equals p, false)
  // Unexpected behavior:
  println(HashSet[Point](p) contains cp, false)
  println(HashSet[Point](cp) contains p, true)

  // Still broken at transitiveness:
  class ColoredPoint2(x: Int, y: Int, val color: Color.Value)
    extends Point(x, y){
    override def equals(other: Any) = other match {
      case that: ColoredPoint2 =>
          this.color == that.color && super.equals(that)
      case that: Point =>
        that equals this
      case _ =>
        false
    }
  }

  val p2 = new Point(1, 2)
  val redp = new ColoredPoint2(1, 2, Color.Red)
  val bluep = new ColoredPoint2(1, 2, Color.Blue)

  println(redp == p2, true)
  println(p2 == bluep, true)
  println(redp == bluep, false)                  // Transitivity is broken.

  // Always treat objects of different classes as different.
  class Point3(val x: Int, val y: Int){
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any) = other match {
      case that: Point3 =>
        this.x == that.x && this.y == that.y && this.getClass == that.getClass
      case _ => false
    }
  }

  class ColoredPoint3(x: Int, y: Int, val color: Color.Value)
    extends Point3(x, y){
    override def equals(other: Any) = other match {
      case that: ColoredPoint =>
        (this.color == that.color) && super.equals(that)
      case _ => false
    }
  }

  // But if we define a point like this:
  val pAnon = new Point3(1, 1) { override val y = 2 }
  // it will be a Point3(1, 2), but it won't be equal to a Point3(1, 2), because it is a different anonymous class.

  // We need to have one more method to solve this problem.
  class Point4(val x: Int, val y: Int) {
    override def hashCode = 41 * (41 + x) + y
    override def equals(other: Any) = other match {
      case that: Point4 =>
        (that canEqual this) &&
          (this.x == that.x) && (this.y == that.y)
      case _ => false
    }

    def canEqual(other: Any) = other.isInstanceOf[Point4]
  }

  class ColoredPoint4(x: Int, y: Int, val color: Color.Value)
    extends Point4(x, y) {
    override def hashCode = 41 * super.hashCode + color.hashCode
    override def equals(other: Any) = other match {
      case that: ColoredPoint4 =>
        (that canEqual this) && super.equals(that) && this.color == that.color
      case _ => false
    }

    override def canEqual(other: Any) =
      other.isInstanceOf[ColoredPoint4]
  }

  // Now everything works:
  val newp = new Point4(1, 2)
  val newcp = new ColoredPoint4(1, 2, Color.Indigo)
  val newpAnon = new Point4(1, 1) { override val y = 2}
  val coll = List(newp)
  println(coll contains newp, true)
  println(coll contains newcp, false)
  println(coll contains newpAnon, true)

  // One potential critisicm of it is that it violates Liskov Substitution Principle (LSP)
  // because coll contains cp returned false
  // but this is a wrong interpretation of LSP (obviously), as ColoredPoint cannot be equal to a Point

  newExample("---------------------- Defining equality for parametrized types ---------------------- ")

  trait Tree[+T] {
    def elem: T
    def left: Tree[T]
    def right: Tree[T]
  }

  object EmptyTree extends Tree[Nothing] {
    def elem = throw new NoSuchElementException("EmptyTree.elem")
    def left = throw new NoSuchElementException("EmptyTree.left")
    def right = throw new NoSuchElementException("EmptyTree.right")
  }

  class Branch[+T](
    val elem: T,
    val left: Tree[T],
    val right: Tree[T]
    ) extends Tree[T]  {
    override def equals(other: Any) = other match {
      case that: Branch[_] => (that canEqual this) &&
                              this.elem == that.elem &&         // Branch[T] is unchecked - because of type erasure
                              this.left == that.left &&         // But we don't care about T
                              this.right == that.right          // So we just use _ (also lower case letter like t can be used)
      case _ => false                                           // This is existential type
    }

    override def hashCode: Int =
      41 * (
        41 * (
          41 + elem.hashCode
          ) + left.hashCode
        ) + left.hashCode

    def canEqual(other: Any) = other.isInstanceOf[Branch[_]]
  }


  newExample("----------------------- Recipes for equals and hashCode -----------------------")

  class Rational(n: Int, d: Int){
    require(d != 0)
    private val g = gcd(n.abs, d.abs)
    val numer = (if (d < 0) -n else n) / g
    val denom = d.abs / g

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    override def equals(other: Any): Boolean =
      other match {
        case that: Rational =>
          (that canEqual this) &&
          numer == that.numer &&
          denom == that.denom
        case _ => false
      }
    def canEqual(other: Any): Boolean =
      other.isInstanceOf[Rational]

    override def hashCode: Int =
      41 * (
        41 + numer
        ) + denom

    override def toString =
      if (denom == 1) numer.toString else numer + "/" + denom
  }

  // 1) If you're goind to override equals in a non-final class, you should create a canEqual method.
  //    The type of the argument should be Any
  //    > def canEqual(other: Any): Boolean = ...
  //         the implementation is usually:
  //    >     = other.isInstanceOf[MyClass]
  // 3) In the equals method, make sure you declare the type of the object passed as an Any:
  //    > override def equals(other: Any): Boolean = ...
  // 4) Write the body of the equals method as a single match expression:
  //    > other match { ...
  // 5) The match expression should have two cases. The first case should delare a typed pattern for the type of the my class
  //    > case that: MyClass =>
  // 6) In the body of this case, write an expression that logically-ands together the individual expressions that must be true for the object to be equal.
  //    If the equals method you are overriding is not that of AnyRef, you will most likely want to include an invocation of the superclass:
  //    > super.equals(that) &&
  //    If you are defining equals for a class that first introduced canEqual, you should invoke it:
  //    > (that canEqual this) &&
  //    Overriding redefinitions of equals should also include the canEqual invocation,
  //    unless they contain a call to super.equals
  //    Lastly, check each field for equality:
  //    > numer == that.numer && denom == that.denom & ....
  // 7) For the second case, return false:
  //    > case _ => false
  //
  // For hashCode, use:
  // 41 * ( 41 * (...) + a.hashCode) + b.hashCode
  // for Int, Short, Byte and Char the .hashCode call is not necessary as their value is their hashCode
  // 41 is selected because it is odd prime. Why 41? Because we reduced the likelihood that the first multiplication will
  // result in zero, under the assumption that it is more likely the first field used will be zero than -41.
  // If the equals method invokes super.equals(that) as part of it's calculation, you should start your hashCode calculation with an invocation of super.hashCode
  // You can also cache hashCode, if it harms the performance.
}

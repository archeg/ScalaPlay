/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter12_Traits

import CommonPlay.ChapterApp
import ProgrammingInScala_OderskyBook.Chapter6.{Rational, RationalBase}

import scala.collection.mutable.ArrayBuffer

/**
 * Created by archeg on 7/19/2015.
 */
object Main extends ChapterApp {
  trait Philosophical { def philosophize() { println("I consume memory, therefore I am!")}}
  trait HasLegs
  abstract class Animal { def breath():String }
  trait Breathable { def breath = "Breathing..." }
  class Frog extends Animal with Philosophical with HasLegs with Breathable { override def toString = "green" }

  new Frog().philosophize()

//  val b = new Animal()  <- Not possible. Animal is abstract
//  val a = new Animal() with Philosophical <- Not possible. This anonymous class is not abstract, but def breath() is not implemented
  val c = new Animal() with Philosophical with Breathable
  c.philosophize()

  val d = new Animal() with Philosophical {
    override def breath = "I am breathing to"
  }
  d.philosophize()

  val e = new Animal() with Philosophical {
    override def breath() = "I am breathing to"
  }
  e.philosophize()


  class Pointy(x: Int, y: Int)
//  trait NoPoint(x: Int, y: Int) <- doesn't compile

  newExample("Rich interfaces")

  class Point(val x: Int, val y: Int)

  trait Rectangular {
    def topLeft: Point
    def bottomRight: Point

    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
  }

  class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular

  println(new Rectangle(new Point(10, 10), new Point(20, 20)).left, 10)

  newExample("The ordered trait")

  class RationalCool(n: Int, d: Int) extends RationalBase(n, d) with Ordered[RationalBase] {
    override def compare(that: RationalBase): Int =
      (this.numer * that.denom) - (that.numer * this.denom)
  }

  val half = new RationalCool(1, 2)
  val third = new RationalCool(1, 3)
  println(half > third, true)
  // Actually we can even:
  val thirdNotCool = new Rational(1, 3)
  println(half > thirdNotCool, true)
//  println(thirdNotCool < half) <- Not possible as Rational does not have >,<...


  // ------------------------------------------------------------------------------------
  newExample("Trait as stackable modifications")
  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }
  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) { buf += x}
  }

  trait Doubling extends IntQueue { abstract override def put(x: Int) {super.put(2 * x)}}

  var f = new BasicIntQueue with Doubling
  f.put(10)
  println(f.get(), 20)

  trait Incrementing extends IntQueue { abstract override def put(x: Int) { super.put(x + 1) }}
  trait Filtering extends IntQueue { abstract override def put(x: Int) { if (x >= 0) super.put(x) }}

  // Filtering and then Incrementing (from right to the left).
  var g = new BasicIntQueue with Incrementing with Filtering
  g.put(-1)         // Is filtered out.
  g.put(0)
  g.put(1)
  println(g.get(), 1)
  println(g.get(), 2)

  val h = new BasicIntQueue with Incrementing with Doubling
  h.put(2)
  println(h.get(), 5)  // (2 * 2) + 1

  newExampleG("Linearization")
  {
    class Animal2 {def a() { println("Animal") }}
    trait Furry extends Animal2 {override def a() { println("Furry"); super.a() }}
    trait HasLegs2 extends Animal2 {override def a() { println("HasLegs"); super.a() }}
    trait FourLegged extends HasLegs2 {override def a() { println("FourLegged"); super.a() }}
    class Cat() extends Animal2 with Furry with FourLegged {override def a() { println("Cat"); super.a() }}
    new Cat().a()
    //  Cat
    //  FourLegged
    //  HasLegs   *
    //  Furry     *
    //  Animal
  }

  newExampleG("Linearization 2")
  {
    class Animal2 {def a() { println("Animal") }}
    trait Furry extends HasLegs2 {override def a() { println("Furry"); super.a() }}
    trait HasLegs2 extends Animal2 {override def a() { println("HasLegs"); super.a() }}
    trait FourLegged extends HasLegs2 {override def a() { println("FourLegged"); super.a() }}
    class Cat() extends Animal2 with Furry with FourLegged {override def a() { println("Cat"); super.a() }}
    new Cat().a()
    //  Cat
    //  FourLegged
    //  Furry    *
    //  HasLegs  *
    //  Animal
  }

}

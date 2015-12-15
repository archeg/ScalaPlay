/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter20_AbstractMembers

import java.io.PrintWriter
import java.util.Date

import CommonPlay.ChapterApp

/**
 * Created by archeg on 8/31/2015.
 */
object Main extends ChapterApp {

  // Abstract members
  trait Abstract {
    type T

    def transform(x: T): T

    val initial: T
    var current: T
  }

  class Concrete extends Abstract {
    override type T = String

    // Override is not mandatory if the base is abstract class.
    def transform(x: T): T = x + x

    override val initial: T = "hi"
    // _ means default. It will be null for string.
    override var current: T = _
  }

  println(new Concrete().current, null)

  abstract class Fruit {
    val v: String

    def m: String
  }

  abstract class Apple extends Fruit {
    val v: String
    val m: String // OK to override a def with a val
  }

  //  abstract class BadApple extends Fruit {
  //    def v: String  // Does not compile
  //    def m: String
  //  }

  trait AbstractTime {
    var hour: Int
    var minute: Int
  }

  trait TTime extends AbstractTime {
    def hour: Int

    def hour_=(x: Int)

    def minute: Int
  }

  val t = new {
    var hour = 5
  } with TTime() {
    override def minute: Int = 50

    override def minute_=(x: Int) = {}
  }

  t.hour = 5
  t.minute = 5

  trait RationalTrait2 {
    val numerArg: Int
    val denomArg: Int
  }

  // In order to create anonymous class with a trait - it should have all parts defined
  // so we need to define numerArg and denomArg
  val tt = new RationalTrait2 {
    val numerArg = 2
    val denomArg = 3
  }

  trait RTRait {
    val numerARg = 1
  }

  // This does not create an instance of trait, but rather an instance of anonymous class with a trait
  // it is the same as in previous example, but it does not require to define anything, as trait is defined already.
  val ttt = new RTRait {}


  trait RationalTrait {
    val numerArg: Int
    val denomArg: Int
    require(denomArg != 0)
    private val g = gcd(numerArg, denomArg)
    val numer = numerArg / g
    val denom = denomArg / g

    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    override def toString = numer + "/" + denom
  }

  // -- Then we can create a rational number:

  // This won't work, because firstly RationalTrait is created, and then denomArg and numerArg is overriden. require of RationalTrait will fail.
  error {
    new RationalTrait {
      override val denomArg: Int = 2
      override val numerArg: Int = 7
    }
  }

  newExample("----------- Preinitialized fields ---------------------")

  // This will work. It will initialize denomArg and numerArg BEFORE subclass is invoked.
  println(new {
    override val denomArg: Int = 2
    val numerArg: Int = 7
  } with RationalTrait)

  // You can also create objects

  // This won't work for the same reasons.
  object twoThirds2 extends RationalTrait {
    val numerArg = 2
    val denomArg = 3
  }

  error(twoThirds2)

  // So we can do this.
  object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
  } with RationalTrait

  println(twoThirds)

  //  new {
  //    val numerArg = 1
  //    val denomArg = this.numerArg * 2  <-------- Doesn't work. This points to the object that owns the constructed object, because this class was not yet created.
  //  } with RationalTrait

  // So here this is Main class (the current one)
  new {
    val d = this.twoThirds.numerArg
  } with RationalTrait2 {
    override val denomArg: Int = 5
    override val numerArg: Int = 5
  }

  // --- So:
  // If you want to add methods that point to this:
  class RationalClass(n: Int, d: Int) extends {
    val numerArg = n
    val denomArg = d
  } with RationalTrait {
    def +(that: RationalClass) = new RationalClass(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  println(new RationalClass(1, 3) + new RationalClass(2, 7))

  newExample(" ------------- The other option is lazy vals -----------------")

  // x is executed when you first access an object.
  object Demo {
    val x = {println("initializing x"); "done" }
  }

  Demo

  object DemoLazy {
    lazy val x = {println("initialyzing x lazily"); "done" }
  }

  DemoLazy
  println("DemoLazy.x is still not initialized")
  println(DemoLazy.x, "done")
  println("Here it is!")

  // So:
  trait LazyRationalTrait {
    val numerArg: Int
    val denomArg: Int
    lazy val numer = numerArg / g
    lazy val denom = denomArg / g

    override def toString = numer + "/" + denom

    private lazy val g = {
      require(denomArg != 0)
      gcd(numerArg, denomArg)
    }

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

  // And it works now!
  val d = new LazyRationalTrait {
    override val denomArg: Int = 3
    override val numerArg: Int = 7
  }
  println(d)

  newExample(" ------------------- 20.6 Abstract type ----------------------")
  class Food
  abstract class Animal {
    def eat(food: Food)
  }

  class FIsh extends Food
  class Grass extends Food
//  class Cow extends Animal {
//    override def eat(food: Grass) {} // This won't compile. This method is different than in the base, as it has different parameter
//  }
  // Because if otherwise this would be possible:
//  val bessy: Animal = new Cow
//  bessy eat (new Fish) // But Cow eats grass only?


  class Food2
  abstract class Animal2 {
    type SuitableFood <: Food2
    def eat(food: SuitableFood)
  }

  class Grass2 extends Food2
  // This works
  class Cow2 extends Animal2 {
    type SuitableFood = Grass2
    override def eat(food: Grass2) {}
  }
  class Fish2 extends Food
  val bessy: Animal2 = new Cow2
//  bessy eat (new Fish2)   // expected bessy.SuitableFood, but was Fish2

  // Path-dependent types:
  // bessy.SuitableFood
  // not
  // Cow2.SuitableFood

  class Outer {
    class Inner
  }
  val o1 = new Outer
  val i1 = new o1.Inner // Because when you create Inner class, it has access to it's Outer instance:
  class Outer2(x: Int) {
    class Inner2 {
      val y = x // <--- Because of this.
    }
  }
  val o2 = new Outer2(50)
  val i2 = new o2.Inner2  // But it's type is Outer2#Inner2
  println(i2.y, 50)

  // You can use it in type checks:
  println(i2.isInstanceOf[Outer2#Inner2], true)
  println(i2.asInstanceOf[Outer2#Inner2])

  newExample(" ------ Structural subtyping ------ ")

  // This is a real type. Anonymous
  type t = Animal { type SuitableFood = Grass }
  println(t)

  // We can use it to define anything with structural subtyping
  // This defines a list of animals that eat grass
  class Pasture {
    var animals: List[Animal { type SuitableFood = Grass }] = Nil       // <- Animal that has it's SuitableFood = Grass
  }

  // Useful for defining using pattern:
  // This using will accept anything that has close(): Unit method:
  // T even does not have a base!
  def using[T <: {def close(): Unit }, S](obj: T)(operation: T => S) = {   // <- anything that has .close(): Unit
    val result = operation(obj)
    obj.close()
    result
  }
  using (new PrintWriter("date.txt")) {
    writer => writer.println(new Date)
  }
  class O {
    def close() {println("Closed executed!")}
  }
  using (new O) { o => {}}

  newExample(" ------ Enumerations ------- ")
  object Color extends Enumeration {
    val Red = Value
    val Green = Value
    val Blue = Value
  }
  // Or even
  object Color2 extends Enumeration {
    val Red, Green, Blue = Value
  }

  println(Color.Blue)
  for (d <- Color.values) print(d + " ")
  println("")

  object Direction extends Enumeration {
    val North = Value("N")
    val East = Value("E")
    val South = Value("S")
    val West = Value("W")
  }

  println(Direction.North)
  println(Direction.North.id, 0)
  for (d <- Direction.values) print(d + " ")
  println("")
  println(Direction(1), Direction.East)
  println(Direction.withName("S"), Direction.South)
}

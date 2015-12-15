/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter21_ImplicitConversionsAndParameters

import CommonPlay.ChapterApp

/**
 * Created by archeg on 9/19/2015.
 */
object Main extends ChapterApp {
  implicit def int2String(i: Int) = i.toString
  def printer(s: String) { println(s)}
  printer(2)

  // Implicits should be in scope:
  object A {
    implicit def int2List(i: Int) = i :: Nil
  }

  def printer2(x: List[Int]) {println(x)}
  //printer2(2) <- doesn't work.
  import A._
  printer2(2)   // But now it works. We brought implicit into scope.

  object Dollar {
    implicit def dollarToString(x: Dollar) : String = x.value
  }

  class Dollar(val value : String) {
  }

  // This also work because the compiler will find implicit declaration in companion object of Dollar
  // In this case the conversion is said to be associated to the type Dollar
  printer(new Dollar("Hello"))

  // You can also import single implicit conversion:
  import A.int2List
  printer2(2)

  // There are three places where implicits are tried by the compiler:

  // 1) ---------------------------- Implicit conversions to an expected type:
  // printer2(int2List(2))
  printer2(2)
  val x: List[Int] = 2 // This is also possible.
  // There are lots of implicits defined in scala.Predef, so you could do:
  val xx: Double = 2

  // 2) ---------------------------- Conversions of the receiver
  // println(int2List(2).tail)
  println(2.tail) // Int does not have tail, but List has. the method is brought by implicit conversion
  // Useful to extend the type that you cannot longer change.
  // Or to implement commutativity for operation:
  class Rational(val n: Int, val d: Int) { x =>
     def * (that: Rational): Rational = new Rational(n * that.n, d*that.d)
     def * (that: Int): Rational = new Rational(n* that, d*that)
  }
  val xxx = new Rational(5, 7) * 5 // This works.
//  val xxxx = 5 * new Rational(5, 7) // But this doesn't
  object Rational{
    implicit def intToRational(i: Int) = new Rational(i, 1)
  }
  // val xxxx = Rational.intToRational(5) * new Rational(5, 7
  val xxxx = 5 * new Rational(5, 7) // Now it works!

  // Another option is if you want to simulate new syntax:
  Map(1 -> "one", 2 -> "two") // -> is method defined in scala.Predef and there is implicit cast to it for Any.

  // 3) ---------------------------- For implicit parameters
  class PreferredPrompt(val preference: String)  // Implicit vals should always have a dedicated type. Do not use standard types (Code style)
  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt){
      println("Welcome, " + name + ". The system is ready.")
      println(prompt.preference)
    }
  }

  implicit val prompt = new PreferredPrompt("Yes, master>")
  Greeter.greet("Iurii")   // Implicit parameter

  class PreferredDrink(val drink: String)
  object BetterGreeter {
    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink){
      println("Welcome, " + name + ". The system is ready. Would you like some " + drink.drink + "?")
      println(prompt.preference)
    }
  }

  //BetterGreeter.greet("Iurii")  // this won't compile as no implicit value for drink is there.
  object MikePrefs {
    implicit val prompt = new PreferredPrompt("Yes, Mike>")
    implicit val drink = new PreferredDrink("Whisky")
  }

  object JohnPrefs {
    implicit val prompt = new PreferredPrompt("Yes, John>")
    implicit val drink = new PreferredDrink("Soda")
  }
  import MikePrefs._  // <- this import has overridden original implicit val prompt
  BetterGreeter.greet("Guy")
  //import JohnPrefs._    <- If this is uncommented the next line won't compile, as these two implicits exist simultaneously, and greet cannot decide.
  BetterGreeter.greet("Guy")

  def maxListImpParm[T](elements: List[T])
                       (implicit orderer: T => Ordered[T]): T = // Style Rule: Notice that implicit is not (T, T) => Boolean or T => Int.
                                                                // Because these are too generic and should not be used.
    elements match {
      case List() => throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)  // no need to specify orderer. It is implicit
        if (x > maxRest) x else maxRest     // x: T does not have >. But orderer(x) has. It is also implicit
    }

  // You can also run it:
  println(maxListImpParm(List(1, 5, 2, 3, 7, 2)))
  // This is because there exists already an implicit val T => Ordered[T] for T = Int in scala.Predef
  // println(maxListImpParm(List(new PreferredDrink("D"), new PreferredDrink("A"))))  <- Won't compile, becase there are not PreferredDrink => Ordered[PreferredDrink] implicit

  // ---- View Bounds -----

  def maxListImpParm2[T <% Ordered[T]](elements: List[T]): T = // T <% Ordered[T] is a view bound. It means that T has an implicit conversion to Ordered[T].
                                                               // This is essentially the same as having an (implicit orderer: T => Ordered[T]) parameter
    elements match {
      case List() => throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)  // no need to specify orderer. It is implicit
        if (x > maxRest) x else maxRest     // x: T does not have >. But orderer(x) has. It is also implicit
    }

  // You can think of "T <% Ordered[T]" as saying, "I can use any T, so long as T can be treated as an Ordered[T]."
  // This is different from saying "T <: Ordered[T]". You cannot say Int <: Ordered[Int], but you can say Int <% Ordered[Int]
  // Moreover if type T happens to already be an Ordered[T], you can still use it.
  // Because in scala.Predef there is an implicit identity function:
  // implicit def identity[A](x: A): A = x

  // If there is ambiguity for implicit, scala generates compile time error
  // but:
  val cba = "abc".reverse
  println(cba.isInstanceOf[String], true)
  // cba is of type string, though there are two implicits:
  // StringToStringOps that has reverse method
  // SeqToSeqOps that has reverse method.
  // But String is more strict than Seq, so only String implicit is applied
}

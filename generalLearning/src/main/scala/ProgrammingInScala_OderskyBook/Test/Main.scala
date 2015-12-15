package ProgrammingInScala_OderskyBook.Test

import CommonPlay.ChapterApp

import scala.util.{Failure, Success, Try}

/**
 * Created by archeg on 7/15/2015.
 */
object Main extends ChapterApp {
  def test = "Hello world"
  def test2() = "Hello world2"
  // def test3() {"Hello world3"}    <- Generates warning as it's return type is Unit
  def test4() = {"Hello world4"}

  println(test)
  println(test2)
  println(test2())
  //println(test3())
  println(test4())
  println(test4 ())

  def test5(): String = {
    return "Hello world !"
    "!"
  }

  println(test5)

  println(this.args.mkString(" "))

  val a = Array(1,2,3,4,5)
  for (b <- a)
    println(b)

  println ("Hello")
  Predef println "Hello"

  Try(println(List(1,2,3,4)(100))) match {
    case Failure(exception) => println("Failed")
    case Success(_) => println("!")
  }

  newExample("Strange behavior")

  def method(a: Any) = println(a)
  def method2(a: AnyRef) = println(a)
  //method()                       // <- Generates warning as it actually invokes method as method (Unit)
  //method2() <- Not possible

  def fun(b: Boolean)(f: => Unit) {
    f
  }

  fun(2 > 3) {
    println("Hello world")
  }

  println(new AnyRef().hashCode())
  println(new AnyRef().hashCode())
  println(new AnyRef().hashCode())
  def g(x: Int)(y: Int) = {
    x * y
  }

  def d(f: Int => Int) {
    f(5)
  }

  d(g(2) _)

  val p: Int => Int = g(2)

  case class A(var b: Int)

  val aa = new A(5)
  var list = List(aa)
  list = list ::: list
  aa.b = 10
  println(list)
}

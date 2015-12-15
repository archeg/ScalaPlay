/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter15_CaseClassesAndPAtternMatching

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/19/2015.
 */
object Main extends ChapterApp {
  val v = Var("x")
  val op = BinOp("+", Number(1), v)
  println(op.operator)
  val op2 = BinOp("+", Number(1), v)
  val op3 = BinOp("+", Number(2), v)
  println(op == op2)
  println(op == op3)
  println(op.copy(operator = "-"))

  def simplifyTop(expr: Expr) = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case BinOp("*", Number(1), e) => e
    case _ => expr
  }

  println(simplifyTop(op2.copy(operator = "*")))

  import math.{E, Pi}
  println(E match {
    case Pi => "strange math? Pi = " + Pi
    case _ => "OK"
  }, "OK")

  // This doesn't work. pi is considered a new variable in a match
  val pi = math.Pi
  println(E match {
    case pi => "strange math? Pi = " + pi
    case _ => "OK"
  })

  // Should be like this:
  println(E match {
    case `pi` => "strange math? Pi = " + pi
    case _ => "OK"
  }, "OK")

  newExample("Sequence pattern")

  List(1,2,3) match {
    case List(_) => "no match"
    case List(_, _, _, _) => "no match"
      // Matches only 3-length list
    case List(1, a, _) => println(s"Second element is $a")
  }

  def listMatcher[T](list: List[T]) {list match {
    case List(a, _*) => println(s"Matches any list if it's first element is $a")
  }}

  listMatcher(List(1, 2, 3))
  listMatcher(List(1))

  newExample("Tuple patterns")
  def tupleDemo(expr: Any) =
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ =>
    }

  tupleDemo((1, 2, 3))

  // Tuples also can be matched like this:
  val (a, b, c) = (1, 2, 3)
  println(s"$a, $b, $c")

  newExample("Typed patterns")
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  println(generalSize("asdwe"), 5)
  println(generalSize(Map(1 -> 2, 3 -> 4)), 2)

  // Another option is to use isInstanceOf and asInstanceOf
  def getStringSize(x: Any) =
    if (x.isInstanceOf[String]) {
      val s = x.asInstanceOf[String]
      s.length
    } else -1

  println(getStringSize("asdwe"), 5)

  newExample("Type erasure")
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  println(isIntIntMap(Map("s" -> 2)), true) // due to type erasure

  // Only exception is Arrays, as they are mapped to java arrays which are special:
  def isStringArray(x: Any) =
    x match {
      case a: Array[String] => true
      case _ => false
    }

  println(isStringArray(Array("a", "b")), true)
  println(isStringArray(Array(1, 2)), false)
  println(isStringArray(Array("a", 1)), false)

  newExample("Variable binding and pattern guards")
  def check(expr: Expr) = expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }

  println(check(UnOp("abs", UnOp("abs", BinOp("+", Number(1), Number(2))))),
    UnOp("abs", BinOp("+", Number(1), Number(2))))

  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ =>
  }

  println(simplifyAdd(BinOp("+", Var("x"), Var("x"))),
    BinOp("*", Var("x"), Number(2)))

  // Patterns can overlap

  newExample("Sealed case classes")

  // It is very useful to seal case classes to ensure compiler gives warnings if match is not exhaustive
  sealed abstract class ExprS
  case class VarS(name: String) extends ExprS
  case class NumberS(num: Double) extends ExprS
  case class UnOpS(operator: String, arg: ExprS) extends ExprS
  case class BinOpS(operator: String, left: ExprS, right: ExprS) extends ExprS

  // Produces warning: match may not be exhaustive
  def describe(e: ExprS): String = e match {
    case NumberS(_) => "a number"
    case VarS(_) => "a variable"
  }

  // Two options for the warning to go away:
  def describeNoWarning(e: ExprS) = e match {
    case NumberS(_) => "a number"
    case VarS(_) => "a variable"
    case _ => throw new RuntimeException
  }
  // OR
  def describeNoWarning2(e: ExprS) = (e: @unchecked) match {
    case NumberS(_) => "a number"
    case VarS(_) => "a variable"
  }

  newExample("The Option type")
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  println(capitals get "Japan")
  println(capitals get "France")
  println(capitals get "North Pole")

  newExample("Patterns everywhere")
  val myTuple = (123, "abc")
  val (number, str) = myTuple
  println(number)
  println(str)

  // The same is possible with case classes
  val exp = new BinOp("*", Number(5), Number(1))
  val BinOp(op5, Number(num), right) = exp
  println(op5)
  println(num)
  println(right)

  val dd: Option[String] = Some("string!")
  val Some(value) = dd
  println(value)
  val ddNone: Option[String] = None
  try { val Some(value2) = ddNone } catch {
    case e:MatchError => println("Match error caught")
  }

  newExample("Partial functions with cases")
  // you can write this almost anywhere. It is a statement that requires a single parameter.
  // Each catch is an entry point to a function
  //  {
  //    case Some(x) => x
  //    case None => 0
  //  }

  // So this is a partial function with two bodies defined.
  // one for Some(x)
  // another one for None
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }

  println(withDefault(Some(10)), 10)
  println(withDefault(None), 0)

  // Compiler with complain to this
  // as this is a partial function (not all cases are covered),
  // but compiler is not sure whether this was intentional
  val second: List[Int] => Int = {
    case x :: y :: _ => y
  }

  // To make it intentional:
  val third: PartialFunction[List[Int], Int] = {
    case x :: y :: _ => y
  }

//  second.isDefinedAt(List(1, 2, 3))          <- Cannot do that.
  println(third.isDefinedAt(List(1, 2, 3)), true)
  println(third.isDefinedAt(List(1)), false)

  val l : PartialFunction[List[Int], Int] = { case x :: y :: _ => y }

  newExample("Patterns if for expressions")
  for ((country, city) <- capitals)
      println(s"The capital of $country is $city")

  // for skips the items that were not matched
  val results = List(Some("apple"), None, Some("orange"))
  for (Some(fruit) <- results)
    println(fruit)

  newExample("ExprFormatter example")

  val f = new ExprFormatter

  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
                      BinOp("+", Var("x"), Number(2)))
  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
                      BinOp("/", Number(1.5), Var("x")))
  val e3 = BinOp("/", e1, e2)
  def show(e: Expr) = println(f.format(e) + "\n\n")
  for (e <- Array(e1, e2, e3)) show(e)
}

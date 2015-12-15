/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp
import scala.collection._
import scala.collection.immutable.HashMap

/**
  * Created by archeg on 11/7/2015.
  */
object LogicAndCodes46_50 extends ChapterApp {
  --------------("P46. Truth tables for logical expressions.")
  def and(a: Boolean, b: Boolean) = (a, b) match {
    case (true, true) => true
    case _ => false
  }
  check(and, _ & _)

  def or(a: Boolean, b: Boolean) = (a, b) match {
    case (false, false) => false
    case _ => true
  }
  check(or, _ | _)

  def xor(a: Boolean, b: Boolean) = a != b
  check(xor, _ ^ _)
  def not(a: Boolean) = a match {
    case true => false
    case false => true
  }
  check(not _, !_)

  def nand(a: Boolean, b: Boolean) = not(and(a, b))
  check(nand, (x, y) => !(x & y))
  def nor(a: Boolean, b: Boolean) = not(or(a, b))
  check(nor, (x, y) => !(x | y))
  def impl(a: Boolean, b: Boolean) = or(not(a), b)
  check(impl, !_ | _)

  def check(a1: (Boolean, Boolean) => Boolean, a2: (Boolean, Boolean) => Boolean): Unit =  {
    for (first <- List(true, false);
         second <- List(true, false)) {
      assert(a1(first, second) == a2(first, second), s"$a1 and $a2 failed at ($first, $second)")
    }
  }

  def check(a1: Boolean => Boolean, a2: Boolean => Boolean): Unit =  {
    for (first <- List(true, false)) {
      assert(a1(first) == a2(first), s"$a1 and $a2 failed at ($first)")
    }
  }

  def table2(f: (Boolean, Boolean) => Boolean): Unit =
    for (a <- List(true, false);
    b <- List(true, false)) {
      printf("%-5s %-5s %-5s\n", a, b, f(a, b))}

  table2(and)

  --------------("P47. Truth tables for logical expressions.")
  implicit class BoolToLogicalOp(val a: Boolean) {
    def or(b: Boolean) = a | b
    def xor(b: Boolean) = a ^ b
    def and(b: Boolean) = a & b
  }

  out(true and true) === true
  out(true and false) === false

  --------------("P48.....")
  out(true and (true or false)) === true
  out(true and true and true) === true

  --------------("P49. Gray code.")
  def p49(n: Int): List[String] = n match {
    case 1 => List("0", "1")
    case x => (p49(x - 1) map { "0" + _ }) ::: (p49(x - 1).reverse map { "1" + _ })
  }

  out(p49(1)) === List("0", "1")
  out(p49(2)) === List("00", "01", "11", "10")
  out(p49(3)) === List("000", "001", "011", "010", "110", "111", "101", "100")

  // memoized
  def p49_2(n: Int): List[String] = {
    val memoized = mutable.Map[Int, List[String]]()

    def compute(n: Int): List[String] = memoized.getOrElseUpdate(n, n match {
      case 1 => List("0", "1")
      case x => (compute(x - 1) map {"0" + _}) ::: (compute(x - 1).reverse map {"1" + _})
    })

    compute(n)
  }

  out(p49_2(1)) === List("0", "1")
  out(p49_2(2)) === List("00", "01", "11", "10")
  out(p49_2(3)) === List("000", "001", "011", "010", "110", "111", "101", "100")

  var size = 18
  time("Not memoized") {
    p49(size)
  }
  time("Memoized") {
    p49_2(size)
  }

  --------------("P50. Huffman code.")
  // Simplest O(n * logn). It requires sorting so this is the most effecient anyway.
  def p50(ls: List[(String, Int)]): List[(String, Int)] = {
    abstract class BaseNode(val weight: Int)
    case class Element(symbol: String, override val weight: Int) extends BaseNode(weight)
    case class Node(override val weight: Int, left: BaseNode, right: BaseNode) extends BaseNode(weight)

    val queue = new mutable.PriorityQueue[BaseNode]()(Ordering.by(x => 1.0 / x.weight))
    queue.enqueue(ls map {case (symb, weight) => Element(symb, weight)}: _*)

    while (queue.length > 1) {
      val a = queue.dequeue()
      val b = queue.dequeue()
      queue.enqueue(Node(a.weight + b.weight, a, b))
    }

    def unwrap(code: List[Int], node: BaseNode) : List[(String, List[Int])] = {node match {
      case Element(symbol, _) => List(symbol -> code)
      case Node(_, left, right) => unwrap(0 :: code, left) ::: unwrap(1 :: code, right)
    }}

    unwrap(Nil, queue.dequeue()) map { case (symbol, code) => (symbol, code.reverse.foldLeft(0)((acc, x) => acc * 10 + x))}
  }

  out(p50(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))).toSet) === Set(("a", 0), ("b", 101), ("c", 100), ("d", 111), ("e", 1101), ("f", 1100))
  out(p50(List(("b", 1), ("p", 1), ("`", 2), ("m", 2), ("j", 3), ("o", 3), ("d", 3), ("a", 4), ("i", 4), ("r", 5), ("u", 5), ("l", 6), ("s", 6), ("e", 8), (" ", 12))))
}

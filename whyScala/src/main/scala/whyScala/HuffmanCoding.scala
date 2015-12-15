/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

import scala.collection.mutable

/**
  * Created by archeg on 11/7/2015.
  */
object HuffmanCoding extends App {

  // Simplest O(n * logn). It requires sorting so this is the most effecient anyway.
  def huffman(ls: List[(String, Int)]): List[(String, Int)] = {
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

  println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
}

/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ScalaTips

/**
  * Created by archeg on 11/18/2015.
  */
object ScalaNewCaseClassExtractor extends App {
  // Problem
  // We had:
  //  sealed abstract class Tree[+T]
  //
  //  case class Node[+T](value: T, left: Tree[T], right: Tree[T])
  //    extends Tree[T] {
  //    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  //  }
  //
  //  case object End extends Tree[Nothing] {
  //    override def toString = "."
  //  }
  // And lots of code that was using this.
  // Now we want to add PositionedNode extends Node, with new fields but we can't do that.
  // Solution:

  sealed abstract class Tree[+T]

  sealed abstract class Node[+T] extends Tree[T] {
    def value: T
    def left: Tree[T]
    def right: Tree[T]
  }

  //renamed from Node
  case class SimpleNode[+T](value: T, left: Tree[T], right: Tree[T])
    extends Node[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }

  case object End extends Tree[Nothing] {
    override def toString = "."
  }

  case class PositionedNode[+T](val value: T, val left: Tree[T], val right: Tree[T], x: Int, y: Int)
    extends Node[T] {
    override def toString = s"T[$x, $y]($value $left $right)"
  }

  object Node {
    def apply[T](value: T, left: Tree[T], right: Tree[T]) = SimpleNode(value, left, right)
    def unapply[T](node: Tree[T]): Option[(T, Tree[T], Tree[T])] = node match {
      case SimpleNode(v, l, r) ⇒ Some((v, l, r))
      case PositionedNode(v, l, r, _, _) ⇒ Some((v, l, r))
      case _ ⇒ None
    }
  }

  def test[T](x: Tree[T]): String = x match {
    case End => "End"
    case Node(v, l, r) => "Node  " + v + "(" + test(l) + ", " + test(r) + ")"
    case PositionedNode(v, l, r, x, y) => s"Pos[$x, $y]  " + v + "(" + test(l) + ", " + test(r) + ")"
  }

  println(test(PositionedNode(5, Node(6, End, End), End, 2, 2)))
}

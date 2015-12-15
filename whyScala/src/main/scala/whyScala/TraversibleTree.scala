/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

/**
 * Created by archeg on 9/23/2015.
 */
object TraversibleTree extends App {

  case class Branch(left: Tree, right: Tree) extends Tree
  case class Node(elem: Int) extends Tree

  sealed abstract class Tree extends Traversable[Int] {
    def foreach[U](f: Int => U) = this match {
      case Node(elem) => f(elem)
      case Branch(l, r) => l foreach f; r foreach f
    }
  }
}

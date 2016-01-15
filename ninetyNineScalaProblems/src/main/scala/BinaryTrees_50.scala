/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp

import scala.annotation.tailrec

/**
  * Created by archeg on 11/8/2015.
  */
object BinaryTrees_50 extends ChapterApp {
  sealed abstract class Tree[+T]
  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }
  case object End extends Tree[Nothing] {
    override def toString = "."
  }
  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }

  --------------("P55. Construct completely balanced binary trees.")
  def p55(nodes: Int, symbol: String) : List[Node[String]] = ((nodes - 1) / 2, (nodes - 1) - (nodes - 1) / 2) match {
    case (1, 1) => Node(symbol, Node(symbol), Node(symbol)) :: Nil
    case (0, 1) => Node(symbol, Node(symbol), End) :: Node(symbol, End, Node(symbol)) ::  Nil
    case (0, 0) => Node(symbol) :: Nil
    case (x, y) if x != y =>  (for (a <- p55(y, symbol); b <- p55(x, symbol)) yield Node(symbol, a, b)) :::
                              (for (a <- p55(x, symbol); b <- p55(y, symbol)) yield Node(symbol, a, b))
    case (x, y) => for (a <- p55(y, symbol); b <- p55(x, symbol)) yield Node(symbol, a, b)
  }

  out(p55(1, "x")) ==@ "List(T(x . .))"
  out(p55(2, "x")) ==@ "List(T(x T(x . .) .), T(x . T(x . .)))"
  out(p55(3, "x")) ==@ "List(T(x T(x . .) T(x . .)))"
  out(p55(4, "x")) ==@ "List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x . .) T(x . T(x . .))))"

  def p55_2[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1 => End :: Nil
    case n if n % 2 == 1 => {
      val subtrees = p55_2(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    }
    case n if n % 2 == 0 => {
      val lesserSubtrees = p55_2((n - 1) / 2, value)
      val greaterSubtrees = p55_2((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
    }
  }
  // Same answer, but different order
  out(p55_2(4, "x")) ==@ "List(T(x T(x . .) T(x . T(x . .))), T(x T(x . T(x . .)) T(x . .)), T(x T(x . .) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . .)))"

  --------------("P56. Symmetric binary trees.")
  def p56[T](tree: Tree[T]): Boolean = {
    def isMirrored(a: Tree[T], b: Tree[T]): Boolean = (a, b) match {
      case (End, End) => true
      case (_, End) => false
      case (End, _) => false
      case (Node(_, ax, ay), Node(_, bx, by)) => isMirrored(ax, bx) && isMirrored(ay, by)
      case _ => false
    }

    tree match {
      case End => true
      case Node(_, a, b) => isMirrored(a, b)
    }
  }

  out(p56(Node('a', Node('b'), Node('c')))) ==== true
  out(p56(Node('a', Node('b'), End))) ==== false

  --------------("P57. Binary search trees (dictionaries)")

  implicit class BinaryTree[T](tree: Tree[T]) {
    def count: Int = tree match {
      case End => 0
      case Node(_, a, b) => a.count + b.count + 1
    }

    def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U] = tree match {
      case End => Node(x)
      case Node(v, a, b) if v >= x => Node(v, a.addValue(x), b)
      case Node(v, a, b) => Node(v, a, b.addValue(x))
    }
  }

  implicit class ListExt[T](lst: List[T])(implicit ev: T => Ordered[T]) {
    def toBinaryTree : Tree[T] = lst match {
      case Nil => End
      case head :: tail => tail.toBinaryTree.addValue(head)
    }
  }

  out(End.addValue(2)) ==== Node(2)
  out(End.addValue(2).addValue(3)) ==== Node(2, End, Node(3))
  out(End.addValue(2).addValue(3).addValue(0)) ==== Node(2, Node(0), Node(3))
  out(p56(End.addValue(2).addValue(3).addValue(0))) ==== true

  out(List(5, 3, 18, 1, 4, 12, 21).toBinaryTree)

  --------------("P58. Generate-and-test paradigm.")

  def p58[T](number: Int, v: String): List[Tree[String]] = p55(number, v) filter {p56(_)}

  --------------("P59. Construct height-balanced binary trees.")

  // ????????????????
  def p59[T](height: Int, value: T): List[Tree[T]] = height match {
    case n if n < 1 => End :: Nil
    case 1 => Node(value) :: Nil
    case _ => {
      val fullHeight = p59(height - 1, value)
      val short = p59(height - 2, value)
      (fullHeight flatMap { l => fullHeight.map(r => Node(value, l, r)) }) :::
        (fullHeight flatMap {f => short.flatMap(s => Node(value, f, s) :: Node(value, s, f) :: Nil)})
    }
  }

  out(p59(3, "s"))

  --------------("P61. Count the leaves of a binary tree.")
  def p61[T](tree: Tree[T]): Int = tree match {
    case End => 0
    case Node(_, End, End) => 1
    case Node(_, x, y) => p61(x) + p61(y)
  }

  out(p61(Node('x', Node('x'), End))) ==== 1

  def p61A[T](tree: Tree[T]): List[T] = tree match {
    case End => Nil
    case Node(v, End, End) => v :: Nil
    case Node(_, x, y) => p61A(x) ::: p61A(y)
  }

  out(p61A( Node('a', Node('b'), Node('c', Node('d'), Node('e'))))) ==== List('b', 'd', 'e')

  --------------("P62. Collect the internal nodes of a binary tree in a list.")
  def p62[T](tree: Tree[T]): List[T] = tree match {
    case End => Nil
    case Node(_, End, End) => Nil
    case Node(v, x, y) => v :: p62(x) ::: p62(y)
  }

  out(p62(Node('a', Node('b'), Node('c', Node('d'), Node('e'))))) ==== List('a', 'c')

  def p62B[T](tree: Tree[T], level: Int) = {
    def inner(tree: Tree[T], curLevel: Int): List[T] = (curLevel, tree) match {
      case (`level`, Node(v, _, _)) => v :: Nil
      case (_, End) => Nil
      case (_, Node(_, r, l)) => inner(r, curLevel + 1) ::: inner(l, curLevel + 1)
    }
    inner(tree, 1)
  }

  out(p62B(Node('a', Node('b'), Node('c', Node('d'), Node('e'))), 2)) ==== List('b', 'c')


  --------------("P63. Construct a complete binary tree.")
  def p63[T](number: Int, value: T): Tree[T] = number match {
    case 0 => End
    case 1 => Node(value)
    case x =>
      val innerNodes = math.pow(2, math.floor(math.log(x + 1) / math.log(2))).toInt - 1 // The biggest power of 2 < number and -1. This is the number of inner nodes for a tree
      val leftLeaves = math.min(x - innerNodes, (innerNodes + 1) / 2)                     // Number of nodes in the leaves in the left subtree
      val rightLeaves = math.max(x - innerNodes - leftLeaves, 0)
      Node(value, p63(leftLeaves + (innerNodes - 1) / 2, value), p63(rightLeaves + (innerNodes - 1) / 2, value))
  }

  out(p63(1, 'x')) ==== Node('x')
  out(p63(2, 'x')) ==== Node('x', Node('x'), End)
  out(p63(3, 'x')) ==== Node('x', Node('x'), Node('x'))
  out(p63(4, 'x')) ==== Node('x', Node('x', Node('x'), End), Node('x'))
  out(p63(5, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x'))
  out(p63(6, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), End))
  out(p63(7, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), Node('x')))

  def p63_2[T](number: Int, value: T): Tree[T] = {
    def generateTree(addr: Int): Tree[T] =
      if (addr > number) End
      else Node(value, generateTree(2 * addr), generateTree(2 * addr + 1))
    generateTree(1)
  }

  out(p63_2(1, 'x')) ==== Node('x')
  out(p63_2(2, 'x')) ==== Node('x', Node('x'), End)
  out(p63_2(3, 'x')) ==== Node('x', Node('x'), Node('x'))
  out(p63_2(4, 'x')) ==== Node('x', Node('x', Node('x'), End), Node('x'))
  out(p63_2(5, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x'))
  out(p63_2(6, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), End))
  out(p63_2(7, 'x')) ==== Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), Node('x')))

  --------------("P64. Layout a binary tree(1)")

  class PositionedNode[+T](override val value: T, override val left: Tree[T], override val right: Tree[T], val x: Int, val y: Int)
    extends Node[T](value, left, right){
    override def toString = s"T[$x, $y]($value $left $right)"
  }

  object PositionedNode {
    def unapply[T](p: PositionedNode[T]) : Option[(T, Tree[T], Tree[T], Int, Int)] =
      Some(p.value, p.left, p.right, p.x, p.y)

    def apply[T](value: T, left: Tree[T], right: Tree[T], x: Int, y: Int) =
      new PositionedNode[T](value, left, right, x, y)

    def apply[T](value: T, x: Int, y: Int) =
      new PositionedNode[T](value, End, End, x, y)
  }

  def drawTree[T](positionedNode: Tree[T]): Unit = {
    def collect(positionedNode: Tree[T]) : List[PositionedNode[T]] = positionedNode match {
      case End => Nil
      case a@PositionedNode(_, left, right, _, _) => a :: collect(left) ::: collect(right)
    }

    val sorted = collect(positionedNode) groupBy { _.y }
    for (key <- 0 to sorted.keys.toSeq.max) sorted.get(key) match {
      case None => println("")
      case Some(value) =>
        val left = value.sortBy(_.x).foldLeft("")((acc, value) => acc + (" " * (math.max(value.x - acc.length + 1, 0))) + value.value.toString)
        println(left)
    }
  }

  //drawTree(PositionedNode('A', PositionedNode('B', 3, 2), End, 2, 2))

  def p64[T](tree: Tree[T]): Tree[T] = {
    def count(tree: Tree[T]): Int = tree match {
      case End => 0
      case Node(_, l, r) => count(l) + count(r) + 1
    }

    def inner(tree: Tree[T], y: Int, x: Int): Tree[T] = tree match {
      case End => End
      case Node(v, l, r) =>
        val leftCount = count(l)
        PositionedNode(v, inner(l, y + 1, x), inner(r, y + 1, leftCount + x + 1), leftCount + x + 1, y)
    }

    inner(tree, 0, 0)
  }

  val p64_input = Node('n', Node('k', Node('c', Node('a'), Node('h', Node('g', Node('e'), End), End)), Node('m')), Node('u', Node('p', End, Node('s', Node('q'), End)), End))
  drawTree(p64(p64_input))

  // The same as p64, but count is returned with the recursion
  def p64_2[T](tree: Tree[T]): Tree[T] = {
    def inner(tree: Tree[T], x: Int, depth: Int): (Tree[T], Int) = tree match {
      case End => (End, x)  // We count elements by x
      case Node(v, l, r) =>
        val (leftTree, myX) = inner(l, x, depth + 1)
        val (rightTree, nextX) = inner(r, myX + 1, depth + 1)
        (PositionedNode(v, leftTree, rightTree, myX, depth), nextX)
    }

    inner(tree, 1, 1)._1
  }

  drawTree(p64_2(p64_input))

  --------------("P65. Layout a binary tree (2)")

  def p65[T](tree: Tree[T]): Tree[T] = {
    def treeDepth(tree: Tree[T]): Int = tree match {
      case End => 0
      case Node(_, l, r) => (treeDepth(l) max treeDepth(r)) + 1
    }

    def leftmostNodeDepth(tree: Tree[T]): Int = tree match {
      case End => 0
      case Node(_, l, _) => leftmostNodeDepth(l) + 1
    }

    def inner(tree: Tree[T], x: Int, depth: Int, exp: Int): Tree[T] = tree match {
      case End => End
      case Node(v, l, r) =>
        PositionedNode(v,
        inner(l, x - math.pow(2, exp).toInt, depth + 1, exp - 1),
        inner(r, x + math.pow(2, exp).toInt, depth + 1, exp - 1),
        x, depth)
    }

    val d = treeDepth(tree)
    val x0 = ((2 to leftmostNodeDepth(tree)) map {n => math.pow(2, d - n).toInt} reduceLeft {_ + _}) + 1
    inner(tree, x0, 1, d - 2)
  }

  drawTree(p65(p64_input))

  --------------("P66. Layout a binary tree (3)")
  def p66[T](tree: Tree[T]): Tree[T] = {
    def lowerBounds(tree: Node[T]) = (bounds(tree.left), bounds(tree.right)) match {
      case (Nil, Nil) => Nil
      case (lb, Nil) => lb map { case (a, b) => (a - 1, b - 1) }
      case (Nil, rb) => rb map { case (a, b) => (a + 1, b + 1) }
      case (a, b) => {
        val shift = a.zip(b) map { case ((la, ra), (lb, rb)) => (ra - lb) / 2 + 1} reduceLeft {_ max _}
        (a map { Some(_) }).zipAll(b map {Some(_)}, None, None) map {
          case (Some((a, b)), Some((c, d))) => (a - shift, d + shift)
          case (Some((a, b)), None)         => (a - shift, b - shift)
          case (None, Some((c, d)))         => (c + shift, d + shift)
          case _ => ???
        }
      }
    }
    def bounds(tree: Tree[T]): List[(Int, Int)] = tree match {
      case a : Node[T] => (0, 0) :: lowerBounds(a)
      case End => Nil
    }

    def internal(tree: Tree[T], x: Int, depth: Int): Tree[T] =
      (tree, bounds(tree)) match {
        case (End, _) => End
        case (Node(v, l, r), _ :: (bl, br) :: _) =>
          PositionedNode(v, internal(l, x + bl, depth + 1), internal(r, x + br, depth + 1), x, depth)
        case (Node(v, l, r), _) => PositionedNode(v, End, End, x, depth)
      }

    internal(tree, (bounds(tree) map { case(x, y) => x} reduceLeft {_ min _}) * -1 + 1, 1)
  }

  drawTree(p66(p64_input))


  --------------("P67. A string representation of a binary tree.")
  def p67[T](tree: Tree[T]): String = tree match {
    case End => ""
    case Node(v, End, End) => v.toString
    case Node(v, l, End) => s"$v(${p67(l)},)"
    case Node(v, End, r) => s"$v(,${p67(r)})"
    case Node(v, l, r) => s"$v(${p67(l)},${p67(r)})"
  }

  out(p67(Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))))) ==== "a(b(d,e),c(,f(g,)))"

  def p67_backward(str: String): Tree[Char] = p67_backward(str.toList)
  def p67_backward(str: List[Char]): Tree[Char] = {
    def findBracket(str: List[Char], curNesting: Int = 1, collectedStr: List[Char] = Nil, leftStr: List[Char] = Nil): (List[Char], List[Char]) = (str, curNesting) match {
      case (_, 0) => (leftStr.reverse, collectedStr.reverse)
      case (',' :: tail, 1) => findBracket(tail, curNesting, Nil, collectedStr)
      case (',' :: tail, _) => findBracket(tail, curNesting, ',' :: collectedStr, leftStr)
      case ('(' :: tail, _) => findBracket(tail, curNesting + 1, '(' :: collectedStr, leftStr)
      case (')' :: tail, 1) => findBracket(tail, curNesting - 1, collectedStr, leftStr)
      case (')' :: tail, _) => findBracket(tail, curNesting - 1, ')' :: collectedStr, leftStr)
      case (head :: tail, _) => findBracket(tail, curNesting, head :: collectedStr, leftStr)
    }

    str match {
      case Nil => End
      case value :: Nil => Node(value)
      case value :: '(' :: tail =>
        val (left, right) = findBracket(tail)    // lookup
        Node(value, p67_backward(left), p67_backward(right))
    }
  }

  out(p67_backward("a(b(d,e),c(,f(g,)))")) ==== Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))

  --------------("P68. Preorder and inorder sequences of binary trees.")
  def p68_preorder(tree: Tree[Char]): List[Char] = {
    def inner(tree: Tree[Char], lst: List[Char]): List[Char] =
      tree match {
        case End => lst
        case Node(v, l, r) => {
          val result = inner(l, v :: lst)
          inner(r, result)
        }
      }

    inner(tree, Nil).reverse
  }

  out(p68_preorder(Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))))) ==== List('a', 'b', 'd', 'e', 'c', 'f', 'g')

  def p68_inorder(tree: Tree[Char]): List[Char] = {
    def inner(tree: Tree[Char], lst: List[Char]): List[Char] =
      tree match {
        case End => lst
        case Node(v, l, r) => {
          val result = v :: inner(l, lst)
          inner(r, result)
        }
      }

    inner(tree, Nil).reverse
  }

  out(p68_inorder(Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))))) ==== List('d', 'b', 'e', 'a', 'c', 'g', 'f')

  // This doesn't work
//
//  def p68_preInTree(preOrder: List[Char], inOrder: List[Char]): Tree[Char] = preOrder match {
//    case Nil => End
//    case v :: preTail => {
//      val (leftIn, rightIn) = inOrder.span(_ != v)
//      Node(v, p68_preInTree(preTail.take(leftIn.length), leftIn),
//        p68_preInTree(preTail.drop(leftIn.length), rightIn))
//    }
//  }
//
//  out(p68_preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))) ===
//    Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
  --------------("P69. Dotstring representation of binary trees.")

  def p69(tree: Tree[Char]): String = {
    def inner(tree: Tree[Char]): List[Char] = tree match {
      case End => '.' :: Nil
      case Node(value, l, r) => value :: inner(l) ::: inner(r)
    }

    inner(tree).mkString
  }
  out(p69(Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))))) ==== "abd..e..c.fg..."

  def p69_back(lst: String): Tree[Char] = p69_back(lst.toList)

  def p69_back(lst: List[Char]): Tree[Char] = {
    def inner(lst: List[Char]): (Tree[Char], List[Char]) = lst match {
      case '.' :: tail => (End, tail)
      case value :: '.' :: '.' :: tail => (Node(value), tail)
      case value :: tail =>
        val (lTree, rest) = inner(tail)
        val (rTree, restLast) = inner(rest)
        (Node(value, lTree, rTree), restLast)
    }

    val (tree, _) = inner(lst)
    tree
  }

  out(p69_back("abd..e..c.fg...")) ==== Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End)))
}

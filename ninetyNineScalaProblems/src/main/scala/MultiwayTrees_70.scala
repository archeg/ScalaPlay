/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp

import scala.annotation.tailrec

/**
  * Created by archeg on 11/22/2015.
  */
object MultiwayTrees_70 extends ChapterApp {
  case class MTree[+T](value: T, children: List[MTree[T]]) {
    def this(value: T) = this(value, List())
    override def toString = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"
  }

  object MTree {
    def apply[T](value: T) = new MTree(value, List())
    //def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)
  }

  --------------("P70C Count the nodes of a multiway tree.")
  def p70c[T](tree: MTree[T]): Int = 1 + tree.children.map(x => p70c(x)).sum

  out(p70c(MTree('a', List(MTree('f'))))) ==== 2

  def p70c2[T](tree: MTree[T]): Int = tree.children.foldLeft(1)(_ + p70c2(_))

  out(p70c2(MTree('a', List(MTree('f'))))) ==== 2

  --------------("P70. Tree construction from a node string")
  def p70(str: String): MTree[Char] = p70(str.toList)
  def p70(str: List[Char]): MTree[Char] = {
    out(split(str.tail))
    def split(str: List[Char], nesting: Int = 0, before: List[Char] = Nil): Option[(List[Char], List[Char])] = (str, nesting) match {
      case (_, 0) if before.nonEmpty => Some((before.reverse, str))
      case (Nil, _) => None
      case ('^' :: tail, _) => split(tail, nesting - 1, '^' :: before)
      case (v :: tail, _) => split(tail, nesting + 1, v :: before)
    }

    def splitToStrings(str: List[Char]): List[List[Char]] = split(str) match {
      case None => Nil
      case Some((before, after)) => before :: splitToStrings(after)
    }

    MTree(str.head, splitToStrings(str.tail) map {p70(_)})
  }

  out(p70("afg^^c^bd^e^^^")) ==== MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))

  // Index out of range. Don't care, mine variant is better.
//  def p70_2(s: String): MTree[Char] = {
//    def nextStrBound(pos: Int, nesting: Int): Int =
//      if (nesting == 0) pos
//      else nextStrBound(pos + 1, if (s(pos) == '^') nesting - 1 else nesting + 1)
//
//    def splitChildStrings(pos: Int): List[String] =
//      if (pos >= s.length) Nil
//      else {
//        val end = nextStrBound(pos + 1, 1)
//        s.substring(pos, end - 1) :: splitChildStrings(end)
//      }
//
//    MTree(s(0), splitChildStrings(1).map(p70_2(_)))
//  }
//
//  out(p70_2("afg^^c^bd^e^^^")) === MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))

  --------------("P71. Determine the internal path length of a tree.")
  def p71[T](tree: MTree[T]): Int = tree.children.foldLeft(0)((a, x) => a + p71(x) + p70c(x))
  out(p71(MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e', List(MTree('f'), MTree('g'), MTree('c'))))))))) ==== 18

  --------------("P72. Construct the postorder sequence of the nodes.")
  def p72(s: String): List[Char] = {
    val tree = p70(s)
    def inner[T](tree: MTree[T]): List[T] = (tree.children flatMap {inner(_)}) :+ tree.value       // :+ is O(n)
    inner(tree)
  }

  out(p72("afg^^c^bd^e^^^")) ==== List('g', 'f', 'c', 'd', 'e', 'b', 'a')

  def p72_2(s: String): List[Char] = {
    import scala.collection.immutable.Queue
    val tree = p70(s)
    def inner[T](tree: MTree[T]): Queue[T] = (Queue(tree.children: _*) flatMap {inner(_)}) :+ tree.value   // :+ is O(1)
    inner(tree).toList
  }

  out(p72_2("afg^^c^bd^e^^^")) ==== List('g', 'f', 'c', 'd', 'e', 'b', 'a')

  --------------("P73. Lisp-like tree representation.")

  def p73(tree: MTree[Char]): String =
      if (tree.children.isEmpty)
        tree.value.toString
       else
        (tree.value :: (tree.children map {p73(_)})).mkString("(", " ", ")")

  out(p73(p70("afg^^c^bd^e^^^"))) ==== "(a (f g) c (b d e))"

  def p73_back(str: String): MTree[Char] = {
    // takes "a (f g) c (b d e)" and turns it into List("a", "(f g)", "c", "(b d e)")
    def splitToGroups(s: String): List[String] = {
      @tailrec
      def inner(s: List[Char], intendation: Int, current: List[Char], collected: List[List[Char]]): List[List[Char]] = (s, intendation) match {
        case (Nil, _) if current == Nil => collected.reverse
        case (Nil, _) => (current.reverse :: collected).reverse
        case (' ' :: tail, 0) => inner(tail, 0, Nil, current.reverse :: collected)
        case ('(' :: tail, _) => inner(tail, intendation + 1, '(' :: current, collected)
        case (')' :: tail, _) => inner(tail, intendation - 1, ')' :: current, collected)
        case (value :: tail, _) => inner(tail, intendation, value :: current, collected)
      }
      inner(s.toList, 0, Nil, Nil) map {_.mkString}
    }

    def composeP70(str: String): String =
      splitToGroups(str.drop(1).dropRight(1)) match {   // Remove first and last ()
      case value :: tail => (value ::
        (tail
          map { x => if (x.head == '(') composeP70(x) else x}      // If it is a bracket group - recurse.
          map {_ + '^'})).mkString                                 // Add ^ in the end of each group.
    }

    val p = composeP70(str)
    p70(p)
  }

  out(p73_back("(a (f g) c (b d e))")) ==== MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
  def p73_back_2(s: String): MTree[Char] = {
    def setNesting(nesting: Int, c: Char): Int = c match {
      case '(' => nesting + 1
      case ')' => nesting - 1
      case _   => nesting
    }
    def nextSpace(pos: Int, nesting: Int): Int =
      if ((s(pos) == ' ' || s(pos) == ')') && nesting == 0) pos
      else nextSpace(pos + 1, setNesting(nesting, s(pos)))
    def nextNonSpace(pos: Int): Int =
      if (s(pos) == ' ') nextNonSpace(pos + 1)
      else pos
    def listSubstrings(pos: Int): List[String] =
      if (pos > s.length || s(pos) == ')') Nil
      else {
        val end = nextSpace(pos, 0)
        s.substring(pos, end) :: (if (s(end) == ')') Nil else listSubstrings(nextNonSpace(end)))
      }
    if (s(0) != '(') MTree(s.head)
    else {
      val vEnd = nextSpace(1, 0)
      MTree(s.substring(1, vEnd).head, listSubstrings(nextNonSpace(vEnd)).map(p73_back_2(_)))
    }
  }

  out(p73_back_2("(a (f g) c (b d e))")) ==== MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))

}

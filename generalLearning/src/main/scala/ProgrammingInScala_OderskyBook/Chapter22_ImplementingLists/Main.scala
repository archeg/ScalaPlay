/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter22_ImplementingLists

import CommonPlay.ChapterApp

import scala.collection.mutable.ListBuffer

/**
 * Created by archeg on 9/19/2015.
 */
object Main extends ChapterApp {
  val l = List(2, 3)
  l match  {
    case 2 :: 3 :: _ => println("!")   // There exists case class ::[T](head, tail) extends List[T]
  }

  abstract class LogicalOperationsTree
  case class OR(val i: Int, val j: Int) extends LogicalOperationsTree

  val b = OR(5, 7)
  b match {
    case x OR y => println(x + " ! " + y)    // <- case x B y is stranslated into B(x, y)
  }

  // --------------- ListBuffer

  // But it is not tail-recursive.
  def incAll(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => x + 1 :: incAll(xs1)
  }

  // This one is effecient
  def incAllNonRec(xs: List[Int]): List[Int] = {
    var buf = new ListBuffer[Int]
    for (x <- xs) buf += x + 1
    buf.toList
  }

}

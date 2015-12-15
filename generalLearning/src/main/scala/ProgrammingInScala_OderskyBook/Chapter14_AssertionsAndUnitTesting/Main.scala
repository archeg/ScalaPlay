/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter14_AssertionsAndUnitTesting

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/19/2015.
 */
object Main extends ChapterApp {
  // Supposed to be placed anywhere as a guard
  assert(2 == 2)

  val list = List(1, 2, 3, 4)
  list.ensuring(_.contains(3))
  // example:
  def createAList(n: Int): List[Int] = {
    if (n == 0)
      Nil
    else {
      val l = List(1, 2, 4)
      3 :: l
    } ensuring (_.contains(3))
  }
  println(createAList(5))
}

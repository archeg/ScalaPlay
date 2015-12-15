/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter11

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/19/2015.
 */
object Main extends ChapterApp {
  var aa = new AnyRef()
  var b = new AnyRef()
  var c = new AnyRef()
  import scala.language.postfixOps    // So postfix ops won't generate warnings.
  println(aa hashCode)
  println(aa == b)
  println(aa != b)
  println(aa ##)
  println(b ##)
  println(aa hashCode)
  println(b hashCode)
  println(aa toString)
  println(Integer.toHexString(aa hashCode))

//  val d = new Int
  println(42 equals 42)
  println(42 == 42)
  println(1 to 5)
  println(3 abs)
  println("abcd".substring(0, 2) == "cdab".substring(2), true)

  val x = "abc"
  val y = "abcd".substring(0, 3)
  println(x == y)
  println(x eq y, false) // eq checks by-ref

  println(classOf[AnyRef].isAssignableFrom(classOf[Nothing]))   // anything is always subtyped by Nothing
}

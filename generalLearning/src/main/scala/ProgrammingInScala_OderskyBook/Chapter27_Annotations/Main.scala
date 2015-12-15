/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter27_Annotations

import CommonPlay.ChapterApp

/**
 * Created by archeg on 10/8/2015.
 */
object Main extends ChapterApp {
  @deprecated("Because I can", "since today")
  def bigMistake() = 2

  //println(bigMistake)                              // generates warning


  sealed abstract class A                          // sealed class allows scala to perform exhaustive check on matches.
  case class B(a: Int) extends A
  case class C(b: Int) extends A
//  def someMatch(a: A) = a match {                  // Generates a warning
//    case B(2) => 3
//  }

  def someMatch2(a: A) = (a : @unchecked) match {  // Does not generate a warning.
    case B(2) => 3
  }

  //println(someMatch(B(2)))
  println(someMatch2(B(2)))

  import annotation._

  class strategy(arg: Annotation) extends Annotation
  class delayed extends Annotation

  //@strategy(@delayed) def f() {}                  // won't compile
  @strategy(new delayed) def f() {}

  @volatile
  var a = 2                                         // The same as Java volatile

  @SerialVersionUID(213)                            // Serial number of the current version of the class
  //@serializable                                     // Serializable annotation. Deprecated. extend Serializable instead
  class SomeClass extends Serializable {
    @transient                                      // Makes the field non-serializable
    val a = 2
  }


  @native
  def aaaa() = {}



}

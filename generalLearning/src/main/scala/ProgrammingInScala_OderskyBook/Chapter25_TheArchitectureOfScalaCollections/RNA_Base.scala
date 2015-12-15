/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter25_TheArchitectureOfScalaCollections

/**
 * Created by archeg on 10/6/2015.
 */

abstract class Base
case object A extends Base
case object T extends Base
case object G extends Base
case object U extends Base
object Base {
  val fromInt: Int => Base = Array(A, T, G, U)
  val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
}
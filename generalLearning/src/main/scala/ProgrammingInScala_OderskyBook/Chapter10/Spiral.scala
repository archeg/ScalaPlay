/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter10

/**
 * Created by archeg on 7/19/2015.
 */

import Element.elem
object Spiral {
  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int = 0): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      direction match {
        case 0 => (corner beside horizontalBar) above (sp beside space)
        case 0 => (corner beside horizontalBar) above (sp beside space)
        case 1 => (sp above space) beside (corner above verticalBar)
        case 2 => (space beside sp) above (horizontalBar beside corner)
        case 3 => (verticalBar above corner) beside (space above sp)
      }
    }
  }
}

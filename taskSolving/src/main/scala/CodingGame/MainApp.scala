/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package CodingGame

/**
 * Created by archeg on 9/14/2015.
 */
class MainApp extends App {
  var list: List[AnyRef] = Nil
  def defineData(l: Int*) {
    list = l.reverse.map(x => x.asInstanceOf[AnyRef]).toList ::: list
  }

  def readInt: Int = {
    val r = list.last
    list = list.init
    r.asInstanceOf[Int]
  }
}

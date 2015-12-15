/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

import scala.collection.BitSet

/**
  * Created by archeg on 11/4/2015.
  */
object Collections extends App {
  val bitSet = BitSet(1, 3, 5, 8, 2)
  println(bitSet map { _ * 2 })
  println(bitSet map { _.toString })
}

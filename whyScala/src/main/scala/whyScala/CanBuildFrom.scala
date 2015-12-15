/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

import scala.collection.BitSet
import scala.collection.generic.CanBuildFrom

/**
 * Created by archeg on 10/6/2015.
 */
object CanBuildFrom extends App {
  // That is chosen automatically.
  def map2[A, B, That](set: Set[A], f: A => B)(implicit bf: CanBuildFrom[Set[_], B, That]) = {
    val builder = bf(set)       // A gets substituted to _
    println(bf.getClass)
    println(builder.getClass)
    for (s <- set) builder += f(s)
    builder.result()
  }

  println(map2(Set(1, 2, 3, 4), (x: Int) => x * 2.5))

  val bitSet = BitSet(1, 3, 5, 7)
  println(bitSet map { _ * 2})
  println(bitSet map { _.toString })
}

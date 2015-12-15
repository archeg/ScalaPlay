/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter25_TheArchitectureOfScalaCollections

import scala.collection.IndexedSeqLike
import scala.collection.mutable.ArrayBuffer

/**
 * Created by archeg on 10/6/2015.
 */
final class RNA2 private (
                         val groups: Array[Int],
                         val length: Int
                           ) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2] {         // We need to inherit both IndexedSeq and IndexedSeqLike
  import RNA2._                                                                                 // It implements all traversible methods in an extensible way
  override def newBuilder: scala.collection.mutable.Builder[Base, RNA2] =                       // That uses newBuilder, and returns the Repr type.
    new ArrayBuffer[Base] mapResult fromSeq                 // mapResult is used to create a builder. No need to define custom class
                                                            // ArrayBuffer[Base] is a builder itself.
                                                            // and we apply our transformation to it by passing fromSeq to mapResult
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}


object RNA2 {
  // Number of bits necessary to represent group
  private val S = 2
  // Number of groups that fit in an INt
  private val N = 32 / S
  // Bitmask to isolate a group
  private val M = (1 << S) - 1
  def fromSeq(buf: Seq[Base]): RNA2 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA2(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}

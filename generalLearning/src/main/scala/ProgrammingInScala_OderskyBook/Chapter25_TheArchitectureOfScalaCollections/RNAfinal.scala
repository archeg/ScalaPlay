/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter25_TheArchitectureOfScalaCollections

import scala.collection.generic.CanBuildFrom
import scala.collection.mutable.ArrayBuffer
import scala.collection.{IndexedSeqLike, mutable}

/**
 * Created by archeg on 10/7/2015.
 */
class RNAfinal private (val groups: Array[Int], val length: Int)
  extends IndexedSeq[Base] with IndexedSeqLike[Base, RNAfinal] {
  import RNAfinal._

  // Mandatory re-implementation of 'newBuilder' in 'IndeedSeq'
  override protected[this] def newBuilder: mutable.Builder[Base, RNAfinal] =
    RNAfinal.newBuilder

  // Mandatory implementation of 'apply' in 'IndexedSeq'
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  // Optional re-implementation of foreach,
  // to make it more efficient.
  override def foreach[U](f: Base => U): Unit = {
    var i = 0
    var b = 0
    while (i < length){
      b = if (i % N == 0) groups(i / N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }
}

object RNAfinal {
  private val S = 2                           // Number of bits in group
  private val M = (1 << S) - 1                // bitmask to isolate a group
  private val N = 32 / S                      // number of groups in an Int

  def fromSeq(buf: Seq[Base]): RNAfinal = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNAfinal(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)

  def newBuilder: mutable.Builder[Base, RNAfinal] =
    new ArrayBuffer mapResult fromSeq

  // This thing was added. This allows ++ to be working for example.
  implicit def canBuildFrom: CanBuildFrom[RNAfinal, Base, RNAfinal] =
    new CanBuildFrom[RNAfinal, Base, RNAfinal] {
      def apply() = newBuilder
      def apply(from: RNAfinal) = newBuilder
    }
}

/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter25_TheArchitectureOfScalaCollections

/**
 * Created by archeg on 10/6/2015.
 */

// ------------------------ Integrating new sequences.
// RNA: R (adenine), T(thymine), G(guanine) and U(uracil)


final class RNA1 private(val groups: Array[Int], val length: Int) extends IndexedSeq[Base] {        // Constructor is private. Cannot call new
  import RNA1._
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}

object RNA1 {
  // Number of bits necessary to represent group
  private val S = 2
  // Number of groups that fit in an INt
  private val N = 32 / S
  // Bitmask to isolate a group
  private val M = (1 << S) - 1
  def fromSeq(buf: Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA1(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}

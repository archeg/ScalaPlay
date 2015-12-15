/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter25_TheArchitectureOfScalaCollections

import CommonPlay.ChapterApp

import scala.collection.generic.CanBuildFrom

/**
 * Created by archeg on 10/6/2015.
 */
object Main extends ChapterApp {
  // Example of Builder used for collections.
  abstract class BuilderMy[-Elem, +To] {
    def +=(elem: Elem): this.type
    def result(): To
    def clear()
    def mapResult[NewTo](f: To => NewTo): BuilderMy[Elem, NewTo]
  }

  import scala.collection.{immutable, mutable}
  val buf = new mutable.ArrayBuffer[Int]                 // ArrayBuffer is a builder for Arrays
  val bldr = buf mapResult (_.toArray)
  println(bldr)


  trait TraversableLikeMy[+Elem, +Repr] {}
  // Here Elem is the element type, and Repr is the representation of the collection.
  // Repr can be anything.
  // for example StringOps extends TraversableLike[Char, String]

  // Filter looks like this:
//  trait TraversableLikeMy2[+Elem, +Repr] {
//    def newBuilder: BuilderMy[Elem, Repr]
//    def filter(p: Elem => Boolean): Repr {
//      val b = newBuilder
//      foreach { elem => if (p(elem)) b += elem}
//      b.result
//    }
//  }
  // newBuilder creates new builder for Repr

  // map is more complicated, because it can produce results with completely different types:
  val bits = immutable.BitSet(1, 2, 3)
  val bits2 = bits map (_ * 2)
  val bits3 = bits map (_.toFloat)
  println(bits2.isInstanceOf[immutable.BitSet], true)
  println(bits3.isInstanceOf[Set[Float]], true)

  val mmap = Map("a" -> 1, "b" -> 2) map { case (x, y) => (y, x) }
  val mmap2 = Map("a" -> 1, "b" -> 2) map { case (x, y) => y }
  println(mmap.isInstanceOf[Map[Int, String]], true)
  println(mmap2.isInstanceOf[List[Int]], true)

//  def map[B, That](p: Elem => B)
//                  (implicit bf: CanBuildFrom[Repr, B, That] ): That = {
//    val b = bf(this)
//    for (x <- this) b += f(x)
//    b.result
//  }

  // trait CanBuildFrom[-From, -Elem, +To] {
  //    def apply(from: From): Builder[Elem, To]
  // }
  // CanBuildFrom allows you to choose the type of the end representation of the collection.
  // Elem is element type to be built
  // To indicates the type of the collection to build
  // From indicates the type for which this builder factory applies.

  // If CanBuild[Repr, B, That] exists, this means that you can build That, from  given representation Repr, with element B
  // That is automatically chosen.
  // CanBuildFrom[Set[_], A, Set[A]]     Set[_] here is existential type.
  // Means for any set we can build a Set[A]

  def map[A, B](set: Set[A], f: A => B)(implicit bf: CanBuildFrom[Set[_], B, Set[B]]) = {
    val builder = bf(set)       // A gets substituted to _
    for (s <- set) builder += f(s)
    builder.result()
  }

  println(map[Int, Double](Set(1, 2, 3, 4), x => x * 2.5))

  // Without specifying representation type explicitly:
  // That is chosen automatically.
  def map2[A, B, That](set: Set[A], f: A => B)(implicit bf: CanBuildFrom[Set[_], B, That]) = {
    val builder = bf(set)       // A gets substituted to _
    println(bf.getClass)
    println(builder.getClass)
    for (s <- set) builder += f(s)
    builder.result()
  }

  println(map2(Set(1, 2, 3, 4), (x: Int) => x * 2.5))

  // For set the following canBuildFrom exists:

  // CC[_] is the type of the set
//  def setCanBuildFrom[A] = new CanBuildFrom[CC[_], A, CC[A]] {
//    def apply(from: CC[_]) = newBuilder[A]
//    def apply() = newBuilder[A]
//  }

  // ---------------------------- RNA example ------------------------------------------------
  val xs = List(A, G, T, A)
  val rna1 = RNA1.fromSeq(xs)
  val rna1_1 = RNA1(A, U, G, G, T)

  println(rna1.take(3), Vector(A, G, T))            // Vector??   We wanted RNA1!

  val rna2 = RNA2(A, G, T, A)
  println(rna2.take(3), RNA2(A, G, T))              // Now it is correct!

  val rna2_1 = rna2 map { case A => T case b => b }
  println(rna2_1, RNA2(T, G, T, T))                 // This produce RNA2. Cool!

  val rna2_2 = rna2 map Base.toInt
  println(rna2_2, Vector(0, 2, 1, 0))               // This produce Vector. Cool!!!!

  val rna2_3 = rna2 ++ rna2
  println(rna2_3, Vector(A, G, T, A, A, G, T, A))  // But this is not RNA :(

  val rna3 = RNAfinal(A, G, T, A)
  val rna3_1 = rna3 ++ rna3
  println(rna3_1, RNAfinal(A, G, T, A, A, G, T, A)) // Finally!

  // ---------------------------- Patricia trie ---------------------------------------------
  // Practical Algorithm to Retrieve Information Coded in Alphanumeric = PATRICIA

  val m = PrefixMap("abc" -> 0, "abd" -> 1, "al" -> 2, "all" -> 3, "xy" -> 4)
  println((m withPrefix "a").getClass())                                             // PrefixMap
  println(m withPrefix "a", PrefixMap("bc" -> 0, "bd" -> 1, "l" -> 2, "ll" -> 3))

  println(PrefixMap.getClass)
  println(PrefixMap.getClass.getSuperclass)
}

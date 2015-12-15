/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter19_TypeParameterization

import CommonPlay.ChapterApp

/**
 * Created by archeg on 8/26/2015.
 */
object Main extends ChapterApp {
  class SlowAppendQueue1[T](elems: List[T]){
    def head = elems.head
    def tail = new SlowAppendQueue1(elems.tail)
    def enqueue(x: T) = new SlowAppendQueue1(elems :: List(x))    // Slow. Not constant time.
  }

  class SlowAppendQueue2[T](elems: List[T]){
    // Here elems is reversed.
    def head = elems.last     // Slow
    def tail = new SlowAppendQueue2(elems.init)    // Slow. Not a constant time
    def enqueue(x: T) = new SlowAppendQueue2(x :: elems)
  }

  // Fast queue.
  class Queue[T] private (
      private val leading: List[T],
      private val trailing: List[T]
  ){
    private def mirror =
      if (leading.isEmpty)
        new Queue[T](trailing.reverse, Nil)
      else
        this

    // auxilary constructors
    def this(elems: T*) = this(elems.toList, Nil)
    def this() = this(Nil, Nil)

    def head = mirror.leading.head
    def trail = {
      val q = mirror
      new Queue[T](q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new Queue[T](leading, x :: trailing)
  }

  println(new Queue[Int](2,3,4,5))

  object Queue {
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
  }

  println(Queue(2, 3, 5, 7))
  //new Queue(Nil, Nil)  // Won't compile. Constructor is private

  newExample("Variance and arrays")

  // +T (covariant) won't work because of set(x: T)
  // -T (contravariant) won't work because of def get: T = current
  // T (nonvariant or rigid) only works here.
  class Cell[T](init: T){
    private[this] var current = init
    def get = current
    def set(x: T) { current = x}
  }

  // Not possible if it is just Cell[T]
//  val c1 = new Cell[String]("abc")
//  val c2: Cell[Any] = c1
//  c2.set(1)
//  val s: String = c1.get


  val a1 = Array("asdasd", "a")
  val a2 = Array(1, 3)
  //val a2: Array[Any] = a1 // Won't compile, although Java compiles. This is because Scala tries to be purer than Java, and it's array are not covariant
  // But you can do this if you really-really need it
  val ar2: Array[Object] = a1.asInstanceOf[Array[Object]]      // This is possible because of type erasure. Scala cannot differ string[] from object[]

  try {
    val ar: Array[Object] = a2.asInstanceOf[Array[Object]]
  } catch {
    case e: ClassCastException => println("Notice: this won't work as you cannot cast java int[] to object[]. int[] is specially handled, and the type is not erased.")
  }

  // -S - contravariance (accept arg)
  // +T - covariance     (return arg)
  trait Function1[-S, +T] {
    def apply(x: S): T
  }

  // Upper bounds
  def ordererdMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(ordererdMergeSort(ys), ordererdMergeSort(zs))
    }
  }

  newExample("Lower Type Bounds")

  // We want make ListNode[String] subtype of ListNode[Object]:
  case class ListNode[+T](h: T, t: ListNode[T]){
    def head: T = h
    def tail: ListNode[T] = t
    // This won't compile as elem it input parameter making T contravariant:
//    def prepend(elem: T): ListNode[T] =
//      ListNode(elem, this)
    def prepend[U >: T](elem: U): ListNode[U] =
      ListNode(elem, this)
  }

  // Now it works.
  val empty: ListNode[Null] = ListNode(null, null)
  val strList: ListNode[String] = empty.prepend("hello").prepend("world")
  val anyList: ListNode[Any] = strList.prepend(12345)
}

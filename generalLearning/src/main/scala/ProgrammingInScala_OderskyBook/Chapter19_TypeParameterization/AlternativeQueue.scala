/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter19_TypeParameterization

/**
 * Created by archeg on 8/27/2015.
 */
trait AlternativeQueue[T] {
  def head: T
  def tail: AlternativeQueue[T]
  def enqueue(x: T): AlternativeQueue[T]
}

object AlternativeQueue {
  def apply[T](xs: T*): AlternativeQueue[T] =
    new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
    ) extends AlternativeQueue[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    def head: T = mirror.leading.head
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  }
}

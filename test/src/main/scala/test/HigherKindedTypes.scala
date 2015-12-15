/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package test

/**
 * Created by archeg on 9/27/2015.
 */
object HigherKindedTypes extends App {
  trait Event[T] {
    val payload: T
    override def toString() = "!" + payload.toString()
  }

  trait Actor[T[E] <: Event[E]] {
    //def resolve(e: E){}       <- Not possible
    def resolve(e: T[Int]){
       println(e.toString())
    }
  }

  val actor = new Actor[Event] {}
  actor.resolve(new Event[Int]() { val payload = 5})


}

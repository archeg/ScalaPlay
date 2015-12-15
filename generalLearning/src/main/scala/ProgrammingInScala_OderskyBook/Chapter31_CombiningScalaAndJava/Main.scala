/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter31_CombiningScalaAndJava

import java.awt.Component
import java.io.InvalidObjectException

import CommonPlay.ChapterApp

/**
 * Created by archeg on 10/10/2015.
 */
object Main extends ChapterApp {
   new JMain().Run()
   val a: Iterator[T] forSome { type T } = null    // The same as Iterator<?> in Java, which means Iterator of anything.
                                                // This is called existential types.
   val b: Iterator[T] forSome { type T <: Component } = null       // You can have type bounds there
                                                                // Java equivalent Iterator<? extends Component>
   val c: Iterator[_] = null                                       // Is the same as Iterator[T] forSome { type T }
   val d: Iterator[_ <: Component] = null                          // also possible.

   val cont = (new JMain()).contents()                             // It is Collection[_]
   println(cont)
   println(cont.isInstanceOf[java.util.Collection[_]])
   println(cont.size)

   // Suppose you want to create a mutable Scala set and initialize it with the elements of contents:
   import scala.collection.mutable.Set
//   val iter = (new JMain).contents().iterator
//   val set = Set.empty[???]                                      // What type to put here?
//   while (iter.hasNext)
//      set += iter.next()

   abstract class SetAndType {
      type Elem
      val set: Set[Elem]
   }

   def javaSet2ScalaSet[T](jset: java.util.Collection[T]): SetAndType = {
      val sset = Set.empty[T]                 // Now T can be named!
      val iter = jset.iterator
      while (iter.hasNext){
         sset += iter.next
      }

      return new SetAndType {
         type Elem = T
         val set = sset
      }
   }

   println(javaSet2ScalaSet((new JMain).contents).set)

   newExample("Synchronized")
   // FOr compatibility's sake Scala provides access to Java's concurrency primitives.
   // The only exception is synchronized, it is only a keyword now:
   var counter = 0
   synchronized {
      counter = counter + 1
   }
}

trait SuperTrait {
   @throws(classOf[InvalidObjectException])
   def method(): Unit
}


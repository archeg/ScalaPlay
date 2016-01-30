import CommonPlay.ChapterApp

import scala.annotation.tailrec
import scala.collection.immutable.Queue
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.reflect.ClassTag

/**
  * Created by archeg on 12/10/2015.
  */
object Main extends ChapterApp {
  import scala.reflect.runtime.{universe => ru}

  class Foo[T](val data: T)

  def matchFoo[A: ru.TypeTag](foo: Foo[A]) = {
    println("Is string = " + (ru.typeOf[A] =:= ru.typeOf[String]))
    println("Is int = " + (ru.typeOf[A] =:= ru.typeOf[Int]))
    foo match {
      case fooStr: Foo[String @unchecked] if (ru.typeOf[A] =:= ru.typeOf[String]) => println("Found String")
      case fooInt: Foo[Int @unchecked] if ru.typeOf[A] =:= ru.typeOf[Int] => println("Found Int")
    }
  }

  matchFoo(new Foo[String]("str"))
  println("------------")
  matchFoo(new Foo[Int](123))
}

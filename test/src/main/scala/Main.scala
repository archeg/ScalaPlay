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
  trait Fn {
      type A
      type B
      def f(x: A): B
     }

  implicit object Bn extends Fn {
    type A = String
    type B = Int

    def f(x: A): B = 5
  }

  implicit object Cn extends  Fn {
    type A = Int
    type B = Boolean

    def f(x: A): B = true
  }

  def fun[C](c: C)(implicit f: Fn { type A = C}) = {
    println(f.f(c))
  }


  fun[String]("H")
  fun[Int](55)


}

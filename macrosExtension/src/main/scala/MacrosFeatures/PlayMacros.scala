/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package MacrosFeatures

import scala.reflect.macros.blackbox.Context

/**
  * Created by archeg on 11/19/2015.
  */
object PlayMacros {

  import scala.language.experimental.macros
  def my_impl[A: c.WeakTypeTag](c: Context)(a: c.Expr[A]): c.Expr[Unit] = {
    import c.universe._

    //    val a = rootMirror.staticClass(implicitly[c.WeakTypeTag[A]].tpe.toString.dropRight(5)).toString
    val className = implicitly[c.WeakTypeTag[A]].tpe.toString
    val module = c.universe.rootMirror.staticClass(className)                        //"Scala_byTopic.Macros.A"
    val m = module.companion


    c.Expr[Unit](q"""println(${m}.unapply($a).get.productIterator.mkString("\t"))""")
  }

  def my[T](a: T): Unit = macro my_impl[T]
}

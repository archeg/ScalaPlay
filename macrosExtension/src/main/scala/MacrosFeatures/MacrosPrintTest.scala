/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package MacrosFeatures

import scala.reflect.macros.blackbox.Context

/**
  * Created by archeg on 12/2/2015.
  */
object MacrosPrintTest {

  def printf_test(): Unit = macro printf_impl
  def printf_impl(c: Context)(): c.Expr[Unit] = {
    import c.universe._

    val mapParams = typeOf[Map[String, Set[Int]]].typeArgs
    val setType = mapParams.drop(1).head
    val setParam = setType.typeArgs.head
    val a = setParam.toString + "!"
    c.Expr[Unit](q"""println(${a})""")
  }
}

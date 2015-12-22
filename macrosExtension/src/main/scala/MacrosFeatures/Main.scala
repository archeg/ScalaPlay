/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package MacrosFeatures

/**
  * Created by archeg on 12/2/2015.
  */
object Main {

  import scala.language.experimental.macros
  import scala.reflect.macros.blackbox.Context
  object LoggerImpl {
    def logImpl(c: Context)(msg: c.Expr[String]): c.Expr[Unit] = {
      import c.universe._
      def getClassSymbol(s: Symbol): Symbol = if (s.isClass) s else getClassSymbol(s.owner)

      val cl = getClassSymbol(c.internal.enclosingOwner).toString
      val time = c.Expr[String](q"new java.util.Date().toString")
      val logline = c.Expr[String](q""" "[" + $cl + " : " + $time + "]" + $msg """)
      c.Expr[Unit](q"println($logline)")
    }
  }

  object Logger {
    def warning(msg: String): Unit = macro LoggerImpl.logImpl
  }

}

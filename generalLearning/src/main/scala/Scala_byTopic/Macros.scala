/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package Scala_byTopic

/**
  * Created by archeg on 11/18/2015.
  */
object Macros extends App {
//  import MacrosFeatures.PrintFExample._
//  printff("hello %s!\n", "world")
//  println("--------------------------------------------------------")
//  case class A(x: Int, s: String)  {
//    override def toString = "Hello world"
//    def test = "!!!!!!!!!"
//  }
//
//  val a = A(5, "Hello world")
//
//  import MacrosFeatures.PlayMacros._
//  my(a)
//
//  def test = {
//    Logger.warning("Hello")
//  }
//
//  test

  import MacrosFeatures.MacrosPrintTest._
  printf_test()
  // TODO: Type providers
}

/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

/**
 * Created by archeg on 10/6/2015.
 */
object ArrayIsFunction extends App {
  val arr = Array("sad", "asd", "hello world", "!", "?")
  val fun: Int => String = arr
  println(fun(2))
  println(fun(3))
}

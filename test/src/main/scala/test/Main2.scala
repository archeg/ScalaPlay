package test

/**
 * Created by archeg on 9/29/2015.
 */
object Main2 extends App {
  class A(arg:String)

  class B(argList:Vector[String]) extends A(argList.head)

  new B(Vector.empty[String])
}

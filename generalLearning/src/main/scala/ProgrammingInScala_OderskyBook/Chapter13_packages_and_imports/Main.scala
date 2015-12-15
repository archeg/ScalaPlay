/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter13_packages_and_imports

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/19/2015.
 */
object Main extends ChapterApp {
   class Outer {
     class Inner {
       private def f = "Hello world"
       class InnerMost() {
         f // OK
       }
     }

//     (new Inner).f // Not OK
   }

  private[Chapter13_packages_and_imports] class AA  // Accessible only from current package

  class A {
    private var d: Int = 2
    private[this] var e: Int = 3

    // No access modifier is public
    def doSomething(a: A){
      this.d = 20
      this.e = 30
      a.d = 10 // ok
//      a.e = 5  // not ok
    }

//    public def doSomethingElse() No public keyword
  }

  newExample("Visibility and companion objects")

  // Both class and it's companion object are considered as a single name-space
  class Rocket {
    import Rocket.fuel
//    import Rocket.pilots    <- Not possible as private[this] restricts usage to only object Rocket instance.
    // private fuel is accessible, because object Rocket is companion object.
    private def canGoHomeAgain = fuel > 20

    private[this] def process() = 50
  }

  object Rocket {
    private def fuel = 10
    private[this] def pilots = 20

    def chooseStrategy(rocket: Rocket) {
      // Companion object can access private fields of objects.
//      rocket.process()   <- But not private[this]
      if (rocket.canGoHomeAgain)
        goHome()
      else
        pickAStar()
    }

    def goHome() {}
    def pickAStar() {}

  }

  newExample("Package objects")
  printHelloWorld
}

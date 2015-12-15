/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter18_StatefulObjects

import CommonPlay.ChapterApp
import ProgrammingInScala_OderskyBook.Chapter18_StatefulObjects.DiscreteEventSimulation.BasicCircuitSimulation

/**
 * Created by archeg on 7/26/2015.
 */
object Main extends ChapterApp {
  // Stateful objects.
  class BankAccount {
    private var bal: Int = 0
    def balance = bal
    def deposit(amount: Int) {
      require(amount > 0)
      bal += amount
    }
    def withdraw(amount: Int): Boolean =
      if (amount > bal) false
      else {
        bal -= amount
        true
      }
  }
  val account = new BankAccount
  account deposit 100
  // Stateful object: calling the same method twice with the same args, returns different results.
  println(account withdraw 80, true) // Returns true
  println(account withdraw 80, false) // Returns false

  class Keyed {
    def computeKey: Int = {
      Thread.sleep(10000L)  // Long operation
      80
    }
  }

  // Not s stateful object, but rather has a cache.
  // so it still has var
  class MemoKeyed extends Keyed {
    private var keyCache: Option[Int] = None
    override def computeKey: Int = {
      if (!keyCache.isDefined)
        keyCache = Some(super.computeKey)
      keyCache.get
    }
  }

  newExample("Properties")
  class Time {
    var hour = 12
  }

  // Is translated into:

  class Time2 {
    var hour_ = 12
    def hour = hour_            // getter
    def hour_=(i: Int):Unit = Time2.this.hour_ = i     // setter
  }

  val time = new Time2()
  println(time.hour)
  time.hour = 40  // you can set it, as the setter is defined
  println(time.hour)

  // There can even be no field, and still there could be getter and setter:
  class Thermometer {
    var celsius: Float = _  // "default" initialization.  Writing =_ is requirement. In another case it will be abstract var.

    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_=(f: Float) { celsius = (f - 32) * 5 / 9}
    override def toString = fahrenheit + "F/"+ celsius + "C"
  }

  val thermometer = new Thermometer
  println(thermometer)
  thermometer.fahrenheit = 100
  println(thermometer)

  newExample("Case study: Discrete Event Simulation")
  import ProgrammingInScala_OderskyBook.Chapter18_StatefulObjects.DiscreteEventSimulation.MySimulation._
  val input1, input2, sum, carry = new Wire
  probe("sum", sum)
  probe("carry", carry)

  halfAdder(input1, input2, sum, carry)
  input1 setSignal true
  run()
  println("---------")
  input2 setSignal true
  run()

}

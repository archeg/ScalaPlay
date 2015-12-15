/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter18_StatefulObjects.DiscreteEventSimulation

/**
 * Created by archeg on 7/26/2015.
 */
object MySimulation extends CircuitSimulation {
  override def InventerDelay: Int = 1

  override def AndGateDelay: Int = 3

  override def OrGateDelay: Int = 5
}

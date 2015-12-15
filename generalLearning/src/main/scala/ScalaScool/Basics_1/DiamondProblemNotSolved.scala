package ScalaScool.Basics_1

/**
 * Created by archeg on 7/5/2015.
 */
object DiamondProblemNotSolved {
  def main(args: Array[String]): Unit = {
    val c = new Concrete()
    println(c.increment())
    println(c.decrement())
  }

  abstract class Abstrct {
    def returnTwo = 2
  }

  abstract class SuperAbstract extends Abstrct {
    override def returnTwo = 50
  }

  trait Incrementer extends Abstrct {
    def increment() = returnTwo + 100500
  }

  trait Subtractor extends SuperAbstract {
    def decrement() = returnTwo - 100500
  }

  abstract class MultiplierBase {
    def returnFive = 5
  }

  trait Multiplier extends MultiplierBase {
    def multiply() = returnFive * 6
  }

  // Cannot mix-in Multiplier, because it has different base abstract class
  //  class Concrete extends Incrementer with Subtractor with Multiplier {
  // Cannot reorder Subtractor and Incrementer, because if Incrementer written it requires Incrementor
  // to be inherited from SuperAbstract
//  class Concrete extends Incrementer with Subtractor {
  class Concrete extends Subtractor with Incrementer  {

  }
}

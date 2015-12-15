package ProgrammingInScala_OderskyBook.Chapter8

import java.io.InvalidObjectException

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/17/2015.
 */
object Main extends ChapterApp {
  // Local functions
  def function() = {
    def localFunction() = {
      def superLocalFunction() = {
          8
      }
      superLocalFunction()
    }
    localFunction()
  }

  println(function())

  val data = List(1,2,3,4,5,6)
  println(data.filter(3 <))
  println(data.filter(3 < _))
  println(data.filter(x => 3 < x))

  val f = (_ : Int) + (_ : Int)

  newExample("Partially applied functions")

  def sum(x: Int, y: Int) = x + y

  val fSum = sum _   // _ denotes an entire parameter list
  val fSuperSum = fSum(2, (_ : Int))
  println(fSum(2, 3))
  println(fSuperSum(3))
  println(fSum.apply(2, 3)) // The same

  println("------------")
  var a = List[() => Int]()
  for (i <- 1 to 10) {    // Closure in for is ok, as for each for run, there is a new i variable
    val fun = () => i     // So each run closes on another instance of i
    a = fun :: a
  }

  for (fun <- a){         // as the results we have 1 2 3 4 5 6 7 8 9 10
    println(fun())
  }

  println("------------")

  a = List[() => Int]()
  var j = 0
  for (i <- 1 to 10) {    // here closure takes the same j
    val fun = () => j     // so each run closes on the same instance of j
    a = fun :: a
    j += 1
  }

  for (fun <- a){         // as the result we have 10 10 10 10 10 10 10 10 10 10
    println(fun())
  }

  j = 0                   // closure closes over the reference
  val fun = () => j += 1  // so you can increment the variable.
  for (i <- 1 to 10) {
    fun()
  }

  println(j, 10)

  newExample("Special function call forms")

  // Repeated parameters
  def echo(args: String*) = {
    for (arg <- args) print(arg + " ")
    println(" ")
  }
  echo("1")
  echo("1", "2", "3")
  echo(Array("1", "2", "3") : _*)
  val arr = Array("1", "2", "3")
  echo(arr : _*)

  // Named arguments
  def speed(distance: Float, time: Float) = distance / time

  println(speed(100, 10), 10)
  println(speed(time = 10, distance = 100), 10)

  // Default parameters
  def speed2(distance: Float = 10, time: Float = speed(5, 2)) = distance / time
  println(speed2(), 4)

  // Default + Named parameters
  println(speed2(time = 5), 2)

  newExample("Tail recursion")

  def analyzeThrowable(data : => Unit) {

    try {
      data
    } catch {
      case ex => println(ex.getStackTrace.filter(_.getMethodName().contains("tailRecursion")).map(_.toString).mkString("\r\n"))
    }

  }

  def tailRecursion(i : Int) : Int =
    if (i == 0) throw new InvalidObjectException("!") else tailRecursion(i - 1)

  def tailRecursion2(i : Int) : Int =
    if (i == 0) throw new InvalidObjectException("!") else 2 * tailRecursion2(i - 1) // Not a tail-rec

  // Is tailed, so stacktrace has only one tailRecursion invoke
  analyzeThrowable {
    tailRecursion(4)
  }

  println("--")
  // Not tailed, so stacktrace has only 4 tailRecursion invoke
  // (because operation 2 * _ is performed after recursion invoke
  analyzeThrowable {
    tailRecursion2(4)
  }
}

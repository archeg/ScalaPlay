package ScalaScool.BasicDataStructures_3

/**
 * Created by archeg on 7/6/2015.
 */
object Main extends App {
  println("---------- Lists -----------")
  val numbersExample = List(1, 2, 3, 4)
  println(numbers)
  println("---------- Sets ------------")
  val sets = Set(1, 1, 2)
  println(sets)
  println("---------- Tuple ----------")
  val tuple = ("localhost", 80)
  println(tuple)
  println(tuple._1)
  println(tuple._2)

  // But you can access them 0 based & progrmmatically (though not a preferable way)
  println(tuple.productElement(0))

  val tupleMatch = tuple match {
    case ("localhost", port) => "verified"
    case (host, port) => "Cannot verify host %s and port %s".format(host, port)
  }
  println(tupleMatch)

  println((1, 2))
  println(1 -> 2) // Is also a tuple

  println("--------------- Destructuring bindings (unmapping tuples) ---------------------")
  val (host, port) = tuple
  println(host)
  println(port)

  case class Connection(host: String, port: Number)
  val conn = Connection("localhost", 80)
  val Connection(host2, port2) = conn    // Works also for case classes.
  println(host2)
  println(port2)

  println("--------------------- Maps -----------------------------------------")
  val simpleMap = Map(1 -> 2, 3 -> 4, "hello world" -> 5, 6 -> "oops")
  Map((1, 2), (3, 4), ("hello world", 5), (6, "oops"))
  println(simpleMap)
  Map(1 -> Map("foo" -> "bar"))

  println("--------------------- Option -------------------------------------")
  val numbers = Map("one" -> 1, "two" -> 2)
  println(numbers.get("two")) // Returns Some(2)
  println(numbers.get("three")) // Returns None

  val res = numbers.get("two")
  val result = if (res.isDefined) {
    res.get * 2
  }  else {
    0
  }
  println(result)
  //
  val result2 = res.getOrElse(0) * 2
  println(result2)
  //
  val result3 = res match {
    case Some(n) => n * 2
    case None => 0
  }
  println(result3)

  println("------------------ Functional combinators --------------------------")
  println(numbersExample.map(i => i *2))

  def timesTwo(i: Int) = i *2
  println(numbersExample.map(timesTwo))

  // foreach is for side effects only
  numbersExample.foreach(i => println(i))

  println(numbersExample.filter(i => i % 2 == 0))

  println(numbersExample.zip(List("a", "b", "c", "d")))

  val superNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(superNumbers.partition(_ % 2 == 0)) // Returns tuple

  println(superNumbers.find(i => i >= 3))
  println(superNumbers.drop(5))
  println(superNumbers.dropWhile(i => i <= 5))

  println(superNumbers.foldLeft(0)((x, y) => x + y))  // 0 is start value

  val nestedNumbers = List(List(1, 2), List(3, 4))
  println(nestedNumbers.flatten) // List(1, 2, 3, 4)

  println(nestedNumbers.flatMap(x => x.map(_ * 2)))  // combines flatten and map

  println("--------------- Generalized functional combinators -----------------")
  def ourMap(numbers: List[Int], fn: Int => Int) = {
    numbers.foldRight(List[Int]())((x: Int, y: List[Int]) => fn(x) :: y)
  }

  println(ourMap(numbersExample, timesTwo(_)))

  println("-------------- Map??? -------------------------")
  // All of the functional combinators shown work on Maps, too.
  // Maps can be thought of as a list of pairs so the functions you write work on a pair of the keys and values in the Map.

  val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
  println(extensions.filter(x => x._2 < 200))
  println(extensions.filter({case (name, extension) => extension < 200}))
  println(extensions.filter(_ match {case (name, extension) => extension < 200}))
  println(extensions.filter(x => x match {case (name, extension) => extension < 200}))
}

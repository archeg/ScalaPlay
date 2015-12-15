package ProgrammingInScala_OderskyBook.Chapter7

import java.io.{File, FileNotFoundException, FileWriter}
import java.net.{MalformedURLException, URL}

import CommonPlay.ChapterApp

import scala.io.Source
import scala.util.Random

/**
 * Created by archeg on 7/17/2015.
 */
object Main extends ChapterApp {
  val boolRnd = Random.nextBoolean()
  val fileName = if (boolRnd) "first" else "last"
  println(fileName)
  println(if (boolRnd) "Hello" else "world")

  newExample("While loops")

  def gcdLoop(x: Long, y: Long) = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  println(gcdLoop(50, 15))

  var i = 10
  do {
    i = Random.nextInt(10)
    print(i)
    print(" ")
  } while (i != 9)
  println("")
  print()

  newExample("!")

  var a = 10
  println(a = 20, ())

  var b = (a = 30) // This doesn't work. b will be Unit . The result of (a = 30) is Unit
  println(b, ())
  println(30 == (a = 30), false) // This also produces always false

  // This will be compiled into loop, as it is a tail-recursion
  def gcd(x: Long, y: Long):Long =
    if (y == 0) x else gcd(y, x % y)

  newExample("Generator for")
  val filesHere = (new File(".")).listFiles

  for (file <- filesHere){
    println("!" + file)
  }

  for (i <- 1 to 4) {
    print(i)
  }
  print(" ")
  for (i <- 1 until 4){
    print(i)
  }
  println("")

  for (
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".txt")
  ) println(file)

  newExample("Nested iteration")

  def fileLines(file: File) = Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".txt");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)


  grep(".*as.*")

  newExample("Mid-stream variable bindings")

  def grep2(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".txt")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)

  grep2(".*as.*")

  newExample("Producing a new collection")

  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".txt")
    } yield file

  val f = scalaFiles
  println(f)
  println(f.getClass)
  println(f.length)

  // Bigger yield
  for {
    file <- filesHere
    if file.getName.endsWith(".txt")
  } yield { println(file); file }

  newExample("Exceptions")
  def half(n: Int) =
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")

  try {
    val f = half(3)
  } catch {
    case ex: FileNotFoundException => println("Handle missing file")
    case ex: RuntimeException => println("Runtime exception happened.")
  }

  val file = new FileWriter("input.txt")
  try {
    file.write(5)
  } finally {
    file.close()
  }

  // Better not to return anything from finally clause
  def ff(): Int = try { return 1 } finally { return 2 }
  println(ff(), 2)
  def ff2(): Int = try { 1 } finally { 2 }
  println(ff2(), 1)

  // But it is completely normal to return something from catch clause
  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")
    }

  val genUrl: URL = urlFor("asdjkdas")
  println(genUrl, new URL("http://www.scala-lang.org"))

  newExample("Match")

  val firstArg = if (args.length > 0) args(0) else ""
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }

  // NO break and continue

  // But there is a breakable which uses exceptions
  import scala.util.control.Breaks._
  breakable {
     while (true) {
       print("? ")
       if (Random.nextInt(10) == 2){
         break
       }
     }
  }

  // By name with return result
  def foo(s: => String) {}
  val l = List(1,2,3,4,5)
  foo(l.filter(2 <).mkString(", "))

  println(" ")
  newExample("Variable scopes")
  val aa = 1; // ; is required
  {
    val aa = 2
    println(aa) // aa hides another aa
  }
  println(aa)

  newExample("Refactoring imperative-style code")

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val cell = (col * row).toString
      val padding = " " * (4 - cell.length)
      padding + cell
    }

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRowSeq(row).mkString
    tableSeq.mkString("\n")
  }

  println(multiTable)

}

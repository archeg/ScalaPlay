package ProgrammingInScala_OderskyBook.Chapter9

import java.io.{PrintWriter, File}

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/18/2015.
 */
object Main extends ChapterApp {

  def filesMatching(matcher: String => Boolean) ={
    for (file <- new File(".").listFiles(); if matcher(file.getName))
      yield file
  }

  println(filesMatching(x => x.contains("a")))

  object FileMatcher {
    private def filesMatching2(query: String, matcher: (String, String) => Boolean) ={
      for (file <- new File(".").listFiles(); if matcher(query, file.getName))
        yield file
    }

    def filesEnding(query: String) = filesMatching2(query, _.endsWith(_))
    def filesContaining(query: String) = filesMatching2(query, _.contains(_))
    def filesRegex(query: String) = filesMatching2(query, _.matches(_))
  }

  newExample("Simplifying client code")
  def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

  println(containsNeg(Nil))
  println(containsNeg(List(1,2,3,4)))
  println(containsNeg(List(1, -2, 3, 4)))

  newExample("Currying sum")

  def curriedSum(x: Int)(y: Int) = x + y

  def curriedS = curriedSum(2)_
  def curriedX = curriedSum((_:Int))(3)

  println(curriedS(5))
  println(curriedX(5))

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  withPrintWriter(new File("date.txt"), writer => writer.println(new java.util.Date))

  def withPrintWriter2(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  withPrintWriter2(new File("date.txt")) {
    writer => writer.println(new java.util.Date)
  }

  newExample("By name arguments")

  def boolAssert(predicate: => Boolean) {
    if (!predicate) throw new AssertionError()
  }

  boolAssert(5 > 3)

}

package ProgrammingInScala_OderskyBook.Chapter3

import CommonPlay.ChapterApp

import scala.io.Source
import scala.util.{Success, Failure, Try}

/**
 * Created by archeg on 7/15/2015.
 */
object Main extends ChapterApp {
  val list = 1 :: 2 :: 3 :: Nil
  println(list)
  //val pist = 1 :: 2

  val slowList = Nil :+ 1 :+ 2 :+ 3 :+ 4
  println(slowList)

  val list2 = List(1, 2, 3, 4, 5)
  println(10 :: list2)
  println(list2 :+ 10)

  println(List() == Nil)

  println(List("A", "B") ::: List("C", "D"))
  println(list2(2))
  try println(list2(100)) catch { case e: IndexOutOfBoundsException => println("Exception caught") }

  //

  val pair = (99, "Hello world")
  println(pair)
  println(pair._1)
  println(pair._2)
  val pair2 = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22) //max
  println(pair2)
  
  //
  println(System.getProperty("user.dir"))
  
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet + "Hello")
  println(jetSet.contains("Lear"))


  def formatArgs(args: Array[String]) = args mkString "\n"

  val res = formatArgs(Array("zero", "one", "two"))
  assert(res == "zero\none\ntwo")

  for (line <- Source.fromFile("test.txt").getLines())
    println(line.length + " " + line)

  newExample
  newExample("1")
  newExample("12")
  newExample("Hello world")

  def widthOfLength(s: String) = s.length.toString.length

  val fileName = "test.txt"
  val lines = Source.fromFile(fileName).getLines().toList
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )

  val maxWidth = widthOfLength(longestLine)

  for (line <- lines){
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}

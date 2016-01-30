package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/24/2016.
  */
object day2_3_FunctionallySolvingProblems extends ChapterApp {
  import scalaz._
  import Scalaz._
  //http://learnyouahaskell.com/functionally-solving-problems
  // This should be interesting I think

  --------------("Reverse Polish notation calculator")

  {
    abstract class NumParser[A] {
      def unapply(s: String): Option[A]
      def /(x: A, y: A): A
    }

    implicit val doubleParser = new NumParser[Double]() {
      def unapply(s: String): Option[Double] = s.parseDouble.toOption
      def /(x: Double, y: Double) = x / y
    }

    implicit val intParser = new NumParser[Int]() {
      def unapply(s: String): Option[Int] = s.parseInt.toOption
      def /(x: Int, y: Int) = x / y
    }

    import scala.reflect.runtime.universe._
    def solveRPN[A : Numeric: NumParser: TypeTag](s: String): A = {
      def foldingFunction[@specialized(Int, Double, Long, Float) A: TypeTag](stack: List[A], item: String)(implicit num: Numeric[A], parser: NumParser[A]): List[A] = {
        import num._
        (stack, item, typeOf[A]) match {
          case (first :: second :: rest, "+", _) => (first + second) :: rest
          case (first :: second :: rest, "-", _) => (first - second) :: rest
          case (first :: second :: rest, "*", _) => (first * second) :: rest
          case (first :: second :: rest, "/", _) => parser./(first, second) :: rest
          case ((first: Double) :: (rest : List[Double]), "ln", t) if typeOf[A] <:< typeOf[Double] => (math.log(first) :: rest).asInstanceOf[List[A]]
          case (list, parser(element), _) => element :: list
        }
      }

      s.split(" ").foldLeft(List.empty[A])((acc, s) => foldingFunction[A](acc, s)).head
    }

    out(solveRPN[Double]("2 3 + 7.3 +"))
    out(solveRPN[Int]("2 3 + 7 +"))
    out(solveRPN[Double]("2 3 + ln 7 +"))
  }

  --------------("Heathrow to London")

  {
    case class Road(length: Int, to: Node)
    sealed abstract class Node
    case class ConnectedNode(a: Road, b: Road) extends Node
    case class EndNode(a: Road) extends Node
  }

  // But we can make it simpler?

  {
    case class Section(getA : Int, getB: Int, getC: Int)
    type RoadSystem = List[Section]

    def inputData : RoadSystem = Section(50, 10, 30) :: Section(5, 90, 20) :: Section(40, 2, 25) :: Section(10, 8, 0) :: Nil
    abstract class Label
    case object A extends Label
    case object B extends Label
    case object C extends Label

    type Path = List[(Label, Int)]
    val emptyPath = List.empty[(Label, Int)]

    def expectedData : Path = (B, 10) :: (C, 30) :: (A, 5) :: (C, 20) :: (B, 2) :: (B, 8) :: Nil

    def optimalPath(roadSystem: RoadSystem): Path = {
      def roadStep(paths: (Path, Path), section: Section) = (paths, section) match {
        case ((pathA, pathB), Section(a, b, c)) =>
          val priceA = (pathA map {_._2}).sum
          val priceB = (pathB map {_._2}).sum
          val forwardA = priceA + a
          val forwardB = priceB + b
          val sideA = priceB + b + c
          val sideB = priceA + a + c
          val newPathToA = if (forwardA <= sideA) (A, a) :: pathA else (C, c) :: (B, b) :: pathB
          val newPathToB = if (forwardB <= sideB) (B, b) :: pathB else (C, c) :: (A, a) :: pathA
          (newPathToA, newPathToB)
      }

      val (bestAPath, bestBPath) = roadSystem.foldLeft(emptyPath -> emptyPath)(roadStep)
      if ((bestAPath map {_._2}).sum <= (bestBPath map {_._2}).sum)
        bestAPath.dropWhile(_._2 == 0).reverse
      else
        bestBPath.dropWhile(_._2 == 0).reverse
    }

    out(optimalPath(inputData)) ==== expectedData

    def rawInput = "50 10 30 5 90 20 40 2 25 10 8 0"

    out(optimalPath(rawInput.split(" ").map(_.toInt).grouped(3).toList map {
      case Array(a, b, c) => Section(a, b, c)
    })) ==== expectedData
  }
}

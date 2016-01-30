import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/24/2016.
  */
object polishRN extends ChapterApp {
  import spire.math._
  import spire.implicits._
  import spire.algebra._

  import scala.util.Try

  import language.implicitConversions

  abstract class NumParser[A] {
    def unapply(s: String): Option[A]
  }

  implicit val doubleParser = new NumParser[Double]() {
    def unapply(s: String): Option[Double] = Try(s.toDouble).toOption
  }

  implicit val intParser = new NumParser[Int]() {
    def unapply(s: String): Option[Int] = Try(s.toInt).toOption
  }

  import scala.reflect.runtime.universe._
  def solveRPN[A : Numeric: NumParser: TypeTag](s: String): A = {
    def foldingFunction[A: TypeTag](stack: List[A], item: String)(implicit num: Numeric[A], parser: NumParser[A]): List[A] = {
      (stack, item, typeOf[A]) match {
        case (first :: second :: rest, "+", _) => (first + second) :: rest
        case (first :: second :: rest, "-", _) => (first - second) :: rest
        case (first :: second :: rest, "*", _) => (first * second) :: rest
        case (first :: second :: rest, "/", _) => (first / second) :: rest
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

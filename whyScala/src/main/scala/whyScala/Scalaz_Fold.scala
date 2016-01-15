package whyScala

/**
  * Created by archeg on 1/12/2016.
  */
object Scalaz_Fold extends App {
  import scalaz._
  import Scalaz._

  def foldingFunction(list: List[Double], next: String): Option[List[Double]] =
    (list, next) match {
      case (x :: y :: ys, "*") => ((y * x) :: ys).some
      case (x :: y :: ys, "+") => ((y + x) :: ys).some
      case (x :: y :: ys, "-") => ((y - x) :: ys).some
      case (xs, numString) => numString.parseDouble.toOption map {_ :: xs}
    }

  def solveRPN(s: String): Option[Double] =
    for {
      List(x) <- s.split(' '). toList.foldLeftM(List.empty[Double]) (foldingFunction)
    } yield x


  println(solveRPN("10 4 3 + 2 * -")) // === (-4.0).some
}

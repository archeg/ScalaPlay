package whyScala

/**
  * Created by archeg on 1/31/2016.
  */
object Streams extends App {
  def squareRootOfPerfectSquare(a: Int): Option[Int] =
    if (scala.math.sqrt(a) % 1 == 0)
      scala.math.sqrt(a)
    else
      -1
}

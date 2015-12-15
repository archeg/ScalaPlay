package test

/**
 * Created by archeg on 9/29/2015.
 */
object O_TypeTags extends App {

  val map: Map[String, Any] = Map("foo" -> 1, "bar" -> Set('a', 'b'))

  abstract class Casts[B] {def cast(a: Any): B}
  implicit val doubleCast = new Casts[Double] {
    override def cast(a: Any): Double = a match {
      case x: Int => x.toDouble
    }
  }

  implicit val intCast = new Casts[Int] {
    override def cast(a: Any): Int = a match {
      case x: Int => x
      case x: Double => x.toInt
    }
  }

  implicit val seqCharCast = new Casts[Seq[Char]] {
    override def cast(a: Any): Seq[Char] = a match {
      case x: Set[Char] => x.toSeq
      case x: Seq[Char] => x
    }
  }


  def cast[T](key: String)(implicit p:Casts[T]) = p.cast(map(key))

  println(cast[Double]("foo"))
  println(cast[Int]("foo"))
  println(cast[Seq[Char]]("bar"))
}

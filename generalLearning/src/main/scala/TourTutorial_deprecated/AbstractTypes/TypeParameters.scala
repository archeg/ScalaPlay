package TourTutorial_deprecated.AbstractTypes

/**
 * Created by archeg on 7/5/2015.
 */
object TypeParameters {

  def main(args: Array[String]): Unit = {
    def newIntSeqBuf(elem1: Int, elem2: Int) : SeqBuffer[Int, Seq[Int]] =
      new IntSeqBuffer[List[Int]] {
        val element = List(elem1, elem2)
      }

    val buf = newIntSeqBuf(2, 3)
    println(buf.length)
    println(buf.element)
  }

  trait Buffer[+T] {
    val element: T
  }

  abstract class SeqBuffer[U, +T <: Seq[U]] extends Buffer[T] {
    def length = element.length
  }


  abstract class IntSeqBuffer[+T <: Seq[Int]] extends SeqBuffer[Int, T]
}

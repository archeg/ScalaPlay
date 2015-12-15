package ProgrammingInScala_OderskyBook.Chapter4

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/15/2015.
 */
object Main extends ChapterApp {
  newExample("Parenthesis can be omitted")
  class A
  class B()

  println(new A)
  println(new A())
  println(new B)
  println(new B())

  newExample("Variables must always be initialized.")
  class C {
    var name: String = _ // default initialization
  }

  println(new C().name, null)

  newExample("Checksum accumulator")
  class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte) {
      sum += b
    }

    def checkSum = ~(sum & 0xFF) + 1
  }

  val c = new ChecksumAccumulator

}

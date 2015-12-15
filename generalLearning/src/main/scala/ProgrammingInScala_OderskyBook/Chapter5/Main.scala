package ProgrammingInScala_OderskyBook.Chapter5

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/16/2015.
 */
object Main extends ChapterApp {
  val hex = 0x5
  val hex2 = 0x00FF
  val magic = 0xcafebabe

  println(hex.getClass().toString, "int")
  val tower = 35L
  println(tower.getClass().toString, "long")
  val little: Short = 367
  val littler: Byte = -120

  val big = 1.2345
  val bigger = 1.2345e2
  val biggerStill=123E45

  val little2 = 1.2345F
  val little3 = 3e5f

  val char = 'A'
//  val c = '\101'  // deprecated
  val d = '\u0041'
  val f = '\u0044'

  val linefeed = '\n'
  val dquote = '\"'
  println(dquote.toString, "\"")
  println('"'.toString, "\"")
  println('\'')

  println(
    """Long line ignoring
      |any stuff
      |It also has a margin "
      |'
      |blaa blaa blaa
    """.stripMargin)

  newExample("Symbols")

  def updateRecordByName(r: Symbol) {
    println(r)
  }

  updateRecordByName('s)


  println(2+5)
  println(2.+(5))
  println(-2)
  println(2.unary_-)
  //

  println(9 / 2, 4)
  println(9.0 / 2, 4.5)

  newExample("Remainder")

  println(11 % 4, 3)
  println(11.0 % 4, 3.0)
  println(math.IEEEremainder(11, 4), -1)     // IEEE remainder

  newExample("Logical ops")
  println(11 | 4, 15)
  println(11 ^ 4, 15)
  println(~1, -2)
  //println(11 || 4) <- doesn't work
  println(true | false)
  println(true || false)

  println(-1 >> 31, -1)     // Fills with 0
  println(-1 >>> 31, 1)     // Cycled
  println(0 >>> 32, 0)
  println(1 << 2, 4)

  newExample("Equals")

  println(1 == 1.0, true)
  println(List(1,2,3) == "hello", false)
  println(List(1,2,3) == null, false)
  println(null == List(1,2,3), false)
  println("He" + "llo" == "Hello", true)     // == compares by content
  println("Hello".eq("Hello"), true)
  val uninternedString = "He" + "llo" + String.valueOf(22)
  println(uninternedString == "Hello22", true)
  println(uninternedString.eq("Hello22"), false)     // .eq compares by reference     ???

  newExample("Operator precendence")
  println(10 / 5, 10./(5))                          // Applies from left to right
  println(List(1,2,3) ::: List(4,5,6), List(4,5,6).:::(List(1,2,3)))   // Operators that end with : applies from right to left

  newExample("Conclusion")
  println(0 max 5, 5)
  println((-2).abs, 2)
  println((1.0 / 0).isInfinity, true)

  println("hello world. love you".capitalize, "Hello world. love you")
  println("robert" drop 2, "bert")

}

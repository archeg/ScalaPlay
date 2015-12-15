package ProgrammingInScala_OderskyBook.Chapter6

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/16/2015.
 */
object Main extends ChapterApp {
   class A{
     println("Default constructor")
   }
  new A

  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)

  println(oneHalf + twoThirds)
  println(oneHalf * twoThirds)

  // constant is PascalCase
  println(math.Pi)
  // class names are PascalCase

  // everything else (even methods) are camelCased

  object Thread {
    //def yield() // Not possible
    def `yield`() = "Nailed!"
  }

  println(Thread.`yield`())

  newExample("Implicit conversions")

  import scala.language.implicitConversions
  implicit def intToRational(x: Int) = new Rational(x)
  val r = new Rational(2, 3)
  println(2 * r)
}

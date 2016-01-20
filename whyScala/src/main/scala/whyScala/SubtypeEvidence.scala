package whyScala

import shapeless.test.illTyped

/**
  * Created by archeg on 1/18/2016.
  */
object SubtypeEvidence extends App {

  case class Wrapper[T](t: T) {
    def checkEquality(b: T) = t == b
    def checkEqualityDouble(b: Double, eps: Double)(implicit ev: <:<[T, Double]) = math.abs(t - b) < eps

    def ===(b: T) = checkEquality(b)
    def ~~~(b: Double, eps: Double = 0.1)(implicit ev: <:<[T, Double]) = checkEqualityDouble(b, eps)
  }

  // Or defining a type-class.
  implicit class WrapperDouble[T](t: Wrapper[T])(implicit ev: <:<[T, Double]) {
    def ==~(b: Double, eps: Double = 0.1) = t ~~~ (b, eps)
  }

  val wD = Wrapper(51.673)
  val wS = Wrapper("Hello")

  assert(wD === 51.673)
  assert(!(wD === 51.6))
  assert(wS === "Hello")

  assert(wD ~~~ 51.6)
  illTyped("""wS ~~~ "Hello" """)     // This still show up in code-completion in IntelliJ Idea - IntellJ Idea does not parse evidences so deeply

  assert(wD ==~ 51.6)
  illTyped("""wS ==~ "Hello" """)
}

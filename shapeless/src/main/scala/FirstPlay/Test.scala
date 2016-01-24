package FirstPlay

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/22/2016.
  */
object Test extends ChapterApp {

  import shapeless._
  import record._
  import scala.reflect.runtime.universe.reify

  case class Signal(a: Int, b: String)

  object fun extends Poly1 {
    implicit def num = at[Int](x => x + 1)
    implicit def caseString = at[String](x => x + "!")
  }

  val genSignal = Generic[Signal]
  val to = genSignal.to(Signal(5, "Hello"))
  println(reify(to))
  out(reify(to.map(fun)))
  out(to.map(fun))

  private def getSqlValuesFromCaseClass(item : Signal, generic: Generic[Signal]) : Seq[Any] = {
    import record._
    val to1 = generic.to(item)
    println(reify(to1))
    to1.map(fun).toList
    Seq.empty[Any]
  }

  getSqlValuesFromCaseClass(Signal(5, "Hello"), genSignal)

}

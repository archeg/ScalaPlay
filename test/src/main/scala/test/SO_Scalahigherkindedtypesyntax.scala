package test

/**
 * Created by archeg on 9/27/2015.
 */
object SO_Scalahigherkindedtypesyntax extends App {
  trait Event[P] {
    val payload: P
  }

  case class FooEvent(payload: Int) extends Event[Int]

  trait BaseActor {
    type E = Event[P]
    type P
    def execute(dep: P)
    def runEvent(actor: E)
  }

  trait IntActor extends BaseActor {
    type P = Int
  }

  class FooActor extends IntActor {
    def execute(dependency: P) = {}
    def runEvent(actor: E) = {}
  }

  val c = new FooActor()
  c.runEvent(FooEvent(5))
  c.execute(5)
}

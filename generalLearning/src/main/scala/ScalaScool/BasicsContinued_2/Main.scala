package ScalaScool.BasicsContinued_2

import java.io.InvalidObjectException

/**
 * Created by archeg on 7/5/2015.
 */
object Main extends App {

  println("---------- Apply methods -----------")
  class Foo {
    override def toString() = "Foo class"
  }

  object FooMaker {
    def apply() = new Foo
  }

  val newFoo = FooMaker()
  println(newFoo)

  //

  class Bar {
    def apply() = "Hello world!"
  }

  println(new Bar()())

  println("-------------- Objects -----------------")

  object Timer {
    var count = 0
    def currentCount() : Long = {
      count += 1
      count
    }
  }

  println(Timer.currentCount())
  println(Timer.currentCount())

  // Companion object
  class Bar2(foo: String)    {
    override def toString() = "_Bar2_" + foo
  }

  object Bar2 {
    def apply(foo: String) = new Bar2(foo)
  }

  println(Bar2)           // This is object Bar2
  println(Bar2("!"))      // This is Bar2 class created via object (comapnion object)
  println(new Bar2("@"))  // This is creating Bar2 as usual

  println(" --- More on companion objects: can access private fields")
  class MyString(val jString: String) {
    private var extraData = ""
    override def toString() = jString + "." + extraData
  }

  object MyString {
    def apply(base: String, extras: String) = {
      val s = new MyString(base)
      s.extraData = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString("hello", "world"))
  println(MyString("word"))


  println("------------ Functions are Objects --------------")
  object addOne extends Function1[Int, Int] {
     def apply(m: Int) = m + 1  // apply is required by Function1
  }
  // The same:
  object addTwo extends ((Int) => Int) {
    def apply(m: Int) = m + 3  // apply is required by Function1
  }

  // And the function is actually an object with apply function defined.
  def addThree(m: Int) = m + 3
  var a:(Int => Int) = addThree
  println(a.apply(50))
  println("------------ Packages -----------------")
  // Obvious
  println("------------ Pattern matching ----------------")
  val times = 1
  val result = times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"  // wildcard. If no wildcard - exception is thrown if value is not 1 or 2
  }

  println(result)

  // Matching with guards
  val result2 = times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other number"
  }
  println(result2)

  // Matching on type
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0    => i -1
      case i: Int             => i + 1
      case d: Double if d < 0 => d - 0.1
      case d: Double          => d + 0.1
      case text: String       => text + "s"
    }
  }

  // Matchin on class members
  def calcType(calc: Calculator) = calc match {
    case _ if calc.brand == "hp" && calc.model == "20B" => "financial"
    case _ if calc.brand == "hp" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "hp" && calc.model == "30B" => "business"
  }

  // Place val to the ctor to define values inside a class
  class Calculator (val brand: String, val model: String){ }

  println("----------- Case Classes -----------")

  case class Calculator2(brand: String, model: String)
  val hp20b = Calculator2("hp", "20b")
  // Case classes have == defined automatically
  println(hp20b == Calculator2("hp", "20b"))
  println(hp20b == Calculator2("hp", "20c"))
  println(hp20b) // and toString

  val hp30b = Calculator2("ibm", "30b")
  def calcType(calc: Calculator2) = calc match {
    case Calculator2("hp", "20b") => "financial"
    case Calculator2("hp", "48g") => "scientific"
    case Calculator2("hp", "30b") => "business"
    case Calculator2("ibm", model) => "IBM Calculator: %s is of unknown type".format(model)
    case superCalc@Calculator2("samsung", model) => "Samsung are nice calculators: " + superCalc // Rebind value
    case Calculator2(brand, model) => "Calculator: %s %s is of unknown type".format(brand, model)     // Order matters. The more generic should go to the end.
  }

  println(calcType(hp20b))
  println(calcType(hp30b))
  println(calcType(Calculator2("nokia", "34")))
  println(calcType(Calculator2("samsung", "34")))

  println("---------- Exceptions -----------")

  object RemoteCalculatorService {
    def add(i: Int, j: Int) = throw new InvalidObjectException("No reason")
    def close() = println("Service closed.")
  }

  try {
     RemoteCalculatorService.add(2, 3)
  }
  catch {
    case e : InvalidObjectException => println("Error happened.")
    case e : ClassCastException => println("Lightning!!")
      // It will be thrown if no match happened.
  }
  finally {
    RemoteCalculatorService.close()
  }

  // Try catch can behave as expression
  val result3: Int = try {
    RemoteCalculatorService.add(2, 3)
  }
  catch {
    case e if e.getMessage() == "No reason" => {
      println("Happened.")
      100
    }
  }

  println(result3)
}

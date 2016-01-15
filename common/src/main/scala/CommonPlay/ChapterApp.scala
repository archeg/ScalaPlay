package CommonPlay

import scala.reflect.ClassTag

/**
  * Created by archeg on 12/8/2015.
  */
trait ChapterApp extends App {
  private val maxLength = 20
  protected def newExample(str: String) {
    val padding = maxLength - (str.length / 2 - 40)
    val padString = "-" * padding + " "
    var resultString = padString + str + padString.reverse
    if (resultString.length % 2 == 0){
      resultString += "-"
    }

    println(resultString)
  }

  //val illTyped = shapeless.test.illTyped

  protected def newExampleG(str: String)(block: => Unit) {
    newExample(str)
    block
  }

  protected def newExample(): Unit ={
    newExample("")
  }

  protected def println(x: Any) = Predef.println(x)
  protected def println(x: Any, y: Any) : Unit = {
    if (x != y){
      print("[assert failed!!!]")
      println(s"Was: $x, Expected $y")
    }

    assert(x == y)
    print("[asserted:]")
    println(x)
  }

  protected def error(x: => Unit) {
    var errorHappened = false
    try {
      x
    } catch {
      case ex =>
        errorHappened = true
        println(s"$ex happened.")
    }

    if (!errorHappened)
      assert(false)
  }

  private val length = 120

  def out[T](a: T) = {
    println(a)
    new Asserter(a)
  }

  def outDebug(a: Any) = {
    println(" - " + a.toString)
  }

  def debug[T](a: T): T = {
    println(a)
    a
  }

  def debugL[T, U](a: T)(f: T => U): T = {
    println(f(a))
    a
  }

  def debug[T](a: T, b : Any): T = {
    println(a, " --> ", b)
    a
  }

  def asrt(a: Any) = {
    new Asserter(a)
  }

  import scala.reflect.runtime.universe._
  def kind[A: TypeTag]: String = {
    def typeKind(sig: Type): String = sig match {
      case PolyType(params, resultType) =>
        (params map { p =>
          typeKind(p.typeSignature) match {
            case "*" => "*"
            case s   => "(" + s + ")"
          }
        }).mkString(" -> ") + " -> *"
      case _ => "*"
    }
    def typeSig(tpe: Type): Type = tpe match {
      case SingleType(pre, sym) => sym.companionSymbol.typeSignature
      case ExistentialType(q, TypeRef(pre, sym, args)) => sym.typeSignature
      case TypeRef(pre, sym, args) => sym.typeSignature
    }
    val sig = typeSig(typeOf[A])
    val s = typeKind(sig)
    sig.typeSymbol.name + "'s kind is " + s + ". " + (s match {
      case "*" =>
        "This is a proper type."
      case x if !(x contains "(") =>
        "This is a type constructor: a 1st-order-kinded type."
      case x =>
        "This is a type constructor that takes type constructor(s): a higher-kinded type."
    })
  }


  def time[T](label: String = "")(a: => T) = {
    val now = System.currentTimeMillis()
    val ret = a
    println(label + ": " + (System.currentTimeMillis() - now) + " ms.")
    ret
  }

  def _time[T](label: String = "")(a: => T): Unit = {
    println(label + ":" + " Skipped.")
  }

  def handle(a: => Unit): ExceptionAsserter[Exception] = {
    val excep = try {
      a
      null
    } catch {
      case ex: Exception => ex
    }

    if (excep == null)
      throw new IllegalStateException("Expression did not issue an exception")
    new ExceptionAsserter(excep)
  }

  def newChapter(s: String, pattern: String) {
    Predef.println((" " + s + " ").padTo((length / 1.5).toInt, pattern).reverse.padTo(length, pattern).reverse.mkString)
  }

  def +++(s: String) { Predef.println("+++ " + s) }
  def -------------- { --------------("") }
  def --------------(s: String) { newChapter(s, "-")}
  def =============================================(s: String) {
    println("")
    newChapter(s, "=")
    println("")
  }

  class Asserter[T](a: T) {
    def ===(b: Any) {
      assert(a == b, s"Answer| Exprected :\r\n$a\r\n$b")
    }

    def ==@(b: Any) {
      assert(a.toString == b.toString, s"Answer| Exprected (toString comparison):\r\n$a\r\n$b")
    }

    def ==%(b: Any) {
      assert(a.toString.startsWith(b.toString), s"Answer| Exprected (toString and startsWith comparison):\r\n$a\r\n$b")
    }

    def ==#(t: Class[_]): Unit = {
      assert(a.getClass == t, s"Answer| Expected (type comparison):\r\n${a.getClass}\r\n${t}")
    }

    def ofType[K : ClassTag](implicit ev: ClassTag[T]): Unit =  {
      val tag = implicitly[ClassTag[K]]
      a match {
        case tag(t) => {println(t)}
        case _ => assert(false, s"Answer| Expected (type comparison):\r\n${a.getClass}\r\n${implicitly[ClassTag[K]]}")
    }}

    def assrt(partialFunction: PartialFunction[Any, Boolean]) = Predef.assert(partialFunction(a))

    override def equals(b: Any) = {
      ===(b)
      true
    }

  }

  class ExceptionAsserter[T <: Exception](a: T) {
    def throws(b: Exception) =
      if (a.getClass == b.getClass)
        true
      else
        assert(false)

    override def equals(b: Any) = {
      throws(b.asInstanceOf[Exception])
      true
    }
  }

}

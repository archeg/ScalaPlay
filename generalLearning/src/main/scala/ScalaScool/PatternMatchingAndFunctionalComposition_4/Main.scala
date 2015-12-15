package ScalaScool.PatternMatchingAndFunctionalComposition_4

/**
 * Created by archeg on 7/6/2015.
 */
object Main extends App {
  println("----------- Function Composition --------------")
  def f(s: String) = "f(" + s + ")"
  def g(s: String) = "g(" + s + ")"

  // Compose
  val fComposeG = f _ compose g _
  println(fComposeG("yay"))

  // andThen
  val fAndThenG = f _ andThen g _
  println(fAndThenG("yay"))

  println("---------- Understanding PartialFunction -----------------")
  // A function works for every argument of the defined type. In other words, a function defined as (Int) => String takes any Int and returns a String.
  // A Partial Function is only defined for certain values of the defined type. A Partial Function (Int) => String might not accept every Int.
  // isDefinedAt is a method on PartialFunction that can be used to determine if the PartialFunction will accept a given argument.
  //  Note PartialFunction is unrelated to a partially applied function that we talked about earlier.
  val one: PartialFunction[Int, String] = { case 1 => "one" }
  println(one.isDefinedAt(1))
  println(one.isDefinedAt(2))
  println(one(1))
  try println(one(2)) catch { case e:MatchError => println("happend")}

  // orElse
  println(" - orElse")
  val two: PartialFunction[Int, String] = { case 2 => "two" }
  val three: PartialFunction[Int, String] = { case 3 => "three" }
  val wildcard: PartialFunction[Int, String] = { case _ => "anything else" }

  val partial = one orElse two orElse three orElse wildcard
  println(partial(2))
  println(partial(5))

  val pf: PartialFunction[Int, String] = {
    case i if i%2 == 0 => "even"
  }

  val tf: (Int => String) = pf orElse { case _ => "odd"}

  println(tf(1))
  println(tf(2))

  // The mystery of case.
  case class PhoneExt(name: String, ext: Int)
  val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
  println(extensions.filter { case PhoneExt(name, extension) => extension < 200 })

  // Why does it work?
  // filter takes function (PhoneExt) => boolean
  // PartialFunction is subtype of function, so filter can take PartialFunction
  //    { case PhoneExt(name, extension) => extension < 200 }
  //            is PartialFunction

  val partialFunc: PartialFunction[PhoneExt, Boolean] = { case PhoneExt(name, extension) => extension < 200 }
}

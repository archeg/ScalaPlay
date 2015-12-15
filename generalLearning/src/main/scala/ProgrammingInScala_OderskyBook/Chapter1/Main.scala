package ProgrammingInScala_OderskyBook.Chapter1

/**
 * Created by archeg on 7/15/2015.
 */
object Main extends App {
  var capital = Map("US" -> "Washington", "France" -> "Paris")
  capital += ("Japan" -> "Tokyo")
  println(capital("France"))

  //-

  def factorial(x: BigInt) : BigInt =
    if (x == 0) 1 else x * factorial(x - 1)
  println(factorial(1000))
}

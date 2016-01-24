/**
  * Created by archeg on 1/22/2016.
  */
object M {
   def main(args:Array[String]): Unit = {
     val t = 5
     test { println("Hello world"); t}
   }

  def test(a: => Int) = {
    val t = 6
    println("!!!!!!!!!" + a)
  }
}

/**
  * Created by archeg on 1/22/2016.
  */
object M {
   def main(args:Array[String]): Unit = {

     def FFFFFFFFFFFFFFFFFFFFFFFFF = {
       lazy val fibo: Stream[Int] = 0 #:: 1 #:: fibo.zip(fibo.tail).map { pair =>
         pair._1 + pair._2
       }
       fibo
     }

     println(FFFFFFFFFFFFFFFFFFFFFFFFF.toList)
     println(FFFFFFFFFFFFFFFFFFFFFFFFF.toList)
     println(FFFFFFFFFFFFFFFFFFFFFFFFF.toList)
   }

}


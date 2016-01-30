/**
  * Created by archeg on 1/22/2016.
  */
object M {
   def main(args:Array[String]): Unit = {
     import scala.reflect.runtime.{universe => ru, _}

     class Foo[T](val data: T)

     def matchFoo[A: ru.TypeTag](foo: Foo[A]) = {
       println("Is string = " + (ru.typeOf[A] =:= ru.typeOf[String]))
       println("Is int = " + (ru.typeOf[A] =:= ru.typeOf[Int]))
       val tt = ru.typeOf[A] =:= ru.typeOf[String]
       foo match {
         case fooStr: Foo[String @unchecked] if tt => println("Found String")
         case fooInt: Foo[Int @unchecked] if ru.typeOf[A] =:= ru.typeOf[Int] => println("Found Int")
       }
     }

     matchFoo(new Foo[String]("str"))
     println("------------")
     matchFoo(new Foo[Int](123))
   }
}


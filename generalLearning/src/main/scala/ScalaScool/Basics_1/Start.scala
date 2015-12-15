package ScalaScool.Basics_1

/**
 * Created by archeg on 7/5/2015.
 */
object Start {
       def main(args: Array[String]):Unit = {
         val two = 1 + 1
         println(two)
         var name = "steve"
         println(name)
         name = "marius"
         println(name)

         def addOne(m: Int) = m + 1
         def addTwo(m: Int) : Int = m + 2

         println(addOne(2))
         println(addTwo (3))

         def three() = 1 + 2
         println(three())
         println(three)

         def four = 1 + 2
         println(four)

         val anonFun = (x: Int) => x + 1
         println(anonFun(20))

         def factorial(i: Int) : Int = {
           if (i == 1){
             return 1
           }

           println("Doing " + i)
           i * factorial(i - 1)
         }

         println(factorial(5))

         // Partial application
         println("----------- Partial application -------------")

         def adder(m: Int, n: Int) = m + n
         val add2 = adder(2, _:Int)
         println(add2(50))

         val anon = 50 + (_: Int)
         println(anon(2))

         println("----------- Curried functions ---------------")
         def multiply(m: Int)(n: Int) : Int = m * n
         println(multiply(2)(3))

         val timesTwo = multiply(2) _
         println(timesTwo)
         println(timesTwo(5))

         val curriedAdd = (adder _).curried
         println(adder _)
         println(curriedAdd)
         println(curriedAdd(100))
         println(curriedAdd(100)(500))

         println("------------ Variable length arguments -------------")
         def capitalizeAll(args: String*) = {
           args.map { x => x.capitalize}
         }

         val result = capitalizeAll("rarity", "appleJack")
         println(result)

         println("------------ Classes -----------------")
         class Calculator {
           private val serial = "HP19as88s8s8-asd8 "
           val brand: String = "HP " + serial + add(2,3)
           def add(m: Int, n: Int) = m + n
         }
         val calc = new Calculator
         println(calc.add(50, 100))
         println(calc.brand)

         println("------------ Constructors --------------")
         class Constructor(brand: String) {
           val color = if (brand == "TI") { "blue" } else "red"
           def add(m: Int, n: Int) = m + n
         }

         println(new Constructor("TI").color)
         println(new Constructor("HP").color)
         println(new Constructor("IBM"))

         println("------------ Aside --------------------")
         class C {
           var acc = 0
           def minc = { acc += 1 }
           val finc = { () => acc += 1 }
           def mc() = { acc += 1 }
         }

         val c = new C()
         c.minc
         //println(c.minc())    <- doesn't work. This def requires for it to be called without ()
         c.finc   // returns val that creates a function
         c.finc() // returns val that creates a function and executes it

         c.mc         //
         c.mc()       // The same as c.mc, just a call convention
         println(c.acc)

         println("----------- Inheritance ------------")
         class ScientificCalculator(brand: String) extends Constructor(brand) {
           def log(m: Double, base: Double) = math.log(m) / math.log(base)
         }

         class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
           def log(m: Int): Double = log(m, math.exp(1))
         }

         abstract class Shape {
           def getArea(): Int
         }

         class Circle(r: Int) extends Shape {
           override def getArea(): Int = r * r * 3
         }

         val s = new Circle(10)
         println(s.getArea())

         println("-------------- Traits ---------------")
         trait Car {
           val brand: String
         }

         trait Shiny {
           val shineRefraction: Int
         }

         class BMW extends Car with Shiny {
           val brand = "BMW"
           val shineRefraction: Int = 50
         }

         val b = new BMW()
         println(b.shineRefraction)

//         trait NoParametersIsAllowed(i: Int){
//         }

         trait DoA{
           def print() {println("Hello world!")}
         }

         val cc = new AnyRef() with DoA
         cc.print()

         trait Cache[K, V] {
           def get(key: K) : V
           def put(key: K, value: V)
           def delete(key: K)
         }
       }
}

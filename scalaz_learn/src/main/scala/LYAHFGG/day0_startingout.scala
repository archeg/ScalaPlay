package LYAHFGG

import CommonPlay.ChapterApp
import shapeless.test.illTyped

/**
  * Created by archeg on 1/12/2016.
  */
object day0_startingout extends ChapterApp {
  import scalaz._
  import Scalaz._

  // Scala is not lazy by default, but if using appropriate structures, it can be done:
  def doubleMe(xs: Stream[Int]): Stream[Int] = xs map {_ * 2}

  out(doubleMe(doubleMe(doubleMe(Stream.from(0)))).take(4).toList) ==== List(0, 8, 16, 24)

  =============================================("Starting Out")

  // Ok, first difference haskell and scala:
  out(5 / 2) ==== 2 // But haskell outputs 2.5

  out(5 == "hello") ==== false
  illTyped( """5 === "hello"""") // We know from day0 in LearningScalaz that we should use === for the type to be checked
  out(5 === 6) ==== false


  out(8.succ) ==== 9 // Works with anything that has a defined successor
  out(8.min(10)) ==== 8

  out(9.succ + 5.max(4) + 1) ==== 16

  // Scalas if behaves exactly the same as in haskell:
  def doubleSmallNumber(x: Int) =
    if (x > 100) x else x * 2

  out(doubleSmallNumber(5)) ==== 10
  out(doubleSmallNumber(5000)) ==== 5000

  // Scala doesn't accept ' in names, because it has a special meaning.
  // illTyped("""def conanO'Brien = "It's a-me, Conan O'Brien!""")
  // even illTyped doesn't work here!

  out(List(1, 2, 3) ++ List(4, 5, 6)) // same as :::, but only ::: works in pattern matchin in scala

  out(2 :: List(1, 2, 3)) // Scala uses : instead of ::, because : is used for other things
  out(2 +: Vector(1, 2, 3))

  // Interesting. Scala's
  out(1 :: 2 :: 3 :: Nil)
  // reassembles Haskell's 1:2:3:[]

  // Got from OrderOps in scalaz
  out(List(2, 4, 6) > List(1, 3, 5))

  // heads & tails are all the same:
  out(List(1, 2, 3).head) ==== 1
  out(List(1, 2, 3).tail) ==== List(2, 3)
  out(List(1, 2, 3).init) ==== List(1, 2)
  out(List(1, 2, 3).last) ==== 3

  out(List(1, 2, 3).element(2)) ==== true // contains. The same as Haskell's elem

  --------------("Texas ranges")

  // scalaz has:
  out('a' |-> 'g') ==== List('a', 'b', 'c', 'd', 'e', 'f', 'g') // but it produces a list
  val xs: Stream[Int] = List(1, 2, 3).toStream #::: xs
  out((xs take 5).toList) ==== List(1, 2, 3, 1, 2)

  //out(List(1, 2, 3).toEphemeralStream.repeat[Stream].join.take(10).toList)
  // Couldn't find repeat analogue in scalaz.
  out(1.from)
  out(List(1, 2, 3))

  --------------("I'm a list comprehension")

  // Easy
  out(for (x <- 1 to 10) yield x*2)
  out(for (x <- 50 to 100 if x % 7 == 3) yield x)

  def length_(xs: List[Int]) = (for (_ <- xs) yield 1).sum
  out(length_(List(1, 2, 3, 4, 5))) ==== 5

  --------------("Tuples")

  out(1.from.zip(List(1, 2, 3).toEphemeralStream).toList)

  import math.pow
  def rightTriangles =
    for (c <- 1 to 10;
         b <- 1 to c;
         a <- 1 to b;
         if pow(a, 2) + pow(b, 2) == pow(c, 2))
      yield (a, b, c)

  out(rightTriangles)
}
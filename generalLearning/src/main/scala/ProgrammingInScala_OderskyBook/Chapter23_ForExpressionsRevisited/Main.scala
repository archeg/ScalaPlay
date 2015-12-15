/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter23_ForExpressionsRevisited

import CommonPlay.ChapterApp

/**
 * Created by archeg on 9/20/2015.
 */
object Main extends ChapterApp {
  case class Person(name: String, isMale: Boolean, children: Person*)
  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  println(persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))
  // Using withFilter is more effecient as it does not create intermediate structure
  println(persons withFilter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name)))))

  // But this reads much easier. The result is exactly the same.
  println {
    for (p <- persons; if !p.isMale; c <- p.children)
      yield (p.name, c.name)
  }

  newExample(" ----------- For expressions --------------")
  for {
    p <- persons            // a generator
    n = p.name              // a definition
    if (n startsWith "To")  // a filter
  } yield n

  for {
    p <- persons            // a generator. Requires traversible. p is a val
    n = p.name              // a definition. Always a val
    if (n startsWith "To")  // a filter
  } yield n
  // If there are several generators, the latter generator vary more rapidly than earlier ones.
  for (x <- List(1, 2); y <- List("one", "two"))
    yield (x, y)

  newExample(" ------------- The n-queens problem ----------- ")

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0)
        List(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
      queens forall (q => !inCheck(queen, q))
    def inCheck(q1: (Int, Int), q2: (Int, Int)) =
      q1._1 == q2._2 || // same row
      q1._2 == q2._2 || // same column
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // same diagonal

    placeQueens(n)
  }

  newExample("--------------------- Querying with for expressions ----------------")

  case class Book(title: String, authors: String*)
  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
      )
    )

  var r = for (b <- books; a <- b.authors if a startsWith "Gosling")
            yield b.title
  println(r)

  r = for (b <- books if (b.title indexOf "Program") >= 0)
        yield b.title
  println(r)

  r = for (b1 <- books; b2 <- books if b1 != b2;
          a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
        yield a1
  println(r)

  def removeDuplicates[A](xs: List[A]): List[A] = {
    if (xs.isEmpty) xs
    else
      xs.head :: removeDuplicates(
        for (x <- xs.tail if x != xs.head) yield x
      )
  }

  println(removeDuplicates(r))

  newExample("---------- Translation of for expressions -----------")
  println(for (x <- books) yield x.authors, books.map(x => x.authors))
  println(for (x <- books if x.title.length() > 5) yield x.authors, for (x <- books withFilter (y => y.title.length() > 5)) yield x.authors)
  println(for (x <- books if x.title.length() > 5) yield x.authors, books withFilter (y => y.title.length() > 5) map (x => x.authors))

  // two generators:
  println(for (x <- books; y <- books) yield (x, y), books.flatMap(x => for (y <- books) yield (x, y)))
  println(for (x <- books; y <- books; z <- books) yield (x, y, z), books.flatMap(x => for (y <- books; z <- books) yield (x, y, z)))
  var r1 = for (b1 <- books; b2 <- books if b1 != b2;
       a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
    yield a1
  // <==>
  var r2 = books flatMap (b1 =>
            books withFilter (b2 => b1 != b2) flatMap (b2 =>
              b1.authors flatMap (a1 =>
                b2.authors withFilter (a2 => a1 == a2) map (a2 =>
                  a1))))

  println(r1, r2)

  val l = List((1, 2), (3, 4), (5, 6))

  // ------------ Patterns
  var r3 = for ((a, b) <- l) yield a + b
  var r4 = l.map { case(a, b) => a + b }
  println(r3, r4)

  // For arbitary pattern it is a bit more complicated.
  val ll = List(Some(4), Some(5), None)
  var r5 = for (Some(d) <- ll) yield d
  var r6 = ll withFilter {
                case Some(d) => true
                case _ => false
              } map {
                case Some(d) => d
              }
  println(r5, r6)

  // ----------- Translating definitions
  r3 = for (x <- l; y = x._1 * x._1) yield y
  r4 = for ((x, y) <- for (z <- l) yield(z, z._1 * z._1)) yield y
  println(r3, r4)

  def p = print("Ran! ")
  // The expressions after generators are ran for each gen.

  for (x <- 1 to 10; y = p) yield x
  println()
  // Instead do this:
  val y = p
  for (x <- 1 to 10) yield x
  println()

  // for LOOP is translated into foreach
  for (x <- 1 to 10) print("H")
  print(" ")
  1 to 10 foreach (x => print("H"))

  println()
  for (x <- 1 to 10; y <- 1 to 10) print(x + y)
  print(" ")
  1 to 10 foreach (x => 1 to 10 foreach(y => print(x + y)))
  println()

  // GOing the other way
  object Demo {
    def map[A, B](xs: List[A] , f: A => B): List[B] =
      for (x <- xs) yield f(x)
    def flatMap[A, B](xs: List[A] , f: A => List[B] ): List[B] =
      for (x <- xs; y <- f(x)) yield y
    def filter[A](xs: List[A] , p: A => Boolean): List[A] =
      for (x <- xs if p(x)) yield x
  }

  class Test {
    def map[B](f: Int => B): List[B] = List(f(1), f(2))
  }

  println("------------------------")
  println(for(x <- new Test()) yield(x + "!"))
  //println(for(x <- new Test() if true) yield(x + "!"))     // exception: value filter is not a member of Test

  // for a full set need to implement:
  abstract class C[A] {
    def map[B](f: A => B): C[B]
    def flatMap[B](f: A => C[B]): C[B]
    def withFilter(p: A => Boolean): C[A]
    def foreach(b: A => Unit): Unit
  }
}

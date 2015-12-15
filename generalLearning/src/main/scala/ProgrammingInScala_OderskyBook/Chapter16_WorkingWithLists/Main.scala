/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter16_WorkingWithLists

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/22/2015.
 */
object Main extends ChapterApp {
  newExample("List literals")
  val fruit = List("apples", "oranges", "pears")
  var nums = List(1, 2, 3)
  val diag3 =
    List(
      List(1, 0, 0),
      List(0, 1, 0),
      List(0, 0, 1)
    )
  val empty = List()

  val homogenousList = List(1, "Hello world")
  // all lists elements has the same type
  // homogenousList is List[Any]

  // It is also covariant:
  val covariantFruit: List[Any] = fruit
  println(covariantFruit)

  newExample("Mutability and operations")
  nums ::= 5  // prepending 5 to nums
  // Creates new List!
  // The same as:
  nums = 5 :: nums
  println(nums)

  // But if mutable (there is no factory for mutable List in scala)
  val mutNums = collection.mutable.Map(1 -> 2)
  mutNums += 3 -> 4 // += here is a method. Notice that mutNUms is val

  // :: is prepending operation, that is run from right to left.
  // that's why you need Nil in the end, because :: is called on Nil, and string does not have ::
  val fruit2 = "apples" :: "oranges" :: "pears" :: Nil

  newExample("Insertation sort")

  // Add this annotation for the compiler to issue warning if recusrion is not tail-rec
  //@tailrec
  // This is not tail-rec though.
  def isort(xs: List[Int]): List[Int] = {
    def insert(x: Int, xs: List[Int]): List[Int] =
      xs match {
        case Nil                       => x :: Nil
        case head :: tail if head >= x => x :: xs
        case head :: tail              => head :: insert(x, tail)
      }

    xs match {
      case Nil          => Nil
      case head :: tail => insert(head, isort(tail))
    }
  }

  println(isort(List(10, 2, 5, 7, 1, 2, 8)))

  val a :: b :: rest = List(1, 2, 3, 4, 5)
  println(a, 1)
  println(b, 2)
  println(rest, List(3, 4, 5))

  println(List(1, 2, 3) ::: List(4, 5, 6))
  println(List() == Nil, true)

  val abcde = List('a', 'b', 'c', 'd', 'e')
  // Fast o(1) time
  println(abcde.head, 'a')
  println(abcde.tail, List('b', 'c', 'd', 'e'))
  // Slow o(n) time
  println(abcde.last, 'e')
  println(abcde.init, List('a', 'b', 'c', 'd'))

  // Reversing can help if you have to work with end of list. Reverse it, work with it, than reverse it back.
  println(abcde.reverse, List('e', 'd', 'c', 'b', 'a'))
  println(abcde.reverse.reverse, abcde)

  println(abcde.reverse.init, abcde.tail.reverse)
  println(abcde.reverse.tail, abcde.init.reverse)
  println(abcde.reverse.head, abcde.last)
  println(abcde.reverse.last, abcde.head)

  newExample("drop, take, splitAt")
  val (before, after) = abcde splitAt 2
  println(before, List('a', 'b'))
  println(after, List('c', 'd', 'e'))
  println(abcde take 2, before)
  println(abcde drop 2, after)

  newExample("apply, indices")
  println(abcde(2), 'c')   // Slow
  // abcde apply n EQUALS (abcde drop n).head
  println(abcde.indices, Range(0, 5))

  val notFlattened = List(List(1, 2), List(3, 4), List(5, 6))
  println(notFlattened.flatten, List(1, 2, 3, 4, 5, 6))
  //List(1, 2, 3).flatten               <- Compilation error

  println(abcde.indices zip abcde)     // Returns Vector
  val zipped = abcde zip List(1, 2, 3)   // zips only first three
  println(zipped)
  // There is also zipWithIndex
  println(abcde.zipWithIndex, (abcde zip abcde.indices).toList)

  println(zipped unzip)
  println(abcde toString)
  println(abcde mkString ",", "a,b,c,d,e")
  println(abcde mkString ("[", ",", "]"), "[a,b,c,d,e]")

  // == doesn't work for Arrays
  println((abcde toArray).sameElements(Array('a', 'b', 'c', 'd', 'e')))

  Array(1, 2) == Array(1, 2)

  val arr = Array[Int](5)
  List(1, 2, 3).copyToArray(arr, 1, 2)
  println(arr.sameElements(Array(0, 1, 2, 0, 0)))

  val it = List(1, 2, 3).iterator

  newExample("Merge sort")

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (xHead :: xTail, yHead :: yTail) =>
            if (less(xHead, yHead))
              xHead :: merge(xTail, ys)
            else
              yHead :: merge(xs, yTail)
      }

    val n = xs.length / 2
    if (n == 0)
      xs
    else {
      val (first, second) = xs splitAt n
      merge(msort(less)(first), msort(less)(second))
    }
  }

  println(msort[Int](_ < _)(List(1, 8, 2, 3, 1, 7)))

  val intSort = msort[Int](_ < _) _
  println(intSort(List(1, 8, 2, 3, 1, 7)))

  println(for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j))

  println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0))

  println(List(1, 2, 3, 4, 5, 1) span (_ < 3), (List(1, 2), List(3, 4, 5, 1)))

  def hasZeroRow(m: List[List[Int]]) =
    m exists (row => row forall (_ == 0))

  newExample("Folds")
  def product(xs: List[Int]):Int = (1 /: xs) (_ * _)

  println(product(List(2,3,7)))

  val words = List("Hello", "Scala", "world!")
  println(("" /: words)(_ + " " + _))
  println((words.head /: words.tail)(_ + " " + _))        // No extra space
  println((words :\ "")(_ + " " + _))

  println(List(1, -3, 4, 2, 6) sortWith (_ < _))
  println(words sortWith (_.length < _.length))

  println(List.fill(5)("Hello!"))
  println(List.fill(2, 3, 7)('0'))

  println(List.tabulate(5)(n => n * n))
  println(List.tabulate(5, 5)(_ * _))

  newExample("Multiplication table")
  def genMultTable(n: Int) =
    (0 :: List.range(0, n)) :: (List.tabulate(n, n)(_ * _).zipWithIndex.map{case (list, index) => index :: list})

  for(row <- genMultTable(10)){
    println(row map (x => if (x == 0) "##" else f"$x%02d" ) mkString " ")
  }

  val n = 10
  val list = List.tabulate(n, n)(_ * _).zipWithIndex map{case (list, index) => index :: list}

//  val n = 10
//  val list = List.tabulate(n, n)(_ * _) zipWithIndex map{case (list, index) => index :: list}

}

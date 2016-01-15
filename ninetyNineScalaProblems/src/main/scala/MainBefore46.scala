/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.math.BigDecimal.int2bigDecimal
import scala.reflect.ClassTag
import scala.util.Random

/**
 * Created by archeg on 11/2/2015.
 */
object MainBefore46 extends ChapterApp {
  // http://aperiodic.net/phil/scala/s-99/

  --------------("P01. Find the last element of a list.")

  def p01(l: List[Int]) = l.last

  out(p01(List(1, 1, 2, 3, 5, 8))) ==== 8

  def p01_2(l: List[Int]): Int = l match {
    case last :: Nil => last
    case _ :: tail => p01_2(tail)
    case _         => throw new NoSuchElementException
  }

  out(p01_2(List(1, 1, 2, 3, 5, 8))) ==== 8
  --------------("P02. Find the last but one element of a list")

  def p02(l: List[Int]) = l.takeRight(2).head

  out(p02(List(1, 1, 2, 3, 5, 8))) ==== 5

  def p02_2(l: List[Int]): Int = l match {
    case before :: _ :: Nil => before
    case _ :: tail => p02_2(tail)
    case _         => throw new NoSuchElementException
  }

  out(p02_2(List(1, 1, 2, 3, 5, 8))) ==== 5

  def p02_3(l: List[Int]) = l.init.last

  out(p02_3(List(1, 1, 2, 3, 5, 8))) ==== 5

  --------------("P03. Find the Kth element of a list.")

  def p03(l: List[Int], k: Int) = l(k)

  out(p03(List(1, 1, 2, 3, 5, 8), 2)) ==== 2

  def p03_2(l: List[Int], k: Int) = {
    def searcher(l: List[Int], p: Int): Int =
      if (p == k) l.head
      else searcher(l.tail, p + 1)
    searcher(l, 0)
  }

  out(p03_2(List(1, 1, 2, 3, 5, 8), 2)) ==== 2

  def p03_3(l: List[Int], k: Int): Int = (k, l) match {
    case (0, h :: _)    => h
    case (n, _ :: tail) => p03_3(tail, n - 1)
    case (_, Nil)       => throw new NoSuchElementException
  }

  out(p03_3(List(1, 1, 2, 3, 5, 8), 2)) ==== 2

  --------------("P04. Find the number of elements of a list.")

  def p04(l: List[Int]) = l.length

  out(p04(List(1, 1, 2, 3, 5, 8))) ==== 6

  def p04_2(l: List[Int]): Int = l match {
    case _ :: tail => p04_2(tail) + 1
    case _ => 0
  }

  out(p04_2(List(1, 1, 2, 3, 5, 8))) ==== 6

  def p04_3(l: List[Int]): Int = {
    @tailrec
    def searcher(l: List[Int], k: Int): Int = l match {
      case _ :: tail => searcher(tail, k + 1)
      case Nil => k
    }

    searcher(l, 0)
  }

  out(p04_3(List(1, 1, 2, 3, 5, 8))) ==== 6

  def p04_4(l: List[Int]) = l.foldLeft(0)((c, _) => c + 1)

  out(p04_4(List(1, 1, 2, 3, 5, 8))) ==== 6

  --------------("P05. Reverse a list.")

  def p05(l: List[Int]) = l.reverse

  out(p05(List(1, 1, 2, 3, 5, 8))) ==== List(8, 5, 3, 2, 1, 1)

  // O(n^2)
  def p05_2(l: List[Int]): List[Int] = l match {
    case a :: b => p05_2(b) ::: List(a)
    case Nil => Nil
  }

  out(p05_2(List(1, 1, 2, 3, 5, 8))) ==== List(8, 5, 3, 2, 1, 1)

  def p05_3(l: List[Int]): List[Int] = {
    @tailrec
    def inner(result: List[Int], curList: List[Int]): List[Int] = curList match {
      case Nil => result
      case h :: tail => inner(h :: result, tail)
    }

    inner(Nil, l)
  }

  out(p05_3(List(1, 1, 2, 3, 5, 8))) ==== List(8, 5, 3, 2, 1, 1)

  // fun
  def p05_4(l: List[Int]) = l.foldLeft(List.empty[Int])((x, y) => y :: x)

  out(p05_4(List(1, 1, 2, 3, 5, 8))) ==== List(8, 5, 3, 2, 1, 1)

  --------------("P06. Find out whether a list is a palindrome.")

  def p06(l: List[Int]): Boolean = l == l.reverse

  out(p06(List(1, 2, 3, 2, 1))) ==== true

  def p06_2(o: List[Int]): Boolean = {
    @tailrec
    def inner(l: List[Int], r: List[Int]): Boolean = l match {
      case Nil => o == r
      case head :: tail => inner(tail, head :: r)
    }
    inner(o, Nil)
  }

  out(p06_2(List(1, 2, 3, 2, 1))) ==== true

  --------------("P07. Flatten a nested list structure.")

  def p07(l: List[Any]): List[Int] = l.flatMap {
    case a: List[_] => p07(a)
    case x: Int => List(x)
  }

  out(p07(List(List(1, 1), 2, List(3, List(5, 8))))) ==== List(1, 1, 2, 3, 5, 8)

  --------------("P08. Eliminate consecutive duplicates of list elements")

  def p08[A](l: List[A]): List[A] = {
    def inner(l: List[A], curr: A): List[A] = (l, curr) match {
      case (a :: Nil, x) if a == x        => List(x)
      case (a :: Nil, x)                  => List(x, a)
      case (head :: tail, x) if x == head => inner(tail, curr)
      case (head :: tail, x)              => curr :: inner(tail, head)
    }

    inner(l.tail, l.head)
  }

  out(p08(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e))) ==== List('a, 'b, 'c, 'a, 'd, 'e)

  def p08_2[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case h :: tail => h :: p08_2(l.dropWhile(_ == h))
  }

  out(p08_2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e))) ==== List('a, 'b, 'c, 'a, 'd, 'e)

  def p08_3[A](l: List[A]) = {
    @tailrec
    def inner(result: List[A], input: List[A]): List[A] = input match {
      case Nil => result.reverse
      case h :: tail => inner(h :: result, tail.dropWhile(_ == h))
    }

    inner(Nil, l)
  }

  out(p08_3(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e))) ==== List('a, 'b, 'c, 'a, 'd, 'e)

  --------------("P09. Pack consecutive duplicates of list elements into sublists.")

  def p09[A](l: List[A]): List[List[A]] = l match {
    case Nil    => Nil
    case h :: _ =>
      val (before, after) = l span { _ == h }
      before :: p09(after)
  }

  out(p09(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))) ==== List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

  --------------("P10. Run-length encoding of a list using P09")

  def p10[A](l: List[A]) = p09(l) map { x => (x.length, x.head) }

  out(p10(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))) ==== List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

  --------------("P11 Modified run-length encoding.")

  def p11[A](l: List[A]) = p09(l) map { x => if (x.length == 1) x.head else (x.length, x.head) }

  out(p11(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))) ==== List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))

  def p11_2[A](l: List[A]) = p09(l) map { x => if (x.length == 1) Left(x.head) else Right(x.length, x.head) }

  --------------("P12 Decode a run-length encoded list")

  def p12[A](l: List[(Int, A)]) = l flatMap { case (i, x) => List.fill(i)(x) }

  out(p12(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))) ==== List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def p12_2[A](l: List[(Int, A)]): List[A] = l match {
    case Nil => Nil
    case (0, a) :: tail => p12_2(tail)
    case (x, a) :: tail => a :: p12_2((x - 1, a) :: tail)
  }

  out(p12_2(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))) ==== List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  --------------("P13. Run-length encoding of a list (direct solution")

  def p13[A](l: List[A]): List[(Int, A)] =
    if (l.isEmpty)
      Nil
    else {
      val (before, after) = l span { _ == l.head }
      (before.length, before.head) :: p13(after)
    }

  out(p13(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))) ==== List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

  --------------("P14. Duplicate the elements of a list")

  def p14[A](l: List[A]) = l flatMap { x => List(x, x) }
  out(p14(List('a, 'b, 'c, 'c, 'd))) ==== List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  --------------("P15. Duplicate the elements of a list a given number of times")

  def p15[A](times: Int, l: List[A]) = l flatMap { x => List.fill(times)(x)}
  out(p15(3, List('a, 'b, 'c, 'c, 'd))) ==== List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

  --------------("P16. Drop every Nth element from a list")

  def p16[A](times: Int, l: List[A]) = l.zipWithIndex.filter { case (x, i) => (i + 1) % times != 0 } map { case (x, i) => x }
  out(p16(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

  def p16_2[A](times: Int, l: List[A]) = {
    def inner(l: List[A], counter: Int): List[A] = (l, counter) match {
      case (Nil, _) => Nil
      case (_ :: tail, x) if x % times == 0 => inner(tail, counter + 1)
      case (head :: tail, _) => head :: inner(tail, counter + 1)
    }

    inner(l, 1)
  }

  out(p16_2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  def p16_3[A](times: Int, l: List[A]) = {
    @tailrec
    def inner(l: List[A], counter: Int, result: List[A]): List[A] = (l, counter) match {
      case (Nil, _) => result.reverse
      case (_ :: tail, x) if x % times == 0 => inner(tail, counter + 1, result)
      case (head :: tail, _) => inner(tail, counter + 1, head :: result)
    }

    inner(l, 1, Nil)
  }

  out(p16_3(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)


  --------------("P17. Split a list into two parts.")

  def p17[A](k: Int, l: List[A]) = l.splitAt(k)
  out(p17(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def p17_2[A](k: Int, l: List[A]) = {
    @tailrec
    def inner(l: List[A], count: Int, result: (List[A], List[A])) : (List[A], List[A])  = (l, count) match {
      case (Nil, _) => (result._1.reverse, result._2.reverse)
      case (head :: tail, x) if x < k => inner(tail, count + 1, (head :: result._1, result._2))
      case (head :: tail, x) if x >= k => inner(tail, count + 1, (result._1, head :: result._2))
    }

    inner(l, 0, (Nil, Nil))
  }

  out(p17_2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  --------------("P18. Extract a slice from a list.")

  def p18[A](i: Int, k: Int, l: List[A]) = l.slice(i, k)
  out(p18(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))  ==== List('d, 'e, 'f, 'g)

  def p18_2[A](i: Int, k: Int, l: List[A]) = {
    @tailrec
    def inner(counter: Int, l: List[A], result: List[A]): List[A] = l match {
      case Nil => result.reverse
      case head :: tail if counter >= k => result.reverse
      case head :: tail if counter < i => inner(counter + 1, tail, result)
      case head :: tail => inner(counter + 1, tail, head :: result)
    }

    inner(0, l, Nil)
  }

  out(p18_2(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))  ==== List('d, 'e, 'f, 'g)

  def p18_3[A](i: Int, k: Int, l: List[A]) =
    l drop i take (k - (i max 0))

  --------------("P19. Rotate a list N places to the left")
  def p19[A](n: Int, l: List[A]) =
    if (n >= 0)
      (l drop n) ::: (l take n)
    else
      (l takeRight -n) ::: (l dropRight -n)

  out(p19(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  out(p19(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))) ==== List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

  --------------("P20. Remove the Kth element from a list.")

  def p20[A](k: Int, l: List[A]) = ((l take k) ::: (l drop k + 1)) -> l(k)
  out(p20(1, List('a, 'b, 'c, 'd))) ==== (List('a, 'c, 'd), 'b)

  def p20_2[A](k: Int, l: List[A]) = l.splitAt(k) match {
    case (before, head :: tail) => (before ::: tail, head)
  }
  out(p20_2(1, List('a, 'b, 'c, 'd))) ==== (List('a, 'c, 'd), 'b)

  --------------("P21. Insert an element at a given position into a list.")

  def p21[A](a: A, p: Int, l: List[A]): List[A] = l splitAt p match {
    case (before, after) => before ::: List(a) ::: after
  }

  out(p21('new, 1, List('a, 'b, 'c, 'd))) ==== List('a, 'new, 'b, 'c, 'd)

  def p21_2[A](a: A, p: Int, l: List[A]): List[A] = {
    def inner(l: List[A], pos: Int): List[A] = (l, pos) match {
      case (_, `p`) => a :: inner(l, pos + 1)
      case (head :: tail, _) => head :: inner(tail, pos + 1)
      case (Nil, _) => Nil
    }

    inner(l, 0)
  }
  out(p21_2('new, 1, List('a, 'b, 'c, 'd))) ==== List('a, 'new, 'b, 'c, 'd)
  def p21_3[A](a: A, p: Int, l: List[A]): List[A] = {
    @tailrec
    def inner(l: List[A], pos: Int, result: List[A]): List[A] = (l, pos) match {
      case (_, `p`) => inner(l, pos + 1, a :: result)
      case (head :: tail, _) => inner(tail, pos + 1, head :: result)
      case (Nil, _) => result.reverse
    }

    inner(l, 0, Nil)
  }
  out(p21_3('new, 1, List('a, 'b, 'c, 'd))) ==== List('a, 'new, 'b, 'c, 'd)

  --------------("P22. Create a list containing all integers within a given range.")
  def p22(x: Int, y: Int) = x to y   // Returns Range.
  out(p22(4, 9)) ==== List(4, 5, 6, 7, 8, 9)

  def p22_2(x: Int, y: Int): List[Int] =
    if (x != y)
      x :: p22_2(x + 1, y)
    else
      List(y)

  out(p22_2(4, 9)) ==== List(4, 5, 6, 7, 8, 9)
  def p22_3(x: Int, y: Int): List[Int] = {
    @tailrec
    def inner(x: Int, y: Int, result: List[Int]): List[Int] =
      if (x != y)
        inner(x + 1, y, x :: result)
      else
        (y :: result).reverse
    inner(x, y, Nil)
  }
  out(p22_3(4, 9)) ==== List(4, 5, 6, 7, 8, 9)

  --------------("P23. Extract a given number of randomly selected elements from a list via P20")
  def p23[A](n: Int, a: List[A]): List[A] =
    if (a.length == n)
      a
    else
      p23(n, p20(Random.nextInt(a.length), a)._1)
  out(p23(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))) assrt { case x: List[_] => x.length == 3 }

  --------------("P24. Lotto: Draw N different random numbers from the set 1..M")
  def p24(n: Int, m: Int) = Stream.continually(Random.nextInt(m)) take n toList

  out(p24(6, 24))

  --------------("P25. Generate a random permutation of the elements of a list.")
  def p25[A](l: List[A]) = p23(l.length, l)

  out(p25(List('a, 'b, 'c, 'd, 'e, 'f)))

  // Fisher-Yates. Perfect?
  def p25_2[A : ClassTag](l: List[A]): List[A] = {
    val a = l.toArray
    for (i <- a.length - 1 to 1 by -1) {
      val i1 = Random.nextInt(i + 1)
      val t = a(i)
      a.update(i, a(i1))
      a.update(i1, t)
    }
    a.toList
  }

  out(p25_2(List('a, 'b, 'c, 'd, 'e, 'f)))
  out(p25_2(List('a, 'b, 'c, 'd, 'e, 'f)))

  // Almost perfect, but proved to be not perfect in the end.
  // Assigning to each value random key, and sorting by them.
  // The bigger range key has - the more "perfect" it is.
  def p25_3[A](l: List[A])(implicit a : Ordering[Int]) =
    (l map (Random.nextInt() -> _)).sortBy(_._1).map(x => x._2)
  // For case of 2 values and range of 2 keys:
  //  Therefore, there are only four possible tagged sequences:
  //  [(0,a) (0,b)]
  //  [(0,a) (1,b)]
  //  [(1,a) (0,b)]
  //  [(1,a) (1,b)]
  //  After the sorting, the sequences become:
  //  [(0,a) (0,b)]
  //  [(0,a) (1,b)]
  //  [(0,b) (1,a)]
  //  [(1,a) (1,b)]
  // So the probablity of (b, a) is only 1/4
  //Furthermore, if we have a sequence of N elements and associate with
  //  each element a key -- a random number uniformly distributed within [0,
  //  M-1] (where N!>M>=N), we have the configurational space of size M^N
  //    (i.e., M^N ways to key the sequence). There are N! possible
  //  permutations of the sequence. Alas, for N>2 and M<N!, M^N is not
  //  evenly divisible by N!. Therefore, certain permutations are bound to
  //  be a bit more likely than the others.

  out(p25_3(List('a, 'b, 'c, 'd, 'e, 'f)))
  out(p25_3(List('a, 'b, 'c, 'd, 'e, 'f)))

  // TODO: implement Haskell implementation: http://okmij.org/ftp/Haskell/perfect-shuffle.txt

  --------------("P26. Generate the combinations ok K distinct objects chosen from the N elements of a list.")
  def p26[A](k: Int, l: List[A]): List[List[A]] = l.combinations(k).toList

  def p26_2[A](k: Int, l: List[A]): List[List[A]] = {
    def inner(l: List[A], path: List[A]): List[List[A]] = l match {
      case _ if path.length >= k => List(path)
      case Nil => Nil
      case head :: tail => inner(tail, head :: path) ::: inner(tail, path)
    }

    inner(l, Nil)
  }

  def p26_4[A](n: Int, ls: List[A]): List[List[A]] = {
    def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
      ls match {
        case Nil => Nil
        case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
      }

    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      p26_4(n - 1, sl.tail) map { sl.head :: _ }
    }
  }

  out(p26(3, List('a, 'b, 'c, 'd, 'e, 'f))).assrt { case x: List[_] => println("1)" + x.length.toString); x.length == 20}
  out(p26_2(3, List('a, 'b, 'c, 'd, 'e, 'f))).assrt { case x: List[_] => println("2)" + x.length.toString); x.length == 20}
  out(p26_4(3, List('a, 'b, 'c, 'd, 'e, 'f))).assrt { case x: List[_] => println("4) " + x.length.toString); x.length == 20}

  assert(p26(3, List('a, 'b, 'c, 'd, 'e, 'f)).map(_.toSet).toSet ==  p26_2(3, List('a, 'b, 'c, 'd, 'e, 'f)).map(_.toSet).toSet)
  assert(p26_4(3, List('a, 'b, 'c, 'd, 'e, 'f)).map(_.toSet).toSet ==  p26_2(3, List('a, 'b, 'c, 'd, 'e, 'f)).map(_.toSet).toSet)

  --------------("P27. Group the elements of a set into disjoint subsets.")

  def p27[A](numbers: List[Int], items: List[A]): List[List[List[A]]] = numbers map { items.combinations(_).toList }

  val p27_r = p27(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
  out(p27_r)

  def p27_2[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
    case Nil     => List(Nil)
    case n :: ns => p26(n, ls) flatMap { c =>
      p27_2(ns, ls diff c) map {c :: _}
    }
  }

  val p27_2r = p27_2(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
  out(p27_2r)

  val p27_t = p27(List(2), List("Aldo", "Jackson", "Hugo"))
  val p27_2t = p27_2(List(2), List("Aldo", "Jackson", "Hugo"))
  //out(p27_t.map(_.map(_.toSet).toSet).toSet) === p27_2t.map(_.map(_.toSet).toSet).toSet
  // It looks ok, the grouping is just wrong.

  --------------("P28. Sorting a list of lists according to length of sublists.")

  def p28[A](l: List[List[A]]) = l sortBy (_.length)

  out(p28(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))

  // O(n^2)
  def p28_m[A](l: List[List[A]]) =
    l map (x => l.count(_.length == x.length) -> x) sortBy {case (len, _) => len } map { _._2 }

  val p28_m_answer = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
  out(p28_m(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))) ==== p28_m_answer


  // O(n * logn)
  def p28_2m[A](l: List[List[A]]) = {
    val lengthMap = l map (x => x.length -> x)              // O(n)
    val array = Array.fill[Int](lengthMap.maxBy(_._1)._1 + 1){0}   // O(n)
    for ((len, x) <- lengthMap) {                                  // O(n)
      array(len) += 1
    }

    l.sortBy(x => array(x.length))                                 // O(n*logn)
  }

  out(p28_2m(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))) ==== p28_m_answer

  def p28_3m[A](ls: List[List[A]]): List[List[A]] = {
    val freqs = Map(p10(ls map { _.length } sorted) map { _.swap }:_*)
    ls sortBy { x => freqs(x.length) }
  }

  out(p28_3m(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))) ==== p28_m_answer


  =============================================("Arithmetic")

  --------------("P31. Determine whether a given integer number is prime.")
  def p31(n: Int) = (2 to math.sqrt(n).toInt).forall(n % _ != 0)
  out(p31(7)) ==== true
  out(p31(8)) ==== false

  // Fermat. Unproven? Doesn't work in all the cases.
  def fib(n: Int): Int = n match { case x if x <= 2 => 1; case x => fib(x - 1) + fib(x - 2)}
  def p31_2(n: Int) = math.pow(2, n - 1) % n == 1 & fib(n + 1) % n == 0
  out(p31_2(7)) ==== true
  out(p31_2(8)) ==== false

  --------------("P32. Determine the greatest common divisor of two positive integer numbers.")
  @tailrec
  def p32(a: Int, b: Int): Int = if (b == 0) a else p32(b, a % b)
  out(p32(36, 63)) ==== 9

  --------------("P33. Determine whether two positive integer numbers are coprime.")
  def p33(a: Int, b: Int) = p32(a, b) == 1
  out(p33(35, 64)) ==== true

  implicit class Coprime(a: Int) {
    def isCoprimeTo(b: Int) = p32(a, b) == 1
  }

  out(35.isCoprimeTo(64)) ==== true

  --------------("P34. Calculate Euler's totient function phi(m)")
  def p34(m: Int) = (1 to m).count(_.isCoprimeTo(m))
  out(p34(10)) ==== 4

  --------------("P35. Determine the prime factors of a given positive integer.")
  // Stupid approach.
  def p35(m: Int): List[Int] = (2 to m) find {m % _ == 0} match {
    case None => Nil
    case Some(x) => x :: p35(m / x)
  }

  out(p35(315)) ==== List(3, 3, 5, 7)

  // Just a bit cleverer
  def p35_2(m: Int): List[Int] = {
    def inner(m: Int, from: Int): List[Int] = (from to m) find { m % _ == 0 } match {
      case None => Nil
      case Some(x) => x :: inner(m / x, x)
    }

    inner(m, 2)
  }
  out(p35_2(315)) ==== List(3, 3, 5, 7)

  --------------("P36. Determine the prime factors of a given positive integer.")
  def p36(m: Int): List[(Int, Int)] = p35_2(m).foldLeft(List.empty[(Int, Int)]) {
    case (Nil, y) => (y, 1) :: Nil
    case ((el, n) :: tail, y) if el == y => (el, n + 1) :: tail
    case (list, y) => (y, 1) :: list
  }.reverse

  out(p36(315)) ==== List((3, 2), (5, 1), (7, 1))

  def p36_m(m: Int) = p36(m).toMap

  out(p36_m(315)) ==== Map(3 -> 2, 5 -> 1, 7 -> 1)

  --------------("P37. Calculate Euler's totient function phi(m) (improved)")
  // Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.

  def p37(m: Int) = p36(m).foldLeft(1) {
    case (acc, (p, m)) => acc * (p - 1) * math.pow(p, m - 1).toInt
  }

  out(p37(10)) ==== 4

  --------------("P38. Compare the two methods of calculating Euler's totient function.")
  time("P34") {
    out(p34(1009000)) ==== 403200
  }
  time("P37") {
    out(p37(1009000)) ==== 403200
  }

  --------------("P39. A list of prime numbers.")
  // Direct
  def p39(a: Int, b: Int): List[Int] =
    (a to b) filter { p31(_) } toList;

  out(p39(7, 31)) ==== List(7, 11, 13, 17, 19, 23, 29, 31)

  // Eratosfen fun
  def p39_2(a: Int, b: Int): List[Int] = {
    val map = mutable.BitSet((2 to b): _*)      // Looks liks scala's BitSet is slow.
    for (
      x <- 2 to b
      if map(x);
      y <- Stream.from(x * 2, x) take (b / x)) {
      map(y) = false
    }

    (map filter {_ >= a}).toList
  }

  out(p39_2(7, 31)) ==== List(7, 11, 13, 17, 19, 23, 29, 31)

  // Eratosfen fun2
  def p39_3(a: Int, b: Int): List[Int] = {
    val map = Array.fill(b + 1)(true)
    for (
      x <- 2 to b
      if map(x);
      y <- Stream.from(x * 2, x) take (b / x - 1)) {
      map(y) = false
    }

    (map.zipWithIndex map { case (x, i) => if (x && i >= a) {i} else {0}} filter { _ != 0 }).toList // With ListBuffer works 3/4 as fast
  }

  out(p39_3(7, 31)) ==== List(7, 11, 13, 17, 19, 23, 29, 31)

  // Structural eratosfen
  def p39_4(a: Int, b: Int): List[Int] = {
    val map = Array.fill(b + 1)(true) // We could use bit array, but it's fine with array as well, given that we have lots of memory anyway.
    map(0) = false
    map(0) = true
    var i = 2
    while (i <= b) {
      for (x <- (i * 2) to b by i) {
        map(x) = false
      }

      // Increasing i until we get into map
      do {
        i += 1
      } while (i <= b && map(i) == false)
    }

    val buffer = new ListBuffer[Int]()
    for (i <- 2 to b) {
      if (map(i) && i >= a) {
        buffer += i
      }
    }

    buffer.toList
  }

  val primes = Stream.cons(2, Stream.from(3, 2) filter { p31(_) })

  // From the link
  def p39_5(a: Int, b: Int): List[Int] = {
    primes dropWhile { _ < a } takeWhile { _ <= b } toList
  }

  out(p39_4(7, 31)) ==== List(7, 11, 13, 17, 19, 23, 29, 31)

  var result: List[Int] = _
  val a = 56
  val b = 257238
  time("Direct") {
    result = p39(a, b)
  }

  _time("Eratosfen fun") {
    asrt(p39_2(a, b)) ==== result
  }

  time("Eratosfen fun2") {
    asrt(p39_3(a, b)) ==== result
  }

  time("Eratosfen struct") {
    asrt(p39_4(a, b)) ==== result
  }

  time("From link") {
    asrt(p39_5(a, b)) ==== result
  }

  --------------("P40. Goldbach's conjecture.")
  def p40(a: Int) = {
    val first = ((2 to a) filter { x => p31(x) && p31(a - x) }).head
    (first, a - first)
  }

  out(p40(28)) ==== (5, 23)
  def p40_2(a: Int) = ((2 to a).view filter { x => p31(x) && p31(a - x) }).head match {
    case x => (x, a - x)
  }

  def p40_3(start: Int): (Int,Int) =
    primes takeWhile { _ < start } find { p => p31(start - p)} match {
      case None     => throw new IllegalArgumentException
      case Some(p1) => (p1, start - p1)
    }

  out(p40_2(28)) ==== (5, 23)
  val ask = 587288
  var result_p40: (Int, Int) = _
  time("Simple") {
    result_p40 = p40(ask)
    out(result_p40)
  }
  time("Simple with view") {
    asrt(p40_2(ask)) ==== result_p40
  }
  time("From link (find)") {
    asrt(p40_3(ask)) ==== result_p40
  }
  val ask_p40_2 = 1237128938

  time("Second: Simple with view") {
    result_p40 = p40_2(ask_p40_2)
  }
  time("Second: From link (find)") {
    asrt(p40_3(ask_p40_2)) ==== result_p40
  }

  --------------("P41. A list of Goldbach compositions.")
  def p41(r: Range) = {
    r map {start => primes takeWhile { _ < start } find { p => p31(start - p)} match {
      case None     => None
      case Some(p1) => Some(p1, start - p1)
    }}
  }

  out(p41(9 to 20))
}

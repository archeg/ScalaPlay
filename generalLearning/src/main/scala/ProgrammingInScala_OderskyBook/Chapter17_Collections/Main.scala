/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter17_Collections

import CommonPlay.ChapterApp
import scala.collection.immutable.Set.{Set3, Set2}
import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * Created by archeg on 7/23/2015.
 */
object Main extends ChapterApp {
  newExample("List buffers")
  // Provides constant time append AND PREPEND
  val listBuffer = new ListBuffer[Int] // Mutable
  listBuffer += 1
  listBuffer += 2
  3 +=: listBuffer
  4 +=: listBuffer
  println(listBuffer)
  println(listBuffer.toList)
  

  val arrayBuffer = new ArrayBuffer[Int]
  arrayBuffer += 12
  13 +=: arrayBuffer
  println(arrayBuffer)
  println(arrayBuffer.toArray)
  println(arrayBuffer(0))

  import scala.collection.mutable
  val mutaSet = mutable.Set(1, 2, 3)
  val text = "See spot run. Run, Spot. Run!"
  val wordsArray = text.split("[ !,.]+")
  val words = mutable.Set.empty[String]
  for (word <- wordsArray)
    words += word.toLowerCase

  val map = mutable.Map.empty[String, Int].withDefaultValue(0)
  for (word <- wordsArray)
    map(word) += 1

  val map2 = mutable.Map.empty[String, Int]
  for (word <- wordsArray)
    map2 += word -> 1

  println(map)
  println(map2)

  newExample("Set")
  val nums = Set(1, 2, 3)
  println(nums + 5, Set(1, 2, 3, 5))
  println(nums - 3, Set(1, 2))
  println(nums ++ List(5, 6), Set(1, 2, 3, 5, 6))
  println(nums -- List(3, 5), Set(1, 2))
  println(nums & Set(1, 2), Set(1, 2))
  println(nums.size, 3)
  println(nums.contains(3), true)
  val w = mutable.Set.empty[String]
  w += "the"
  println(w, Set("the"))
  w -= "the"
  println(w, Set.empty[String])
  w ++= List("do", "re", "mi")
  println(w, Set("do", "re", "mi"))
  w --= List("do", "re")
  println(w, Set("mi"))
  w.clear
  println(w, Set.empty[String])


  newExample("Maps")
  val nums2 = Map("i" -> 1, "ii" -> 2)
  println(nums2 + ("vi" -> 6), Map("i" -> 1, "ii" -> 2, "vi" -> 6))
  println(nums2 - "ii", Map("i" -> 1))
  println(nums2 ++ List("iii" -> 3, "v" -> 5), Map("i" -> 1, "ii" -> 2, "iii" -> 3, "v" -> 5))
  println(nums2 -- List("i", "ii"), Map.empty[String, Int])
  println(nums2.size, 2)
  println(nums2.contains("ii"), true)
  println(nums2("ii"), 2)
  println(nums2.keys) // Iterable over keys
  println(nums2.keySet, Set("i", "ii"))
  println(nums2.values) //Itarable over values
  println(nums2.isEmpty, false)
  val w2 = mutable.Map.empty[String, Int]
  w2 += ("one" -> 1)
  println(w2, Map("one" -> 1))
  w2 -= "one"
  println(w2, Map.empty[String, Int])
  w2 ++= List("one" -> 1, "two" -> 2, "three" -> 3)
  println(w2, Map("one" -> 1, "two" -> 2, "three" -> 3))
  w2 --= List("one", "two")
  println(w2, Map("three" -> 3))
  w2 += ("three" -> 10)
  println(w2, Map("three" -> 10))
  println(w2("three"), 10)
  w2("three") = 20
  println(w2("three"), 20)
  w2("four") = 4
  println(w2("four"),4)

  // Factory returns different sets
  var s = Set(1, 3)
  println(s.isInstanceOf[Set2[Int]], true)
  s = Set(1, 3, 4)
  println(s.isInstanceOf[Set3[Int]], true)

  newExample("Sorted sets and maps")

  val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
  val cs = TreeSet('f', 'u', 'n')
  println(ts.toArray.mkString(","))

  var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
  tm += (2 -> 'x')
  println(tm)

  import collection.immutable
  var people = immutable.Set("Nancy", "Jane")
  people += "Bob" // Should be var, as this is reassignment.
  // This is actually :
  people = people + "Bob"
  println(people)

  val peopleM = mutable.Set("Nancy", "Jane")
  peopleM += "Bob" // Can be val, as this is a method call.
  // This is actually:
  peopleM.+=("Bob")
  println(peopleM)

  newExample("Converting between mutable and immutable sets and maps")
  val treeSet = immutable.Set.empty              // Immutable
  val mutaSet2 = mutable.Set.empty += treeSet      // Mutable
  val immutaSet = immutable.Set.empty ++ mutaSet   // Immutable again

  newExample("Tuples")

  val longest = ("word", 2)

  println(longest._1)
  println(longest._2)
  val (word, idx) = longest
  println(word, "word")
  println(idx, 2)
  // But not
  val ww, i = longest
  println(ww, ("word", 2))
  println(i, ("word", 2))
}

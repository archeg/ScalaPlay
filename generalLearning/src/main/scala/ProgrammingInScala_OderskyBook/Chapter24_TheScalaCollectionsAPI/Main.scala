/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter24_TheScalaCollectionsAPI

import CommonPlay.ChapterApp

import scala.collection._
import scala.collection.immutable.{HashMap, HashSet, Queue, TreeSet}
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

/**
 * Created by archeg on 9/23/2015.
 */
object Main extends ChapterApp {
  // Array behave differently in scala than other collections. That's because it is Java array mostly,
  // and in many cases calls to array methods type-check, so they are not converted to ArrayOps
  // this is not the case, but due to array are different == produces false
  // there is a method .sameElements that is in ArrayOps -> IndexedSeq -> IndexedSeqOptimized
  println(Array(1, 3, 5) == Array(1, 3, 5), false)
  println(Array(1, 3, 5).sameElements(Array(1, 3, 5)), true)

  // These are only defaults: May change in another Scala version (running 2.11.2 right now)

  val l = Traversable(1, 2, 3)
  println(l, List(1, 2, 3))  // It's actually a list.
  val ll = Iterable("x", "y", "z")
  println(ll, List("x", "y", "z")) // the same

  val s = Set(1, 2, 3, 5, 1, 2)
  println(s, HashSet(1, 2, 3, 5)) // The Set is a HashSet
  val ss = SortedSet(1, 2, 1, 7, 5)
  println(ss, TreeSet(1, 2, 5, 7))

  val b = mutable.Buffer(1, 2, 3, 7)
  println(b, ArrayBuffer(1, 2, 3, 7))

  val sss = IndexedSeq(1.0, 2.0)
  println(sss, Vector(1.0, 2.0))

  val ssss = LinearSeq(1.0, 2.0)
  println(ssss, List(1.0, 2.0))

  val m = Map("x" -> 20, "y" -> 25)
  println(m)
  println(m, HashMap("x" -> 20, "y" -> 25))

  // To make it traversable, just override foreach
  class TCollection(val l:List[Int]) extends Traversable[Int] {
    override def foreach[U](f: (Int) => U): Unit = l.foreach(f)
  }

  val t = new TCollection(List(1, 2, 5))
  println(t.map(x => x + 2))
  println(t.filter(_ > 3))
  println(t.size)
  println(t.find(_ == 2))
  println(t.last)
  println(t.takeWhile(_ < 5))
  println(t.splitAt(2))
  println(t.exists(_ == 2))
  println(t.foldLeft(0)(_ + _))
  println(t.max)
  println(t.sum)
  println(t.mkString("!"))
  println(t.view.map(_ + 2).filter(_ > 3).force)
  println(t.view(1, 2).force)

  // ---------------------------- Some interesting operations
  println(t ++ t, List(1, 2, 5, 1, 2, 5))
  // Maps
  println(t flatMap (x => List(x, x + 1)), List(1, 2, 2, 3, 5, 6))            // flats the function of map
  println(t collect {case 1 => 100; case e if e > 4 => 200}, List(100, 200))  // applies a partial function
  // Conversions
  println(t toStream)                                                         // Creates a lazy stream
  println(t toSet)
  println(t map (_ -> 100) toMap)                                             // Creates a map if the elements are in form of a tuple (->)
  // Size info
  println(t hasDefiniteSize)                                                  // True if collection is finite. Always True for Traversable
  // Element retrieval
  println(t headOption, Some(1))                                              // Some(Head) or None if list is empty
  // Subcollections
  println(t slice (1, 2), List(2))                                            // Slice by index
  println(t withFilter (_ >= 2) map (_ + 1))                                  // Lazy filter. only restricts the domain of subsequent map, flatMap, foreach, and withFilter operations
  println(t filterNot (_ == 2), List(1, 5))
  // Subdivisions
  println(t splitAt(1), (List(1), List(2, 5)))
  println(t span (_ <= 2), (List(1, 2), List(5)))
  println(t span (_ == 2), (List(), List(1, 2, 5)))
  println(t partition (_ == 2), (List(2), List(1, 5)))
  println(t groupBy (_ + 1))                                                  // Creates a Map(K, List()) by grouping the elements
  // Element conditions
  println(t forall (_ > 0), true)
  println(t exists (_ > 5), false)
  println(t count (_ == 2), 1)
  // Folds
  println(t.foldLeft(1)(_ * _), 10)                                           // Folds by specyfying default and the operation
  println((1 /: t)(_ * _), 10)                                                // Fold Left. The same
  println((1 /: t)(_ - _), -7)                                                // (1) - 1 - 2 - 5 = -7
  println((t :\ 1)(_ - _), 3)                                                 // Fold right. 1 - (2 - (5 - (1)))
  println(List.empty[Int].foldLeft(1)(_ * _), 1)                              // Fold even works on empty list
  error { println(List.empty[Int].reduceLeft(_ * _)) }                        // Reduce does the same, but does not have default so it won't work on empty list
  println(List(1).reduceLeft(_ * _))
  println(t.reduceLeft(math.max(_, _)), 5)                                   // max
  // Specific folds
  println(t.sum, 8)
  println(t.product, 10)
  // Strings
  println(t.addString(new StringBuilder(), "Start ->", "|", "<- End"))         // Returns StringBuilder
  println(t.addString(new StringBuilder(), "|"))
  println(t.mkString("Start ->", "|", "<- End"))                               // Returns string
  println(t.toString)
  println(t.stringPrefix)                                                      // Returns a prefix of toString representation???

  newExample("------------------ Trait Iterable ------------------")

  // Iterable needs to define iterator. The foreach is already defined via iterator.
  // This one is infinite
  val i = new Iterable[Int] {
    override def iterator: Iterator[Int] = new Iterator[Int]{
      var el = 0
      override def hasNext: Boolean = true
      override def next(): Int = { el += 1; el }
    }
  }

  // If not for view, this expression would have never finished
  // View makes it lazy
  // Map computes indefinitely, but as view is lazy - it delays the operation
  // Take limits the operation making the collection finite
  // Force computes everything.
  println(i.view map (_ + 1) take 500 force)

  // grouped splits iterable into groups of iterable by 100
  // then take 1 group
  // and toList it
  println((i grouped 100).take(1).toList)

  // Sliding take all the groups by 10 elements.
  // first one is 1 2 3 4 5 6 7 8 9 10
  // second one is 2 3 4 5 6 7 8 9 10 11
  // etc...
  println((i sliding 10).take(2).toList)
  println(i zip List("first", "second", "third"), List((1, "first"), (2, "second"), (3, "third")))
  println(i zip List("first", "second", "third") toMap, Map((1 -> "first"), (2 -> "second"), (3 -> "third")))
  println((i take 5).zipAll(List("first", "second", "third"), 100, "!"), List((1, "first"), (2, "second"), (3, "third"), (4, "!"), (5, "!")))
  println((i take 1).zipAll(List("first", "second", "third"), 100, "!"), List((1, "first"), (100, "second"), (100, "third")))
  println((i take 10).zipWithIndex)
  println(i.sameElements(List(1, 2)))

  newExample("Traversing a tree")
  case class Branch(left: Tree, right: Tree) extends Tree
  case class Node(elem: Int) extends Tree

  sealed abstract class Tree extends Traversable[Int] {
    def foreach[U](f: Int => U) = this match {
      case Node(elem) => f(elem)
      case Branch(l, r) => l foreach f; r foreach f
    }
  }

  newExample("---------------------------------- Sequences -------------------------------")

  val seq = Seq(100, 105, 10, 15, 20, 25, 30)
  println(seq.isInstanceOf[List[Int]], true)
  println(seq(1), 105)
  println(seq.apply(1), 105)
  println(seq.isDefinedAt(1), true)
  println(seq.isDefinedAt(50), false)
  println(seq.length, 7)
  println(seq.indices, 0 to 6)
  println(seq.lengthCompare(500), -1)
  // Seq is PartialFunction:
  println(seq.asInstanceOf[PartialFunction[Int, Int]])
  println(Seq("Hello", "World").isInstanceOf[PartialFunction[Int, String]], true)
  // Index search operations:
  println(seq.indexWhere(_ < 100), 2)
  println(seq.segmentLength(_ > 5, 4)) // Length of the longest uninterupted segment starting from index 4 that satisfy condition
  println(Seq(10, 10, 10, 10, 1, 10, 10, 1, 10, 10, 10, 10, 10, 10).segmentLength(_ == 10, 5), 2)
  println(seq prefixLength (_ > 90), 2)
  // Additions
  println(0 +: seq)
  println(seq :+ 35)
  // Updates
  println(seq patch (1, Seq(2, 3, 4, 5, 6, 7, 8, 9), 2))   // Replaces 2 elements from index 1 to given sequence (inserting it)
  println(seq updated (1, -5)) // Replaces seq(1) = -5, and returns new sequences (as the original one in immutable)
  //println(seq(1) = -5)         <- Is not available for immutable. Works only for mutable.

  // Sorting
  println(seq.sorted, Seq(10, 15, 20, 25, 30, 100, 105))
  def lessThan[T <% Ordered[T]](x : T, y : T) = x < y
  println(seq sortWith lessThan)
  println(seq sortWith (_ > _))
  println(seq sortBy (x => if (x % 2 == 0) { x * -1} else { x }))

  // Reversals
  println(seq.reverse)
  println(seq reverseMap (_ * 2))  // Applying map in reverse order

  // Comparisons
  println(seq startsWith Seq(100, 105), true)
  println(seq endsWith Seq(25, 45), false)
  println(seq contains 25, true)
  println(seq containsSlice Seq(20, 25, 30), true)
  println(seq containsSlice Seq(20, 25, 33), false)
  println((seq corresponds Seq(5, 0, 95, 90, 85, 80, 75))(_ + _ == 105), true)
  println(seq.corresponds(Seq(5, 0, 95, 90, 85, 80, 75))(_ + _ == 105), true)
  println((seq corresponds Seq(5, 0, 95, 90, 85, 80))(_ + _ == 105), false)

  // Multiset operations:
  println(seq intersect Seq(1, 2, 3), List())
  println(seq intersect Seq(1, 105, 10, 3), List(105, 10))
  println(seq diff Seq(1, 105, 10, 3), List(100, 15, 20, 25, 30))
  println(seq union Seq(1, 105), List(100, 105, 10, 15, 20, 25, 30, 1, 105))
  println(Seq(100, 105, 105, 3, 1, 100).distinct, List(100, 105, 3, 1))

  newExample("------------------------- Buffers ----------------------------")

  val buffer = mutable.Buffer(1, 5, 10, 6, 1)
  println(buffer.isInstanceOf[ArrayBuffer[Int]], true)
  // Additions
  buffer += 100
  buffer += (10, 10, 10)
  println(buffer, ArrayBuffer(1, 5, 10, 6, 1, 100, 10, 10, 10))
  buffer ++= List(1, 5, 1)
  println(buffer, ArrayBuffer(1, 5, 10, 6, 1, 100, 10, 10, 10, 1, 5, 1))
  buffer insert (2, 100)
  buffer.insertAll(5, List(-1, -5))
  println(buffer, ArrayBuffer(1, 5, 100, 10, 6, -1, -5, 1, 100, 10, 10, 10, 1, 5, 1))

  // Removals
  buffer -= 1
  println(buffer, ArrayBuffer(5, 100, 10, 6, -1, -5, 1, 100, 10, 10, 10, 1, 5, 1))
  buffer -= (100, 6, -1)
  println(buffer, ArrayBuffer(5, 10, -5, 1, 100, 10, 10, 10, 1, 5, 1))
  buffer remove 4   // Remove by index
  println(buffer, ArrayBuffer(5, 10, -5, 1, 10, 10, 10, 1, 5, 1))
  buffer remove (4, 3) // Remove by index 4 elements
  println(buffer, ArrayBuffer(5, 10, -5, 1, 1, 5, 1))
  buffer trimStart 1    // Removes first 1 element
  buffer trimEnd 2
  println(buffer, ArrayBuffer(10, -5, 1, 1))
  val buffer2 = buffer.clone()
  buffer.clear()
  println(buffer, ArrayBuffer())
  println(buffer2, ArrayBuffer(10, -5, 1, 1))

  newExample(" ---------------------- Sets ------------------- ")
  val set = Set(1, 3, 5, 2, 1)
  println(set.toList, List(1, 3, 5, 2))

  // Tests
  println(set contains 3, true)
  println(set(3), true)
  println(Set(3, 2) subsetOf set, true)
  // Additions
  println(set + 100, Set(1, 3, 5, 2, 100))
  println(set + (50, 51, 52), Set(1, 3, 5, 2, 50, 51, 52))
  println(set ++ Set(50, 51, 52), Set(1, 3, 5, 2, 50, 51, 52))
  // Removals
  println(set - 5, Set(1, 3, 2))
  println(set - (5, 1), Set(3, 2))
  println(set -- Set(5, 1), Set(3, 2))
  println(set -- Set(3, 2, 50), Set(1, 5))
  println(set.empty, Set.empty[Int]) // An empty set of the same class as original
  // Binary operations
  println(set & Set(3, 2, 50), Set(3, 2))                // And
  println(set intersect Set(3, 2, 50), Set(3, 2))        // same as &
  println(set | Set(3, 2, 50), Set(1, 3, 5, 2, 50))      // OR
  println(set union Set(3, 2, 50), Set(1, 3, 5, 2, 50))
  println(set &~ Set(3, 2, 50), Set(1, 5))               // Set difference. The same as --
  println(set diff Set(3, 2, 50), Set(1, 5))             // the same as &~. The same as --

  // ------------------------ Mutable set
  val mset = mutable.Set(1, 3, 5, 2, 1)
  // Additions
  mset += 7
  mset += (8, 11)
  mset ++= Set(9, 71)
  mset add 0
  println(mset, Set(0, 1, 2, 3, 5, 7, 8, 9, 11, 71))
  // Removals
  mset -= 7
  mset -= (8, 11)
  mset --= Set(9, 71)
  mset remove 0
  println(mset, Set(1, 2, 3, 5))
  mset retain (_ > 2)                  // Keeps only those elements that satisfy a predicate
  println(mset, Set(3, 5))
  val mset2 = mset.clone()
  mset.clear()
  println(mset, Set.empty[Int])
  println(mset2, Set(3, 5))

  // ------------------------ Sorted set
  val myOrdering = Ordering.fromLessThan[String](_ > _)
  val sset = TreeSet.empty[String]
  val numbers = sset + ("one", "two", "three")
  println(numbers)
  println(numbers range ("one", "two"))
  println(numbers from "three")

  var bitSet = BitSet(1, 3)
  bitSet += 2
  println(bitSet)
  //bitSet += 2147483647     // max int. Looong operation (several seconds). Allocates 32 - 6 = 26 Longs.
  println(bitSet)

  // ------------------------- Maps ---------------------------
  val mapt1 = Map("x" -> 24, "y" -> 25, "z" -> 26)
  val mapt2 = Map(("x", 24), ("y", 25), ("z", 26))
  println(mapt1, mapt2) // They are the same

  val map = Map(2 -> 50, 3 -> 71, 10 -> 2)
  // Lookups
  println(map get 2, Some(50))                                   // As an option
  println(map get 1, None)
  println(map(2), 50)                                            // Gets a key
  error { map(1) }
  println(map getOrElse (1, 77), 77)
  println(map contains 1, false)
  println(map isDefinedAt 1, false)                              // the same as contains
  // Additions and updates:
  println(map + (100 -> 150), Map(2 -> 50, 10 -> 2, 3 -> 71, 100 -> 150))
  println(map + (100 -> 150, 5 -> 5), Map(2 -> 50, 10 -> 2, 3 -> 71, 100 -> 150, 5 -> 5))
  println(map ++ Map(100 -> 150, 5 -> 5), Map(2 -> 50, 10 -> 2, 3 -> 71, 100 -> 150, 5 -> 5))
  println(map + (3 -> 7), Map(2 -> 50, 10 -> 2, 3 -> 7))
  println(map updated (100, 150))                                 // The same as +
  // Removals
  println(map - 2, Map(3 -> 71, 10 -> 2))
  println(map - (2, 3), Map(10 -> 2))
  println(map -- List(3, 10), Map(2 -> 50))
  // Subcollections
  println(map.keys, Set(2, 3, 10).asInstanceOf[Iterable[Int]])    // as iterable
  println(map.keySet, Set(2, 3, 10))
  println(map.keysIterator)                                       // an Iterator(2, 3, 10) that yields.
  println(map.values.toList, List(50, 71, 2))                     // Returns strange iterable. Not a list.
  println(map.valuesIterator)
  // Transformation
  println(map filterKeys (_ >= 10), Map(10 -> 2))
  println(map mapValues (_ * 2), Map(2 -> 100, 3 -> 142, 10 -> 4))

  // --- mutable.Map
  val mmap = mutable.Map.empty[Int, Int]
  // additions and updates
  mmap(2) = 5
  mmap += (3 -> 7)
  mmap += (4 -> 8, 5 -> 9)
  mmap ++= Map(6 -> 10, 7 -> 11)
  println(mmap, Map(2 -> 5, 3 -> 7, 4 -> 8, 5 -> 9, 6 -> 10, 7 -> 11))

  println(mmap put (2, 100), Some(5))                              // put returns a previous value set as an Option
  println(mmap getOrElseUpdate(1, 1000), 1000)                     // gets or updates and returns the value if not set. Useful for caches.
  println(mmap get 1, Some(1000))
  println(mmap getOrElse(0, 7), 7)                                 // Just returns 7 if no value set.
  println(mmap get 0, None)                                        // The 0 is still None

  println(mmap)
  // Removals
  println(mmap -= 1)
  println(mmap -= (2, 4))
  println(mmap --= List(5, 6))
  println(mmap remove 3, Some(7))                                   // returns a value previously associated with 3
  println(mmap)
  mmap += (1 -> 1, 2 -> 2, 3 -> 3)
  mmap retain ((k, v) => k > 4)                                     // retains only the values satisfying the predicate
  println(mmap, Map(7 -> 11))
  mmap.clear()
  println(mmap, Map.empty[Int, Int])
  mmap += (1 -> 1, 2 -> 2, 3 -> 3, 4 -> 4)
  mmap transform ((k, v) => v * 2)                                  // Almost the same as map, but for immutable (inmemory)
  println(mmap.clone())

  // ---------------------------------- Synchronized sets and maps ----------------
  // val smap = new HashMap[String, String] with mutable.SynchronizedMap[String, String]
  // ok, it's deprecated and no longer works. Use java.util.concurrent.ConcurrentHashMap instead


  // ---------------------------------- Streams                   -----------------
  val str = 1 #:: 2 #:: 3 #:: Stream.empty
  println(str)                                                      // Prints Stream(1, ?) because other elements are not yet computed.

  def fibFrom(a: Int, b: Int): Stream[Int] =                        // Cool! No need to stop
    a #:: fibFrom(b, a + b)

  println(fibFrom(20, 30).take(3).toList, List(20, 30, 50))

  // ----------------------------------- Vectors ---------------------------------

  // Vectors are special array-like structures. They have effectively constant time accessing any element
  // They are slower than Lists in terms of accessing Head
  // and slower than Array in accessing any element
  // but they still are almost constnt

  val vec = immutable.Vector.empty
  val vec2 = vec :+ 1 :+ 2
  val vec3 = 100 +: vec2
  println(vec3, Vector(100, 1, 2))

  val vec4 = vec3 updated (1, 5)
  println(vec3, Vector(100, 1, 2))
  println(vec4, Vector(100, 5, 2))

  // They are the current implementation of IndexedSeq:
  val vec5 = IndexedSeq(1, 2, 3)
  println(vec5.isInstanceOf[Vector[Int]], true)

  // --------- Immutable stacks --------------
  val stack = immutable.Stack.empty
  val hasOne = stack.push(1)
  println(hasOne, immutable.Stack(1))
  println(hasOne.top, 1)
  // --------- Immutable queues --------------
  val queue = immutable.Queue.empty.enqueue(1)
  val queue2 = queue.enqueue(List(2, 3))
  println(queue2)
  val (element, has23) = queue2.dequeue                 // dequeue returns element -> dequeued queue
  println(has23, Queue(2, 3))
  // --------- Ranges ------------------------
  println((1 to 3).toList, List(1, 2, 3))
  println((5 to 14 by 3).toList, List(5, 8, 11, 14))
  println((1 until 3).toList, List(1, 2))
  // --------- Hash tries
  // Immutable Set and map are implemented by Hash tries (Trie)
  // --------- Red-black trees -------------------------
  val tset = immutable.TreeSet.empty[Int]
  println(tset + 1 + 2 + 3)
  // Default implementation of SortedSet in scala is Red-black tree
  // --------- List maps -------------------------------
  val lmap = immutable.ListMap(1 -> "one", 2 -> "two")           // <- Linked-list of key-value pairs
  // Used very rarely, as only head operation is in constant time

  // -------------------------------------------------------------------------------------------------------------------------
  newExample("--------------------- Concrete mutable collection classes ------------------------------------------------------")
  // -------------------------------------------------------------------------------------------------------------------------

  // ------- Array buffers
  val buf = ArrayBuffer.empty[Int]
  buf += 1
  buf += 10
  println(buf.toArray.sameElements(Array(1, 10)), true)
  // ------- List buffers
  val lbuf = mutable.ListBuffer.empty[Int]
  lbuf += 10
  lbuf += 1
  println(lbuf, List(10, 1))
  // ------- String builder
  val sbuf = new StringBuilder
  sbuf ++= "Hello "
  sbuf ++= "world"
  println(sbuf.toString, "Hello world")
  // -------------- Linked Lists
  val llist = mutable.LinkedList.empty[Int]          // Deprecated as too low leveled.
  //llist += 5       // Low level. DOes not support such operations.
  // ------ Double Linked Lists
  val dllist = mutable.DoubleLinkedList.empty[Int]   // Deprecated as too low leveled.
  // --------------- Mutable Lists
  val mlist = mutable.MutableList.empty[Int]
  mlist += 5
  println(mlist, mutable.MutableList(5))
  // --------------- Queues
  val mqueue = new mutable.Queue[String]
  mqueue += "a"
  mqueue ++= List("b", "c")
  println(mqueue)
  mqueue.dequeue
  // --------------- Array sequences
  val arrSeq = new mutable.ArraySeq[Int](5)     // Constant size. Maintains ClassManifest?
  arrSeq(2) = 3;
  // --------------- Stacks
  val mstack = new mutable.Stack[Int]
  mstack push 1
  mstack push 2
  println(mstack, immutable.Stack(2, 1))
  println(mstack.top, 2)                         // peek
  println(mstack.pop, 2)
  println(mstack, immutable.Stack(1))
  // Array stack - better stack with indexing. Slightly more effecient.
  // --------------- Hash tables
  val hmap = mutable.HashMap.empty[Int, String]
  hmap += (1 -> "make a web site")
  hmap += (3 -> "profit!")
  println(hmap, Map(1 -> "make a web site", 3 -> "profit!"))
  // --------------- Weak hash maps
  // GC will remove items from such maps if they are not referenced anywhere else.
  var a = new AnyRef
  val weakHashMap = new mutable.WeakHashMap[AnyRef, Int]
  weakHashMap += (a -> 1)
  println(weakHashMap.contains(a), true)
  // Unfortunately cannot test it.

  // -------------- Mutable BitSet
  val mbit = mutable.BitSet.empty
  mbit += 1
  mbit += 3
  println(mbit, BitSet(1, 3))
  // ---------------------------------------------------------------------------------
  newExample("---------------------- Arrays -----------------------------------------")
  // ---------------------------------------------------------------------------------
  val a1 = Array(1, 2, 3)                             // Corresponds to int[] in Java, but:
  // Scala arrays are Generic.
  println(a1.isInstanceOf[Array[Int]], true)
  // Compatible with scala's Seq[T]
  println(a1.isInstanceOf[Seq[Int]], false)           // Because array is NOT Seq[Int]
  def check(a: Seq[Int]) { println(a) }
  check(a1)                                           // But this works, because there is an implicit to Seq[Int]. So they are almost Seq[Int]
  println(a1 map (_ * 3) filter (_ % 2 != 0) toSeq)   // Everything works as usually for Seq[Int]. But to println it, you need to convert to Seq[Int]
  // as printing arrays gives a Java (unreadable) result.

  val a2: Seq[Int] = a1
  println(a2.isInstanceOf[Array[Int]], false)         // It's no longer an array, but a wrapper
  println(a2.isInstanceOf[mutable.WrappedArray[Int]], true)

  println(a2.toArray eq a1, true)                     // It operates over original array


  class Data {}
  val a3 = Array(new Data, new Data)
  println(a3)                                         // In Java terms this will be object[], as Java doesn't support generic arrays.

  // This won't compile because int[] and double[] are two completely different types and cannot be created in generic way
//  def evenElems[T](xs: Vector[T]): Array[T] = {
//    val arr = new Array[T]((xs.length + 1) / 2)
//    for (i <- 0 until xs.length by 2){
//      arr(i / 2) = xs(i)
//    }
//    arr
//  }
  // You should context bound it to ClassTag
  def evenElems[T : ClassTag](xs: Vector[T]): Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
    for (i <- 0 until xs.length by 2) {
      arr(i / 2) = xs(i)
    }
    arr
  }

  // --------------------- Strings -----------------
  val str2 = "Hello"
  println(str2.reverse, "olleH")
  println(str2.map(_.toUpper), "HELLO")
  println(str2 drop 3, "lo")
  println(str2 slice (1, 4), "ell")
  val str3: Seq[Char] = str2
  println(str3, Seq('H', 'e', 'l', 'l', 'o'))
  // -------------------------------------------------------------------------------------------------
  // --------------------- Equality
  println(List(1, 2, 3) == Set(1, 2, 3), false)                    // Different category. Set is not the same as List
  println(List(1, 2, 3) == Seq(1, 2, 3), true)                     // Same category. Seq is almost the same as list.
  println(Array(1, 2, 3).sameElements(Array(1, 2, 3)), true)       // For arrays only .sameElements call will work
  println(Array(1, 2, 3) == Array(1, 2, 3), false)

  // --------------------- Views
  // Transformations always perform right away:
  val mlist1 = mutable.ListBuffer(1, 2, 3)
  val mlist1_tr = mlist1 map (_ * 2)
  mlist1(0) = 100
  println(mlist1, List(100, 2, 3))
  println(mlist1_tr, List(2, 4, 6))

  // If you want lazy - you use a view:
  val mlist2 = mutable.ListBuffer(1, 2, 3)
  val mlist2_tr = mlist2.view map (_ * 2)
  mlist2(0) = 100
  println(mlist2, List(100, 2, 3))
  println(mlist2_tr, List(200, 4, 6))
  mlist2(1) = 200
  println(mlist2_tr.force, List(200, 400, 6))                       // .force makes the view into original collection, it computes it.

  // Why views?
  def isPalindrome(x: String) = x == x.reverse
  def findPalindrome(s: Seq[String]) = s find isPalindrome

  val words = Array("Hello", "Palaa", "omnonmo") // Assume it is very long
  findPalindrome(words take 1000000)                                // This will copy 1000000 words
  findPalindrome(words.view take 1000000)                           // But this will just iterate over first 10000 until it finds a palindrome. Much faster and less memory consumption

  val aaa = mutable.ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  println(aaa.view(2, 5).toList, List(3, 4, 5))

  val aaaa = (1 to 9).toArray
  def negate(xs: mutable.Seq[Int]) = for (i <- 0 until xs.length) xs(i) = -xs(i)
  negate(aaaa.view(2, 5))
  println(aaaa.mkString("|"))
  println(aaaa.sameElements(Array(1, 2, -3, -4, -5, 6, 7, 8, 9)), true)

  //(1 to 9) is not a view. Prior to 2.8 scala has it as a view, and that caused some problems, because it was lazy
  // so for (i <- 1 to 10) yield ... was also lazy.
  // if you want a view:
  val lazyRange = for (i <- (1 to 10).view) yield 5
  println(lazyRange)

  // ----------------- Iterators
  val it = Iterator(1, 2, 3, 4, 5)
  for (i <- it) println(i)                                           // Behaves like collection, but leaves iterator in unreadable state afterwards
  // Other operations as well:
  val it2 = Iterator(1, 2, 3, 4, 5)
  it2 map (_ * 2) filter (_ % 2 == 0) foreach (print(_))
  println(it2.isEmpty, true)

  val it3 = (1 to 5).iterator
  val (it4, it5) = it3.duplicate                                     // Iterates over the iterator, and creates two new.

  // There are some methods in iterator. We'll miss that.
  // Buffered iterators allow look ahead:
  val itb = it4.buffered
  while (itb.head != 4) { itb.next()}
  println(itb.next(), 4)

  // ---------------- Factory methods -------------
  val listEmpty = List.empty                                         // Any type as it is not specified
  println(listEmpty, List.empty[Nothing])
  val concatList = List.concat(List(1, 2, 3), Set(3, 5))
  println(concatList, List(1, 2, 3, 3, 5))
  val filledList1 = List.fill(3)(100)
  println(filledList1, List(100, 100, 100))
  val filledList2 = List.fill(3, 2)(100)
  println(filledList2, List(List(100, 100), List(100, 100), List(100, 100)))
  val tabulatedList1 = List.tabulate(3)(_ * 3)
  println(tabulatedList1, List(0, 3, 6))
  val tabulatedList2 = List.tabulate(3, 3)((x, y) =>  x * y * 3)
  val listRange1 = List.range(3, 5)
  val listRange2 = List.range(3, 10, 2)
  println(listRange2, List(3, 5, 7, 9))
  val listIterate = List.iterate(2, 5)(x => x * x)                // 2, f(2), f(f(2)), ....
  println(listIterate, List(2, 4, 16, 256, 65536))

  // ------------- Java conversions
  import collection.JavaConversions._
  val mmbuffer = mutable.Buffer(3, 5)
  val jmbufer: java.util.List[Int] = mmbuffer                     // Java conversions allow this.

}

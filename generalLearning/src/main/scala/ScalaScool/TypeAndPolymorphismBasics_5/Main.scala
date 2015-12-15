package ScalaScool.TypeAndPolymorphismBasics_5

/**
 * Created by archeg on 7/6/2015.
 */
object Main extends App {
  println("-------- Parametric polymorphism -----------")
  val list = 2 :: 1 :: "bar" :: "foo" :: Nil
  println(list)
  println(list.head)
  println(list.head.getClass)

  def drop1[A](l : List[A]) = l.tail

  println(drop1(List(1,2,3)))

  // Scala has rank-1 polymorphism
  def toList[A](a: A) = List(a)
  //def foo[A, B](f: A => List[A], b: B) = f(b)          <- Doesn't compile. Kinda obvious...

  println("---------- Type inference ----------")
  // In scala all type inference is local. Scala considers one expression at a time.
  def id[T](x: T) = x
  val x1 = id(322)
  val x2 = id("hey")
  val x3 = id(Array(1,2,3,4))
  println(x1.getClass)
  println(x2.getClass)
  println(x3.getClass)
  println(Array(1,2,3,4).getClass)

  println("----------- Variance --------------")
  // If T' is subclass of T
  // T' extends T

  // covariant          [+T] :      Then C[T'] is a subclass of C[T]          C[T'] extends C[T]
  // contravariant      [-T] :      Then C[T] is a subclass of C[T']          C[T] extends C[T']
  // invariant          [T]  :      Then C[T] and C[T'] are not related

  class Covariant[+A]
  val cv: Covariant[AnyRef] = new Covariant[String]
  //val cv2: Covariant[String] = new Covariant[AnyRef]     <- do not compile

  class Contravariant[-A]
  //  val cv: Contravariant[AnyRef] = new Contravariant[String] <- do not compile
  val cv2: Contravariant[String] = new Contravariant[AnyRef]

  class Invariant[A]
//  val cv3: Invariant[AnyRef] = new Invariant[String]    <- do not compile
//  val cv3: Invariant[String] = new Invariant[AnyRef]    <- do not compile

  // -------- Explained -------------
  class Apple extends Fruit
  class Fruit

  // T - fruit, T' - apple
  // If C[T'] accepts apples, it won't accept fruits. You cannot call apple-juice machine a "fruit-juice machine", because it won't process other fruits
  // If C[T'] accepts fruits, it will accept apples. You can call fruit-juice machine an apple-juice machine, because it processes apples.
  // So C[T] extends C[T']
  // -A
  class JuiceMachine[-A]{
    def process(a: A): Unit ={
      println()
    }
  }
  val machine: JuiceMachine[Apple] = new JuiceMachine[Fruit]
  // JuiceMachine[Fruit] is always JuiceMachine[Apple]
  // JuiceMachine[Apple] is not always JuiceMachine[Fruit]
  // -
  // Fruit-juice-maker is always apple-juice-maker
  // apple-juice-maker is not always a fruit-juice-maker

  // T - fruit, T' - apple
  // If C[T'] returns apples, it also returns fruit. Any stuff from the apple-tree can be called a fruit
  // If C[T'] returns fruits, it doesn't always return apples. Fruit garden doesn't always have apple trees.
  class Tree[+A] {
    def grow(): A = {
      throw new NotImplementedError()
    }
  }

  val tree: Tree[Fruit] = new Tree[Apple]
  // Tree[Apple] is always Tree[Fruit]
  // Tree[Fruit] is not always Tree[Apple]
  // -
  // apple-tree is always a fruit-tree
  // fruit-tree is not always an apple tree

  // ---------- SO: -------------
  trait Function1[-T1, +R] extends AnyRef

  class Animal {val sound = "rustle"}
  class Bird extends Animal { override val sound = "call" }
  class Chicken extends Bird { override val sound = "cluck" }

  // Contravariant
  val getTweet: (Bird => String) = ((a: Animal) => a.sound)
  // Covariant
  val hatch: (() => Bird) = (() => new Chicken)

  println("----------- Bounds -----------------")
//  def cacophony[T](things: Seq[T]) = things map (_.sound) <- Could not compile. sound method not defined on T
  // adding bounds:
  def cacophony[T <: Animal](things: Seq[T]) = things map (_.sound)

  println(cacophony(Seq(new Chicken, new Bird)))

  val flock = List(new Bird, new Bird)   // flock: List[Bird]
  println(flock)
  val a2 = new Chicken :: flock   // a2 : List[Bird]
  println(a2)

  // List defines:
//  def ::[B >: T](x:B) = {
//    return new List[B]
//  }
  // ------ Lower bound (often convenient for covariance) -------------.
  // B >: T -> T extends B
  // B <: T -> B extends T

  val a3 = new Animal :: flock       // a3 : List[Animal]
  println(a3)

  println("------------- Quantification ---------------")
  // Sometimes you do not care to be able to name a type variable, for example:
  def count[A](l: List[A]) = l.size
  // The same:
  def count2(l: List[_]) = l.size
  // This is a shorthand for:
  def count3(l: List[T forSome { type T }]) = l.size

  // Note that quantification can get tricky:
  def drop2(l: List[_]) = l.tail
  // returns drop1: (List[_])List[Any]
  // Heavy-handed syntax:
  def drop3(l: List[T forSome {type T}]) = l.tail
//  We can?t say anything about T because the type does not allow it.
//  You may also apply bounds to wildcard type variables:
  def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)

//  hashcodes(Seq(1,2,3)) ERROR: 1 is not AnyRef
  println(hashcodes(Seq("one", "two", "three")))
}

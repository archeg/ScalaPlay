package FirstPlay

import CommonPlay.ChapterApp

/**
  * Created by archeg on 12/6/2015.
  */
object Play extends ChapterApp {
  // https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0
  import shapeless._
  import shapeless.poly._

  {
    --------------("Polymorphic function values")
    object choose extends (Set ~> Option) {    // choose is polymorhic because it accepts any argument
      def apply[T](s: Set[T]) = s.headOption
    }

    object choose2 {    // choose is polymorhic because it accepts any argument
      def apply[T](s: Set[T]) = s.headOption
    }

    out(choose(Set(1, 2, 3))) ==== Some(1)
    out(choose(Set('a', 'b', 'c'))) ==== Some('a')

    out(choose2(Set(1, 2, 3))) ==== Some(1)
    out(choose2(Set('a', 'b', 'c'))) ==== Some('a')

    def pairApply(f: Set ~> Option) = (f(Set(1, 2, 3)), f(Set('a', 'b', 'c')))         // But thanks to ~> we can now accept such functions.

    def pairApply2[T](f: Set[T] => Option[T]) = ??? // f(Set(1, 2, 3) ummm....

    def pairApply3(f: Set[_] => Option[_]) = (f(Set(1, 2, 3)), f(Set('a', 'b', 'c')))   // Buuut, we still can do this.
    // Also scala here does not know that first _ and second _ is the same type.

    out(pairApply(choose))                      // Return type (Option[Int], Option[Char])
    out(pairApply3(x => x.headOption))          // Return type (Option[_], Option[_])


    out("---")

    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) = at[(T, U)](t => size(t._1) + size(t._2))
    }

    out(size(23)) ==== 1
    out(size("foo")) ==== 3
    out(size((23, "foo"))) ==== 4
    out(size(((23, "foo"), 13))) ==== 5

    def size2(a: Any): Int = a match {
      case a : Int => 1
      case a : String => a.size
      case (a, b) => size2(a) + size2(b)
    }

    out(size2(23)) ==== 1
    out(size2("foo")) ==== 3
    out(size2((23, "foo"))) ==== 4
    out(size2(((23, "foo"), 13))) ==== 5
  }

  --------------("Heterogenous lists")

  {
    object choose extends (Set ~> Option) {    // choose is polymorhic because it accepts any argument
      def apply[T](s: Set[T]) = s.headOption
    }

    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) = at[(T, U)](t => size(t._1) + size(t._2))
    }

    val sets = Set(1) :: Set("foo") :: HNil
    val a = sets map choose                   // HList - strict type.
    out(a) ==== Some(1) :: Some("foo") :: HNil

    val sets_ori = Set(1) :: Set("foo") :: Nil
    val a1 = sets_ori map (_.headOption)       // List[Option[Any]]
    out(a1)

    val l = (23 :: "foo" :: HNil) :: HNil :: (true :: HNil) :: HNil
    out(l flatMap identity)

    object addSize extends Poly2 {
      implicit def default[T](implicit st: size.Case.Aux[T, Int]) = at[Int, T]{ (acc, t) => acc + size(t) }
    }

    val ll = 23 :: "foo" :: (13, "wibble") :: HNil
    out(ll.foldLeft(0)(addSize))
  }

 {
   import syntax.zipper._

    out("!")
    val lll = 1 :: "foo" :: 3.0 :: HNil
    out(lll.toZipper.right.put(("wibble", 45)).reify)

    // It is covariant
    trait Fruit
    case class Apple() extends Fruit
    case class Pear() extends Fruit

    type FFFF = Fruit :: Fruit :: Fruit :: Fruit :: HNil
    type APAP = Apple :: Pear :: Apple :: Pear :: HNil

    val a : Apple = Apple()
    val p : Pear = Pear()

    val apap: APAP = a :: p :: a :: p :: HNil
    val ffff: FFFF = apap
    out(apap)
    out(ffff)

   out(apap.unify) // Converts to Fruit :: Fruit :: Fruit :: Fruit :: HNil
   out(apap.toList) // Convers to List[Fruit]

   import syntax.typeable._
   val ffff2 : FFFF = apap.unify
   val precise: Option[APAP] = ffff2.cast[APAP]
   out(precise)
 }

  --------------("HList-style operations on standard Scala typles")

  {
    import syntax.std.tuple._
    out((23, "foo", true).head) ==== 23
    out((23, "foo", true).tail) ==== ("foo", true)
    out((23, "foo", true).drop(2)) ==== Tuple1(true)
    out((23, "foo", true).take(2)) ==== (23, "foo")
    out((23, "foo", true).split(1)) ==== (Tuple1(23), ("foo", true))

    out(23 +: ("foo", true)) ==== (23, "foo", true)
    out((23, "foo") :+ true) ==== (23, "foo", true)
    out((23, "foo") ++ (true, 2.0)) ==== (23, "foo", true, 2.0)

    import poly._

    object option extends (Id ~> Option) {
      def apply[T](t: T) = Option(t)
    }

    out((23, "foo", true) map option) ==== (Some(23), Some("foo"), Some(true))
    out(((23, "foo"), (), (true, 2.0)) flatMap identity) ==== (23, "foo", true, 2.0)

    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) = at[(T, U)](t => size(t._1) + size(t._2))
    }
    object addSize extends Poly2 {
      implicit def default[T](implicit st: size.Case.Aux[T, Int]) = at[Int, T]{ (acc, t) => acc + size(t) }
    }

    out((23, "foo", (13, "wibble")).foldLeft(0)(addSize))  ==== 11

    out((23, "foo", true).productElements) ==== 23 :: "foo" :: true :: HNil
    out((23, "foo", true).toList) == 23 :: "foo" :: true :: Nil

    import syntax.zipper._

    out((23, ("foo", true), 2.0).toZipper.right.down.put("bar").root.reify)
  }

  --------------("Facilities for abstracting over arity")

  {
    import ops.function._
    import syntax.std.function._

    def applyProduct[P <: Product, F, L <: HList, R](p: P)(f: F)
                                                    (implicit gen: Generic.Aux[P, L], fp: FnToProduct.Aux[F, L => R]) =
      f.toProduct(gen.to(p))

    out(applyProduct(1, 2)((_: Int) + (_: Int)))
    //out(applyProduct(1, 2)(_ + _))
    out(applyProduct(1, 2, 3)((_: Int) *(_: Int) * (_: Int)))
  }

  --------------("Heterogenous maps")

  {
    class BiMapIS[K, V]
    implicit val intToString = new BiMapIS[Int, String]
    implicit val stringToInt = new BiMapIS[String, Int]

    val hm = HMap[BiMapIS](23 -> "foo", "bar" -> 13)

    out(hm.get(23))
    out(hm.get("bar"))
    val l = 23 :: "bar" :: HNil
    //out(l map hm)
  }

  --------------("Singleton-typed literals")

  {
    import syntax.std.tuple._

    val l = 23 :: "foo" :: true :: HNil
    out(l(1))

    val t = (23, "foo", true)
    out(t(1))

    import shapeless._
    import syntax.singleton._

    out(23.narrow) ==== 23
    out("foo".narrow) ==== "foo"

    val (wTrue, wFalse) = (Witness(true), Witness(false))
    type True = wTrue.T
    type False = wFalse.T

    trait Select[B] { type Out }
    implicit val selInt = new Select[True] { type Out = Int }
    implicit val selString = new Select[False] { type Out = String }

    def select[T](b: WitnessWith[Select])(t: b.instance.Out) = t

    out(select(true)(23))

    out(select(false)("false"))
    //out(select(false)(23))
  }

  --------------("Singleton-types Symbols")

  {
    import syntax.singleton._
    out('foo)
    out('foo.narrow)
  }

  --------------("Extensible records")

  {
    import shapeless._
    import record._
    import syntax.singleton._

    val book =
      ("author" ->> "Benjamin Pierce") ::
      ("title" ->> "Types and Programming Languages") ::
      ("id" ->> 262162091) ::
      ("price" ->> 44.11) ::
      HNil

    out(book("author")) ==== "Benjamin Pierce"
    out(book("title")) ==== "Types and Programming Languages"
    out(book("id")) ==== 262162091
    out(book.keys)
    out(book.values)

    val newPrice = book("price") + 2.0
    val updated = book + ("price" ->> newPrice)
    out(updated("price")) ==== 46.11

    val extended = updated + ("inPrint" ->> true)
    val noId = extended - "id"
    out(noId("price"))
    //out(noId("id"))                <- Compile time error
  }

  --------------("Coproducts and discriminated unions")

  {
    type ISB = Int :+: String :+: Boolean :+: CNil

    val isb = Coproduct[ISB]("foo")
    out(isb.select[Int]) ==== None
    out(isb.select[String]) ==== Some("foo")

    object size extends Poly1 {
      implicit def caseInt = at[Int](i => (i, 1))
      implicit def caseString = at[String](s => (s, s.length))
      implicit def caseBoolean = at[Boolean](b => (b, 1))
    }

    out(isb map size) ==== Coproduct[(Int, Int) :+: (String, Int) :+: (Boolean, Int) :+: CNil](("foo", 3))
    out((isb map size).select[(String, Int)]) ==== Some(("foo", 3))
  }

  --------------("Generic representation of (sealed families of) case classes")

  {
    case class Foo(i: Int, s: String, b: Boolean)
    val fooGen = Generic[Foo]
    val foo = Foo(23, "foo", true)

    out(fooGen.to(foo)) ==== 23 :: "foo" :: true :: HNil

    out(13 :: fooGen.to(foo).tail) ==== 13 :: "foo" :: true :: HNil

    out(fooGen.from(13 :: fooGen.to(foo).tail)) ==== Foo(13, "foo", true)

    sealed trait Tree[T]
    case class Leaf[T](t: T) extends Tree[T]
    case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]

    object inc extends ->((i: Int) => i + 1)

    val tree: Tree[Int] =
      Node(
        Node(
          Node(
            Leaf(1),
            Node(
              Leaf(2),
              Leaf(3)
            )
          ),
          Leaf(4)
        ),
        Node(
          Leaf(5),
          Leaf(6)
        )
      )

    //out(everywhere(inc)(tree))
  }

}

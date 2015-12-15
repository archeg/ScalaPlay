package FirstPlay

package Shapeless_test

import CommonPlay._
/**
  * Created by archeg on 12/6/2015.
  */
object Overview extends ChapterApp {
  // https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0
  import shapeless.poly._
  import shapeless._

  {
    --------------("Polymorphic function values")
    object choose extends (Set ~> Option) {    // choose is polymorhic because it accepts any argument
    def apply[T](s: Set[T]) = s.headOption
    }

    object choose2 {    // choose is polymorhic because it accepts any argument
    def apply[T](s: Set[T]) = s.headOption
    }

    out(choose(Set(1, 2, 3))) === Some(1)
    out(choose(Set('a', 'b', 'c'))) === Some('a')

    out(choose2(Set(1, 2, 3))) === Some(1)
    out(choose2(Set('a', 'b', 'c'))) === Some('a')

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

    out(size(23)) === 1
    out(size("foo")) === 3
    out(size((23, "foo"))) === 4
    out(size(((23, "foo"), 13))) === 5

    def size2(a: Any): Int = a match {
      case a : Int => 1
      case a : String => a.size
      case (a, b) => size2(a) + size2(b)
    }

    out(size2(23)) === 1
    out(size2("foo")) === 3
    out(size2((23, "foo"))) === 4
    out(size2(((23, "foo"), 13))) === 5
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
    out(a) === Some(1) :: Some("foo") :: HNil

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
    out((23, "foo", true).head) === 23
    out((23, "foo", true).tail) === ("foo", true)
    out((23, "foo", true).drop(2)) === Tuple1(true)
    out((23, "foo", true).take(2)) === (23, "foo")
    out((23, "foo", true).split(1)) === (Tuple1(23), ("foo", true))

    out(23 +: ("foo", true)) === (23, "foo", true)
    out((23, "foo") :+ true) === (23, "foo", true)
    out((23, "foo") ++ (true, 2.0)) === (23, "foo", true, 2.0)

    import poly._

    object option extends (Id ~> Option) {
      def apply[T](t: T) = Option(t)
    }

    out((23, "foo", true) map option) === (Some(23), Some("foo"), Some(true))
    out(((23, "foo"), (), (true, 2.0)) flatMap identity) === (23, "foo", true, 2.0)

    object size extends Poly1 {
      implicit def caseInt = at[Int](x => 1)
      implicit def caseString = at[String](_.length)
      implicit def caseTuple[T, U](implicit st: Case.Aux[T, Int], su: Case.Aux[U, Int]) = at[(T, U)](t => size(t._1) + size(t._2))
    }
    object addSize extends Poly2 {
      implicit def default[T](implicit st: size.Case.Aux[T, Int]) = at[Int, T]{ (acc, t) => acc + size(t) }
    }

    out((23, "foo", (13, "wibble")).foldLeft(0)(addSize))  === 11

    out((23, "foo", true).productElements) === 23 :: "foo" :: true :: HNil
    out((23, "foo", true).toList) == 23 :: "foo" :: true :: Nil

    import syntax.zipper._

    out((23, ("foo", true), 2.0).toZipper.right.down.put("bar").root.reify)
  }

  --------------("Facilities for abstracting over arity")

  {
    import syntax.std.function._
    import ops.function._

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


    import hm._
    val l = 23 :: "bar" :: HNil
    out(l map hm)
  }

  --------------("Singleton-typed literals")

  {
    import syntax.std.tuple._

    val l = 23 :: "foo" :: true :: HNil
    out(l(1))

    val t = (23, "foo", true)
    out(t(1))

    import shapeless._, syntax.singleton._

    out(23.narrow) === 23
    out("foo".narrow) === "foo"

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
    import syntax.singleton._
    import record._

    val book =
      ("author" ->> "Benjamin Pierce") ::
        ("title" ->> "Types and Programming Languages") ::
        ("id" ->> 262162091) ::
        ("price" ->> 44.11) ::
        HNil

    out(book("author")) === "Benjamin Pierce"
    out(book("title")) === "Types and Programming Languages"
    out(book("id")) === 262162091
    out(book.keys)
    out(book.values)

    val newPrice = book("price") + 2.0
    val updated = book + ("price" ->> newPrice)
    out(updated("price")) === 46.11

    val extended = updated + ("inPrint" ->> true)
    val noId = extended - "id"
    out(noId("price"))
    //out(noId("id"))                <- Compile time error
  }

  --------------("Coproducts and discriminated unions")

  {
    type ISB = Int :+: String :+: Boolean :+: CNil

    val isb = Coproduct[ISB]("foo")
    out(isb.select[Int]) === None
    out(isb.select[String]) === Some("foo")

    object size extends Poly1 {
      implicit def caseInt = at[Int](i => (i, 1))
      implicit def caseString = at[String](s => (s, s.length))
      implicit def caseBoolean = at[Boolean](b => (b, 1))
    }

    out(isb map size) === Coproduct[(Int, Int) :+: (String, Int) :+: (Boolean, Int) :+: CNil](("foo", 3))
    out((isb map size).select[(String, Int)]) === Some(("foo", 3))
  }

  --------------("Generic representation of (sealed families of) case classes")

  {
    case class Foo(i: Int, s: String, b: Boolean)
    val fooGen = Generic[Foo]
    val foo = Foo(23, "foo", true)

    out(fooGen.to(foo)) === 23 :: "foo" :: true :: HNil

    out(13 :: fooGen.to(foo).tail) === 13 :: "foo" :: true :: HNil

    out(fooGen.from(13 :: fooGen.to(foo).tail)) === Foo(13, "foo", true)

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

    //out(everywhere(inc)(tree))            Does not compile for some reason?
  }

  {
    import record._
    import syntax.singleton._

    case class Book(author: String, title: String, id: Int, price: Double)

    val bookGen = LabelledGeneric[Book]

    val tapl = Book("Benjamin Pierce", "Types and Programming Languages", 262162091, 44.11)
    val rec = bookGen.to(tapl)

    out(rec('price)).ofType[Double]
    out(rec('price) + 2) === 46.11 // Return type is Double

    out(bookGen.from(rec.updateWith('price)(_ + 2.0)))

    case class ExtendedBook(author: String, title: String, id: Int, price: Double, inPrint: Boolean)

    val bookExtGen = LabelledGeneric[ExtendedBook]

    out(bookExtGen.from(rec + ('inPrint ->> true))) ==# classOf[ExtendedBook]
  }

  --------------("Boilerplate-free lenses for arbitrary case classes")

  {
    import shapeless._

    case class Address(street: String, city: String, postcode: String)
    case class Person(name: String, age: Int, address: Address)

    // Some lenses over Person/Address

    val nameLens = lens[Person] >> 'name
    val ageLens = lens[Person] >> 'age
    val addressLens = lens[Person] >> 'address
    val streetLens = lens[Person] >> 'address >> 'street
    val cityLens = lens[Person] >> 'address >> 'city
    val postcodeLens = lens[Person] >> 'address >> 'postcode

    val person = Person("Joe Grey", 37, Address("Southover Street", "Brighton", "BN2 9UA"))
    val age1 = ageLens.get(person)
    out(age1) === 37

    val person2 = ageLens.set(person)(38)
    out(person2).ofType[Person]

    val person3 = ageLens.modify(person2)(_ + 1)
    out(person3)

    val street = streetLens.get(person3)
    out(street)

    val person4 = streetLens.set(person3)("Montpelier Road")
    out(person4)
  }


  --------------("Automatic type class instance derivation")

  {
    // Shapeless-contrib ???
  }

  --------------("First class lazy values tie implicit recursive knots")

  {
    sealed trait List[+T]
    case class Cons[T](hd: T, tl: List[T]) extends List[T]
    sealed trait Nil extends List[Nothing]
    case object Nil extends Nil

    trait Show[T] {
      def apply(t: T): String
    }

    object Show {
      implicit def showInt: Show[Int] = new Show[Int] {
        def apply(t: Int) = t.toString
      }

      implicit def showNil: Show[Nil] = new Show[Nil] {
        def apply(t: Nil) = "Nil"
      }

      implicit def showCons[T](implicit st: Lazy[Show[T]], sl: Lazy[Show[List[T]]]): Show[Cons[T]] = new Show[Cons[T]] {
        def apply(t: Cons[T]) = s"Cons(${show(t.hd)(st.value)}, ${show(t.tl)(sl.value)})"
      }

      implicit def showList[T](implicit sc: Lazy[Show[Cons[T]]]): Show[List[T]] = new Show[List[T]] {
        def apply(t: List[T]) = t match {
          case n: Nil => show(n)
          case c: Cons[T] => show(c)(sc.value)
        }
      }
    }

    def show[T](t: T)(implicit s: Show[T]) = s(t)

    val l: List[Int] = Cons(1, Cons(2, Cons(3, Nil)))

    out(show(l))
  }

  --------------("Collections with statically known sizes")

  {
    def row(cols: Seq[String]) =
      cols.mkString("\"\"")

    def csv[N <: Nat](hdrs: Sized[Seq[String], N], rows: List[Sized[Seq[String], N]]) =
      row(hdrs) :: rows.map(row(_))

    val hdrs = Sized("Title", "Author")

    val rows = List(
      Sized("Types and Programming Languages", "Benjamin Pierce"),
      Sized("The Implementation of Functional Programming Languages", "Simon Peyton-Jones")
    )

    val formatted = csv(hdrs, rows)

    val extendedHdrs = Sized("Title", "Author", "ISBN")
    //val badFormatted = csv(extendedHdrs, rows)                             <- Does not compile
  }


  --------------("Type safe cast")

  {
    import syntax.typeable._

    val l: Any = List(Vector("foo", "bar", "baz"), Vector("wibble"))

    out(l.cast[List[Vector[String]]]) === Some(List(Vector("foo", "bar", "baz"), Vector("wibble")))
    out(l.cast[List[Vector[Int]]]) === None
    out(l.cast[List[List[String]]]) === None


    val `List[String]` = TypeCase[List[String]]
    val `List[Int]` = TypeCase[List[Int]]
    val l2 = List(1, 2, 3)


    out((l2: Any) match {
      case `List[String]`(List(s, _*)) => s.length
      case `List[Int]`(List(i, _*)) => i + 1
    })
  }

  --------------("Testing for non-compilation")

  {
    import shapeless.test.illTyped

    out(illTyped { """1+1 : Boolean"""})
    //out(illTyped { """1+1 : Int"""})         // Error - type-checking succeeded unexpectedly. Expected some error

  }
}


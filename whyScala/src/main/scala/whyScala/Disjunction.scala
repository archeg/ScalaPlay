package whyScala

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/30/2016.
  */
object Disjunction extends ChapterApp {
  import shapeless.test.illTyped
    // credits: http://stackoverflow.com/questions/3508077/how-to-define-type-disjunction-union-types
  --------------("Simple, by type evidence")

  {
    def size[T](t: T)(implicit ev: (Int with String) <:< T) =
      t match {
        case i: Int => i
        case s: String => s.length
        case _ => 0
      }

    out(size(5)) ==== 5
    out(size("hello!")) ==== 6

    illTyped("size(5.6)")

    // But it fails for some cases:
    out(size(5.6: AnyVal)) ==== 0
  }


  --------------("Type negation, Curry-Howard isomorphism")

  {
    object Def {
      // Type negation:
      type ¬[A] = A => Nothing
      // Union by De-Morgan law:
      type ∨[T, U] = ¬[¬[T] with ¬[U]]

      // Auxilary constructors:
      type ¬¬[A] = ¬[¬[A]]
      type |∨|[T, U] = {type λ[X] = ¬¬[X] <:< (T ∨ U)}
    }

    import Def._

    def size[T : (Int |∨| String)#λ](t : T) =
      t match {
        case i: Int => i
        case s: String => s.length
      }

    out(size(5)) ==== 5
    out(size("hello!")) ==== 6

    illTyped("size(5.6)")
  }

  --------------("Type negation, V2")

  {
    object Def {
      sealed trait ¬[-A]

      sealed trait TSet {
        type Compound[A]
        type Map[F[_]] <: TSet
      }

      sealed trait ∅ extends TSet {
        type Compound[A] = A
        type Map[F[_]] = ∅
      }

      // Note that this type is left-associative for the sake of concision.
      sealed trait ∨[T <: TSet, H] extends TSet {
        // Given a type of the form `∅ ∨ A ∨ B ∨ ...` and parameter `X`, we want to produce the type
        // `¬[A] with ¬[B] with ... <:< ¬[X]`.
        type Member[X] = T#Map[¬]#Compound[¬[H]] <:< ¬[X]

        // This could be generalized as a fold, but for concision we leave it as is.
        type Compound[A] = T#Compound[H with A]

        type Map[F[_]] = T#Map[F] ∨ F[H]
      }
    }

    import Def._

    def foo[A : (∅ ∨ String ∨ Int ∨ List[Int])#Member](a: A): String = a match {
      case s: String => "String"
      case i: Int => "Int"
      case l: List[_] => "List[Int]"
    }

    out(foo(42))
    out(foo("bar"))
    out(foo(List(1, 2, 3)))
    illTyped("foo(42d)") // error
    illTyped("foo[Any](???)") // error
  }
}

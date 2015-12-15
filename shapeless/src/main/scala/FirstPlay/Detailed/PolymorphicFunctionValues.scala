package FirstPlay.Detailed

import CommonPlay.ChapterApp

import scala.collection.immutable

/**
  * Created by archeg on 12/8/2015.
  */
object PolymorphicFunctionValues extends ChapterApp {
  // https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0#polymorphic-function-values
  import shapeless._
  import poly._
  import shapeless.test.illTyped

  object choosePolymorphic extends (Set ~> Option){
    def apply[T](s: Set[T]) = s.headOption
  }

  class chooseMonomorphic[T] extends (Set[T] => Option[T]){
    def apply(s: Set[T]) = s.headOption
  }

  val chooseResult: Option[Int] = choosePolymorphic(Set(1, 2, 3))
  out(chooseResult) === Some(1)                               // Single function can accept both Set[Int] and Set[Char]
  out(choosePolymorphic(Set('a', 'b', 'c'))) === Some('a')

  val chooseMonoInstance = new chooseMonomorphic[Int]               // This function accepts only Set[Int].
  val chooseMonomorphicResult = chooseMonoInstance(Set(1, 2, 3))
  out(chooseMonomorphicResult) === Some(1)                          // For Set[Char] you need to create a new function.
  out(new chooseMonomorphic()(Set('a', 'b', 'c'))) === Some('a')


  // Is it polymorphic?
  def scalaMap[T](s: Set[T]) = s.headOption            // It seems not to be polymorphic, because `scalaMap` itself is not a function in scala,
                                                       // only `scalaMap[Int]` is. And `scalaMap[Int]` is monomorphic.

  illTyped("val eta: (Set[_]) => Option[Nothing] = scalaMap _")

  def pairApply(f: Set ~> Option) = (f(Set(1, 2, 3)), f(Set('a', 'b', 'c')))
  illTyped("pairApply(scalaMap)") // Nope.

  // But we can:
  pairApply(choosePolymorphic)

  // We can still call scala functions polymorphic in the sense of object-oriented polymorphism:


  out(scalaMap(Set(1, 2, 3))) === Some(1)
  out(scalaMap(immutable.HashSet(1, 2, 3))) === Some(1)
  out(scalaMap(immutable.ListSet(1, 2, 3))) === Some(3)

  // So scalaMap accepts the family of functions that derive from Set[T], and thus is polymorphic, but only in object-oriented polymorphism,
  // and not in parametric polymorphism.
}

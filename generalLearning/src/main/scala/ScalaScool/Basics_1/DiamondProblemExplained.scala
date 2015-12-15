package ScalaScool.Basics_1

/**
 * Created by archeg on 7/5/2015.
 */
object DiamondProblemExplained extends App {
  trait Base1 {
    def print() { println("Base1") }
  }

  trait A extends Base1 {
    override def print() { println("A"); super.print() }
  }

  trait B extends Base1 {
    override def print() { println("B"); super.print() }
  }

  class Base2 {
    def print() { println("Base2") }
  }

  class C extends Base2 with A with B {
    override def print() { println("C"); super.print() }
  }

  (new C).print()

  // Linearization
  // { C }
  // { Base2 with A with B with C }
  // {
  // Any with AnyRef with Base2                <- Base2
  // Any with AnyRef with Base1 with A         <- A
  // Any with AnyRef with Base1 with B         <- B
  // Any with AnyRef with C                    <- C
  // }
  // After removing duplicates (left to right):
  // Any with AnyRef with Base2 with Base1 with A with B with C

  // So, to reread:
  // C <- B <- A <- Base1 <- Base2 <- AnyRef for C. So, for C super is    B <- A <- Base1 <- Base2 <- AnyRef
  // B <- A <- Base1 <- Base2 <- AnyRef for B. So for B super is A <- Base1 <- Base2 <- AnyRef
  //
  // From within a given trait (or class), the runtime type of super is given by the longest prefix of the final linearized type that ends does not include that trait (or class).
  // For example, within A, super has type:
  // Any with AnyRef with Base2 with Base1
  //
  //    You might wonder why ?Base2? is never printed. However, by inspecting the type definitions and the linearization
  //  above, you will see that Base2 is left of Base1 in the linearization, meaning that it can only be called if Base1 delegates to super, but this does not happen.
}

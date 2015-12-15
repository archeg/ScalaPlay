/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter20_AbstractMembers

import CommonPlay.ChapterApp

/**
 * Created by archeg on 9/17/2015.
 */
object CaseStudyCurrencies extends ChapterApp {

  abstract class FaultyCurrency {
    val amount: Long
    def designation: String
    override def toString = amount + " " + designation
    def + (that: FaultyCurrency): FaultyCurrency = throw new NotImplementedError()
    def * (x: Double): FaultyCurrency = throw new NotImplementedError()
  }

  // You can create an instance like this:
  val concreteFaultyCurrency = new FaultyCurrency {
    def designation: String = "USD"
     val amount: Long = 79L
  }
  abstract class FaultyDollar extends FaultyCurrency { def designation = "USD" }
  abstract class FaultyEuro extends FaultyCurrency { def designation = "EUR" }
  // But now you can add Dollars to Euro :(

  newExample("------------------------ Next (still imperfect) design ------------------------")
  abstract class FaultyAbstractCurrency2 {
    type Currency <: FaultyAbstractCurrency2
    val amount: Long
    def designation: String
    override def toString = amount + " " + designation
    def + (that: Currency): Currency = throw new NotImplementedError()
    def * (x: Double): Currency = throw new NotImplementedError()
  }

  // USD:
  abstract class FaultyDollar2 extends FaultyAbstractCurrency2 {
    type Currency = FaultyDollar2
    def designation = "USD"
  }

  // But how to implement + method? You cannot create an instance of Currency type, because it is abstract!
  // We can define a factory method for this:
  abstract class FaultyAbstractCurrency3 {
    type Currency <: FaultyAbstractCurrency3
    def make(amount: Long): Currency
    val amount: Long
    def designation: String
    override def toString = amount + " " + designation
    def + (that: Currency): Currency = make(amount + that.amount)
    def * (x: Double): Currency  = make((amount * x).asInstanceOf[Long])
  }

  // But because of this you can create dollars if you have at least 1:
  // myDollar.make(100)
  // Another problem is that you can create dollars by having a dollar, but how do you create a first dollar?

  newExample(" ----- Currency Zone -----------------")
  abstract class CurrencyZone {
    type Currency <: AbstractCurrency
    def make(x: Long): Currency
    val CurrencyUnit: Currency
    abstract class AbstractCurrency {
      val amount: Long
      def designation: String

      override def toString =
        ((amount.toDouble / CurrencyUnit.amount.toDouble)
          formatted ("%."+ decimals(CurrencyUnit.amount) +"f")
          +" "+ designation)

      def + (that: Currency) = make(this.amount + that.amount)
      def * (x: Double) = make((this.amount * x).toLong)

      private def decimals(n: Long): Int =
        if (n == 1) 0 else 1 + decimals(n / 10)

      def from(other: CurrencyZone#AbstractCurrency): Currency =
        make(math.round(other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)))
    }
  }

  object US extends CurrencyZone {
    abstract class Dollar extends AbstractCurrency {
      def designation = "USD"
    }
    type Currency = Dollar
    def make(cents: Long) = new Dollar { val amount = cents }
    val Cent = make(1)
    val Dollar = make(100)
    val CurrencyUnit = Dollar // val Dollar
  }
  object Europe extends CurrencyZone {
    abstract class Euro extends AbstractCurrency {
      def designation = "EUR"
    }
    type Currency = Euro
    def make(cents: Long) = new Euro {
      val amount = cents
    }
    val Cent = make(1)
    val Euro = make(100)
    val CurrencyUnit = Euro
  }
  object Japan extends CurrencyZone {
    abstract class Yen extends AbstractCurrency {
      def designation = "JPY"
    }
    type Currency = Yen
    def make(yen: Long) = new Yen {
      val amount = yen
    }
    val Yen = make(1)
    val CurrencyUnit = Yen
  }

  object Converter {
    var exchangeRate = Map(
      "USD" -> Map("USD" -> 1.0 , "EUR" -> 0.7596,
        "JPY" -> 1.211 , "CHF" -> 1.223),
      "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0 ,
        "JPY" -> 1.594 , "CHF" -> 1.623),
      "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
        "JPY" -> 1.0 , "CHF" -> 1.018),
      "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
        "JPY" -> 0.982 , "CHF" -> 1.0 )
    )
  }

  val x = Japan.Yen from US.Dollar * 100
  println(x)
  println(Europe.Euro from x)

  // But you cannot add the amounts of different currencies:
  // US.Dollar + Europe.Euro

}

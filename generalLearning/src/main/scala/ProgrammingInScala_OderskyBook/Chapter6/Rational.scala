package ProgrammingInScala_OderskyBook.Chapter6

/**
 * Created by archeg on 7/16/2015.
 */
class Rational(n: Int, d: Int) extends RationalBase(n, d) {
  def this(n: Int) = this(n, 1) // auxiliary constructor

  // This is done for the other chapter's example. We will implement >,<... better with a trait Ordered[] in Ch12
  def <(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this < that) that else this
}

class RationalBase(n: Int, d: Int) {
  require(d != 0)
  override def toString = numer + "/" + denom

  private val g = gcd(n abs, d abs)
  val numer = n / g
  val denom = d / g

  def +(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def +(i: Int) = new Rational(numer + i * denom, denom)
  def -(that: Rational) = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  def -(i: Int) = new Rational(numer - i * denom, denom)

  def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
  def *(i: Int) = new Rational(numer * i, denom)
  def /(that: Rational) = new Rational(numer * that.denom, denom * that.numer)
  def /(i: Int) = new Rational(numer, denom * i)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

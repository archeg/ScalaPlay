/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

/**
 * Created by archeg on 10/8/2015.
 */
object RegexExtractors extends App {
  val Decimal = """(-)?(\d+)(\.\d*)?""".r
  val Decimal(sign, integerpart, decimalpart) = "1.0"

  val input = "for -1.0 to 99 by 3"
  for (Decimal(sign, intPart, decPart) <- Decimal findAllIn input)
    println("sign: " + sign + ", integer: " + intPart + ", decimal: " + decPart)
}

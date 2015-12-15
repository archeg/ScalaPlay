/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter26_Extractors

import CommonPlay.ChapterApp

/**
 * Created by archeg on 10/8/2015.
 */
object Main extends ChapterApp {
  def checkEmail(s: String) = s match {
    case EMail(user, domain) => user + " AT " + domain                        // is translated to if s.isInstanceOf[String] { EMail.unapply(s) match { Some(user, domain) => ....
    case _ => "not an email address"
  }

  object EMail extends ((String, String) => String) {
    def apply(user: String, domain: String) = user + "@" + domain               // extends function. Optional for extractors, but is common sense.
    def unapply(str: String): Option[(String, String)] = {                      // extractor
      val parts = str split "@"
      if (parts.length == 2) Some(parts(0), parts(1)) else None
    }
  }

  // apply is called Injection
  // unapply is called Extraction

  println(checkEmail("gai@gmail.com"), "gai AT gmail.com")
  println(checkEmail("martson@ululu.dir"), "martson AT ululu.dir")
  println(checkEmail("Hello world!"), "not an email address")

  // It should be dual:
  println(EMail.unapply(EMail.apply("username", "domain")), Some("username" -> "domain"))     // not enforced, but recommended way of doing things.

  newExample("------------- Patterns with zero or one variables -------------")
  object Twice {
    def apply(s: String) = s + s
    def unapply(s: String) = {
      val length = s.length / 2
      val half = s.substring(0, length)
      if (half == s.substring(length))
        Some(half)
      else
        None
    }
  }

  object UpperCase {                                    // No injector, as it is impossible to write injector for this one.
    def unapply(s: String): Boolean = s.toUpperCase == s
  }

  def userTwiceUpper(s: String) =
    s match {
      case EMail(Twice(x @ UpperCase()), domain) => "match: " + x + " in domain " + domain
      case _ => "no match"
    }

  println(userTwiceUpper("DIDI@hotmail.com"), "match: DI in domain hotmail.com")       // match!
  println(userTwiceUpper("DIDO@hotmail.com"), "no match")                              // no match
  println(userTwiceUpper("didi@hotmail.com"), "no match")                              // no match

  newExample("----------------- Variable argument extractors --------------------")

  object Domain {
    def apply(parts: String*): String =
      parts.reverse.mkString(".")
    def unapplySeq(whole: String): Option[Seq[String]] =
      Some(whole.split("\\.").reverse)
  }

  def domainMatch(dom: String) = dom match {
    case Domain("org", "acm") => "acm.org"
    case Domain("com", "sun", "java") => "java.sun.com"
    case Domain("net", _*) => "a .net domain"
  }

  println(domainMatch("http://microsoft.net"), "a .net domain")

  def isTomInDotCom(s: String): Boolean =
    s match {
      case EMail("tom", Domain("com", _*)) => true
      case _ => false
    }

  println(isTomInDotCom("tom@sun.com"), true)
  println(isTomInDotCom("peter@sun.com"), false)
  println(isTomInDotCom("tom@acm.org"), false)

  object ExpandedEMail {
    def unapplySeq(email: String) : Option[(String, Seq[String])] = {          //unapplySeq ends with a sequence.
      val parts = email split "@"
      if (parts.length == 2)
        Some(parts(0), parts(1).split("\\.").reverse.toSeq)
      else
        None
    }
  }

  val s = "tom@support.epfl.ch"
  val ExpandedEMail(name, topdom, subdoms @ _*) = s                              // Remember? this is also a match!

  newExample("--------------------- Extractors and sequence patterns -------------------------")

  // List is extractor:
  def parseList(l: List[_]) =
    l match {
      case List(1, 2, _*) => "1 + 2"
      case List(3, 4)     => "3 + 4"
      case List(3, _*)    => "!!!"
      case _              => "nothing"
    }

  println(parseList(List(1, 2, 3, 4)), "1 + 2")
  println(parseList(List(3, 4, 1)), "!!!")
  println(parseList(List(3, 4)), "3 + 4")
  println(parseList(List(5)), "nothing")

  // This is because:
  object MyList {
    def apply[T](elems: T*) = elems.toList
    def unapplySeq[T](x: List[T]): Option[Seq[T]] = Some(x)
  }

  // Problem with case classes:
  // Their representation is bound with implementation. You have to change representation if you are changing implementation
  // Extractors are better in that. But they are more complicated.
  // Case classes also have exhaustive check for match.

  val Decimal = """(-)?(\d+)(\.\d*)?""".r
  val Decimal(sign, integerpart, decimalpart) = "1.0"
  println("sign: " + sign + ", integer: " + integerpart + ", decimal: " + decimalpart)

  val input = "for -1.0 to 99 by 3"
  for (Decimal(sign, intPart, decPart) <- Decimal findAllIn input)
    println("sign: " + sign + ", integer: " + intPart + ", decimal: " + decPart)

  object Mult {
    def apply(l: String, r: String) = s"$l*$r"
    def unapply(x: String): Option[(String, String)] = x.split("\\*") match {
      case Array(a: String, b: String) => Some(a -> b)
      case _ => None
    }
  }

  def a(s: String) = s match {
    case Mult(left, right) => println("Left part: " + left + " Right part: " + right)
    case _ => println("not matched")
  }

  a("a*b")
  a("test*a*test")
  println(Mult("test", "probe"))
}

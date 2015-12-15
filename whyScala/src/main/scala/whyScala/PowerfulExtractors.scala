/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

/**
 * Created by archeg on 10/8/2015.
 */
object PowerfulExtractors extends App {

  object EMail extends ((String, String) => String) {
    def apply(user: String, domain: String) = user + "@" + domain               // extends function. Optional for extractors, but is common sense.
    def unapply(str: String): Option[(String, String)] = {                      // extractor
    val parts = str split "@"
      if (parts.length == 2) Some(parts(0), parts(1)) else None
    }
  }

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

  println(userTwiceUpper("DIDI@hotmail.com"))       // match!
  println(userTwiceUpper("DIDO@hotmail.com"))       // no match
  println(userTwiceUpper("didi@hotmail.com"))       // no match
}

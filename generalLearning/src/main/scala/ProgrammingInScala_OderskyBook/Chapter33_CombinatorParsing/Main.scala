/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter33_CombinatorParsing

import CommonPlay.ChapterApp

/**
 * Created by archeg on 10/10/2015.
 */
object Main extends ChapterApp {
  // expr ::= term {"+" term | "-" term }
  // term ::= factor { "*" factor | "/" factor }
  // factor ::= floatingPointNumber | "(" expr ")"

  import scala.util.parsing.combinator._
  class Arith extends JavaTokenParsers{
    def expr: Parser[Any] = term~rep("+"~term | "-"~term)
    def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
    def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
  }

  val arith = new Arith()
  println(arith.parseAll(arith.expr, "2 * (3 + 7)"))
  println(arith.parseAll(arith.expr, "2 * (3 + 7))"))

  object MyParsers extends RegexParsers {
    val ident: Parser[String] = """[a-zA-Z_]\w*""".r
  }
  println(MyParsers.parseAll(MyParsers.ident, "Hello_world"))
  println(MyParsers.parseAll(MyParsers.ident, "Hello world"))

  // | means OR
  // ~ means AND
  // ^^ means TRANSFORM. The result of P^^f will be if P is matched and the match is R, f(R)
  // ~> means AND, but keep only right result
  // <~ means AND, but keep only left result
//  object JSON extends JavaTokenParsers {
//    def value: Parser[Any] = obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false"
//    def obj: Parser[Map[String, Any]] = "{"~repsep(member, ",")~"}" ^^
//                                { case "{"~ms~"}" => Map() ++ ms.toMap }     // You can write obj differently:
//    def obj2: Parser[Map[String, Any]] = "{"~> repsep(member, ",") <~"}" ^^ (Map() ++ _.toMap)
//    def arr: Parser[Any] = "["~repsep(value, ",")~"]"
//    def member: Parser[Any] = stringLiteral~":"~value
//  }

  // Better version.
  class JSON1 extends JavaTokenParsers {
    def obj: Parser[Map[String, Any]] =
      "{"~> repsep(member, ",") <~"}" ^^ (Map() ++ _)
    def arr: Parser[List[Any]] =
      "["~> repsep(value, ",") <~"]"
    def member: Parser[(String, Any)] =
      stringLiteral~":"~value ^^
        { case name~":"~value => (name, value) }
    def value: Parser[Any] = (                                // Here the parenthesis is needed to turn off semicolon autoinsertion by the compiler
      obj                                                     // Otherwise it have insterted: obj;
        | arr
        | stringLiteral
        | floatingPointNumber ^^ (_.toDouble)
        | "null" ^^ (x => null)
        | "true" ^^ (x => true)
        | "false" ^^ (x => false)
      )
  }

  // List of parser combinators:
  // "..."          literal
  // "...".r        regular expression
  // P~Q            sequential composition
  // P <~ Q, P ~> Q sequential composition; keep left/right only
  // P | Q          alternative
  // opt(P)         option
  // rep(P)         repetition
  // repsep(P, Q)   interleaved repetition
  // P ^^ f         result conversion
  // P~!Q           sequential composition with no back-tracking ( LL(1)). It never back-tracks to "un-read" input elements that have already been parsed.

  newExample("---------------- Implementing combinator parsers ------------------------")

  // Most of the things defined in scala.util.parsing.combinator.Parsers
  // type Parser[T] = Input => ParseResult[T]
  // type Input = Reader[Elem]                      // stream of tokens to read
  // Reader is from scala.util.parsing.input, similar to Stream, but also keeps track of the posistions of all the elements it reads
  // type Element is each individual input elements. It is abstract in Parsers
  // this means that subclasses will redefine it. For instance RegexParsers and JavaTokenParsers fix Elem to be equal to Char
  // but it also possible to set Elem to some other type, such as the type of tokens returned from a separate lexer.

  class Input

  // A parser might succeed or fail on some given input.
  sealed abstract class ParseResult[+T]
  case class Success[T](result: T, in: Input) extends ParseResult[T]
  case class Failure(msg: String, in: Input) extends ParseResult[Nothing]


  // Aliasing this:
  class Outer { p =>              // Alias of Outer.this, just for simpler use
    class Inner {
      println(Outer.this eq p)
    }
  }
}

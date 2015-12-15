/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter35_TheSCellsSpreadsheet

import scala.swing._
import scala.swing.event.TableUpdated

/**
 * Created by archeg on 10/11/2015.
 */
object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet(100, 26)
  }

  class Spreadsheet(val height: Int, val width: Int) extends ScrollPane {
    val cellModel = new Model(height, width)
    import cellModel._

    val table = new Table(height, width){
      override def rendererComponent(isSelected: Boolean, hasFocus: Boolean, row: Int, column: Int): Component =
        if (hasFocus) new TextField(userData(row, column))
        else
          new Label(cells(row)(column).toString){
            xAlignment = Alignment.Right
          }
      def userData(row: Int, column: Int): String = {
        val v = this(row, column)
        if (v == null) "" else v.toString
      }

      reactions += {
        case TableUpdated(table, rows, column) =>
          for (row <- rows) cells(row)(column).formula = FormulaParsers.parse(userData(row, column))
        case ValueChanged(cell) =>
          updateCell(cell.row, cell.column)
      }
    }

    contents = table
  }


  class Model(val height: Int, val width: Int)
    extends Evaluator with Arithmetic {
    case class Cell(row: Int, column: Int) extends Publisher {
      private var v: Double = 0
      private var f: Formula = Empty

      def value: Double = v
      def value_=(w: Double) {
        if (!(v == w || v.isNaN && w.isNaN)){
          v = w
          publish(ValueChanged(this))
        }
      }

      def formula: Formula = f
      def formula_=(f: Formula) {
        for (c <- references(formula)) deafTo(c)
        this.f = f
        for (c <- references(formula)) listenTo(c)
        value = evaluate(f)
      }

      override def toString = formula match {
        case Textual(s) => s
        case _ => value.toString
      }

      reactions += {
        case ValueChanged(_) => value = evaluate(formula)
      }
    }
    val cells = Array.ofDim[Cell](height, width)
    for (i <- 0 until height; j <- 0 until width)
      cells(i)(j) = new Cell(i, j)

    case class ValueChanged(cell: Cell) extends event.Event
  }

  trait Formula
  case class Coord(row: Int, column: Int) extends Formula {
    override def toString = ('A' + column).toChar.toString + row
  }
  case class Range(c1: Coord, c2: Coord) extends Formula {
    override def toString = c1.toString + ":" + c2.toString
  }
  case class Number(value: Double) extends Formula {
    override def toString = value.toString
  }
  case class Textual(value: String) extends Formula {
    override def toString = value
  }
  case class Application(function: String, arguments: List[Formula]) extends Formula {
    override def toString = function + arguments.mkString("(", ",", ")")
  }
  object Empty extends Textual("")
  import scala.util.parsing.combinator._
  object FormulaParsers extends RegexParsers {
    def ident: Parser[String] = """[a-zA-Z_]\w*""".r
    def decimal: Parser[String] = """-?\d+(\.\d*)?""".r

    def cell: Parser[Coord] =
      """[A-Za-z]\d+""".r ^^ { s =>
        val column = s.charAt(0).toUpper - 'A'
        val row = s.substring(1).toInt
        Coord(row, column)
      }

    def range: Parser[Range] = cell~":"~cell ^^ {
        case c1~":"~c2 => Range(c1, c2)
      }
    def number: Parser[Number] = decimal ^^ (d => Number(d.toDouble))
    def application: Parser[Application] = ident~"("~repsep(expr, ",")~")" ^^ {
        case f~"("~ps~")" => Application(f, ps)
      }
    def expr: Parser[Formula] = range | cell | number | application
    def textual: Parser[Textual] = """[^=].*""".r ^^ Textual
    def formula: Parser[Formula] = number | textual | "="~>expr

    def parse(input: String): Formula =
      parseAll(formula, input) match {
        case Success(e, _) => e
        case f: NoSuccess => Textual("[" + f.msg + "]")
      }
  }

  trait Evaluator { this: Model =>
    def evaluate(e: Formula): Double = try {
      e match {
        case Coord(row, column) => cells(row)(column).value
        case Number(v) => v
        case Textual(_) => 0
        case Application(function, arguments) =>
          val argvals = arguments flatMap evalList
          operations(function)(argvals)
      }
    } catch {
      case ex: Exception => Double.NaN
    }

    type Op = List[Double] => Double
    val operations = new collection.mutable.HashMap[String, Op]
    private def evalList(e: Formula): List[Double] = e match {
      case Range(_, _) => references(e) map (_.value)
      case _ => List(evaluate(e))
    }

    def references(e: Formula): List[Cell] = e match {
      case Coord(row, column) => List(cells(row)(column))
      case Range(Coord(r1, c1), Coord(r2, c2)) =>
        for (row <- (r1 to r2).toList; column <- c1 to c2)           // toList is needed to "cast" the result of yield to List.
          yield cells(row)(column)                                   // If it is left as is, IndexedSeq will be used.
      case Application(function, arguments) =>
        arguments flatMap references
      case _ => List()
    }
  }

  trait Arithmetic { this: Evaluator =>
    operations += (
      "add" -> { case List(x, y) => x + y },
      "sub" -> { case List(x, y) => x - y },
      "div" -> { case List(x, y) => x / y },
      "mul" -> { case List(x, y) => x * y },
      "mod" -> { case List(x, y) => x % y },
      "sum" -> { xs => (0.0 /: xs)(_ + _)},
      "prod" -> { xs => (1.0 /: xs)(_ * _)}
      )
  }
}
/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter28_WorkingWithXML

import CommonPlay.ChapterApp

import scala.xml.XML

/**
 * Created by archeg on 10/9/2015.
 */
object Main extends ChapterApp {
  // WARNING! This feature requires scala-xml on classpath.
  val xml = <a>
    This is some XML {{
    Here is a tag:
    <atag/>
  </a>
  println(xml)

  // Scala code can be embedded with { and }
  val xml2 = <a> { String.join(",", "Hello", "World") }</a>
  println(xml2)

  val yearMda = 1955
  val xml3 = <a> {                                           // Anything can be embedded with { and }
       if (yearMda < 2000)
         <old> {yearMda} </old>
      else scala.xml.NodeSeq.Empty
    } </a>
  println(xml3)

  println(<a> { 3 + 4 } </a>)

  println(<a> { "</a>potential security hole<a>"} </a>)       // But strings are escaped, so it's fine and it will build valid xml

  newExample("---------------------- Serialization ---------------------------------------------")
  abstract class CCTherm1 {
    val description: String
    val yearMade: Int
    val dateObtained: String
    val bookPrice: Int
    val purchasePrice: Int
    val condition: Int

    override def toString = description

    def toXML =
      <cctherm>
        <description>{description}</description>
        <yearMade>{yearMade}</yearMade>
        <dateObtained>{dateObtained}</dateObtained>
        <bookPrice>{bookPrice}</bookPrice>
        <purchasePrice>{purchasePrice}</purchasePrice>
        <condition>{condition}</condition>
      </cctherm>
  }

  val therm = new CCTherm1 {
    val description = "hot dog #5"
    val yearMade = 1952
    val dateObtained = "March 14, 2006"
    val bookPrice = 2199
    val purchasePrice = 500
    val condition = 9
  }

  println(therm.toXML)                           // IN action

  newExample("---------------- Taking XML apart -------------------")
  val xml4 = <a>Sounds <tag/> good </a>
  println(xml4.text, "Sounds  good ")
  val xml5 = <a><b><c>hello</c></b></a>
  println(xml5 \ "b")            // <b><c>hello</c></b>                     XPath
  println(xml5 \ "c")            // null                                    XPath
  println(xml5 \\ "c")           // <c>hello</c>                            XPath

  val xml6 = <employee name="Joe" rank="code monkey" serial="123"/>
  println(xml6 \ "@serial")      //123
  newExample("--------------------- Deserialization --------------------------")

  def fromXML(node: scala.xml.Node): CCTherm1 =
    new CCTherm1 {
      override val description: String = (node \ "description").text
      override val yearMade: Int = (node \ "yearMade").text.toInt
      override val dateObtained: String = (node \ "dateObtained").text
      override val bookPrice: Int = (node \ "bookPrice").text.toInt
      override val purchasePrice: Int = (node \ "purchasePrice").text.toInt
      override val condition: Int = (node \ "condition").text.toInt
    }

  val node = therm.toXML
  println(node)
  println(fromXML(node))

  newExample("---------------------- Loading and Saving ---------------------------")
  scala.xml.XML.save("therm1.xml", node)
  println(XML.load("therm1.xml"))

  newExample("---------------------- Pattern matching on XML ----------------------------")
  def proc(node: scala.xml.Node): String =
    node match {
      case <a>{contents}</a> => "It's an a: " + contents
      case <b>{contents}</b> => "It's a b: " + contents
      case _ => "It's something else."
    }

  println(proc(<a>apple</a>))           // matches a
  println(proc(<b>banana</b>))          // matches b
  println(proc(<c>cherry</c>))          // do not match

  println(proc(<a/>))                               // does not mach
  println(proc(<a>a <em>red</em> apple</a>))        // does not match anyway (because it has only a single node inside (text)

  def proc2(node: scala.xml.Node): String =
    node match {
      case <a>{contents @ _*}</a> => "It's an a: " + contents
      case <b>{contents @ _*}</b> => "It's a b:" + contents
      case _ => "It's something else."
    }

  // Now it maches, because internally it has array of nodes:
  println(proc2(<a>a <em>red</em> apple</a>))       // matches ArrayBuffer(a , <em>red</em>,  apple)
  println(proc2(<a/>))                              // matches empty array

  val catalog =
    <catalog>
      <cctherm>
        <description>hot dog #5</description>
        <yearMade>1952</yearMade>
        <dateObtained>March 14, 2006</dateObtained>
        <bookPrice>2199</bookPrice>
        <purchasePrice>500</purchasePrice>
        <condition>9</condition>
      </cctherm>
      <cctherm>
        <description>Sprite Boy</description>
        <yearMade>1964</yearMade>
        <dateObtained>April 28, 2003</dateObtained>
        <bookPrice>1695</bookPrice>
        <purchasePrice>595</purchasePrice>
        <condition>5</condition>
      </cctherm>
    </catalog>

  // This one processes spaces as nodes
  catalog match {
    case <catalog>{therms @ _*}</catalog>  =>
      for (therm <- therms)
        println("processing: " + (therm \ "description").text)
  }

  // So to ignore spaces:
  println("-")
  catalog match {
    case <catalog>{therms @ _*}</catalog>  =>
      for (therm @ <cctherm>{_*}</cctherm> <- therms)
        println("processing: " + (therm \ "description").text)
  }
}

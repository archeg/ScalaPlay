/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter34_GUIProgramming

import scala.swing._
import scala.swing.event.ButtonClicked

/**
 * Created by archeg on 10/11/2015.
 */
object Main extends SimpleSwingApplication {
  // The library  https://github.com/scala/scala-swing is mostly abandoned.
  def top = new MainFrame {
    title = "First Swing App"
    val button = new Button {
      text = "Click me"
    }

    val label = new Label {
      text = "No button clicks registered"
    }

    contents = new BoxPanel(Orientation.Vertical){
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }

    listenTo(button)

    var nClicks = 0
    reactions += {
      case ButtonClicked(b) => {
        nClicks += 1
        label.text = "Number of button clicks: " + nClicks
      }
    }
  }
}

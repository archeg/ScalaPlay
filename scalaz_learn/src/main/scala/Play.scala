import CommonPlay.ChapterApp

import scalaz.{Tag, @@}

/**
  * Created by archeg on 12/14/2015.
  */
object Play extends ChapterApp {
  sealed trait KiloGram

  def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

  val mass = KiloGram(20.0)

  println(2 * Tag.unwrap(mass))
}

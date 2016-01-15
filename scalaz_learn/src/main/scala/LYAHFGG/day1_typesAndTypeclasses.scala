package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/15/2016.
  */
object day1_typesAndTypeclasses extends ChapterApp {
  // :t <expression> works in scala interpreter as well.
  // Note that scala does not support x -> y -> z notation. Probably because in scala carry is not implicit, like in Haskell
  // (I guess later on that?)
  out(().getClass) ==@ "void"
}

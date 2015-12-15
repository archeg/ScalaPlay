import CommonPlay.ChapterApp

import scala.reflect.ClassTag

/**
  * Created by archeg on 12/10/2015.
  */
object Main extends App {
  import MacrosFeatures.PrintFExample._
  import MacrosFeatures.MacrosPrintTest._
  printff("dd2%d", 5)
  println
  printf_test()
}

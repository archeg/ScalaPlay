package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/17/2016.
  */
object day1_2_modules extends ChapterApp {
  import scalaz._
  import Scalaz._

  =============================================("Modules")

  --------------("Data.List")

  // intersperse
  out((1 :: 2 :: 3 :: 4 :: INil()).intersperse(10)) ==== IList(1, 10, 2, 10, 3, 10, 4)
  out(2 :: INil())

  //intercalate

  out((1 :: 2 :: INil()) intercalate 100) ==== 103
  out((IList(2, 3) :: IList(4, 5) :: INil()) intercalate IList(50)) ==== IList(2, 3, 50, 4, 5)
  out((IList(2, 3) :: IList(4, 5) :: IList(100) :: INil()) intercalate IList(50)) ==== IList(2, 3, 50, 4, 5, 50, 100)

  out(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)).transpose) ==== List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9))
  out(List("hey", "the", "guy").transpose)

  --------------("Data.Char")

  out('c'.isDigit) ==== false
  out('9'.isDigit) ==== true

  out('a'.isLetter) ==== true
  out('\t'.isSpaceChar) ==== false
  out(' '.isSpaceChar) ==== true

  out("Helllo2381".forall(_.isLetterOrDigit)) ==== true

  out(List(1 -> 3, 2 -> 2, 1 -> 7).toMap) ==== Map(1 -> 7, 2 -> 2)
  out(IMap.fromListWith(List(1 -> 3, 2 -> 2, 1 -> 7))((x, y) => x + y)) ==== IMap(1 -> 10, 2 -> 2)
  out(IMap.fromListWithKey(List(1 -> 3, 2 -> 2, 1 -> 7))((key, x, y) => key + x + y)) ==== IMap(1 -> 11, 2 -> 2)

}

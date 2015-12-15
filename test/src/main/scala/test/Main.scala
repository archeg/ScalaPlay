package test

import CommonPlay.ChapterApp

/**
 * Created by archeg on 7/26/2015.
 */
object Main extends ChapterApp {

  def flatten(ls: List[_]): List[Int] = ls match {
    case Nil => Nil
    case (a: Int) :: tail => a :: flatten(tail)
    case (a: List[_]) :: tail => flatten(a) ::: flatten(tail)
    case _ :: tail => flatten(tail)
  }

  println(flatten(List(List("one",9,8),3,"str",4,List(true,77,3.2))))
}

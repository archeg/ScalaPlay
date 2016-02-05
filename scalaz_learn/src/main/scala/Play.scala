import CommonPlay.ChapterApp

import scalaz.{Tag, @@}

/**
  * Created by archeg on 12/14/2015.
  */
object Play extends ChapterApp {
  def subSeq (xs: List[(Char, Int)]): List[List[(Char,Int)]] = {
    xs match {
      case Nil => List(List())
      case y::ys => {
        val eh: List[(Char, Int)] = xs.filter (c => c._1 == y._1)
        val et = xs.filter (c => c._1 != y._1)
        val t = subSeq(et)
        (for {
          z: (Char,Int) <- eh
          foo <- t
        } yield z :: foo) ++ t
      }
    }
  }

  for (l <- subSeq(List(('a',1), ('a',2), ('b',1), ('b',2))))
  println(l)
}

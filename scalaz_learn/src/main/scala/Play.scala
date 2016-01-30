import CommonPlay.ChapterApp

import scalaz.{Tag, @@}

/**
  * Created by archeg on 12/14/2015.
  */
object Play extends ChapterApp {

  import scala.collection.immutable.{TreeMap, HashMap}

  implicit class RichMap[A, B, MapType[x, y] <: Map[x, y]](val self: MapType[A, B]) extends AnyVal {
    import scala.collection.generic.CanBuildFrom
    def updatedWith[R >: B](k: A, f: B => R)(implicit bf: CanBuildFrom[MapType[A, B], (A, R), MapType[A, R]]): MapType[A, R] = {
      val b = bf(self)
      for ((key, value) <- self) {
        if (key != k) {
          b += (key -> value)
        } else {
          b += (key -> f(value))
        }
      }
      b.result()
    }
  }

  val map1 = HashMap(1 -> "s", 2 -> "d").updatedWith(2, _.toUpperCase())  // map1 type is HashMap[Int, String]
  val map2 = TreeMap(1 -> "s", 2 -> "d").updatedWith(2, _.toUpperCase())  // map2 type is TreeMap[Int, String]
  val map3 = HashMap(1 -> "s", 2 -> "d").updatedWith(2, _.asInstanceOf[Any])  // map3 type is HashMap[Int, Any]
}

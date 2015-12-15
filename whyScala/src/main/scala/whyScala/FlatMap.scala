/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package whyScala

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
 * Created by archeg on 10/21/2015.
 */
object FlatMap extends App {
  // A lot of classes in scala implement flatMap, map, filter etc., which allows a lot of additional functionality.
  val list = List(1, 2, 3, 4)
  println(list.flatMap(x => Seq(x * 10, x * 10 + 1, x * 10 + 2)))

  // This allows for-comprehensions usages (no requirement to implement Traversable though):
  println(for (x <- List(1, 2, 3, 4);
       xx = x * 10;
       z <- List(xx, xx + 1, xx + 2)) yield z)

  // ------- But this works with non collections too:
  def processOption(listOp: Option[Int], listOp2: Option[Int]): Option[Int] = {
    for (x <- listOp;
         xx = x * 10;
         z <- listOp2;
         zz = x * z) yield zz
  }

  println(processOption(Some(1), Some(3)))
  println(processOption(Some(1), None))

  // ------- Or with futures and promises:

  import scala.concurrent.ExecutionContext.Implicits.global
  var factorial = Future {
    def fac(x: Double): Double =
      x match {
        case 1 => 1
        case y => y * fac(y - 1)
      }

    val result = for (i <- 1 to 30000) yield fac(i)
    result.head
  }

  var justList = Future {
    for (i <- 1 to 4000) yield i
  }

  factorial = factorial map (_ / 2)

  var result = for (            // Still a Future! Was not computed yet
    fact <- factorial;
    divided = fact / 2;
    list <- justList;
    sum = list.sum
  ) yield (fact, sum)

  result = result andThen {
    case Success(x) => println(x)
    case Failure(ex) => println("Exception happened: " + ex)
  }

  import scala.concurrent.duration.Duration
  Await.result(result, Duration.Inf)
}

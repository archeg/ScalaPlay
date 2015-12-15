/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package CodingGame

/**
 * Created by archeg on 9/14/2015.
 */
object SkynetTheChasm extends MainApp {
  defineData(24, 2, 5)
  defineData(1, 0) //(speed, coord)
  val road = readInt // the length of the road before the gap.
  val gap = readInt // the length of the gap.
  val platform = readInt // the length of the landing platform.
  val tryDict = Map[(Int, Int), (Boolean, List[String])]().withDefault{case (x, y) => tryItRec(x, y)}

  val speedOri = readInt // the motorbike's speed.
  val coordxOri = readInt // the position on the road of the motorbike.

  val computation = tryIt(coordxOri, speedOri)
  if (!computation._1){
    throw new IllegalStateException("Something went wrong")
  }

  var path = computation._2
  println(path)

  def tryIt(currentPos: Int, currentSpeed: Int) =
    tryDict((currentPos, currentSpeed))

  def tryItRec(currentPos: Int, currentSpeed: Int): (Boolean, List[String]) = {

    if (currentPos >= road + gap + platform) { //>=23
      // the bike is behind the platform
      return (false, Nil)
    }

    if (currentPos >= road && currentPos < road + gap) { //>=16 & <18
      // the bike is in the gap.
      return (false, Nil)
    }

    if (currentPos >= road + gap && currentSpeed == 0) { //>=18
      // the bike has finished on the platform
      return (true, Nil)
    }

    if (currentPos < road && currentPos + currentSpeed >= road + gap){
      val t = tryIt(currentPos + currentSpeed, currentSpeed)
      if (t._1) {
        return (true, "JUMP" :: t._2)
      } else {
        return (false, Nil)
      }
    }

    if (currentPos < road && currentPos + currentSpeed > road){
      return (false, Nil)
    }

    val speedTry = tryIt(currentPos + currentSpeed + 1, currentSpeed + 1)

    if (speedTry._1) {
      return (true, "SPEED" :: speedTry._2)
    }

    if (currentSpeed != 0) {
      val slowTry = tryIt(currentPos + currentSpeed - 1, currentSpeed - 1)

      if (slowTry._1) {
        return (true, "SLOW" :: slowTry._2)
      }

      val stayTry = tryIt(currentPos + currentSpeed, currentSpeed)

      if (stayTry._1) {
        return (true, "WAIT" :: stayTry._2)
      }
    }

    return (false, Nil)
  }
}

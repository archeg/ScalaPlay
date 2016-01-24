package LYAHFGG

import CommonPlay.ChapterApp

/**
  * Created by archeg on 1/21/2016.
  */
object day2_2_InputAndOutput extends ChapterApp {
  import scalaz._
  import Scalaz._

  import effect._
  import IO._

  // This chapter probably isn't interesting in scala terms, so I'll just read it and do in Haskell.
  // There probably will be very little code here as I do here only scala code.

  // We have IO monad in scalaz:
  // -- See RunIOExample1

  println(System.getProperty("user.dir"))
  // But we can make our own action - reading from a file
  // though it will always return first line as there is no state here (yet?)
  val fileRead : IO[String] = IO {
    val source = scala.io.Source.fromFile("test.txt")
    source.getLines().toList.head
  }

  def fileReadLine(i: Int): IO[String] = IO {
    val source = scala.io.Source.fromFile("test.txt")
    source.getLines().toArray.apply(i)
  }

  {
    val action = for {
      _ <- putStrLn("Hello, what's your name?")
      name <- fileRead
      _ <- putStrLn(s"Hey $name, you rock")
    } yield ()

    action.unsafePerformIO()

    // And we can use monoid addition function:

    (action |+| action).unsafePerformIO()
  }

  {
    val action = for {
      _ <- putStrLn("What's your first name?")
      firstName <- fileReadLine(0)
      _ <- putStrLn("What's your last name?")
      lastName <- fileReadLine(1)
      bigFirstName = firstName.toUpperCase
      bigLastName = lastName.toUpperCase
      _ <- putStrLn(s"hey $bigFirstName $bigLastName, how are you?")
    } yield ()

    action.unsafePerformIO()
  }

  {
    // I thought I couldn't do loops in scala, but in fact it is possible.
    // Although looks a bit complicated than in Haskell
    def main: IO[Unit] = for {
      line <- readLn
      _ <- if (line.isEmpty) {
        ioUnit
      } else {
        for {
          _ <- putStrLn(line)
          _ <- main
        } yield ()
      }
    } yield ()

   // main.unsafePerformIO()
  }

}

// This reads a string from keyboard, so it is commented for the purpose of the next code
object RunIOExample1 extends ChapterApp {
  import scalaz._
  import effect._
  import IO._

  // Very similar to haskell, but remember import IO._, or use IO directly: IO.putStrLn
  val action = for {
    _ <- putStrLn("Hello, what's your name?")
    name <- readLn
    _ <- putStrLn(s"Hey $name, you rock")
  } yield ()

  out("Nothing is printed here yet")
  action.unsafePerformIO()
}

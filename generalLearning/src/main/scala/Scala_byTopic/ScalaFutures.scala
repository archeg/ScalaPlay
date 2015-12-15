/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package Scala_byTopic

import java.io.{FileNotFoundException, InvalidObjectException}
import java.util.concurrent._

import CommonPlay.ChapterApp

import scala.concurrent.forkjoin.ForkJoinPool
import scala.concurrent.forkjoin.ForkJoinPool.ManagedBlocker
import scala.concurrent.{Promise, Await, ExecutionContext, Future}
import scala.util.{Success, Failure}

/**
 * Created by archeg on 10/20/2015.
 */
object ScalaFutures extends ChapterApp {
  val myEc = scala.concurrent.ExecutionContext.global // Default ExecutionContext, backed by a ForkJoinPool
  val testFuture: Future[Int] = Future {
    5
  } (myEc)

  // Or implicitly:
  //implicit val ec = scala.concurrent.ExecutionContext.global
  // The following is equivalent to `import val ec = ExecutionContext.global`
  import ExecutionContext.Implicits.global
  val testFuture2 = Future {
    5
  }

  // ForkJoinPool manages a limited amounts of thread.
  // Following VM attributes can be overriden:
  // scala.concurrent.context.minThreads              Defaults to Runtime.availableProcessors
  // scala.concurrent.context.numThreads              (multiplier) in the form to 'xN'. Defaults to Runtime.availableProcessors
  // scala.concurrent.context.maxThreads              Defaults to Runtime.availableProcessors
  //                                                  minThreads <= numThreads <= maxThreads

  // You can specify parallelism manually:


  Future {
    ForkJoinPool.managedBlock {
      new ManagedBlocker {
        var done = false
        def block(): Boolean = {
          try {
           // myLock.lock()
          } finally {
            done = true
          }
          true
        }

        def isReleasable: Boolean = done
      }
    }
  }

  // Fortunately the concurrent package provides a convenient way for doing so:
  import scala.concurrent.blocking
  Future {
    blocking {
      //myLock.Lock()
    }
  }

  // ForkJoinPool is not designed for long lasting blocking operations
  // If you need to wrap long lasting blocking operations we recommend using a dedicated ExecutionContext, for instance by wrapping a Java Executor.

  ExecutionContext.fromExecutor(new ThreadPoolExecutor(50, 50, 50l, TimeUnit.HOURS, new ArrayBlockingQueue[Runnable](50) {}))  // Some configuration (random here)

  // Futures should not be used with the contexts that run stuff on the same thread!:
  val badContext = ExecutionContext.fromExecutor(
    new Executor {
      // Do not do this!
      def execute(runnable: Runnable) { runnable.run() }
    })

  newExample("---------------------------------------------- Futures ----------------------------------------------------------------")

  // Once future produces a value it becomes immutable.

  val f = Future {
    var r = 0
    for (i <- 1 to 100000) r += i
    r
  }

  while (!f.isCompleted) {
    println("waiting... The value is " + f.value)
  }

  println("Worked out: The value is " + f.value)

  val f2 = Future[Int] {
    var r = 0
    for (i <- 1 to 100000) r += i
    throw new InvalidObjectException("Reason")
    r
  }

  while (!f2.isCompleted) {
    println("f2: waiting... The value is " + f2.value)
  }

  println("f2: Worked out: The value is " + f2.value)


  val f3 = Future[Int] {
    var r = 0
    for (i <- 1 to 100000) r += i
    throw new InvalidObjectException("Reason")
    r
  }

  f3 onComplete {
    case Success(result) => println("Success: " + result)
    case Failure(exception) => println("Failed with " + exception)
  }

  f3 onFailure {
    case exception => println(exception)
  }

  f3 onFailure {                                                   // onFailure does not throw if partial function is not fully covered.
    case _ : FileNotFoundException => println("This is never triggered.")
  }

  // Callbacks registered on the same future are unordered.

  @volatile var totalA = 0
  val text = Future {
    "na" * 16 + "BATMAN!!!"
  }

  // May be executed concurrently: (depends on execution context)
  text onSuccess {
    case txt => totalA += txt.count(_ == 'a')
  }
  text onSuccess {
    case txt => totalA += txt.count(_ == 'A')
  }

  while (!text.isCompleted) {}
  Thread.sleep(1000)
  println(totalA)                             // Could end up 18 or 16 or 2 since += is not an atomic operation

  //Registering a callback on the future which is already completed will result in the callback being executed eventually (as implied by 1).
  text onSuccess { case _ => println("!!!!!!!")}

  //In the event that some of the callbacks never complete (e.g. the callback contains an infinite loop),
  //the other callbacks may not be executed at all. In these cases, a potentially blocking callback must use the blocking construct (see below).

  //Once executed, the callbacks are removed from the future object, thus being eligible for GC.

  newExample("-------------- Functional Composition and For-Comprehensions ------------------------")
  val rateQuote = Future {
    2
  }

  rateQuote onSuccess { case quote =>
    val purchase = Future {
      3
    }

    purchase onSuccess { case _ => println("Done!")}
  }

  Thread.sleep(1000)

  // But you can use map instead, and it looks much better:
  var newFuture = Future { 2 } map { x => x + 200}
  newFuture = newFuture map { x => println(x); x}
  newFuture.onSuccess({ case _ => println("Finished!!!")})

  Thread.sleep(1000)

  val usdQuote = Future { for (i <- 1 to 1000) {}; "USD" }
  val chfQuote = Future { for (i <- 1 to 1000) {}; "CHF" }

  val purchase = for {
    usd <- usdQuote
    chf <- chfQuote
    if (usd + chf).length > 3
    superChf = usd + chf
  } yield usd + "!" + chf + superChf

  purchase onSuccess {
    case x => println(x)
  }

  Thread.sleep(1000)

  // Combinator recover runs partial function if Future finished with error, and uses the result of partial function.
  val newFuture2 = Future {
    throw new InvalidObjectException("sd");
  } recover {
    case x: InvalidObjectException => "Done!"
  } onSuccess {
    case x => println(x)
  }

  Thread.sleep(1000)

  // Combinator fallbackTo recovers the future by another future instead of partialFunction
  val usdQuote2 = Future {
    throw new InvalidObjectException("asd")
  }

  val chfQuote2 = Future {
    "Super!"
  }

  (usdQuote2 fallbackTo chfQuote2) onSuccess { case x => println(x) }
  Thread.sleep(1000)

  // Combinator andThen usually used for side-effects. It schedules another closure to be run AFTER future
  // but still use the value from original future
  Future {
    "Original"
  } andThen {
    case x => println(x); "This value's never used"
  } andThen {
    case x => println("1)" + x); "This value's never used"          // andThen's are always in order
  } andThen {
    case x => println("2)" + x); "This value's never used"
  } onSuccess {
    case x => println(x)                                            // Output's Original
  }

  Thread.sleep(1000)

  newExample("------------------------------ Blocking ---------------------------")
  // blocking is handled by ExecutionContext.
  // ExecutionContext.global handles blocking with ManagedBlocker
  // ExecutionContext.fromExecutor(Executors.newFixedThreadPool(x)) doesn't have any blocking implementation, and blocking {} will do nothing.


  // Blocking outside of Future

  import scala.concurrent.duration._
  println(Await.result(Future { 3 }, 0 nanos))                                            // Awaiting for the result from Future
  try
  println(Await.result(Future { throw new Exception("!") }, 0 nanos))                     // The exception is propagated to the caller
  catch {
    case _: Exception => println("Exception caught!")
  }

  // Alternatively Await.ready waits for the future to be completed, but does not retrieve the result.
  // Calling this method will not throw an exception, if Future has failed.

  // The methods of the Future
  // .ready()
  // .result()
  // should not be called ever. They are used by ExecutionResult

  newExample("--------------------------------- Promises ---------------------------------------------------------------")
  // While futures are defined as a type of read-only placeholder object, created for a result which doesn't yet exist
  // A promise can be thought of as a writable, single-assignment container, which completes a future

  // Two methods to complete a promise:
  // .failure
  // .success

  val promise1 = Promise[Int]
  val promise2 = Promise[Int]

  val future1 = promise1.future
  val future2 = promise2.future

  val producer = Future {
    var r = 0
    for (i <- 1 to 10000) r += 10
    promise1 success r
    for (i <- 1 to 10000) r -= 10
    promise2 failure (new Exception("A problem happened."))
  }

  val consumer = Future {
    for (i <- 1 to 10000) {}
    future1 onSuccess {
      case r => println(r)
    }

    future2 onFailure {
      case e => println(e)
    }
  }

  Thread.sleep(1000)
  println("Finished!")

  // Promises also can be completed with .complete with accepts a Try - either success of failure

  // The method completeWith completes the promise with another future.
  // When the future gets completed, the promise gets completed with the result of that future as well.
  val ff = Future { 1 }
  val p = Promise[Int]
  p completeWith ff

  p.future onSuccess {
    case x => println(x)
  }

//  When failing a promise with an exception, three subtypes of Throwables are handled specially. If the Throwable used to
//  break the promise is a scala.runtime.NonLocalReturnControl, then the promise is completed with the corresponding value.
//    If the Throwable used to break the promise is an instance of Error, InterruptedException, or scala.util.control.ControlThrowable,
//  the Throwable is wrapped as the cause of a new ExecutionException which, in turn, is failing the promise.

  // Let’s assume you want to implement a new combinator first which takes two futures f and g and produces a third future which
  // is completed by either f or g (whichever comes first), but only given that it is successful.
  def first[T](f: Future[T], g: Future[T]): Future[T] = {
    val p = Promise[T]
    f onSuccess {
      case x => p.trySuccess(x)
    }
    g onSuccess {
      case x => p.trySuccess(x)
    }
    p.future
  }

  import scala.concurrent.duration._

  // instantiation
  val d1 = Duration(100, MILLISECONDS) // from Long and TimeUnit
  val d2 = Duration(100, "millis") // from Long and String
  val d3 = 100 millis // implicitly from Long, Int or Double
  val d4 = Duration("1.2 µs") // from String
  // pattern matching
  val Duration(length, unit) = 5 millis

  Thread.sleep(1000)
}

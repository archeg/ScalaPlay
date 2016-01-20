package whyScala

/**
  * Created by archeg on 1/16/2016.
  */
object QuickSort extends App {

  // It isn't in-memory, and slower than original quick sort, but this example often used as a FP quicksort, and
  // it's still quite quick.
  // Actually this is MergeSort
  def quickSort(a: List[Int]): List[Int] = a match {
    case Nil => Nil
    case x :: xs => quickSort(xs filter (_ <= x)) ::: (x :: quickSort(xs filter (_ > x)))
  }

  println(quickSort(1 :: 2 :: 1 :: 3 :: 7 :: -2 :: Nil))
}

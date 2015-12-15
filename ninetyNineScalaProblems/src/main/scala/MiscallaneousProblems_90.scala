/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp
import NinetyNineScalaProblem.Graphs_80.Graph

import scala.annotation.tailrec

/**
  * Created by archeg on 12/2/2015.
  */
object MiscallaneousProblems_90 extends ChapterApp {
  --------------("P90. Eight queens problem")

  def p90(numberOfQueens : Int) = {
    def testQueen(l: List[Int]) = l.size == l.toSet.size &&
      (for (
        xa <- l.indices;
        xb <- l.indices if xb > xa;
        ya = l(xa);
        yb = l(xb))
        yield math.abs(xa - xb) != math.abs(ya - yb)).forall(identity)

    def tryQueens(l: List[Int]): List[List[Int]] =
      if (l.size == numberOfQueens)
        l :: Nil
      else
        (for (i <- 0 until numberOfQueens if testQueen(i :: l)) yield i :: l).toList flatMap tryQueens

    //out(testQueen(0 :: Nil))
    tryQueens(Nil)
  }

  out(p90(8))
  out(p90(8).size)
  out(p90(4))

  --------------("P91. Knight's tour")

  def p91_slow(boardSize: (Int, Int), start: (Int, Int)) = {
    val (boardSizeX, boardSizeY) = boardSize
    def knightGo(current: (Int, Int)) = current match {
      case (x, y) =>
        for (firstMult <- List (-2, -1, 1, 2);
             secondMult <- List (-2, -1, 1, 2)
             if math.abs(firstMult) != math.abs(secondMult);
             newX = x + firstMult;
             newY = y + secondMult
             if newX >= 0 && newY >= 0 && newX < boardSizeX && newY < boardSizeY
        ) yield (newX, newY)
    }

    def inner(current: (Int, Int), visited: Set[(Int, Int)], path: List[(Int, Int)]): List[List[(Int, Int)]] =
      if (visited.size == boardSizeX * boardSizeY)
        path.reverse :: Nil
      else
        for (move <- knightGo(current)
             if !visited.contains(move);
             result <- inner(move, visited + move, move :: path)
        ) yield result

    inner(start, Set(start), start :: Nil)
  }

  out(p91_slow((1, 1), (0, 0))) === List(List((0, 0)))
//  private val p = p91_slow((5, 5), (0, 0))
//  println(p.size)
//  println(p.head)

  def p91_lazy(boardSize: (Int, Int), start: (Int, Int)): Stream[List[(Int, Int)]] = {
    val (boardSizeX, boardSizeY) = boardSize
    def knightGo(current: (Int, Int)) = current match {
      case (x, y) =>
        for (firstMult <- List (-2, -1, 1, 2);
             secondMult <- List (-2, -1, 1, 2)
             if math.abs(firstMult) != math.abs(secondMult);
             newX = x + firstMult;
             newY = y + secondMult
             if newX >= 0 && newY >= 0 && newX < boardSizeX && newY < boardSizeY
        ) yield (newX, newY)
    }

    case class StackFrame(current: (Int, Int), visited: Set[(Int, Int)], path: List[(Int, Int)])

    def inner(stack: List[StackFrame]): Stream[List[(Int, Int)]] = stack match {
      case Nil => Stream.empty
      case StackFrame(current, visited, path) :: tail =>
        if (visited.size == boardSizeX * boardSizeY) Stream.cons(path, inner(tail))
        else
          inner(
            (for (move <- knightGo(current)
                 if !visited.contains(move)
            ) yield StackFrame(move, visited + move, move :: path)) ::: tail)
    }

    inner(StackFrame(start, Set(start), start :: Nil) :: Nil)
  }

  val p91_lazyStream = p91_lazy((5, 5), (0, 0))
  println(p91_lazyStream.head)

  def p91_vansdorf(boardSize: (Int, Int), startOptional: Option[(Int, Int)]): Option[List[(Int, Int)]] = {
    val r = scala.util.Random
    val (boardSizeX, boardSizeY) = boardSize
    val start = startOptional.getOrElse((r.nextInt(boardSizeX), r.nextInt(boardSizeY)))

    def knightGo(current: (Int, Int)): List[(Int, Int)] = current match {
      case (x, y) =>
        for (firstMult <- List (-2, -1, 1, 2);
             secondMult <- List (-2, -1, 1, 2)
             if math.abs(firstMult) != math.abs(secondMult);
             newX = x + firstMult;
             newY = y + secondMult
             if newX >= 0 && newY >= 0 && newX < boardSizeX && newY < boardSizeY
        ) yield (newX, newY)
    }

    def knightGoVisited(current: (Int, Int), visited: Set[(Int, Int)]): List[(Int, Int)] =
      knightGo(current) filter {!visited.contains(_)}

    def inner(current: (Int, Int), visited: Set[(Int, Int)], path: List[(Int, Int)]): Option[List[(Int, Int)]] =
      if (visited.size == boardSizeX * boardSizeY)
          Some(path)
      else
        knightGoVisited(current, visited) sortBy(move => knightGoVisited(move, visited).size) headOption match {
          case None => None
          case Some(move) => inner(move, visited + move, move :: path)
        }

    inner(start, Set(start), start :: Nil)
  }

  out(p91_vansdorf((5, 5), Some((0, 0)))) === Some(List((3,3), (1,4), (2,2), (4,1), (2,0), (0,1), (1,3), (3,4), (4,2), (3,0), (1,1), (0,3), (2,4), (4,3), (3,1), (1,0), (0,2), (2,1), (4,0), (3,2), (4,4), (2,3), (0,4), (1,2), (0,0)))

  --------------("P92. Van Koch's conjecture.")

  def p92(graph: Graph[Char, Char]): Option[Graph[(Char, Int), Int]] = {
    val n = graph.nodes.size
    def inner(current: graph.Node, visitedNodes: Set[graph.Node],
              usedNodeWeights: Set[Int], usedEdgesWeights: Set[Int], currentNodeWeight: Int,
              newNodes: List[(Char, Int)], newEdges: List[((Char, Int), (Char, Int), Int)])
        : Option[(List[(Char, Int)], List[((Char, Int), (Char, Int), Int)])] =
    if (visitedNodes.size == n)
      Some(newNodes, newEdges)
    else {
      val choices = for (nodeWeight <- (1 to n).view if !usedNodeWeights.contains(nodeWeight);
                         edgeWeight = math.abs(nodeWeight - currentNodeWeight) if !usedEdgesWeights.contains(edgeWeight) && edgeWeight <= n - 1;
                         node <- current.neighbors if !visitedNodes.contains(node);
                         prevNode = (current.value, currentNodeWeight);
                         newNode = (node.value, nodeWeight))
                      yield
                        inner(node, visitedNodes + node,
                          usedNodeWeights + nodeWeight, usedEdgesWeights + edgeWeight, nodeWeight,
                          newNode :: newNodes, (newNode, prevNode, edgeWeight) :: newEdges)

      choices collectFirst {case Some((n, e)) => (n, e)}
    }

    val (_, startNode) = graph.nodes.head
    val choices = for (startWeight <- (1 to n).view; newNode = (startNode.value, startWeight))
      yield inner(startNode, Set(startNode), Set(startWeight), Set.empty, startWeight, newNode :: Nil, Nil)
    choices collectFirst {
      case Some((n, e)) => Graph(n, e map {case (a, b, c) => (a, b, Some(c))})
    }
  }

  out(p92(Graph.fromString("[a-b]"))) ==! "Some([(a,2)-(b,1)/1])"
  out(p92(Graph.fromString("[a-b, a-c]")))
  out(p92(Graph.fromString("[a-b, b-c, b-d]")))
  //out(p92(Graph.fromString("[d-a, a-g, a-b, b-e, e-f, b-c]")))
//  out(p92(Graph.fromString("[i-a, h-a, a-b, a-g, a-c, c-f, c-d, k-d, c-e, e-q, q-m, q-n, q-p]")))
}

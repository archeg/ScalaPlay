/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package NinetyNineScalaProblem

import CommonPlay.ChapterApp

import scala.annotation.tailrec

/**
  * Created by archeg on 11/24/2015.
  */
object Graphs_80 extends ChapterApp {
  abstract class GraphBase[T, U] {
    case class Edge(n1: Node, n2: Node, value: Option[U]) {
      def toTuple = (n1.value, n2.value, value)
      override def toString = (n1, n2, value) match {
        case (Node(v1), Node(v2), None) => s"$v1-$v2"
        case (Node(v1), Node(v2), Some(value)) => s"$v1-$v2//$value"
      }
    }

    case class Node(value: T) {
      var adj: List[Edge] = Nil
      def neighbors: List[Node] = adj.map(edgeTarget(_, this).get)
    }

    var nodes: Map[T, Node] = Map()
    var edges: List[Edge] = Nil

    // If the edge E connects N to another node, returns the other node,
    // otherwise returns None.
    def edgeTarget(e: Edge, n: Node): Option[Node]

    override def equals(o: Any) = o match {
      case g: GraphBase[T,U] => (nodes.keys.toSet diff g.nodes.keys.toSet) == Set.empty &&
          (edges.map(_.toTuple) diff g.edges.map(_.toTuple)) == Nil
      case _ => false
    }

    override def hashCode(): Int = nodes.keys.map(_.hashCode()).sum + ((edges map {
      case Edge(Node(n1), Node(n2), Some(value)) => n1.hashCode() + n2.hashCode() + value.hashCode()
      case Edge(Node(n1), Node(n2), None) => n1.hashCode() + n2.hashCode()
    }).sum)

    def addNode(value: T) = {
      val n = new Node(value)
      nodes = Map(value -> n) ++ nodes
      n
    }

  }

  class Graph[T, U] extends GraphBase[T, U] {
    override def equals(o: Any) = o match {
      case g: Graph[T,U] => super.equals(g)
      case _ => false
    }

    def edgeTarget(e: Edge, n: Node): Option[Node] =
      if (e.n1 == n) Some(e.n2)
      else if (e.n2 == n) Some(e.n1)
      else None

    def addEdge(n1: T, n2: T): Unit = addEdge(n1, n2, new Edge(nodes(n1), nodes(n2), None))
    def addEdge(n1: T, n2: T, value: U): Unit = addEdge(n1, n2, new Edge(nodes(n1), nodes(n2), Some(value)))

    private[this] def addEdge(n1: T, n2: T, e: Edge) = {
      edges = e :: edges
      nodes(n1).adj = e :: nodes(n1).adj
      nodes(n2).adj = e :: nodes(n2).adj
    }

    override def toString = {
      val fromEdges = edges map {
        case Edge(n1, n2, None) => n1.value.toString + "-" + n2.value.toString
        case Edge(n1, n2, Some(value)) => n1.value.toString + "-" + n2.value.toString + "/" + value.toString
      }

      val aloneNodes = nodes.values.toList diff (edges flatMap { case Edge(n1, n2, _) => n1 :: n2 :: Nil }) map {
        case Node(value) => value.toString
      }
      (fromEdges ::: aloneNodes).mkString("[", ", ", "]")}
  }

  class Digraph[T, U] extends GraphBase[T, U] {
    override def equals(o: Any) = o match {
      case g: Digraph[T,U] => super.equals(g)
      case _ => false
    }

    def edgeTarget(e: Edge, n: Node): Option[Node] =
      if (e.n1 == n) Some(e.n2)
      else None

    def addArc(source: T, dest: T): Unit = addArc(source, dest, None)
    def addArc(source: T, dest: T, value: U): Unit = addArc(source, dest, Some(value))

    private[this] def addArc(source: T, dest: T, value: Option[U]) = {
      val e = new Edge(nodes(source), nodes(dest), value)
      edges = e :: edges
      nodes(source).adj = e :: nodes(source).adj
    }

    override def toString = {
      val fromEdges = edges map {
        case Edge(n1, n2, None) => n1.value.toString + ">" + n2.value.toString
        case Edge(n1, n2, Some(value)) => n1.value.toString + ">" + n2.value.toString + "/" + value.toString
      }

      val aloneNodes = nodes.values.toList diff (edges flatMap { case Edge(n1, n2, _) => n1 :: n2 :: Nil }) map {
        case Node(value) => value.toString
      }
      (fromEdges ::: aloneNodes).mkString("[", ", ", "]")}
  }

  --------------("Implicits")
  object Graph {
    def term[T](nodes: List[T], edges: List[(T, T)]): Graph[T, Unit] = {
      val graph = new Graph[T, Unit]
      for (node <- nodes) graph.addNode(node)
      for ((from, to) <- edges) graph.addEdge(from, to)
      graph
    }

    def apply[T, U](nodes: List[T], edges: List[(T, T, Option[U])]): Graph[T, U] = {
      val graph = new Graph[T, U]()
      for (nodeValue <- nodes) graph.addNode(nodeValue)

      for ((n1, n2, value) <- edges) value match {
        case Some(edgeValue) => graph.addEdge(n1, n2, edgeValue)
        case None => graph.addEdge(n1, n2)
      }

      graph
    }

    def termLabel[T, U](nodes: List[T], edges: List[(T, T, U)]): Graph[T, U] =
      apply(nodes, edges map { case (n1, n2, v) => (n1, n2, Some(v))})


    def fromString(str: String): Graph[Char, Char] = p80(str)
    def fromStringNum(str: String): Graph[Char, Int] = {
      val parsedGraph = p80(str)
      Graph(parsedGraph.nodes.keys.toList, parsedGraph.edges map {
        case parsedGraph.Edge(parsedGraph.Node(n1), parsedGraph.Node(n2), Some(v)) => (n1, n2, Some(v.asDigit))
      })
    }
  }

  object Digraph {
    def fromString(str: String): Digraph[Char, Char] = p80_2(str)
    def apply[T, U](nodes: List[T], edges: List[(T, T, Option[U])]) = {
      val graph = new Digraph[T, U]()
      for (nodeValue <- nodes) graph.addNode(nodeValue)

      for ((n1, n2, value) <- edges) value match {
        case Some(edgeValue) => graph.addArc(n1, n2, edgeValue)
        case None => graph.addArc(n1, n2)
      }

      graph
    }
  }

  implicit class GraphExt[T, U](gr: Graph[T, U]){
  }

  implicit class DigraphExt[T, U](gr: Digraph[T, U]){
  }

  implicit class GraphBaseExt[T, U](gr: GraphBase[T, U]) {
    def addNodeIfMissing(value: T) = {
      if (!gr.nodes.contains(value)) {
        gr.addNode(value)
      }
    }

    def toTermForm = gr.nodes.keys.toList -> (gr.edges map { case gr.Edge(n1, n2, value) => (n1.value, n2.value, value) })

    def toAdjacentForm = {
      val edges = (for (node <- gr.nodes.values;
                       edge <- gr.edges
                       if edge.n1 == node) yield node.value -> (edge.n2, edge.value)
                   ) groupBy { _._1 } mapValues { case x => x.map {
          case (k, (gr.Node(value), Some(v))) => (value.toString, v.toString)
          case (k, (gr.Node(value), None)) => (value.toString, "?")
        }.toList
      }

      val loneNodes = (gr.nodes.values
        filter { node => gr.edges.forall(x => x.n1 != node)}
        map  { node => (node.value, List.empty) })
      edges.toList ::: loneNodes.toList
    }

    def findPaths(from: T, to: T):List[List[T]] = p81(gr, from, to)
  }

  --------------("P80. Conversions.")

  def p80(str: String): Graph[Char, Char] = {
    val graph = new Graph[Char, Char]
    val edgeMap = str.drop(1).dropRight(1).split(", ") map {_.toList}
    edgeMap map {
      case from :: '-' :: to :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addEdge(from, to)
      case from :: '-' :: to :: '/' :: value ::Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addEdge(from, to, value)
      case node :: Nil => graph.addNodeIfMissing(node)
      }
    graph
  }

  def p80_2(str: String): Digraph[Char, Char] = {
    val graph = new Digraph[Char, Char]
    val edgeMap = str.drop(1).dropRight(1).split(", ") map {_.toList}
    edgeMap map {
      case from :: '>' :: to :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to)
      case from :: '>' :: to :: '/' :: value :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to, value)
      case to :: '<' :: from :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to)
      case to :: '<' :: from :: '/' :: value :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to, value)
      case from :: '-' :: to :: Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to)
        graph.addArc(to, from)
      case from :: '-' :: to :: '/' :: value ::Nil =>
        graph.addNodeIfMissing(from)
        graph.addNodeIfMissing(to)
        graph.addArc(from, to, value)
        graph.addArc(to, from, value)
      case node :: Nil => graph.addNodeIfMissing(node)
    }
    graph
  }

  out(p80("[b-c, f-c, g-h, d, f-b, k-f, h-g]")) ==@ "[h-g, k-f, f-b, g-h, f-c, b-c, d]"
  out(p80_2("[b>c, f>c, g>h, d, f<b, k<f, h<g]")) ==@ "[g>h, f>k, b>f, g>h, f>c, b>c, d]"
  out(p80("[b-c/e, f-c/1, g-h/2, d, f-b/3, k-f, h-g]")) ==@ "[h-g, k-f, f-b/3, g-h/2, f-c/1, b-c/e, d]"
  out(p80_2("[b>c/1, f>c/e, g>h/2, d, f<b, k<f, h<g/8]")) ==@ "[g>h/8, f>k, b>f, g>h/2, f>c/e, b>c/1, d]"         // Notice g>h twice, once labeled 2, the other one - 8

  out(p80("[b-c, f-c, g-h, d, f-b, k-f, h-g]").toTermForm)
  out(Digraph.fromString("[p>q/9, m>q/7, k, p>m/5]").toAdjacentForm)

  --------------("P81. Path from one node to another one")
  def p81[T, U](graph: GraphBase[T, U], from: T, to: T): List[List[T]] = {
    def inner(node: graph.Node, visited: Set[graph.Node]): List[List[T]] = {
      val nodesToGoTo = graph.edges collect {
        case graph.Edge(`node`, to : graph.Node, value) if !visited.contains(node) => to
      }

      val finishList = nodesToGoTo collect {
        case graph.Node(value) if value == to => node.value :: value :: Nil
      }

      finishList ::: (nodesToGoTo filter {
          case graph.Node(value) => value != to
        } flatMap { x => inner(x, visited + node)
        } map { x => node.value :: x })
    }

    inner(graph.nodes(from), Set.empty)
  }

  def p81_2[T, U](graph: GraphBase[T, U], from: T, to: T): List[List[T]] = {
    def findPathsR(curNode: graph.Node, curPath: List[T]): List[List[T]] = {
      if (curNode.value == to) List(curPath)
      else curNode.adj.map(graph.edgeTarget(_, curNode).get).filter(n => !curPath.contains(n.value)).flatMap(n => findPathsR(n, n.value :: curPath))
    }

    findPathsR(graph.nodes(from), List(from)).map(_.reverse)
  }

  out(Digraph.fromString("[p>q/9, m>q/7, k, p>m/5]").findPaths('p', 'q')) ==== List(List('p', 'q'), List('p', 'm', 'q'))
  out(p81_2(Digraph.fromString("[p>q/9, m>q/7, k, p>m/5]"), 'p', 'q')) ==== List(List('p', 'm', 'q'), List('p', 'q'))

  --------------("P82. Cycle from a given node.")
  def p82[T, U](graph: GraphBase[T, U], target: T): List[List[T]] = {
    def inner(node: graph.Node, visited: Set[graph.Edge]): List[List[T]] =
      graph.edges filter {
        x => !visited.contains(x)
      } flatMap {
        case graph.Edge(`node`, to, _) if to.value == target => List(Nil)
        case edge@graph.Edge(`node`, to : graph.Node, _) => inner(to, visited + edge)
        case _ => Nil
      } map {
        x => node.value :: x
      }

    inner(graph.nodes(target), Set.empty) map { x => x ::: (target :: Nil) }
  }
  out(p82(Digraph.fromString("[f>a, a>f, f>b, b>c, c>d, d>f, c>f]"), 'f'))
  out(p82(Digraph.fromString("[b<c, f>c, g-h, d, f<b, k-f, h-g, f>e, e>g, g>h, h>f]"), 'f'))

  --------------("P83. Construct all spanning trees.")

  val tree = Graph.term(List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
    List(('a', 'b'), ('a', 'd'), ('b', 'c'), ('b', 'e'),
      ('c', 'e'), ('d', 'e'), ('d', 'f'), ('d', 'g'),
      ('e', 'h'), ('f', 'g'), ('g', 'h')))

  import scala.collection.mutable
  def p83(graph: Graph[Char, Char]): List[Graph[Char, Char]] = {
    def isGraphConnected(graph: Graph[Char, Char]): Boolean = {
      // BFS in OO style.
      val visitedNodes = mutable.Set[graph.Node]()
      val visitedEdges = mutable.Set[graph.Edge]()
      val scheduled = mutable.Queue[graph.Node]()
      val (_, startingNode) = graph.nodes.head
      scheduled += startingNode
      visitedNodes += startingNode
      for (elem <- scheduled){
        val nodesToVisit = graph.edges filter {!visitedEdges.contains(_)} collect {
          case e@graph.Edge(`elem`, n : graph.Node, _) => { visitedEdges += e; n }
          case e@graph.Edge(n : graph.Node, `elem`, _) => { visitedEdges += e; n }
        }

        if (nodesToVisit.exists(visitedNodes.contains(_))) {
          // We found a visited node via not visited edges paths - not a tree.
          return false
        }

        visitedNodes ++= nodesToVisit
        scheduled ++= nodesToVisit
      }

      graph.nodes.values.toSet == visitedNodes
    }

    def permutateEdges(lst: List[graph.Edge]): List[List[graph.Edge]] = lst match {
      case Nil => List(Nil)
      case head :: tail => permutateEdges(tail) ::: (permutateEdges(tail) map { head :: _ })
    }

    for (edgeMap : List[graph.Edge] <- permutateEdges(graph.edges);
         newGraph = Graph[Char, Char](graph.nodes.keys.toList, edgeMap map {case graph.Edge(graph.Node(n1), graph.Node(n2), value) => (n1, n2, value)})
        if isGraphConnected(newGraph)) yield newGraph
    }

  out(p83(Graph.fromString("[a-b, b-c, a-c]"))) ==== List(Graph.fromString("[b-c, a-b]"), Graph.fromString("[a-c, a-b]"), Graph.fromString("[a-c, b-c]"))

  def p83_2(graph: Graph[Char, Char]): List[Graph[Char, Char]] = {
    def listEdgeEquals(l: List[graph.Edge], s: Set[graph.Edge]): Boolean =
      l.size == s.size && l.forall(l_edge => s.exists(s_edge => (l_edge.n1 == s_edge.n1 && l_edge.n2 == s_edge.n2) || (l_edge.n2 == s_edge.n1 && l_edge.n1 == s_edge.n2)))

    @tailrec
    def removeDuplicates(l: List[List[graph.Edge]], filteredObjects: Set[Set[graph.Edge]]): List[List[graph.Edge]] = l match {
      case Nil => filteredObjects.toList.map(_.toList)
      case head :: tail if filteredObjects.exists(listEdgeEquals(head, _)) => removeDuplicates(tail, filteredObjects)
      case head :: tail => removeDuplicates(tail, filteredObjects + head.toSet)
    }

    def collectSpanTrees(fringe: Set[graph.Node], visitedNodes: Set[graph.Node], visitedEdges: Set[graph.Edge]): List[List[graph.Edge]] =
      if (visitedNodes.size == graph.nodes.size) {
        List(visitedEdges.toList)
      } else {
      val proposedData = graph.edges filter {!visitedEdges.contains(_)} collect {
        case e@graph.Edge(n1: graph.Node, n2: graph.Node, _) if fringe.contains(n1) && !visitedNodes.contains(n2) => (e, n2, n1)
        case e@graph.Edge(n1: graph.Node, n2: graph.Node, _) if fringe.contains(n2) && !visitedNodes.contains(n1) => (e, n1, n2)
      }

      for ((newEdge, newNode, oldNode) <- proposedData;
           newGraph <- collectSpanTrees(fringe + newNode, visitedNodes + newNode, visitedEdges + newEdge))
         yield newGraph
    }

    val startNode = graph.nodes.values.head
    val toList = removeDuplicates(collectSpanTrees(Set(startNode), Set(startNode), Set.empty), Set.empty)
    toList map {
      edgeList => Graph[Char, Char](graph.nodes.keys.toList, edgeList map {case graph.Edge(graph.Node(n1), graph.Node(n2), v) => (n1, n2, v)})
    }
  }

  out(p83_2(Graph.fromString("[a-b, b-c, a-c]"))) ==== List(Graph.fromString("[b-c, a-c]"), Graph.fromString("[a-b, a-c]"), Graph.fromString("[a-b, b-c]"))

  def p83_3[T, U](graph: Graph[T, U]) = {
    def edgeConnectsToGraph[T,U](e: graph.Edge, nodes: List[graph.Node]): Boolean =
      !(nodes.contains(e.n1) == nodes.contains(e.n2))

    def spanningTreesR(graphEdges: List[graph.Edge], graphNodes: List[graph.Node], treeEdges: List[graph.Edge]): List[Graph[T,U]] = {
      if (graphNodes == Nil) List(Graph(graph.nodes.keys.toList, treeEdges.map(_.toTuple)))
      else if (graphEdges == Nil) Nil
      else graphEdges.filter(edgeConnectsToGraph(_, graphNodes)) flatMap { ge =>
        spanningTreesR(graphEdges.filterNot(_ == ge),
          graphNodes.filter(graph.edgeTarget(ge, _) == None),
          ge :: treeEdges)
      }
    }

    spanningTreesR(graph.edges, graph.nodes.values.toList.tail, Nil).distinct
  }

  out(p83_3(Graph.fromString("[a-b, b-c, a-c]"))) ==== List(Graph.fromString("[a-c, b-c]"), Graph.fromString("[a-c, a-b]"), Graph.fromString("[b-c, a-b]"))

  --------------("P84. Construct the minimal spanning tree (with Prim's Algorithm)")

  def p84(graph: Graph[Char, Int]) = {
    @tailrec
    def inner(nodes: Set[graph.Node], edges: Set[graph.Edge]): Set[graph.Edge] =
      if (nodes.size == graph.nodes.size) {
        edges
      } else {
        val (selectedNode, selectedEdge) = graph.edges.toSet diff edges collect {
            case e@graph.Edge(n1: graph.Node, n2: graph.Node, _) if nodes.contains(n1) && !nodes.contains(n2) => (n2, e)
            case e@graph.Edge(n1: graph.Node, n2: graph.Node, _) if nodes.contains(n2) && !nodes.contains(n1) => (n1, e)
          } minBy {
          case (_, graph.Edge(_, _, Some(v))) => v
          }
        inner(nodes + selectedNode, edges + selectedEdge)
      }

    Graph(graph.nodes.keys.toList, inner(Set(graph.nodes.head._2), Set.empty).toList map {case graph.Edge(graph.Node(n1), graph.Node(n2), Some(v)) => (n1, n2, Some(v))})
  }

  val t_84 = Graph.termLabel(
    List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'),
    List(('a', 'b', 5), ('a', 'd', 3), ('b', 'c', 2), ('b', 'e', 4),
      ('c', 'e', 6), ('d', 'e', 7), ('d', 'f', 4), ('d', 'g', 3),
      ('e', 'h', 5), ('f', 'g', 4), ('g', 'h', 1)))

  out(p84(t_84)) ==== Graph.fromStringNum("[g-h/1, b-e/4, f-g/4, e-h/5, d-g/3, a-d/3, b-c/2]")
  out(p84(Graph.fromStringNum("[a-b/1, b-c/2, a-c/3]"))) ==== Graph.fromStringNum("[a-b/1, b-c/2]")


  --------------("P85. Graph isomorphism.")

  def p85(a: Graph[Char, Char], b: Graph[Char, Char]): Boolean = {
    def getConnectedNodes(graph: Graph[Char, Char])(node: graph.Node) =
      graph.edges collect {
        case graph.Edge(n1, n2, _) if n1 == node => n2
        case graph.Edge(n1, n2, _) if n2 == node => n1
      }

    def areNodesUniquilyConnected[T](l: List[T], connectedTo: List[T]) = {
      l == Nil || (l.distinct.size == l.size && l.forall(connectedTo.contains(_)))
    }

    def isValidArity(nodeA: a.Node, nodeB: b.Node) =
      getConnectedNodes(a)(nodeA).size == getConnectedNodes(b)(nodeB).size

    def inner(mapped: List[(a.Node, b.Node)], aLeft: List[a.Node], bLeft: List[b.Node]): Boolean =
      if (aLeft == Nil && bLeft == Nil) true else
      (for (bNode <- bLeft;
            bConnectedNodes = getConnectedNodes(b)(bNode);
            aNode <- aLeft;
            bSupposedlyConnectedNodes = getConnectedNodes(a)(aNode) map {node => mapped collectFirst { case (`node`, v) => v }} collect { case Some(v) => v}
            if isValidArity(aNode, bNode) && areNodesUniquilyConnected(bSupposedlyConnectedNodes, bConnectedNodes))
                yield inner((aNode, bNode) :: mapped, aLeft diff List(aNode), bLeft diff List(bNode))
        ).exists(identity)

    inner(Nil, a.nodes.values.toList, b.nodes.values.toList)
  }

  def p85_c(a: Graph[Char, Char], b: Graph[Char, Char]) = {
    val ra = p85(a, b)
    val rb = p85(a, b)
    assert(ra == rb)
  }

  p85_c(Graph.fromString("[a-b]"), Graph.fromString("[d-e]"))
  p85_c(Graph.fromString("[a-b, b-c]"), Graph.fromString("[d-e, e-g]"))
  p85_c(Graph.fromString("[a-b, b-c]"), Graph.fromString("[d-e, e-d]"))
  p85_c(Graph.fromString("[a-b, b-c, c-a]"), Graph.fromString("[d-e, e-g, g-d]"))
  p85_c(Graph.fromString("[a-b, b-c, c-a]"), Graph.fromString("[d-e, e-g, g-e]"))

  def p85_2[R,S](g: GraphBase[R, S], o: GraphBase[R, S]): Boolean = {
    // Build a lazy list so we only have to evaluate as much as necessary.
    def listMappings(tNodes: List[g.Node], oNodes: List[o.Node]) =
      tNodes.view.flatMap(tn => oNodes.view.map((tn, _)))
    // Used on partially-filled isomorphisms to weed out some early.
    def isValidMapping(iso: Map[g.Node,o.Node]): Boolean =
      g.nodes.values forall {tn =>
        !iso.contains(tn) ||
          tn.neighbors.filter(iso.contains).forall(tnn => iso(tn).neighbors.contains(iso(tnn)))
      }
    def isValidCompleteMapping(iso: Map[g.Node,o.Node]): Boolean =
      g.nodes.values forall {tn =>
        Set(tn.neighbors.map(x => iso.apply(x)): _*) == Set(iso(tn).neighbors: _*)
      }
    def isIsomorphicToR(tNodes: List[g.Node], oNodes: List[o.Node], iso: Map[g.Node,o.Node]): Boolean =
      if (tNodes == Nil) isValidCompleteMapping(iso)
      else listMappings(tNodes, oNodes).filter(p => isValidMapping(iso + p)) exists {p =>
        isIsomorphicToR(tNodes diff List(p._1), oNodes diff List(p._2), iso + p)
      }
    isIsomorphicToR(g.nodes.values.toList, o.nodes.values.toList, Map())
  }

  --------------("P86. Node degree and graph coloration.")

  def p86[T, U](g: Graph[T, U])(node: g.Node) = node.adj.size
  def p86[T, U](g: Graph[T, U])(s: T): Option[Int] = g.nodes.get(s).map(_.adj.size)

  def p86_2[T, U](g: Graph[T, U]): List[g.Node] = g.nodes.values.toList.sortBy(-_.adj.size)

  out(p86_2(Graph.fromString("[a-b, b-c, a-c, a-d]"))) ==@ "List(Node(a), Node(c), Node(b), Node(d))"

  def p86_3[T, U](g: Graph[T, U]): List[(g.Node, Int)] = {
    def inner(notColored: List[g.Node], color: Int) : List[(g.Node, Int)] =
      notColored match {
        case Nil => Nil
        case head :: tail =>
          val (left, colored) = tail span {_.adj.exists{ case g.Edge(n1, n2, _) => n1 == head || n2 == head}}
          inner(left, color + 1) ::: ((head :: colored) map {x => (x, color)})
      }

    val p = p86_2(g)
    inner(p, 1)
  }

  out(p86_3(Graph.fromString("[a-b, b-c, a-c, a-d]")))

  --------------("P87. Depth-first order graph traversal.")

  def p87[T, U](g: Graph[T, U], from: T): List[g.Node] = {
    def inner(current: g.Node, visited: Set[g.Node]): (Set[g.Node], List[g.Node]) =
      current.neighbors.foldLeft((visited, List.empty[g.Node])){
          case ((visitedAcc, traversalAcc), node) =>
         if (visitedAcc.contains(node))
           (visitedAcc, traversalAcc)
         else {
           val (newVisited, newTrav) = inner(node, visitedAcc + node)
           (newVisited, node :: newTrav)
         }
      }

    val firstNode = g.nodes(from)
    val (_, result) = inner(firstNode, Set(firstNode))
    firstNode :: result
  }

  out(p87(Graph.fromString("[a-b, b-c, e, a-c, a-d]"), 'd')) ==@ "List(Node(d), Node(a), Node(c), Node(b))"

  --------------("P88. Connected components")

  def p88[T, U](g: Graph[T, U]): List[Graph[T, U]] = {
    def createGraph(nodes: List[g.Node], edges: List[g.Edge]) =
      Graph(nodes.map(_.value), g.edges.collect { case g.Edge(n1@g.Node(nv1), n2@g.Node(nv2), v) if nodes.contains(n1) && nodes.contains(n2) => (nv1, nv2, v)})

    val nodes = p87(g, g.nodes.values.head.value)
    if (g.nodes.size != nodes.size) {
      createGraph(nodes, g.edges) :: p88(createGraph(g.nodes.values.toList diff nodes, g.edges))
    } else {
      List(g)
    }
  }

  out(p88(Graph.fromString("[a-b, c]"))) ==@ "List([c], [a-b])"
  out(p88(Graph.fromString("[a-b, b-c, d-e]"))) ==@ "List([d-e], [a-b, b-c])"

  --------------("P89. Bipartite graphs.")

  def p89[T, U](g: Graph[T, U]): Boolean = {
    @tailrec
    def inner(edges: List[(T, T)], setA: Set[T], setB: Set[T]): Boolean = edges match {
      case Nil => true
      case (n1, n2) :: tail if !setA.contains(n1) && !setB.contains(n2) => inner(tail, setA + n2, setB + n1)
      case (n1, n2) :: tail if !setA.contains(n2) && !setB.contains(n1) => inner(tail, setA + n1, setB + n2)
      case _ => false
    }

    inner(p88(g).flatMap(x => x.edges.map(y => y.n1.value -> y.n2.value)), Set.empty, Set.empty)
  }

  out(p89(Graph.fromString("[a-b, b-c, c-a]"))) ==== false
  out(p89(Graph.fromString("[a-b, b-c, d]"))) ==== true
  out(p89(Graph.fromString("[a-b, b-c, d, e-f, f-g, g-e, h]"))) ==== false
}

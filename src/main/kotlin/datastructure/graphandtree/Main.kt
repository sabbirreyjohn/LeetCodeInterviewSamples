package datastructure.graphandtree

import com.google.gson.Gson

fun main() {
    var tree = BinarySearchTree()
   /* tree.insert(9)
    tree.insert(4)
    tree.insert(6)
    tree.insert(20)
    tree.insert(170)
    tree.insert(15)
    tree.insert(1)

   var queue = ArrayDeque<Node?>()
   queue.add(tree.root)
    println(
        tree.DFSInOrder(tree.root!!,  mutableListOf())
    )*/

    tree.insert(2)
    tree.insert(1)
    tree.insert(3)

    println(tree.isValidBST(tree.root))
    /*var graph = Graph()
    graph.addVertex(Node(0))
    graph.addVertex(Node(1))
    graph.addVertex(Node(2))
    graph.addVertex(Node(3))
    graph.addVertex(Node(4))
    graph.addVertex(Node(5))
    graph.addVertex(Node(6))

    graph.addEdge(Node(3), Node(1))
    graph.addEdge(Node(3), Node(4))
    graph.addEdge(Node(4), Node(2))
    graph.addEdge(Node(4), Node(5))
    graph.addEdge(Node(1), Node(2))
    graph.addEdge(Node(1), Node(0))
    graph.addEdge(Node(0), Node(2))
    graph.addEdge(Node(6), Node(5))

    graph.showConnections()*/

}


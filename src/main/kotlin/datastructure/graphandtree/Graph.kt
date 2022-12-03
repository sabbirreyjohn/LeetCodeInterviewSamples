package datastructure.graphandtree

class Graph(var numberOfNodes: Int = 0, var adjacentList: MutableMap<Node, MutableList<Node>> = mutableMapOf()) {

    fun addVertex(node: Node) {
        adjacentList.put(node, mutableListOf())
        numberOfNodes++
    }

    fun addEdge(node1: Node, node2: Node) {
        adjacentList.get(node1).also {
            it?.add(node2)
        }
        adjacentList.get(node2).also {
            it?.add(node1)
        }
    }

    fun showConnections() {
        val allNodes = adjacentList.keys
        allNodes.forEach { node ->
            var nodeConnection = adjacentList[node]
            var connections = ""
            nodeConnection?.forEach { vertex ->
                connections += "${vertex.value} "
            }
            println("${node.value}-->$connections")
        }
    }
}
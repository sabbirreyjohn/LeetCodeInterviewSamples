package datastructure.graphandtree

import singlyLinkedList.stack.Queue


class BinarySearchTree {
    var root: Node? = null

    fun insert(value: Int): BinarySearchTree {
        var newNode = Node(value)
        if (root == null) {
            root = newNode
            return this
        }
        var currentNode = root
        while (true) {
            if (value < currentNode?.value!!) {
                if (currentNode.left == null) {
                    currentNode.left = newNode
                    return this
                }
                currentNode = currentNode.left
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode
                    return this
                }
                currentNode = currentNode.right
            }
        }

    }

    fun search(value: Int): Node? {
        root?.let { rootNode ->
            var currentNode: Node? = rootNode
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left ?: null
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right ?: null
                } else if (value == currentNode.value) {
                    return currentNode
                }
            }
        }
        return null
    }

    fun remove(value: Int): BinarySearchTree? {
        if (root == null) {
            return null
        }
        var currentNode = root
        var parentNode: Node? = null
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.left
            } else if (value > currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.right
            } else if (value == currentNode.value) {
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left
                    }

                } else if (currentNode.right!!.left == null) {

                } else {

                }
            }
        }
        return this
    }

    fun breadthFirstSearch(): List<Int> {
        var currentNode = root
        var list = mutableListOf<Int>()
        var queue = ArrayDeque<Node?>()
        queue.add(currentNode)
        while (queue.size > 0) {
            currentNode = queue.removeFirst()
            list.add(currentNode?.value!!)
            currentNode.left?.let {
                queue.add(it)
            }
            currentNode.right?.let {
                queue.add(it)
            }
        }
        return list
    }

    fun isValidBST(root: Node?): Boolean {
        var currentNode = root
        var currentNodeValue: Int?
        var queue = ArrayDeque<Node?>()
        queue.add(currentNode)
        while (queue.size > 0) {
            currentNode = queue.removeFirst()
            if(currentNode?.value== null)
                return false
            currentNodeValue = currentNode?.value
            currentNode?.left?.let {
                if(it.value > currentNodeValue!!){
                    return false
                }
                queue.add(it)
            }
            currentNode?.right?.let {
                if(it.value < currentNodeValue!!){
                    return false
                }
                queue.add(it)
            }
        }
        return true
    }

    fun breadthFirstSearchRecursive(queue: ArrayDeque<Node?>, list: MutableList<Int>): MutableList<Int> {
        if (queue.size == 0) {
            return list
        }
        var currentNode = queue.removeFirst()
        list.add(currentNode?.value!!)
        currentNode.left?.let {
            queue.add(it)
        }
        currentNode.right?.let {
            queue.add(it)
        }
        return breadthFirstSearchRecursive(queue, list)
    }

    fun DFSInOrder(root: Node, list: MutableList<Int>): MutableList<Int> {
        root.left?.let {
            DFSInOrder(it, list)
        }
        list.add(root.value)
        root.right?.let {
            DFSInOrder(it, list)
        }
        return list
    }

    fun DFSPreOrder(root: Node, list: MutableList<Int>): MutableList<Int> {
        list.add(root.value)
        root.left?.let {
            DFSPreOrder(it, list)
        }
        root.right?.let {
            DFSPreOrder(it, list)
        }
        return list
    }

    fun DFSPostOrder(root: Node, list: MutableList<Int>): MutableList<Int> {
        root.left?.let {
            DFSPostOrder(it, list)
        }
        root.right?.let {
            DFSPostOrder(it, list)
        }
        list.add(root.value)
        return list
    }
}
package singlyLinkedList

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    override fun toString(): String {
        return if (size == 0) {
            "empty linked list"
        } else {
            head.toString()
        }
    }

    fun append(value: T): LinkedList<T> {
        var newNode = Node(value)
        tail?.next = newNode
        tail = newNode
        if (head == null) {
            head = tail
        }
        size++
        return this
    }

    fun prepend(value: T): LinkedList<T> {
        var newNode = Node(value)
        newNode.next = head
        head = newNode
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun insert(pos: Int, value: T): LinkedList<T> {
        var newNode = Node(value)
        if (pos == 0) {
            prepend(value)
            return this
        } else if (pos >= size) {
            append(value)
            return this
        }
        var leader = nodeAt(pos - 1)
        var follower = leader?.next
        leader?.next = newNode
        newNode.next = follower
        size++
        return this

    }

    fun remove(pos: Int): LinkedList<T> {
        var leader = nodeAt(pos - 1)
        var follower = leader?.next
        leader?.next = follower?.next
        size--
        return this
    }

    private fun nodeAt(pos: Int): Node<T>? {
        var currentNode = head
        var currentPosition = 0;
        while (currentNode != null && currentPosition < pos) {
            currentNode = currentNode.next
            currentPosition++
        }
        return currentNode
    }

    fun reverse(): LinkedList<T> {
        if (this.head?.next == null) {
            return this
        }
        var prev: Node<T>? = null
        var current = head
        var next: Node<T>?
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
        return this
    }

}
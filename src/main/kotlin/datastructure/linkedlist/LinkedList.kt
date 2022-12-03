package linkedlist

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun insert(pos: Int, value: T): LinkedList<T> {
        var newNode = Node(value = value)
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
        newNode.previous = leader
        newNode.next = follower
        follower?.previous = newNode
        size++
        return this
    }

    fun remove(pos: Int): LinkedList<T> {
        if(pos==0){
            head = head?.next
            size--
            return this
        }
        var leader = nodeAt(pos - 1)
        var follower = leader?.next
        leader?.next = follower?.next
        follower?.previous = leader
        size--
        return this
    }

     fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun prepend(value: T): LinkedList<T> {
        var newNode = Node(value = value)
        newNode.next = head
        head?.previous = newNode
        head = newNode
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        var newNode = Node(value = value)
        newNode.previous = tail
        tail?.next = newNode
        tail = newNode
        if (head == null) {
            head = tail
        }
        size++
        return this
    }
}
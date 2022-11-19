package singlyLinkedList.stack

import singlyLinkedList.Node

class Stack<T> {
    var top: Node<T>? = null
    var bottom: Node<T>? = null
    var size = 0

    fun push(value: T): Stack<T> {
        var newNode = Node(value)
        if (size == 0) {
            top = newNode
            bottom = newNode
        } else {
            var oldTop = top
            top = newNode
            top?.next = oldTop

        }
        size++
        return this
    }

    fun pop(): Stack<T>? {
        if (size == 0) {
            return null
        }
        if(top == bottom){
            bottom = null
        }
        top = top?.next
        size--
        return this

    }

    fun peek(): T? {
        return top?.value
    }
}
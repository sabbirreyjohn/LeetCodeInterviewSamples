package singlyLinkedList.stack

import singlyLinkedList.Node

class Queue<T> {
    var first: Node<T>? = null
    var last: Node<T>? = null
    var length =0

    fun enqueue(value: T): Queue<T>{
        var newNode = Node(value)
        if(length==0){
            first = newNode
            last = newNode
        }else{
            last?.next = newNode
            last= newNode
        }
        length++
        return this
    }

    fun peek(): Node<T>?{
        return first
    }

    fun dequeue(): Queue<T>?{
        if(length==0){
            return null
        }
        if(first==last){
            last = null
        }
        first = first?.next
        length--
        return this
    }
    fun shift(): Node<T>?{
        if(length==0){
            return null
        }
        if(first==last){
            last = null
        }
        var temp = first
        first = first?.next
        length--
        return temp
    }
}
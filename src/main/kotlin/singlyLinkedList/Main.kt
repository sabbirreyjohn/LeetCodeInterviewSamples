package singlyLinkedList

import singlyLinkedList.stack.Stack


fun main() {
//    var list = LinkedList<Int>()
//
//    list.append(1)
//    list.append(2)
//    list.append(3)
//    println(list.reverse())

    var stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.peek())
}
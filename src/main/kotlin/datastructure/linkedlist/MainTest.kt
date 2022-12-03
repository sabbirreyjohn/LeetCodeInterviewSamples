package linkedlist

fun main() {
    var node1 = Node(value = 1)
    var node2 = Node(value = 2)
    var node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    var linkedList = LinkedList<Int>()
    linkedList.append(1)
    linkedList.append(2)
    linkedList.insert(1,3)


    println(linkedList)
}
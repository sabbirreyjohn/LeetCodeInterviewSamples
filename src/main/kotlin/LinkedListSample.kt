fun main() {

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var newList: ListNode? = ListNode(0)
    newList?.next = head
    var current = newList

    while(newList?.next!=null){
        if(current?.`val` == current?.next?.`val`){
            current = current?.next
            newList.next = current
        }
    }

    return newList
}
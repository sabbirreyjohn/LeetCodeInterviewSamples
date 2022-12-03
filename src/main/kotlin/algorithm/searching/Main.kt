package algorithm.searching

fun main() {
    var list = intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
    println(binarySearchIterative(list, 99))

}

fun binarySearchRecursive(array: IntArray, num: Int): Boolean {
    array.sort()
    if (array.size < 1)
        return false
    var midIndex = (array.size - 1) / 2
    if (num < array[midIndex]) {
        return binarySearchRecursive(array.sliceArray(0..midIndex), num)
    } else if (num > array[midIndex]) {
        return binarySearchRecursive(array.sliceArray(midIndex + 1..array.size - 1), num)
    } else {
        return true
    }
}

fun binarySearchIterative(array: IntArray, num: Int): Int {
    array.sort()
    var leftIndex = 0
    var rightIndex = array.size - 1
    var midIndex = ((rightIndex - leftIndex) / 2) + leftIndex
    while (leftIndex <= rightIndex) {
        if (num < array[midIndex]) {
            rightIndex = midIndex - 1
        } else if (num > array[midIndex]) {
            leftIndex = midIndex + 1
        } else {
            return midIndex
        }
        midIndex = ((rightIndex - leftIndex) / 2) + leftIndex
    }
    return -1
}
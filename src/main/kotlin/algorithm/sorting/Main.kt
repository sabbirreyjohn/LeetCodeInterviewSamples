package algorithm.sorting

import kotlin.math.floor

fun main() {
    mergeSort(intArrayOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)).forEach {
        print("$it ")
    }

    intArrayOf(2,5,9,1,6,4,7,2,3,9,0,5).sort()

}

fun bubbleSort(array: IntArray): IntArray {
    for (i in 0..array.size - 1) {
        for (j in i + 1..array.size - 1) {
            if (array[i] > array[j]) {
                var temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }
    return array
}

fun selectionSort(array: IntArray): IntArray {
    // var minIndex = 0
    for (i in 0..array.size - 1) {
        var currentMin = array[i]
        var minIndex = i
        for (j in i + 1..array.size - 1) {
            if (array[j] < currentMin) {
                currentMin = array[j]
                minIndex = j
            }
        }
        var temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
    return array
}

fun insertionSort(array: IntArray): IntArray {
    for (i in array.indices) {
        var j = i
        while (j > 0 && array[j] < array[j - 1]) {
            var temp = array[j]
            array[j] = array[j - 1]
            array[j - 1] = temp
            j--
        }
    }
    return array
}

fun mergeSort(array: IntArray): IntArray {
    if (array.size == 1) {
        return array
    }
    var length = array.size
    var middle = (length-1)/2
    var leftArray = array.sliceArray(0..middle)
    var rightArray = array.sliceArray(middle + 1..length - 1)

    return merge(mergeSort(leftArray), mergeSort(rightArray))
}

private fun merge(leftArray: IntArray, rightArray: IntArray): IntArray {
    var resultArray = mutableListOf<Int>()
    var leftArrayIndex = 0
    var rightArrayIndex = 0

    while (leftArrayIndex < leftArray.size && rightArrayIndex < rightArray.size) {
        if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
            resultArray.add(leftArray[leftArrayIndex])
            leftArrayIndex++
        } else {
            resultArray.add(rightArray[rightArrayIndex])
            rightArrayIndex++
        }
    }

    while (leftArrayIndex < leftArray.size) {
        resultArray.add(leftArray[leftArrayIndex])
        leftArrayIndex++
    }

    while (rightArrayIndex < rightArray.size) {
        resultArray.add(rightArray[rightArrayIndex])
        rightArrayIndex++
    }
    return resultArray.toIntArray()
}

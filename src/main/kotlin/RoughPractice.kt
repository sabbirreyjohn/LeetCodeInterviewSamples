fun main() {
    print(hasPairWithSum(intArrayOf(1,2,3,4),3))
}

fun hasDuplicate(array1: IntArray, array2: IntArray): Boolean {
    var map = mutableMapOf<Int, Boolean>()
    for (i in array1.indices) {
        map.put(array1[i], true)
    }
    for (i in array2.indices) {
        if (map.get(array2[i]) == true)
            return true
    }
    return false
}

fun hasPairWithSum(array: IntArray, sum: Int): Boolean {
    //1,2,3,4   3
    var set = mutableSetOf<Int>()
    for (i in array.indices) {
        if (set.contains(array[i])) return true
        set.add(sum - array[i])
    }
    return false
}
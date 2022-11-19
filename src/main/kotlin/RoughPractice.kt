import java.lang.Exception

fun main() {

//    var x = 10
//    changePrimitive(x)
//    println(x)

    var p= Pass(5)
    println(p.value)
    changeObject(p)
    println(p.value)
}

fun changePrimitive(num: Int) {
    var num = num
    num += 10
}

fun changeObject(pass: Pass) {
    pass.value = 10
}

data class Pass(var value: Int)

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

fun mergeArray(array1: IntArray, array2: IntArray): IntArray {
//    var resultArray = array1+array2
//    for(i in 0..resultArray.lastIndex){
//        for(j in i+1..resultArray.lastIndex){
//            if(resultArray[i]>resultArray[j]){
//                var temp = resultArray[i]
//                resultArray[i] = resultArray[j]
//                resultArray[j]= temp
//            }
//        }
//    }
//    return resultArray

    var resulArray = mutableListOf<Int>()
    var currentArray1Item = array1[0]
    var currentArra2Item = array2[0]
    var i = 1
    var j = 1

    while (currentArray1Item >= 0 || currentArra2Item >= 0) {
        if (currentArra2Item != -1 || currentArray1Item < currentArra2Item) {
            resulArray.add(currentArray1Item)
            try {
                currentArray1Item = array1[i]
            } catch (e: Exception) {
                currentArray1Item = -1
            }
            i++
        } else {
            resulArray.add(currentArra2Item)
            try {
                currentArra2Item = array2[j]
            } catch (e: Exception) {
                currentArra2Item = -1
            }
            j++
        }

    }
    return resulArray.toIntArray()
}

fun maxSubArray(nums: IntArray): Int {
    var max_so_far = nums[0]
    var current_max = nums[0]
    for (i in 1..nums.lastIndex) {
        current_max = Math.max(nums[i], current_max + nums[i])
        max_so_far = Math.max(current_max, max_so_far)
    }

    var v =

        return max_so_far
}

fun firstRecurringNumber(nums: IntArray): Int {
    // 2, 1, 1, 2, 3, 5, 1, 2, 4
//    var map = mutableMapOf<Int, Int>()
//    for (i in nums.indices) {
//        if(map.containsKey(nums[i]))
//        return nums[i]
//        map.put(nums[i], 0)
//    }
//    return -1

    var keyPosition = Int.MAX_VALUE
    for (i in 0..nums.lastIndex) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] == nums[j]) {
                if (j < keyPosition)
                    keyPosition = j
            }
        }
    }
    var result = try {
        nums[keyPosition]
    } catch (e: Exception) {
        -1
    }
    return result
}
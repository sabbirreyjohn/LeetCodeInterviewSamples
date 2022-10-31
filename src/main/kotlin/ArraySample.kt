import java.lang.Math.abs
import java.math.BigInteger

fun main() {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}

//1
fun removeDuplicates(nums: IntArray): Int {
    val sets = nums.toSet()
    for (i in 0..nums.lastIndex) {
        if (i < sets.size)
            nums[i] = sets.elementAt(i)
        else
            nums[i] = 0
    }
    return sets.size
}

//2
fun maxProfit(prices: IntArray): Int {
    var totalProfit = 0
    for (i in 1..prices.lastIndex) {
        if (prices[i] > prices[i - 1])
            totalProfit += prices[i] - prices[i - 1]
    }

    return totalProfit
}

//3
fun rotate(nums: IntArray, k: Int): Unit {

    val count = k % nums.size
    for (i in 1..count) {
        val temp = nums[nums.lastIndex]
        for (currentIndex in nums.lastIndex downTo 1) {
            nums[currentIndex] = nums[currentIndex - 1]
        }
        nums[0] = temp
    }

}

//4
fun containsDuplicate(nums: IntArray): Boolean {
    var sets = nums.toSet()
    if (nums.size != sets.size)
        return true
    return false
}

//5
fun singleNumber(nums: IntArray): Int {
    var res = 0
    var map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.get(nums[i]) == null) {
            map.put(nums[i], 1)
        } else {
            map.put(nums[i], map.get(nums[i])!! + 1)
        }
    }

    map.onEach {
        if (it.value == 1)
            res = it.key
    }
    return res
}

//6
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val largeList = if (nums1.size >= nums2.size) nums1 else nums2
    val smalList = if (nums1.size >= nums2.size) nums2 else nums1
    var intList = mutableListOf<Int>()
    for (index in 0..smalList.size - 1) {
        if (largeList.contains(smalList[index])) {
            intList.add(smalList[index])
            largeList[largeList.indexOf(smalList[index])] = -1
        }
    }
    return intList.toIntArray()
}

fun plusOne(digits: IntArray): IntArray {
    for (currentIndex in digits.size - 1 downTo 0) {
        if (digits[currentIndex] < 9) {
            digits[currentIndex] += 1
            return digits
        }
        digits[currentIndex] = 0
    }
    var result = IntArray(digits.size + 1)
    result[0] = 1
    return result
}

fun moveZeroes(nums: IntArray): Unit {
    var inserPosition = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[inserPosition] = nums[i]
            inserPosition++
        }
    }
    for (i in inserPosition..nums.size - 1) {
        nums[i] = 0
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0..nums.size - 1) {
        for (j in 1..nums.size - 1) {
            if (nums[i] + nums[j] == target && i!=j){
                var result = intArrayOf(i, j)
                return result
            }
        }
    }
    return intArrayOf(0,0)
}


import java.lang.Math.abs

fun main() {
    print(singleNumber(intArrayOf(2, 2, 1)))
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
    val largeList = if(nums1.size>= nums2.size) nums1 else nums2
    val smalList = if(nums1.size>= nums2.size) nums2 else nums1
    var intList = mutableListOf<Int>()
    for (index in 0..smalList.size-1){
        if(largeList.contains(smalList[index])){
            intList.add(smalList[index])
            largeList[largeList.indexOf(smalList[index])] = -1
        }
    }
    return intList.toIntArray()
}


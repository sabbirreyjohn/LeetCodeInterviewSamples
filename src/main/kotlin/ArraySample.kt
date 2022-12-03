import java.lang.Math.abs
import java.math.BigInteger
import java.util.LinkedList

fun main() {
    smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).forEach {
        print("$it ")
    }
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
            if (nums[i] + nums[j] == target && i != j) {
                var result = intArrayOf(i, j)
                return result
            }
        }
    }
    return intArrayOf(0, 0)
}

fun buildArray(nums: IntArray): IntArray {
    var resultArray = mutableListOf<Int>()
    for (i in nums.indices) {
        resultArray.add(nums[nums[i]])
    }

    return resultArray.toIntArray()
}

fun getConcatenation(nums: IntArray): IntArray {
    var result = mutableListOf<Int>()
    var currentIndex = 0
    for (i in 0..(nums.size * 2) - 1) {
        result.add(nums[currentIndex])
        currentIndex++
        if (currentIndex == nums.size) currentIndex = 0
    }
    var t = LinkedList<Int>()
    return result.toIntArray()
}

fun runningSum(nums: IntArray): IntArray {
    var sum = nums[0]
    for (i in 1..nums.size - 1) {
        sum += nums[i]
        nums[i] = sum
    }
    return nums
}

fun finalValueAfterOperations(operations: Array<String>): Int {
    var num = 0;
    for (i in 0..operations.size - 1) {
        when (operations[i]) {
            "++X", "X++" -> {
                num++
            }

            "--X", "X--" -> {
                num--
            }

        }
    }
    return num
}

fun shuffle(nums: IntArray, n: Int): IntArray {
    var shuffledArray = mutableListOf<Int>()
    for (i in 0..n - 1) {
        shuffledArray.add(nums[i])
        shuffledArray.add(nums[n + i])
    }
    return shuffledArray.toIntArray()
}

fun maximumWealth(accounts: Array<IntArray>): Int {
    var max = 0
    for (i in 0..accounts.size - 1) {
        var currentArray = accounts[i]
        var sum = 0
        for (j in 0..currentArray.size - 1) {
            sum += currentArray[j]
        }
        max = Math.max(max, sum)
    }
    return max
}

fun numIdenticalPairs(nums: IntArray): Int {
    var output = 0;
    for (i in 0..nums.size - 1) {
        for (j in i + 1..nums.size - 1) {
            if (nums[i] == nums[j]) {
                output += 1
            }
        }
    }
    return output
}

fun mostWordsFound(sentences: Array<String>): Int {

    var maxWords = 0
    for (i in sentences.indices) {
        if (sentences[i].split(" ").size > maxWords) {
            maxWords = sentences[i].split(" ").size
        }
    }
    return maxWords
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    var boolList = mutableListOf<Boolean>()
    var max = candies[0]
    for (i in candies.indices) {
        if (candies[i] > max) max = candies[i]
    }
    for (i in candies.indices) {
        boolList.add(candies[i] + extraCandies >= max)
    }
    return boolList
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {

    var resultList = mutableListOf<Int>()
    for (i in nums.indices) {
        var totalMin = 0
        for (j in nums.indices) {
            if (i != j) {
                if (nums[j] < nums[i]) {
                    totalMin++
                }
            }
        }
        resultList.add(totalMin)
    }
    return resultList.toIntArray()
}

fun decompressRLElist(nums: IntArray): IntArray {
    var result = mutableListOf<Int>()
    for (i in 0..nums.size - 1 step 2) {
        var freq = nums[i]
        var value = nums[i + 1]
        for (i in 1..freq) {
            result.add(value)
        }
    }
    return result.toIntArray()
}
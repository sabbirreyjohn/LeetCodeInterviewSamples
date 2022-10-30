fun main() {
print(6%11)
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


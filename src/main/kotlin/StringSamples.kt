fun main() {
    print(isPalindrome("A man, a plan, a canal: Panama"))
}

fun reverseString(s: CharArray): Unit {

    for (i in 0..(s.size - 1) / 2) {
        var temp = s[i]
        s[i] = s[s.size - 1 - i]
        s[s.size - 1 - i] = temp
    }
}

fun reverse(x: Int): Int {

    var reverse = 0
    var number = x
    while (number != 0) {
        var tail = number % 10
        if (reverse * 10 / 10 != reverse)
            return 0
        reverse = reverse * 10 + tail
        number /= 10
    }
    return reverse

}

fun firstUniqChar(s: String): Int {
    var originalArray = s.toCharArray()
    var theMap = mutableMapOf<Char, Int>()
    for (i in 0..originalArray.size - 1) {
        theMap.put(originalArray[i], theMap.getOrDefault(originalArray[i], 0) + 1)
    }
    for (i in 0..originalArray.size - 1) {
        if (theMap.get(originalArray[i])!! < 2)
            return i
    }
    return -1
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length)
        return false
    var sArray = s.toCharArray()
    var tArray = t.toCharArray()
    sArray.sort()
    tArray.sort()
    for (i in 0..sArray.size - 1) {
        if (!sArray[i].equals(tArray[i]))
            return false
    }
    return true
}

fun isPalindrome(s: String): Boolean {
    val regex = Regex("[^A-Za-z0-9]")
    var sArray = regex.replace(s.replace(" ", "").toLowerCase(),"").toCharArray()
    for (i in 0..(sArray.size - 1) / 2) {
        if (!sArray[i].equals(sArray[sArray.size - 1 - i]))
            return false
    }
    return true
}
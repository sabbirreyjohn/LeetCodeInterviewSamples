package algorithm.recursion

fun main() {
    println(reverseString("kutta"))
}

var counter = 0

fun factorial(num: Int): Int {
    if (num == 2) {
        return 2
    }
    return num * factorial(num - 1)
    /*var result= 1;
    for(i in num downTo 1){
        result*= i
    }
    return result*/
}

fun fibonacci(num: Int): Int {
    /* var numList = mutableListOf<Int>()
     numList.add(0)
     numList.add(1)

     for (i in 2..num) {
         numList.add( numList[i-1]+ numList[i-2])
     }
     return numList[num]*/

    if (num < 2)
        return num
    return fibonacci(num - 1) + fibonacci(num - 2)
}

fun reverseString(string: String): String{
    var array = string.toCharArray()
    if(array.size==1)
        return array[0].toString()

    return array[array.size-1]+ reverseString(string.dropLast(1))

}
/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 22/05/2023
*/

package algoexpert.stockPicker

//[44, 30, 24, 32, 35, 30, 40, 38, 15]
fun stockPicker(arr: IntArray): Int {
    val profitList = mutableListOf<Int>()

    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            val day1 = arr[i]
            val day2 = arr[j]
            val profit =  day2 - day1
            println("For Day 1: $day1 - Day2 : $day2 = $profit")
            profitList.add(profit)
        }
    }

    return profitList.max()
}

fun main() {
//    println(stockPicker(intArrayOf(10, 12, 4, 5, 9))) //5
//    println(stockPicker(intArrayOf(14,20,4,12,5,11))) //8
    println(stockPicker(intArrayOf(10, 9, 8, 2))) //-1
}
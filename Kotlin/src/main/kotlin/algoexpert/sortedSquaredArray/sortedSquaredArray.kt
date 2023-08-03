/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 08/05/2023
*/

package algoexpert.sortedSquaredArray

import algoexpert.twoNumberSum.printMeasureTime
import kotlin.math.abs

/**
 * Brute force approach
 *
 * Complexity: O(nLog(n)) time | O(n) space
 */
fun sortedSquaredArray1(array: List<Int>): List<Int> {
    // Write your code here.
    //map  creates a new array and does not change the original array
    //Sorting is the cause of nLog(n) time complexity
    return array.map { it * it }.sorted()
}

/**
 * Uses two pointer and takes two items at the same time to compare
 * Complexity: O(n) time | O(n) space Complexity: O(n) space | O(n) time.
 */
fun sortedSquaredArray2(array: List<Int>): List<Int> {
    // Write your code here.
    val outputArray = MutableList(array.size) { 0 }

    var lowerIndex = 0
    var upperIndex = array.size - 1

    for (index in (array.size - 1) downTo 0) {
        val lowerValue = array[lowerIndex]
        val upperValue = array[upperIndex]

        if (abs(lowerValue) > abs(upperValue)) {
            //insert the lower value at index and increase lowerIndex
            outputArray[index] = lowerValue * lowerValue
            lowerIndex++
        } else {
            outputArray[index] = upperValue * upperValue
            upperIndex--
        }
    }
    return outputArray
}

fun main() {
    printMeasureTime {
        sortedSquaredArray1(listOf(1, 2, 3, 5, 6, 8, 9))
    }

    printMeasureTime {
        sortedSquaredArray2(listOf(1, 2, 3, 5, 6, 8, 9))
    }
}
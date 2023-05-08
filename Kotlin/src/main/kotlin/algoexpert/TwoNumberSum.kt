/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 06/05/2023
*/

package algoexpert

import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


/**
 * Uses double for loop T = O(N^2), S = O(1)
 *
 * @param array
 * @param targetSum
 * @return
 */
fun twoNumberSum1(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    for (i in 0 until array.size) {
        val n1 = array[i]

        for (j in (i + 1) until array.size) {
            val n2 = array[j]
            if (n1 + n2 == targetSum)
                return listOf(n1, n2)
        }
    }
    return listOf<Int>()
}

/**
 * Uses two pointer and sorted array
 * T = O(nlog(n)), S = 0(1)
 *
 * @param array
 * @param targetSum
 * @return
 */
fun twoNumberSum2(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    array.sort()
    var leftPointer = 0
    var rightPointer = array.size - 1

    //While the two points do not overlap, left <<< right
    while (leftPointer < rightPointer) {
        val currentSum = array[leftPointer] + array[rightPointer]
        if (currentSum == targetSum) {
            return listOf(array[rightPointer], array[leftPointer])
        } else if (currentSum < targetSum) {
            //move closer to right
            leftPointer++
        } else {
            //move closer to left
            rightPointer--
        }

    }
    return listOf<Int>()
}

/**
 * Uses HashTable and runs in T = O(n) and S = O(n)
 *
 * @param array
 * @param targetSum
 * @return
 */
fun twoNumberSum3(array: MutableList<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    val visited = HashSet<Int>()

    for (item in array) {
        val expectedNumber = targetSum - item

        if (visited.contains(expectedNumber))
            return listOf(expectedNumber, item)

        visited.add(item)
    }
    return listOf<Int>()
}

@OptIn(ExperimentalTime::class)
fun main() {
    //slow ~ 16.688071ms
    printMeasureTime {
        twoNumberSum1(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    }
    //fast ~ 276.871us
    printMeasureTime {
        twoNumberSum2(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    }

    //fastest ~ 48.655us
    printMeasureTime {
        twoNumberSum3(mutableListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    }
}

@OptIn(ExperimentalTime::class)
fun printMeasureTime(block: () -> Any) {
    var result: Any?
    val time = measureTime { result = block() }

    println("Code Finished in: $time : $result")
}




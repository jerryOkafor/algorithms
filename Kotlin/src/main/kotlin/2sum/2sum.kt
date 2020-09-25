package twosum

import utils.measure
import java.util.*
import kotlin.collections.HashMap

/**
 * @author jerry on 25/09/2020
 * for Kotlin
 **/
//https://www.callicoder.com/two-sum-problem/
/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
* */

//Solution 1: Naive Approach|Bruteforce.
//Time complexity: O(n^2)
fun twoSumNaive(array: Array<Int>, target: Int): Array<Int> {
    for (i in 0 until array.count()) {
        for (j in i + 1 until array.count())
            if (array[i] + array[j] == target)
                return arrayOf(i, j)
    }
    return emptyArray()
}

//Solution 2: Use HashMap for lookup table  - Most Efficient
//Time Complexity: O(n)
fun twoSumEfficient(array: Array<Int>, target: Int): Array<Int> {
    val numMap = HashMap<Int, Int>() //has O(1) for set, get and for containsKey()

    for (i in 0 until array.count()) {
        val complement = target - array[i]

        if (numMap.containsKey(complement)) {
            return arrayOf(numMap[complement]!!, i)
        } else {
            numMap[array[i]] = i
        }
    }
    return emptyArray()
}

//Solution 3: Two Pointer sliding Window approach
/*
1. Sort the array.
2. Initialize two variables, one pointing to the beginning of the array (left) and another pointing to the end of the array (right).
3. Loop until left < right, and for each iteration
   - if arr[left] + arr[right] == target, then return the indices.
   - if arr[left] + arr[right] < target, increment the left index.
   - else, decrement the right index.
*/
//Complexity: O(n*log(n))
fun twoSum2Pointer(array: Array<Int>, target: Int): Array<Int> {
    Arrays.sort(array)

    var left = 0
    var right = array.count() - 1

    while (left < right) {
        when {
            array[left] + array[right] == target -> {
                return arrayOf(left, right)
            }
            array[left] + array[right] < target -> {
                left++
            }
            else -> {
                right++
            }
        }
    }
    return emptyArray()
}

fun main() {
    measure("2 Sum Naive") {
        println(twoSumNaive(arrayOf(2, 7, 11, 15), 9).contentToString())
    }

    measure("2 Sum Efficient") {
        println(twoSumEfficient(arrayOf(2, 7, 11, 15), 9).contentToString())
    }

    measure("2 Sum 2 Pointer") {
        println(twoSumEfficient(arrayOf(2, 7, 11, 15), 9).contentToString())
    }
}

//git mv foldername tempname && git mv tempname folderName

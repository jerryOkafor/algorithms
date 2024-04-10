/*
 * Kotlin
 *
 * Copyright (C) 2020 Jerry Okafor
 * https://jerryokafor.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package threesum

import utils.measure

/**
 * Problem Statment: Given an array of integers, are there three elements
 * a, b and c such that a + b + c = 0? find all unique triplet (3 numbers)
 * (non duplicate) in the array which gives the sum of 0. The solution set
 * must not contain duplicate triplet.
 *
 * Example: Given array of numbers: [-1,0,1,2,-1,-4] Solution Set is:
 * [[-1,0,1],-1,-1,-2]
 */

//Solution 1: Brute Force
//Approach : Sort the array ans ensure that i,j and k are never equal at anytime.
fun threeSumBF(numbers: IntArray, sum: Int = 0): Array<IntArray> {
    //sort the array
    val result = mutableListOf<IntArray>()
    numbers.sort()
    println(numbers.contentToString())

    val length = numbers.count()

    var i = 0
    loop1@ while (i < length) {
        if (i > 0 && numbers[i] == numbers[i - 1]) break@loop1

        var j = i + 1
        loop2@ while (j < length) {
            print("${j > i + 1} ")
            println(numbers[j] == numbers[j - 1])
            if (j > i + 1 && numbers[j] == numbers[j - 1]) break@loop2

            var k = j + 1
            loop3@ while (k < length) {
                if (k > j + 1 && numbers[k] == numbers[k - 1]) break@loop3
                if (numbers[i] + numbers[j] + numbers[k] == sum) {
                    println("$i $j $k")
                    result.add(intArrayOf(i, j, k))
                }
                k++
            }

            j++
        }
        i++
    }
    return result.toTypedArray()
}

fun main() {
    threeSumBF(intArrayOf(-1, 2, -1, 0, 1, -4)).forEach {
        println("Answers: ${it.contentToString()}")
    }
}


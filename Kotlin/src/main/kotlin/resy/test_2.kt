/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 11/08/2023
*/

package resy

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

/*
*
* Kotlin
*
* @Author : Jerry Okafor
* @Date : 11/08/2023
*/

// -------- QUESTION -------- //
//
// Given a range of integers, find the integers in this range that are squares of any integer.
//
// For example 4 is square of 2 and 5 is square of 2.23. We want to return 4 but not 5.

// -------- EXAMPLE -------- //
//
// Range:  (1)   2   3   (4)   5   6   7   8   (9)   10
//          ^             ^                     ^
// Roots:   1             2                     3
//
// Returns: [1, 4, 9]

// -------- HINT -------- //
//
// You can use Math.sqrt() or any math function from a math library.

// -------- IMPLEMENTATION -------- //

fun findSquares(range: List<Int>): List<Int> {
    // >>>>>>>> IMPLEMENT HERE <<<<<<<< //
    val result = mutableListOf<Int>()
    for (num in range) {
        val sqrt = sqrt(num.toDouble())

        val upper = ceil(sqrt)
        val lower = floor(sqrt)

        val isAnInteger = upper == lower
//        val isAnInteger = sqrt.rem(1) == 0.0 //You can also use the rem
        if (isAnInteger) {
            result.add(num)
        }
    }

    return result
}

fun main() {
    val range: List<Int> = (1..10).toList()
    val squares = findSquares(range)
    println(squares)
}
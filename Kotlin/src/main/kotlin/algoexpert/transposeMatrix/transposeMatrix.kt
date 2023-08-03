/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 03/08/2023
*/

package algoexpert.transposeMatrix

import kotlin.math.max

//Q. Transpose of a 2D matrix
//O(wxh) time and 0(wxh) space -> two for loops and new 2D array creations
fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {

    val newArray = mutableListOf(mutableListOf<Int>())

    for (col in 0 until matrix[0].size) { //cols
        val newRow = mutableListOf<Int>()
        for (row in 0 until matrix.size) { //rows
            newRow.add(matrix[row][col])
        }
        println(newRow)
        newArray.add(col, newRow)
    }

    return newArray.filter { it.isNotEmpty() }.toMutableList()
}

fun main() {
    println(transposeMatrix(mutableListOf(mutableListOf(1, 2, 3), mutableListOf(4, 5, 6), mutableListOf(7, 8, 9))))
}
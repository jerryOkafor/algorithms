/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 08/08/2023
*/

package reversCyclicArray

//Given a cyclic array, write a function to reverse from any k number
// (where k is an input to the function).
// You can also treat this as elements in an array
//        Example:
//Input: [1,2,3,4,5,6,7,8] K = 3
//Output: [3,2,1,8,7,6,5,4]
//Input: [1,2,3,4,5,6,7,8] K = 5
//Output: [5,4,3,2,1,8,7,6]
//N.B: Treat the input and output as an array


fun reversArray(a: IntArray, k: Int): IntArray {
    val indexToStart = k % a.size

    val leftSlice = a.slice(0 until indexToStart)
    val rightSlice = a.slice(indexToStart until a.size)

    val leftReverse = leftSlice.reversed().toIntArray()
    val rightReversed = rightSlice.reversed().toIntArray()

    return leftReverse + rightReversed
}

fun main() {
    check(
        reversArray(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 3)
            .contentEquals(intArrayOf(3, 2, 1, 8, 7, 6, 5, 4))
    )
    check(
        reversArray(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 5)
            .contentEquals(intArrayOf(5, 4, 3, 2, 1, 8, 7, 6))
    )
}
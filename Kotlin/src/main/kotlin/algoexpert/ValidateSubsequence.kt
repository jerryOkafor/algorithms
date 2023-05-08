/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 06/05/2023
*/

package algoexpert

/**
 * In mathematics, a subsequence of a given sequence is a sequence that
 * can be derived from the given sequence by deleting some or no elements
 * without changing the order of the remaining elements
 *
 * T = O(n), S = O(1)
 *
 * @param array
 * @param sequence
 * @return
 */
fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    // Write your code here.
    var aIndex = 0
    var sIndex = 0

    while (aIndex < array.size && sIndex < sequence.size) {
        if (sequence[sIndex] == array[aIndex])
            sIndex++
        aIndex++
    }

    //we can say we have a valid sequence if we have the below condition
    return sIndex == sequence.size
}

fun main() {
    printMeasureTime {
        isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10))
    }

}
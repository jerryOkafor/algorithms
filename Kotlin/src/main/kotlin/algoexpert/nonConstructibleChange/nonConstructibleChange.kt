/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 03/08/2023
*/

package algoexpert.nonConstructibleChange

//Given an array of positive integers representing the values of coins in your
//possession, write a function that returns the minimum amount of change (the
//minimum sum of money) that you cannot  create. The given coins can have
//any positive integer value and aren't necessarily unique (i.e., you can have
//multiple coins of the same value).
//
//For example, given coins = [1,2,5], the min amount of change that you can't creat is 4. If
//you're given no coins, the min amount of change that you can't create is 1


//Runs in O(nlogn) time and O(1) space
fun nonConstructibleChange(coins: MutableList<Int>): Int {
    // Write your code here.
    //assume we can sort ths list
    val sortedCoin = coins.sorted() //runs at O(nlogn) time and O(1) space because the array is sorted in-place

    var change = 0

    // loop through the coins, on at a time and check for a case where
    //coin > change + 1
    for (coin in sortedCoin) {
        if (coin > change + 1) {
            return change + 1
        }
        change += coin
    }
    return change + 1
}

fun main() {
//    println(nonConstructibleChange(mutableListOf(5, 7, 1, 1, 2, 3, 22)))
//    println(nonConstructibleChange(mutableListOf(109, 2000, 8765, 19, 18, 17, 16, 8, 1, 1, 2, 4)))
//    println(nonConstructibleChange(mutableListOf(1,2,3,4)))
    println(nonConstructibleChange(mutableListOf(1, 2, 3, 4, 5, 6, 7)))
}
package twosum

import utils.measure
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

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

//Asumptions:
//1. Each input will have one solution
//2. An element can not be used twice.

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
//Here we reduce the Time Complexity from O(n^2) to O(n) by trading space for time.
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
//Complexity: O(n*log(n)) works for sorted Array - Arrays.sort(array)
fun twoSum2Pointer(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.count() - 1

    while (left < right) {
        when {
            numbers[left] + numbers[right] == target -> {
                return intArrayOf(left, right)
            }
            numbers[left] + numbers[right] < target -> {
                left++
            }
            else -> {
                right--
            }
        }
    }
    return intArrayOf()
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findTarget(root: TreeNode?, k: Int): Boolean {
    if (root == null) return false

    val numbers = HashSet<Int>()

    //add root
    numbers.add(root.`val`)

    //check left and right sub tree

    return visitDepth(root.left, k, numbers) || visitDepth(root.right, k, numbers)
}

fun visitDepth(root: TreeNode?, k: Int, numbers: HashSet<Int>): Boolean {
    if(root == null) return false

    val diff = k - root.`val`

    if(numbers.contains(diff)) return true

    numbers.add(root.`val`)

    return visitDepth(root.left, k, numbers) || visitDepth(root.right, k, numbers)

}

//fun findTarget(root: TreeNode?, k: Int): Pair<Int, Int>? {
//    if (root == null) return null
//
//    val numbers = HashSet<Int>() //O(n) lookup
//    numbers.add(root.`val`)
//    val queue: Queue<TreeNode> = LinkedList() //implementation of queue
//    queue.add(root)
//
//    while (queue.isNotEmpty()) {
//        val current = queue.poll()
//
//        val diff = k - current.`val`
//        if (numbers.contains(diff)) return Pair(current.`val`, diff)
//        else {
//            //add left and right to both set and queue
//            current.left?.let {
//                numbers.add(it.`val`)
//                queue.add(it)
//            }
//
//            current.right?.let {
//                numbers.add(it.`val`)
//                queue.add(it)
//            }
//        }
//    }
//    return null
//}

fun findTargetWithQueue(root: TreeNode?, k: Int): Boolean {
    if (root == null) return false
    if (root.right == null || root.left == null) return false //we need at least 2 nodes


    val numbers = HashSet<Int>() //O(n) lookup
    numbers.add(root.`val`)
    val queue: Queue<TreeNode> = LinkedList() //implementation of queue
    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        val diff = if (k < 0) k + current.`val` else k - current.`val`
        if (numbers.contains(diff)) return true
        else {
            //add left and right to both set and queue
            current.left?.let {
                numbers.add(it.`val`)
                queue.add(it)
            }

            current.right?.let {
                numbers.add(it.`val`)
                queue.add(it)
            }
        }
    }
    return false
}


fun main() {
//    measure("2 Sum Naive") {
//        println(twoSumNaive(arrayOf(2, 7, 11, 15), 9).contentToString())
//    }
//
//    measure("2 Sum Efficient") {
//        println(twoSumEfficient(arrayOf(2, 7, 11, 15), 9).contentToString())
//    }

//    measure("2 Sum 2 Pointer") {
//        println(twoSum2Pointer(intArrayOf(2, 7, 11, 15), 9).contentToString())
//    }
    val one = TreeNode(1)
    val two = TreeNode(2)
    val four = TreeNode(4)
    val seven = TreeNode(7)

    val three = TreeNode(3)
    three.left = two
    three.right = four

    val six = TreeNode(6)
    six.right = seven

    val five = TreeNode(5)
    five.right = three
    five.left = six


//    val treeNode = arrayOf(five, three, six, four, null, seven)
    val treeNode = arrayOf(one)

    measure("Target for BST") {
        println(findTargetWithQueue(one, k = 2))
    }

}

//git mv foldername tempname && git mv tempname folderName

/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package binarySearchTree

import core.BinarySearchTree
import utils.example


val exampleTree = BinarySearchTree<Int>().apply {
    insert(3)
    insert(1)
    insert(4)
    insert(0)
    insert(2)
    insert(5)
}

val exampleTree2 = BinarySearchTree<Int>().apply {
    insert(2)
    insert(5)
    insert(3)
    insert(1)
    insert(0)
}

fun main() {
    "removing a node" example {
        println("Tree before removal:")
        println(exampleTree)
        exampleTree.remove(3)
        println("Tree after removing root:")
        println(exampleTree)
    }
}
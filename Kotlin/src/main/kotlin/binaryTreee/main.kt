/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package binaryTreee

import core.BinaryNode
import utils.example

fun makeBinaryTree(): BinaryNode<Int> {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    return seven
}

fun main() {
    val tree = makeBinaryTree()

    "print binary tree" example {
        println(tree.toString())
    }

    //left -> center -> right
    "traverse in order" example {
        tree.traverseInOrder { println(it?.value) }
    }

    //center -> left -> right
    "traverse pre order" example {
        tree.traversePreOrder { println(it?.value) }
    }

    //right -> right -> center
    "traverse post order" example {
        tree.traversePostOrder { println(it?.value) }
    }

    "serialzation" example {
        println(tree.serialize())
    }

    "deserialize" example {
        val list = tree.serialize().toMutableList() //mutableListOf(7, 1, 0, null, null, 5, null, null, 9, 8, null, null, null)
        println(tree.deserialize(list))
    }

}
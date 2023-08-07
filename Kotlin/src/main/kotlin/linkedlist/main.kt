/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 04/08/2023
*/

package linkedlist

import core.LinkedList
import core.Node
import utils.example

//O(n) time complexity because we have to traverse the whole lists
fun <T : Any> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T : Any> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" <- ")
    }
    print(this.value.toString())
}

//Find the middle of a LinkedList using runner technique with fast and
//slow pointers
//Runs in o(n) time complexity because you need to traverse the list in a single
//pass
fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = nodeAt(0)
    var fast = nodeAt(0)

    while (fast != null) {
        fast = fast.next

        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

//Reverses LinkedList in O(n) time and space complexity
//because we traverse the list once and also create a new
//list
fun <T : Any> LinkedList<T>.reverse(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)

    if (head != null) {
        addInReverseOrder(result, head)
    }
    return result
}

private fun <T : Any> LinkedList<T>.addInReverseOrder(result: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverseOrder(result, next)
    }
    result.append(node.value)
}

//Crate a function that takes two sorted LinkedLists and merge them into a single
//sorted list
//Runs in O(n + m) where n and m are the lengths of the LinkedLists respectively
fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherLinkedList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherLinkedList
    if (otherLinkedList.isEmpty()) return this

    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherLinkedList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T : Comparable<T>> LinkedList<T>.append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}

fun main() {
    "print LinkedList in revers order" example {
        val list = LinkedList<Int>()
        list.apply {
            add(3)
            add(2)
            add(1)
            add(4)
            add(5)
        }
        println(list)
        list.printInReverse()
    }

    "print middle of LinkedList" example {
        val list = LinkedList<Int>()
        list.apply {
            add(3)
            add(2)
            add(1)
            add(4)
            add(5)
        }
        println(list)
        println(list.getMiddle()?.value)
    }

    "reverse list" example {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println("Original: $list")
        println("Reversed: ${list.reversed()}")
    }

    "merge lists" example {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)

        val other = LinkedList<Int>()
        other.add(-1)
        other.add(0)
        other.add(2)
        other.add(2)
        other.add(7)
        println("Left: $list")
        println("Right: $other")
        println("Merged: ${list.mergeSorted(other)}")
    }
}
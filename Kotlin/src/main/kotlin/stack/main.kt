/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 04/08/2023
*/

package stack

import core.LinkedList
import core.StackImpl
import utils.example

//1.
//One of the prime use case of Stack is to facilitate backtrcking. If you push a sequence
//of values into the stack, sequentially popping the stack will give you the values in reverse order


//Print LinkedList in reverse order
//Runs in O(n) time and space complexity
fun <T : Any> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()

    //push all sequentially
    for (item in this) {
        stack.push(item)
    }

    //pop the first item and build a new LinkedList
    var node = stack.pop()

    while (node != null) {
        print(node)
        node = stack.pop()
    }

}

//2.
//Parenthesis Validation. Stack can also be used for parenthesis validation
//Go through all the chars in the string, when you encounter an opening parenthesis, you will push to
//the stack when you encounter a closing parenthesis, you pop, compare and continue


//Runs in O(n) time and space complexity where n is the number of characters in the string
fun String.checkValidParenthesis(): Boolean {
    val stack = StackImpl<Char>()
    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> if (stack.isEmpty) return false else stack.pop()
        }
    }
    return stack.isEmpty
}

fun main() {
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
}
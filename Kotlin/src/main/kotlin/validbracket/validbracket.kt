/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 02/08/2023
*/

package validbracket

//Given an expression string exp, write a program to examine whether
// the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct
// in the given expression.

fun isValid(input: String?): Boolean {
    //basic input validation -> input must not be null and count must be even
    if (input == null || (input.length % 2) != 0) return false

    val pairs = listOf(
        Pair('{', '}'),
        Pair('[', ']'),
        Pair('(', ')')
    )

    val allowed = pairs.flatMap { it.toList() }
    val openingBrackets = pairs.map { it.first }
    val closingBrackets = pairs.map { it.second }
//    println("Allowed: ${allowed.joinToString(separator = ", ")}")
//    println("Opening: ${openingBrackets.joinToString(", ")}")
//    println("Closing: ${closingBrackets.joinToString(", ")}")

    //ensure only brackets are  allowed
    if (input.any { !allowed.contains(it) }) return false

    //Using Deck (double ended queue) is faster than using Stack
    val stack = ArrayDeque<Char>()

    //loop through all the chars in input and add them to the deck if they are opening brackets
    for (char in input) {
        if (openingBrackets.contains(char)) {
            stack.addFirst(char)
        } else {
            //if it not an opening bracket and the deck is empty, we return false
            if (stack.isEmpty()) return false

            when (char) {
                pairs[0].second -> {
                    //get the top element and compare
                    val topmostItem = stack.first()

                    //they must match
                    if (topmostItem != pairs[0].first) return false
                    stack.removeFirst()
                }

                pairs[1].second -> {
                    //get the top element and compare
                    val topmostItem = stack.first()

                    //they must match
                    if (topmostItem != pairs[1].first) return false
                    stack.removeFirst()
                }

                pairs[2].second -> {
                    //get the top element and compare
                    val topmostItem = stack.first()

                    //they must match
                    if (topmostItem != pairs[2].first) return false
                    stack.removeFirst()
                }
            }
        }
    }

    return true
}

fun isValid2(input: String?): Boolean {
    if (input == null || (input.length % 2) != 0) return false

    var str: String = input

    while (str.contains("[]") || str.contains("{}") || str.contains("()")) {
        str = str.replace("()", "")
            .replace("[]", "")
            .replace("{}", "");
    }

    return str.isEmpty()
}

fun main() {
//    println("Is valid: ${isValid(null)}")
//    println("Is valid: ${isValid("[()]{}{[()()]()}")}")
//    println("Is valid: ${isValid2("[()]{}{[()()]()}")}")
//    println("Is valid: ${isValid("[()]{}{c[()()]c()}")}")
}

///Other solutions:

//1. We can use String.replaceAll Method to replace all occurrences of {}, () and [] until non is left, at this point, the input should be empty
//else, the string is not a valid bracket

//The ArrayDeque class is the resizable array implementation of the Deque interface and LinkedList class is the list implementation
//NULL elements can be added to LinkedList but not in ArrayDeque
//ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends and LinkedList implementation is efficient for removing the current element during the iteration
//The LinkedList implementation consumes more memory than the ArrayDeque
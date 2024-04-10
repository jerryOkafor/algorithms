/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 11/08/2023
*/

package factorial

//no tailrec, can cause stackoverflow
fun factorial(n: Long): Long {
    return if (n == 1L) n else n * factorial(n - 1)
}

//optimised with tailrec, avoids stackoverflow
tailrec fun factorial(n: Int, runAccumulator: Int = 1): Long {
    println("Checking for $n, run: $runAccumulator")
    return if (n == 1) runAccumulator.toLong() else factorial(n - 1, runAccumulator * n)
}

/**
 * tailrec marks a function as tail-recursive (allowing the compiler to
 * replace recursion with iteration). This is because a recursion function
 * will/may cause the stackOverflowError when the number of recursive-calls
 * is significant enough.
 */

fun main() {
    val number = 5
    println("Factorial of $number = ${factorial(number.toLong())}")
    println("Factorial of $number = ${factorial(number)}")
}

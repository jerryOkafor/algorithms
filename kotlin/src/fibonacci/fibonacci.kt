package fibonacci

import java.math.BigInteger


/**
 * @author jerry on 05/09/2020
 * for kotlin
 *
 * The Fibonacci algorithm is a classic example of a recursive function,
 * expressed as Fn = Fn-1 + Fn-2:
 *
 * The definition with:
 * 1. Fib(0) = 1 is known as the combinatorial definition,and
 * 2. Fib(0) = 0 is the classical definition.
 * */

/**
 * Return the first nth fibonacci sequence of size n + 1 based on the
 * classical definition of fibonacci sequence.
 * */
fun fibonacci(n: Int) = sequence {
    var terms = Pair(0, 1)
    var counter = 0

    while (counter <= n) {
        yield(terms.first)

        //update terms
        terms = Pair(terms.second, terms.first + terms.second)
        counter++
    }
}

/**
 * Classic and highly inefficient function
 * Returns the nth term of fibonacci series using the combinatorial definition
 * */
fun fib1(n: Int): Int = if (n <= 2) 1 else {
    fib1(n - 1) + fib1(n - 2)
}

/**
 * Iterative and Ugly
 * Returns the nth term of fibonacci series using the combinatorial definition
 * */
fun fib2(n: Int): Int {
    var a = 1
    var b = 1

    for (i in 3..n) {
        val temp = a // n-2 value
        a += b //add the n-1 value to get n
        b = temp
    }

    return a
}

/**
 * Tail Recursive
 *Returns the nth term of the fibonacci series based on the combinatorial definition
 * */
@JvmOverloads
tailrec fun fibonacciWithTailCall(n: Int, a: Int = 0, b: Int = 1): Int =
    if (n == 0) a else fibonacciWithTailCall(n - 1, b, a + b)


/**
 * Tail Recursive
 *Returns the nth term of the fibonacci series based on the combinatorial definition for [BigInteger]
 * */
@JvmOverloads
tailrec fun fibonacciBig(n: Int, a: BigInteger = 0.toBigInteger(), b: BigInteger = 1.toBigInteger()): BigInteger =
    if (n == 0) a else fibonacciBig(n - 1, b, a + b)


/**
 *Returns the nth term of the fibonacci series based on the combinatorial definition using
 * kotlin [fold] function.
 * */
fun fibonacciFold(n: Int) =
    (2 until n).fold(1 to 1) { (prev, cur), _ -> cur to (prev + cur) }.second

fun main() {
    val n = 10
    println("Using fib1() with combinatorial definition: ${fib1(n)}")
    println("Using fib2() with combinatorial definition: ${fib1(n)}")
    println("Using kotlin sequence for n = 10 using classical definition: ${fibonacci(n).take(11).toList()}")
    println("Using Tail Recursion for n = 10: ${fibonacciWithTailCall(10)}")
    println("Using fibonacciBig() for n = 10: ${fibonacciBig(n, 0.toBigInteger(), 1.toBigInteger())}")
    println("Using fold() for n = 10: ${fibonacciFold(n)}")
}
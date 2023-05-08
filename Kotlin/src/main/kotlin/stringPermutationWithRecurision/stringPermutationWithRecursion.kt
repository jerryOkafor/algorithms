/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 29/09/2021
*/

package stringPermutationWithRecurision

import kotlin.reflect.typeOf

/**
Write arecursive function for genrating all permutations of an input
String. Return them as a set.

Solutions:

Using a base case and breaking the problem into the smallest possible case -> a char say s

Given s -> s

Second possible case is st -> (s) -> (t) <- (s)
Simply hold t and add s before and after s.

Similarly, given cat, we can find all permutations of cats as follows:
Permutations of cat:
cat
cta
atc
act
tac
tca
For each permutation, we insert s accordingly from index 0..length:
cat
scat
csat
cast
cats

cta
scta
csta
ctsa
ctas
.... and so on
 */
fun stringPermutationWithRecursion(string: String): Set<String> {
    //Base case
    if (string.length == 1)
        return setOf(string)

    val allCharsExceptLast = string.substringBeforeLast("")
    val lastChar = string.last()

    //Use recursion to get all possible permutations for all chars except last
    val permutations = stringPermutationWithRecursion(allCharsExceptLast)

    val allPermutations = mutableSetOf<String>()
    for (permutation in permutations) {
        val n = allCharsExceptLast.length
        for (i in 0..n) {
            val newP = permutation.substring(0, i) + lastChar + permutation.substring(i, n)
            allPermutations.add(newP)
        }
    }

    return allPermutations
}

fun main() {
    println(stringPermutationWithRecursion("cats"))
}
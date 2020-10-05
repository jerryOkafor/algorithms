/*
 * Kotlin
 *
 * Copyright (C) 2020 Jerry Okafor
 * https://jerryokafor.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twoPointer

import utils.measure
import kotlin.math.min

//https://medium.com/hackernoon/manachers-algorithm-explained-longest-palindromic-substring-22cb27a5e96f
//https://medium.com/@tombaranowicz/how-to-solve-the-longest-palindromic-substring-problem-517c1c3429cf
//https://www.educative.io/edpresso/longest-palindromic-substring-in-on-with-manachers-algorithm?utm_source=Google%20AdWords&aid=5082902844932096&utm_medium=cpc&utm_campaign=kb-dynamic-edpresso&gclid=Cj0KCQjw5eX7BRDQARIsAMhYLP-ci-n-MKMZS3dB7XK-YHjFGCi5YU2_QmBentjqWbo19ifrpm_xeVoaAlTaEALw_wcB
/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * <p>Example:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer
 * */
//Solution 1: Brute Force - simple check all possible substrings => O(n^3)
//No accepted on LeetCode
fun longestPalindromicSubstringBruteForce(s: String): String {
    if (s.length == 1) return s
    var maxPalindrome = ""

    var i = 0
    while (i < s.length) {

        var j = i + 1;
        while (j < s.length) {
            val subString = s.substring(i, j)
            if (isPalindrome(subString)) {
                if (subString.length > maxPalindrome.length) {
                    maxPalindrome = subString
                }
            }
            j++
        }
        i++
    }
    return maxPalindrome
}

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    var isPalindrome = true

    while (left < right) {
        //println("left: $left | right: $right")
        if (s[left] != s[right]) {
            isPalindrome = false
            break
        }
        left++
        right--
    }
    return isPalindrome
}

//Solution 2: Using  Manacher's Algorithm: Acceptef => O(n)
fun lpsWithManachersAlgorithm(s: String): Int {
    val str = s.fold("#") { acc, c -> "$acc$c$#" }
    val len = 2 * s.length + 1
    val LPS = IntArray(len) { 0 }

    var center = 0 //center of the LPS
    var right = 0 //right boundary of the LPS

    for (i in 0 until len) {
        //get mirror index of i
        val mirror = 2 * center - i

        //see if the mirror of i is expanding beyond the left boundary of
        // the current longest palindrome at center c
        //if it is, then take right - i as P[i]
        //else take P[mirror] as P[i]
        if (i < right) {
            LPS[i] = min(right - i, LPS[mirror])
        }

        //expand at i
        var a = i + (1 + LPS[i])
        var b = i - (1 + LPS[i])
        while (a < len && b >= 0 && str[a] == str[b]) {
            LPS[i]++
            a++
            b--
        }

        //check if the expanded palindrome at i is expanding beyond the right
        // boundary of current longest palindrome at center c
        //if it is, the new center is i
        if (i + LPS[i] > right) {
            center = i
            right = i + LPS[i]
        }
    }


    val r = LPS.maxOrNull()!!
    val c = LPS.indexOf(r)
    val subString = str.substring(c - r, c + r).replace("#","")

    return subString.length
}


fun main() {

    println(isPalindrome("racecar"))

    measure("max Palindrome with Brute Force:") {
        println(longestPalindromicSubstringBruteForce("babad"))
    }
    measure("max Palindrome with Brute Force:") {
        println(lpsWithManachersAlgorithm("babad"))
    }
}
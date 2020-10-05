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

package palindrome


tailrec fun isPalindrome(s: String): Boolean {

    val N = s.length
    //base case 1: single char is a plaindrome
    if (N == 1) return true

    //base case #2, first and last char must be the same
    if (s.first() != s.last()) return false

    //remove the first and last chars and recurse
    return isPalindrome(s.substring(1, N - 1))
}

fun main() {
    val s = "madam"
    println(s.slice(1 until s.length - 1))
    println(s.subSequence(1, s.length - 1))
    println(isPalindrome("madam"))
    println(isPalindrome("racecar"))
    println(isPalindrome("here"))
}
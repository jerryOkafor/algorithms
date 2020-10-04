/*
 * Copyright 2020 Jerry Okafor
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

import kotlin.math.max

/**
 * Given a String find the length of the longest substring
 * without repeating characters.
 *
 * <p>Example:
 *
 * <p>Given "abcabcbb", the answer is "abc" with length 3
 */
//https://www.educative.io/edpresso/finding-length-of-longest-substring-without-repeating-characters
//https://www.youtube.com/watch?v=3IETreEybaA&ab_channel=NickWhite
//implementation using Hashset -> returns only the count
fun longestSubStringWithoutRepeating(s: String): Int {
    //constraint case
    if (s.isEmpty()) return 0
    if (s.isBlank()) return 1
    val map = hashSetOf<Char>()

    var leftPointer = 0
    var rightPointer = 0
    var max = 0

    while (rightPointer < s.length) {
        println(map)
        if (!map.contains(s[rightPointer])) {
            //just add the char to the map, increment rightPointer and calculate max
            map.add(s[rightPointer])
            rightPointer++
            max = max(map.size, max)
        } else {
            //remove char and increase the leftPointer
            //we have encountered a non unique char
            map.remove(s[leftPointer])
            leftPointer++
        }
    }
    return max

}

//implementation using HasMap -> return the substring
fun longestSubStringWithoutRepeatingWithHashMap(s: String): String {
    //constraint case
    if (s.isEmpty()) return s
    if (s.isBlank()) return s
    val hashSet= hashSetOf<Char>()

    var leftPointer = 0
    var rightPointer = 0
    var max = 0

    while (rightPointer < s.length) {
        println(hashSet)
        if (!hashSet.contains(s[rightPointer])) {
            //just add the char to the map, increment rightPointer and calculate max
            hashSet.add(s[rightPointer])
            rightPointer++
            max = max(hashSet.size, max)
        } else {
            //remove char and increase the leftPointer
            //we have encountered a non unique char
            hashSet.remove(s[leftPointer])
            leftPointer++
        }
    }
    return s.substring(leftPointer, rightPointer)

}

fun main() {
    println(longestSubStringWithoutRepeating("qrsvbspk"))
    println(longestSubStringWithoutRepeatingWithHashMap("qrsvbspk"))

}
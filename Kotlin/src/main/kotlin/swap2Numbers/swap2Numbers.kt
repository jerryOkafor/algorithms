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

package swap2Numbers

//Swap using + and - arithmetic operators
fun swapTwoNumbersWithPlusAndMinus(a: Int, b: Int): Pair<Int, Int> {
    var x = a
    var y = b

    x += y          // x = x + y
    y = x - y       // y = x - y
    x -= y          //x = x - y

    return Pair(x, y)
}

//Swap two numbers with * and /
fun swapTwoNumbersWithTimeAndDivision(a: Int, b: Int): Pair<Int, Int> {
    var x = a
    var y = b

    x *= y          // x = x * y
    y = x / y       // y = x / y
    x /= y          //x = x / y

    return Pair(x, y)
}

//swap two numbers wit XOR xor()
fun swapTwoNumbersWithXOR(a: Int, b: Int): Pair<Int, Int> {
    var x = a
    var y = b

    x = x xor y     // x = x ^ y
    y = x xor y     // y = x ^ y
    x = x xor y     //x = x ^ y

    return Pair(x, y)
}

fun main() {
    val a = 10
    val b = 50

    val (x, y) = swapTwoNumbersWithPlusAndMinus(10, 50) //property destructuring
    println(x == b)
    println(y == a)

    val (x1, y1) = swapTwoNumbersWithTimeAndDivision(10, 50) //property destructuring
    println(x1 == b)
    println(y1 == a)

    val (x2, y2) = swapTwoNumbersWithXOR(10, 50) //property destructuring
    println(x2 == b)
    println(y2 == a)
}
package twoQueens

import kotlin.math.abs


/**
 * @author jerry on 09/09/2020
 * for kotlin
 **/

/*You are given coordinates of two queens on a chess board. Find out whether or not they hit each other.

Input data format
Four integer numbers x_1, y_1, x_2, y_2x
1 1 2 2
Output data format
Type "YES" (uppercase) if they hit each other or "NO" if they don't.*/

fun theyHit(x1: Int, x2: Int, y1: Int, y2: Int): String {
    if (x1 == x2 || y1 == y2 || abs(x1 - x2) == abs(y1 - y2))
        return "YES"
    return "NO"
}

fun main() {
    println(theyHit(1, 1, 3, 3))
}
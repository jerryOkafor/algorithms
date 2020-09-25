package nmchocolate


/**
 * @author jerry on 09/09/2020
 * for kotlin
 **/

fun canCutKSegments(n: Int, m: Int, k: Int): Boolean {
    return ((k % n == 0 || k % m == 0) && k < m * n)
}

fun main() {
    print(if (canCutKSegments(4, 2, 6)) "YES" else "NO")
}
package creepingSnail


/**
 * @author jerry on 08/09/2020
 * for kotlin
 **/

fun findDays(height: Int, up: Int, down: Int): Int {
    var runningHeight = 0;
    var days = 0;

    while (true) {
        days++
        runningHeight += up

        if (runningHeight >= height) {
            break
        }

        runningHeight -= down
    }

    return days
}

fun main() {
    println(findDays(10, 3, 2))
    println(findDays(20, 7, 3))
}
package utils


/** @author jerry on 24/09/2020 for kotlin */

fun measure(title: String, func: () -> Unit) {
    val startTime = System.currentTimeMillis()
    func()
    val elapsedTime = System.currentTimeMillis() - startTime

    println("Time Elapsed for $title: $elapsedTime s")
}

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}

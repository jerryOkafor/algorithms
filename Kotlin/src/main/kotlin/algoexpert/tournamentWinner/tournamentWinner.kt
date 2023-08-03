/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 03/08/2023
*/

package algoexpert.tournamentWinner

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val scores = HashMap<String, Int>()
    // Write your code here.
    competitions.forEachIndexed { index, (home, away) ->
        println("Tournament between: Home(${home} and Away(${away}))  -> ${results[index]}]")

        when {
            results[index] == 1 -> {
                //home team won
                var score = 3
                if (scores.containsKey(home)) {
                    score += scores[home]!!
                }

                scores[home] = score

            }

            results[index] == 0 -> {
                //away team won
                var score = 3
                if (scores.containsKey(away)) {
                    score += scores[away]!!
                }
                scores[away] = score
            }
        }
    }
    val winner = scores.maxBy { it.value }

    println("${winner.key} won by ${winner.value} points")
    return winner.key
}

fun main() {
    println(
        tournamentWinner(
            competitions = listOf(
                listOf("HTML", "C#"),
                listOf("C#", "Python"),
                listOf("Python", "HTML")
            ), results = listOf(0, 0, 1)
        )
    )
}
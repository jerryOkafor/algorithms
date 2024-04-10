import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/04/2024
*/

data class User(val name: String, val profile: String)

sealed class UiState {
    data object Loading : UiState()
    data class Success(val user: User) : UiState()
    data class Error(val message: String) : UiState()
}

fun charCount(chars: String): String {
    val charArray = chars.toCharArray()
    val charMap = mutableMapOf<Char, Int>()

    for (char in charArray) {
        if (charMap.containsKey(char)) {
            charMap[char] = charMap.get(char)!! + 1
        } else {
            charMap[char] = 1
        }
    }

    return charMap.toSortedMap().entries.fold("") { acc, (key, value) ->
        acc + (if (value > 1) {
            "$key$value"
        } else {
            "$key"
        })
    }
}

//A string "aabbcccdeff" :  count the number of letters ---> "a2b2c3def2"

suspend fun main() = coroutineScope {
    launch {
        delay(1000)
        println("First finished")
    }

    launch {
        delay(2000)
        println("Second finished")
    }
    println(charCount("aafffrrrttdhgggw"))
}
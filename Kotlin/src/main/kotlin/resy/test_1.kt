/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 11/08/2023
*/

package resy

// -------- QUESTION -------- //
//
// Given the number of columns and the alphabet array, find the coordinates of a given letter when this alphabet is laid out on a grid.
//
// Imagine a keyboard on TV where the alphabet is laid out on a grid and every letter has a coordinate.
// Coordinates are the x and y or column and row values of the letter on this grid.

// -------- IMPLEMENTATION -------- //

class AlphabetGrid {

    // `alphabet` is a single list of String as letters
    val alphabet: List<String> = listOf<String>(
        //  <---- numberOfColumns ---->
        "a", "b", "c", "d",    // <- letters       (actual elements of array)
        //  (0,0)   (1,0)   (2,0)   (3,0)   // <- coordinates   (just comments, not part of array)

        "e",   "f",    "g",    "h",
        //  (0,1)   (1,1)   (2,1)   (3,1)

        "i", "j", "k", "l",
        //  (0,2)   (1,2)   (2,2)   (3,2)

        "m", "n", "o", "p",
        //  (0,3)   (1,3)   (2,3)   (3,3)

        "q", "r", "s", "t",
        //  (0,4)   (1,4)   (2,4)   (3,4)

        "u", "v", "w", "x",
        //  (0,5)   (1,5)   (2,5)   (3,5)

        "y", "z",
        //  (0,6)   (1,6)
    )
    val numberOfColumns: Int = 4

    fun getCoordinates(letter: String): Pair<Int, Int>? {

        // >>>>>>>> IMPLEMENT HERE <<<<<<<< //
        val matrixOfLetters = alphabet.chunked(4)

        matrixOfLetters.forEachIndexed { i, strings ->
            strings.forEachIndexed { j, s ->
                if (s == letter) return Pair(j, i)
            }
        }

        return null
    }
}

fun main() {
    val letter = "g"
    val grid = AlphabetGrid()
    val coordinates = grid.getCoordinates(letter)
    println(coordinates)

    val letterz = "z"
    val coordinatesz = grid.getCoordinates(letterz)
    println(coordinatesz)
}
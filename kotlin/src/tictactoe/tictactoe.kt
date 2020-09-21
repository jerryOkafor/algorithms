package tictactoe

import java.util.*

/**
 * Instructions
 * - Upon completion the program should let two players play Tic Tac Toe
 * - You can implement your own methods when you need to, or modify existing ones
 * - The isGameWon() method has some bugs, you need to find the bugs and fix them
 * - Implement the playing logic in the main function
 * - Thinking of edge cases and handling them is a plus
 * - executing input.nextLine(); in the main function will read input from the console
 */

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val game = TicTacToe()
    game.printBoard()
}


internal class TicTacToe {
    private val board = arrayOf(
        charArrayOf('N', 'N', 'N'),
        charArrayOf('N', 'N', 'N'),
        charArrayOf('N', 'N', 'N')
    )

    //Represents the current pal,yer
    private val currentPlayer = 'X'

    //prints the board at anytime
    fun printBoard() {

    }

    val isBoardFull: Boolean
        get() {
            return true
        }

    fun markCoordinates(line: String?): Boolean {
        return false
    }
    // check rows
    // check cols

    // check diag
    val isGameWon: Boolean
        get() {
            var rowsWon: Boolean
            var colsWon: Boolean
            var diagWon: Boolean
            diagWon = false
            colsWon = diagWon
            rowsWon = colsWon
            for (i in 0..board.size) {
                // check rows
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) rowsWon = true
                // check cols
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) colsWon = true
            }

            // check diag
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) diagWon = true
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) diagWon = true
            return rowsWon && colsWon && diagWon
        }
}
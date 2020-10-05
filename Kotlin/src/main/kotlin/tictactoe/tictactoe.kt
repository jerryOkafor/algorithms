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

    println("Welcome to TicTacToe!\nTo Play, simply enter a number between 1 and 9 corresponding to a position on the Board")

    //Begin player the game while !gameIsWon and !boardFull
    do {
        //print board each time
        game.printBoard()

        //make a move
        var move: Int
        do {
            println("\nPlayer: ${game.currentPlayer}, make your move")
            move = input.nextInt()

        } while (!game.markCoordinates(move))

        //toggle the player after a successful move
        game.togglePlayer()

    } while (!game.isBoardFull && !game.isGameWon)

    //if we are, either the board is full or the game is won
    if (game.isBoardFull && !game.isGameWon){
        print("Game over: Tie")
    }else{
        //print the board for reference
        game.printBoard()

        //toggle to get the exact player the won
        game.togglePlayer()

        println("\nGame Over: Player ${game.currentPlayer} Won!!")
    }

}


internal class TicTacToe {
    private val board = arrayOf(
        charArrayOf('N', 'N', 'N'),
        charArrayOf('N', 'N', 'N'),
        charArrayOf('N', 'N', 'N')
    )

    //Represents the current pal,yer
    var currentPlayer = PLAYER_X

    fun togglePlayer() {
        currentPlayer = if (currentPlayer == PLAYER_X) {
            PLAYER_0
        } else {
            PLAYER_X
        }
    }

    //prints the board at anytime
    fun printBoard() {
        println("\nGame Board:\n")
        for (row in board) {
            println(row.fold("|") { acc, c -> "$acc $c |" })
            println("-------------")
        }
    }

    val isBoardFull: Boolean
        get() {
            for (row in board) {
                if (row.contains(EMPTY_STATE))
                    return false
            }
            return true
        }

    fun markCoordinates(move: Int): Boolean {

        if (move !in 1..9) {
            println("Wrong Move, please try again")
        }
        when (move) {
            1 -> return markBoard(0, 0, move)
            2 -> return markBoard(0, 1, move)
            3 -> return markBoard(0, 2, move)
            4 -> return markBoard(1, 0, move)
            5 -> return markBoard(1, 1, move)
            6 -> return markBoard(1, 2, move)
            7 -> return markBoard(2, 0, move)
            8 -> return markBoard(2, 1, move)
            9 -> return markBoard(2, 2, move)
        }
        return false
    }

    private fun markBoard(x: Int, y: Int, move: Int): Boolean {
        if (board[x][y] == EMPTY_STATE) {
            board[x][y] = currentPlayer
            println("Nice move!")
            return true
        }
        return false
    }


    // check rows
    // check cols
    // check diag
    val isGameWon: Boolean
        get() {
            var rowsWon = false
            var colsWon = false
            var diagWon = false

            for (i in board.indices) {
                // check rows
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i]
                    && board[2][i] != EMPTY_STATE
                ) rowsWon = true
                // check cols
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2]
                    && board[i][2] != EMPTY_STATE
                ) colsWon = true
            }

            // check diag
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
                && board[2][2] != EMPTY_STATE
            ) diagWon = true
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]
                && board[2][0] != EMPTY_STATE
            ) diagWon = true

            return rowsWon || colsWon || diagWon
        }

    companion object {
        const val EMPTY_STATE = 'N'
        const val PLAYER_X = 'X'
        const val PLAYER_0 = 'O'
    }
}
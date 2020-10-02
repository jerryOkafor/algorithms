package tictactoe;

import java.util.Scanner;

/**
 * Instructions
 * - Upon completion the program should let two players play Tic Tac Toe
 * - You can implement your own methods when you need to, or modify existing ones
 * - The isGameWon() method has some bugs, you need to find the bugs and fix them
 * - Implement the playing logic in the main function
 * - Thinking of edge cases and handling them is a plus
 * - executing input.nextLine(); in the main function will read input from the console
 */

public class Main {
    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        TicTacToeJava game = new TicTacToeJava();
        System.out.println("To play this game, enter values between 1 and 9 representing the " +
                "Board position that corresponds to your move. All the best ");

        //start playing the game while board is not full
        //or game not won
        do {
            //Play the game:
            game.printBoard();

            //Take turns and swap players beginning with the current player
            //allow the current player to make a move, until he makes the right move,
            //continue here
            int move;
            do {
                System.out.println("Player: " + game.currentPlayer + ", make your move.");
                move = input.nextInt();

                //check if this move have been made
            } while (!game.markCoordinates(Character.forDigit(move, 10)));

            //toggle player
            game.togglePlayer();


        } while (!game.isGameWon() && !game.isBoardFull());

        //check if board is full or game won
        if (game.isBoardFull() && !game.isGameWon()) {
            System.out.println("Game was a tie!");
        } else {
            game.printBoard();

            //toggle to the last player who just won
            game.togglePlayer();

            System.out.println();
            System.out.println("Game Over!!");
            System.out.println("Player " + game.currentPlayer + " Wins!");
        }

    }

}

class TicTacToeJava {
    private char board[][] = {{'N', 'N', 'N'}, {'N', 'N', 'N'}, {'N', 'N', 'N'}};

    char currentPlayer = 'X';

    public void printBoard() {
        System.out.println("State of Board:");
        System.out.println();

        for (char[] chars : board) {
            System.out.print("| "); //print opening |
            for (int j = 0; j < board.length; j++) {
                System.out.print(chars[j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }

    }

    //added
    public void togglePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    //Loop through the board and check if any exist that is == 'N', then return false, else return true
    public boolean isBoardFull() {
        for (char[] chars : board) {
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == 'N') return false;
            }
        }
        return true;
    }

    //Should mark the coordinate which brings the move to and end
    //true if successfully marked and false if not successful
    //when false, current player remains the same and they are asked
    //to make another move until they make a move that has not been taken
    public boolean markCoordinates(char move) {
        switch (move) {
            case '1':
                if (board[0][0] == 'N') {
                    board[0][0] = currentPlayer;
                    System.out.println(move);
                    return true;
                }
            case '2':
                if (board[0][1] == 'N') {
                    board[0][1] = currentPlayer;
                    return true;
                }
            case '3':
                if (board[0][2] == 'N') {
                    board[0][2] = currentPlayer;
                    return true;
                }
            case '4':
                if (board[1][0] == 'N') {
                    board[1][0] = currentPlayer;
                    return true;
                }
            case '5':
                if (board[1][1] == 'N') {
                    board[1][1] = currentPlayer;
                    return true;
                }
            case '6':
                if (board[1][2] == 'N') {
                    board[1][2] = currentPlayer;
                    return true;
                }
            case '7':
                if (board[2][0] == 'N') {
                    board[2][0] = currentPlayer;
                    return true;
                }
            case '8':
                if (board[2][1] == 'N') {
                    board[2][1] = currentPlayer;
                    return true;
                }
            case '9':
                if (board[2][2] == 'N') {
                    board[2][2] = currentPlayer;
                    return true;
                }
        }

        return false;
    }

    //also match the content of the cells against the current player
    //We need to check this every time before playing another round of the game.
    public boolean isGameWon() {
        boolean rowsWon, colsWon, diagWon;
        rowsWon = colsWon = diagWon = false;

        for (int i = 0; i < board.length; i++) { //bug, because of zero indexing , you can not use <=array length
            // check rows 
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && (board[2][i] != 'N'))
                rowsWon = true;
            // check cols 
            if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) && (board[i][2] != 'N'))
                colsWon = true;
        }

        // check diag
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && (board[2][2] != 'N'))
            diagWon = true;
        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && (board[2][0] != 'N'))
            diagWon = true;
        return rowsWon || colsWon || diagWon;
    }

}


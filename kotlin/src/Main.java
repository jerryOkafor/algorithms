import java.util.Scanner;

/**
 Instructions
 - Upon completion the program should let two players play Tic Tac Toe
 - You can implement your own methods when you need to, or modify existing ones
 - The isGameWon() method has some bugs, you need to find the bugs and fix them
 - Implement the playing logic in the main function
 - Thinking of edge cases and handling them is a plus
 - executing input.nextLine(); in the main function will read input from the console
 */

public class Main {
    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.printBoard();

    }

}

class TicTacToe {
    private char board[][] = {{'N', 'N', 'N'}, {'N', 'N', 'N'}, {'N', 'N', 'N'}};
    private char currentPlayer = 'X';

    public void printBoard() {

    }

    public boolean isBoardFull() {

    }

    public boolean markCoordinates(String line) {

    }

    public boolean isGameWon() {
        boolean rowsWon, colsWon, diagWon;
        rowsWon = colsWon = diagWon = false;

        for (int i = 0; i <= board.length; i++) {
            // check rows
            if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) rowsWon = true;
            // check cols
            if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) colsWon = true;
        }

        // check diag
        if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) diagWon = true;
        if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) diagWon = true;
        return rowsWon && colsWon && diagWon;
    }

}


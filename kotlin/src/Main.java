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
        Scanner input = new Scanner(System.in);
//        Scanner scanner = new Scanner(System.in);
//        TicTacToe game = new TicTacToe();
//        game.printBoard()

//        final int year = scanner.nextInt();
//        boolean isLeap = false;
//        if (year % 4 == 0) {
//            if (year % 100 == 0) {
//                isLeap = year % 400 == 0;
//            } else {
//                isLeap = true;
//            }
//        } else {
//            isLeap = false;
//        }
//
//        System.out.print(isLeap ? "Leap" : "Regular");

//        int a = 4;
//        System.out.println(a++/*Uses a and increments it*/ + a/*The value of a has changed now to 9*/); // this is 9

//        int n1 = scanner.nextInt();
//        int n2 = scanner.nextInt();
//        int n3 = scanner.nextInt();
//        int n4 = scanner.nextInt();
//
//        System.out.printf("%d %d %d %d", --n1, --n2, --n3, --n4);

//        char c = 65;
//        char z = 'z';
//        char c1 = '\u0040';
////        char m = z - 10;
//        char x = '1' + '3';
//        System.out.println(x);
//
//        Scanner scanner = new Scanner(System.in);
//        final String str1 = scanner.nextLine();
//        final String str2 = scanner.nextLine();
//
//        final boolean theSame = str1.trim().replace(" ","").equalsIgnoreCase(str2.trim().replace(" ",""));
//        System.out.print(theSame);

//        final String line = scanner.nextLine();
//
//        final String[] contents = line.split("");
//
//        for (int i = 0; i < contents.length; i++) {
//            if (i == 0) {
//                System.out.println("---------");
//                System.out.print("|");
//            }
//            if (i != 0 && i % 3 == 0) {
//                System.out.print(" |");
//                System.out.println();
//                System.out.print("|");
//            }
//            System.out.print(" " + contents[i]);
//
//            if (i == contents.length - 1) {
//                System.out.print(" |");
//                System.out.println();
//                System.out.print("---------");
//            }
//        }

    }
}


class TicTacToe {
    private char board[][] = {{'N', 'N', 'N'}, {'N', 'N', 'N'}, {'N', 'N', 'N'}};
    private char currentPlayer = 'X';

    public void printBoard() {

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);


    }

//    public boolean isBoardFull() { }

//    public boolean markCoordinates(String line) {
//
//    }

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
        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) diagWon = true;
        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) diagWon = true;
        return rowsWon && colsWon && diagWon;
    }

}


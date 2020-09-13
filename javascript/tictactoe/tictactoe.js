'use strict'
//TicTacToa in Python: //https://techwithtim.net/tutorials/python-programming/tic-tac-toe-tutorial/
//Refer to Strict Mode: https://www.w3schools.com/js/js_strict.asp
//Stack Overfloe in Strict Mode: https://stackoverflow.com/questions/36444783/es6-javascript-declaring-variables-without-let-const

/* 
Why Strict Mode ?
Strict mode makes it easier to write "secure" JavaScript.

Strict mode changes previously accepted "bad syntax" into real errors.

As an example, in normal JavaScript, mistyping a variable name creates a new global variable.In strict mode, this will throw an error, making it impossible to accidentally create a global variable.

In normal JavaScript, a developer will not receive any error feedback assigning values to non - writable properties.

In strict mode, any assignment to a non - writable property, a getter - only property, a non - existing property, a non - existing variable, or a non - existing object, will throw an error.
 */


const readline = require('readline');

/**
    Instructions 
    - Upon completion the program should let two players play Tic Tac Toe 
    - You can implement your own functions when you need to, or modify existing ones 
    - The isGameWon() functions has some bugs, you need to find the bugs and fix them 
    - Implement the playing logic in the playGame function 
    - Thinking of edge cases and handling them is a plus 
    - executing 'await readInput();' in the playGame() function will read input from the console 
*/


const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const board = [
    ['N', 'N', 'N'],
    ['N', 'N', 'N'],
    ['N', 'N', 'N']
]

let currentPlayer = 'X';

toggleCurrentPlayer = () => {
    if (currentPlayer == 'X') { currentPlayer = 'O'; }
    if (currentPlayer == 'O') { currentPlayer = 'X'; }
}

let readInput = () => {
    return new Promise((resolve, reject) => {
        rl.question(`${currentPlayer}'s move: `, (answer) => {
            resolve(answer);
        });
    });
}

// debug this function 
let isGameWon = () => {
    let rowsWon = colsWon = diagWon = false;

    for (let i = 0; i <= board.length; i++) {
        // check rows
        if ((board[i][0] === board[i][1]) && (board[i][1] === board[i][2])) rowsWon = true;
        // check cols 
        if ((board[0][i] === board[1][i]) && (board[1][i] === board[2][i])) colsWon = true;
    }

    // Check diag
    if ((board[0][0] === board[1][1]) && (board[1][1] === board[2][2])) diagWon = true;
    if ((board[0][2] === board[1][1]) && (board[1][1] === board[2][0])) diagWon = true;

    return rowsWon && colsWon && diagWon;
}

let isBoardFull = () => {
    console.log("I am here")
}

let printBoard = () => {
    for (let i = 0; i < board.length; i++) {
        let row = ""
        for (let j = 0; j < board[i].length; j++) {

            row = row + " " + board[i][j] + " "

        }
        console.log(row)
    }

}

let markCoordinates = (line) => {

}


let playGame = async () => {
    printBoard()
    // You can use this statement to read input from the console 

    isBoardFull = false
    console.log(isBoardFull)

    // isBoardFull = true
    // console.log(isBoardFull())
}

playGame();
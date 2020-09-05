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

readInput = () => {
    return new Promise((resolve, reject) => {
        rl.question(`${currentPlayer}'s move: `, (answer) => {
            resolve(answer);
        });
    });
}

// debug this function 
isGameWon = () => {
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

isBoardFull = () => {

}

printBoard = () => {
    for (let i = 0; i < board.length; i++) {
        let row = ""
        for (let j = 0; j < board[i].length; j++) {

            row = row + " " + board[i][j] + " "

        }
        console.log(row)
    }

}

markCoordinates = (line) => {

}


playGame = async () => {
    printBoard();
    // You can use this statement to read input from the console 
    // let line = await readInput();

}

playGame();



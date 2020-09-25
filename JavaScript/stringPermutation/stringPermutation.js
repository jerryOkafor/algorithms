//Ref: https://levelup.gitconnected.com/find-all-permutations-of-a-string-in-javascript-af41bfe072d2
/*
:::Master Thorem:

1: Establish a base case — if our input’s size is less than a certain constant, solve it directly without recursion.
2: If the input is bigger than said constant, break it down into smaller pieces.
3: Call the function recursively on the pieces, until they are small enough to be solved directly.
4: Combine the results from the pieces, and return the completed solution.

::Pseudocode
procedure p( input x of size n ):
   if n < some constant k:
     Solve x directly without recursion
   else:
     Create a subproblems of x, each having size n/b
     Call procedure p recursively on each subproblem
     Combine the results from the subproblems
*/


/* 
Returns array of all posible permutations for the given string
*/
let findPermutations = (string, repeating = false) => {
    if (!string || typeof string != "string") {
        return new CustomException("Please enter a string")
    } else if (string.length < 2) {//0 or 1
        return [string]
    }

    let permutattionsArray = []

    for (let i = 0; i < string.length; i++) {
        //get the string for i
        let char = string[i]

        //console.log(i, ":", string.indexOf(char))
        if (string.indexOf(char) != i && !repeating)
            continue

        //get the reaming characters and invoke recursively
        let remainingChar = string.slice(0, i) + string.slice(i + 1, string.length)

        //invoke recursion on reaminaing char and combine results
        for (let permutation of findPermutations(remainingChar)) {
            permutattionsArray.push(char + permutation)
        }

    }

    return permutattionsArray
}

module.exports = findPermutations
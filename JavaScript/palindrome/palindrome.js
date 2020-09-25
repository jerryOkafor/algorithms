/*
1. If the string is made of no letters or just one letter, then it is a palindrome.
2. Otherwise, compare the first and last letters of the string.
3. If the first and last letters differ, then the string is not a palindrome.
4. Otherwise, the first and last letters are the same. Strip them from the string,
and determine whether the string that remains is a palindrome. Take the answer for this
smaller string and use it as the answer for the original string
*/
// Returns the first character of the string str
const firstCharacter = function (str) {
    return str.slice(0, 1);
};

// Returns the last character of a string str
const lastCharacter = function (str) {
    return str.slice(-1);
};

// Returns the string that results from removing the first
//  and last characters from str
const middleCharacters = function (str) {
    return str.slice(1, -1);
};

const isPalindrome = function (str) {
    // base case #1
    if (str.length <= 0) { return true; }
    // base case #2
    if (firstCharacter(str) !== lastCharacter(str)) { return false; }
    // recursive case
    return isPalindrome(middleCharacters(str));
};

module.exports = isPalindrome
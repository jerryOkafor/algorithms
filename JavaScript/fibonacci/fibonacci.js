var memo = {}

/* 
Obtain the first n+1 fibonacci
*/
const fibonacci = (n) => {
    if (n === 0 || n == 1) {
        return [0, 1]
    } else if (memo[n]) {
        return memo[n]
    } else {
        var result = fibonacci(n - 1)
        result.push(result[result.length - 1] + result[result.length - 2])
        memo[n] = result
        return result
    }
}


module.exports = fibonacci
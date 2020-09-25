const factorial = (n) => {
    //preconditons
    if (isNaN(n)) throw 'not a number'
    if (n < 0) throw 'not a positive number'
    //base
    if (n === 0) { return 1 }

    return n * factorial(n - 1)
}

module.exports = factorial
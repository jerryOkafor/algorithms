const isEven = (n) => {
    return n % 2 === 0;
};

const isOdd = (n) => {
    return !isEven(n);
};

const power = (x, n) => {
    // base case
    if (n === 0) { return 1; }
    // recursive case: n is negative 
    if (n < 0) {
        return 1 / power(x, -n);
    }
    // recursive case: n is odd
    if (n > 0 && isOdd(n)) {
        return x * power(x, n - 1);
    }
    // recursive case: n is even
    if (n > 0 && isEven(n)) {
        var y = power(x, n / 2);
        return y * y;
    }
};

module.exports = power
let isPrime = require('./primeNumber')

describe('Test isPrime', () => {
    it("Should return true", () => {
        expect(isPrime(2)).toBeTruthy()
        expect(isPrime(3)).toBeTruthy()
        expect(isPrime(7)).toBeTruthy()
    })

    it("Should return false", () => {
        expect(isPrime(1)).toBeFalsy()
        expect(isPrime(4)).toBeFalsy()
        expect(isPrime(6)).toBeFalsy()
    })

})
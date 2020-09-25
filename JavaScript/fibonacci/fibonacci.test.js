const fibonacci = require("./fibonacci")


describe("Test Fibonacci", () => {
    it("Should return : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55", () => {
        expect(fibonacci(10)).toEqual([0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55])
    })
})
var factorial = require("./factorial")


describe("Test Recursive Facotrial",()=>{
    it("Should return 1",()=>{
        expect(factorial(0)).toBe(1)
    })

    it("Should throw",()=>{
        expect(() => { factorial("a") }).toThrowError('not a number')
    })

    it("Should throw", () => {
        expect(() => { factorial(-1) }).toThrowError('not a positive number')
    })

    it("Should return 120", () => {
        expect(factorial(5)).toBe(120)
    })

    it("Should return 24", () => {
        expect(factorial(4)).toBe(24)
    })

    it("Should return 8", () => {
        expect(factorial(8)).toBe(40320)
    })

    it("Should return 8", () => {
        expect(factorial(8)).toBe(40320)
    })
})
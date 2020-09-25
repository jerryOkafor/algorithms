const isPalindrome = require("./palindrome")

describe("Test isPalindrome",()=>{
    it("Should return true",()=>{
        expect(isPalindrome("")).toBeTruthy()
    })

    it("Should return true", () => {
        expect(isPalindrome("a")).toBeTruthy()
    })

    it("Should return true", () => {
        expect(isPalindrome("motor")).toBeFalsy()
    })

    it("Should return true", () => {
        expect(isPalindrome("rotor")).toBeTruthy()
    })

    it("Should return true", () => {
        expect(isPalindrome("madam")).toBeTruthy()
    })

    it("Should return true", () => {
        expect(isPalindrome("racecar")).toBeTruthy()
    })
})
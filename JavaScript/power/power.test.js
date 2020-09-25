const power = require("./power")


describe("Test Power", () => {
    it("Should return 1", () => {
        expect(power(3,0)).toBe(1)
    })

    it("Should return 3", () => {
        expect(power(3, 1)).toBe(3)
    })

    it("Should return 9", () => {
        expect(power(3, 2)).toBe(9)
    })

    it("Should return 1/3", () => {
        expect(power(3, -1)).toBe(1/3)
    })

    it("Should return 8", () => {
        expect(power(2, 3)).toBe(8)
    })

    it("Should return 625", () => {
        expect(power(5, 4)).toBe(625)
    })
})
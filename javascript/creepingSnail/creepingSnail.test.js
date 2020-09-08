let findDays = require('./creepingSnail')

describe("Test creeping snail problem", () => {
    it("Should Return 8", () => {
        expect(findDays(10,3,3)).toBe(8)
        expect(findDays(20,7,3)).toBe(5)

    })
})
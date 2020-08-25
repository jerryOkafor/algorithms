var insert = require("./insertValueToArray")

var array = [3, 5, 7, 11, 13, 2, 9, 6]

describe("Test Insert Value to an array", () => {
    it("Should return [2, 3, 5, 7, 11, 13, 9, 6]", () => {
        insert(array, 4, 2)
        expect(array).toEqual([2, 3, 5, 7, 11, 13, 9, 6])
    })

    it("Should return [2, 3, 5, 7, 9, 11, 13, 6]", () => {
        insert(array, 5,9)
        expect(array).toEqual([2, 3, 5, 7, 9, 11, 13, 6])
    })

    it("Should return [2, 3, 5, 6, 7, 9, 11, 13]", () => {
        insert(array, 6, 6)
        expect(array).toEqual([2, 3, 5, 6, 7, 9, 11, 13])
    })

})
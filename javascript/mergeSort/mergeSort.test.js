var merge = require('./mergeSort').merge
var sortWithMerge = require('./mergeSort').sortWithMerge



var array = [3, 7, 12, 14, 2, 6, 9, 11]
var array2 = [-1, 2, 4, 15, 20, 7, 8, 9, 11, 15]
describe("Test merge array with sorted subarray", () => {
    it("Should return : [2, 3, 6, 7, 9, 11, 12, 14]", () => {
        merge(array, 0, Math.floor((0 + array.length - 1) / 2), array.length - 1)
        expect(array).toEqual([2, 3, 6, 7, 9, 11, 12, 14])
    })

    it("Should return : [-1, 2, 4, 7, 8, 9, 11, 15, 15, 20]", () => {
        merge(array2, 0, Math.floor((0 + array2.length - 1) / 2), array2.length - 1)
        expect(array2).toEqual([-1, 2, 4, 7, 8, 9, 11, 15, 15, 20])
    })
})

var array3 = [14, 7, 3, 12, 9, 11, 6, 2]
var array4 = [14, -1, -3, 4, 6, 12, 60]
describe("Test Merge sort", () => {
    it("Should return : [2, 3, 6, 7, 9, 11, 12, 14]", () => {
        sortWithMerge(array3)
        expect(array3).toEqual([2, 3, 6, 7, 9, 11, 12, 14])
    })

    it("Should return : [-3, -1, 4, 6, 12, 14, 60]", () => {
        sortWithMerge(array4)
        expect(array4).toEqual([-3, -1, 4, 6, 12, 14, 60])
    })
})
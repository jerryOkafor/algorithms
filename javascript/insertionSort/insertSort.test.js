var { insert, insertionSort } = require("./insertionSort")

var array = [3, 5, 7, 11, 13, 2, 9, 6]

describe("Test Insert Value to an array", () => {
    it("Should return [2, 3, 5, 7, 11, 13, 9, 6]", () => {
        insert(array, 4, 2)
        expect(array).toEqual([2, 3, 5, 7, 11, 13, 9, 6])
    })

    it("Should return [2, 3, 5, 7, 9, 11, 13, 6]", () => {
        insert(array, 5, 9)
        expect(array).toEqual([2, 3, 5, 7, 9, 11, 13, 6])
    })

    it("Should return [2, 3, 5, 6, 7, 9, 11, 13]", () => {
        insert(array, 6, 6)
        expect(array).toEqual([2, 3, 5, 6, 7, 9, 11, 13])
    })

})


var arrayToSort = [22, 11, 99, 88, 9, 7, 42];
var arrayToSort2 = [-22, 0, 1, -1, 11, 99, 88, 9, 7, 42, 45, 89, 200]
describe("Test InsertionSort", () => {
    it("Should return sorted array: [7, 9, 11, 22, 42, 88, 99]", () => {
        insertionSort(arrayToSort)
        expect(arrayToSort).toEqual([7, 9, 11, 22, 42, 88, 99])
    })

    it("Should return sorted array: [-22, -1,0, 1, 7, 9, 11, 42, 45, 88, 89, 99, 200]", () => {
        insertionSort(arrayToSort2)
        expect(arrayToSort2).toEqual([-22, -1, 0, 1, 7, 9, 11, 42, 45, 88, 89, 99, 200])
    })
})
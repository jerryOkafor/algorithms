var selectionSort = require("./selectionSort")

var array = [22, 11, 99, 88, 9, 7, 42];
var array2 = [99, 10, 77, 4, 5, -1, 0, 3, 8, 2]

var sortedArray = [7, 9, 11, 22, 42, 88, 99]
var sortedArray2 = [-1, 0, 2, 3, 4, 5, 8, 10, 77, 99]

describe("Test Selection Sort", () => {
    it(`Should return sorted array = [${sortedArray}]`, () => {
        expect(selectionSort(array)).toEqual(sortedArray)
    });

    // it(`Should return sorted array  = [${sortedArray2}]`, () => {
    //     expect(selectionSort(array2)).toEqual(sortedArray2)
    // })
})
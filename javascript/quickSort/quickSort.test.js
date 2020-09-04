const partition = require('./quickSort').partition
const sortWithQuickSort = require('./quickSort').sortWithQuickSort

var array = [9, 7, 5, 11, 12, 2, 14, 3, 10, 4, 6]
var array2 = [-1, 0, 5, 11, 12, 2, 14, 3, 10, 4, 5]
describe("Test Partition", () => {
    it("Should return : [5, 2, 3, 4, 6, 7, 14, 9, 10, 11, 12]", () => {
        expect(partition(array, 0, array.length - 1)).toBe(4)
        expect(array).toEqual([5, 2, 3, 4, 6, 7, 14, 9, 10, 11, 12])
    })
    
    it("Should return : [-1, 0, 5, 2, 3, 4, 5, 12, 10, 11, 14]", () => {
        expect(partition(array2, 0, array2.length - 1)).toBe(6)
        expect(array2).toEqual([-1, 0, 5, 2, 3, 4, 5, 12, 10, 11, 14])
    })
})
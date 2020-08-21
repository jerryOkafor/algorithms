var doSearch = require("./../binarySearch")

var primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
    41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];

describe("Test binarySearch", () => {
    it("Shoult return 20", () => {
        expect(doSearch(primes, 73)).toBe(20)
    })

    it("Shoult return 19", () => {
        expect(doSearch(primes, 71)).toBe(19)
    })

    it("Shoult return 9", () => {
        expect(doSearch(primes, 29)).toBe(9)
    })

    it("Shoult return -1", () => {
        expect(doSearch(primes, 100)).toBe(-1)
    })

})



// var result = doSearch(primes, 73);
// console.log("Found prime at index " + result);

// Program.assertEqual(doSearch(primes, 73), 20);
// Program.assertEqual(doSearch(primes, 71), 19);
// Program.assertEqual(doSearch(primes, 29), 9);
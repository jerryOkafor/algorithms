let findPermutations = require('./stringPermutation')

describe("Test String Permutations", () => {
    it("Should return all the posible permutations for a given string with or without repeatation", () => {
        let permutations = findPermutations("aabc", repeating = true)
        expect(permutations.length).toBe(18)
        expect(permutations).toEqual([
            'aabc', 'aacb', 'abac',
            'abca', 'acab', 'acba',
            'aabc', 'aacb', 'abac',
            'abca', 'acab', 'acba',
            'baac', 'baca', 'bcaa',
            'caab', 'caba', 'cbaa'
        ])


        let permutations2 = findPermutations("aabc", repeating = false)
        expect(permutations2.length).toBe(12)
        expect(permutations2).toEqual([
            'aabc', 'aacb',
            'abac', 'abca',
            'acab', 'acba',
            'baac', 'baca',
            'bcaa', 'caab',
            'caba', 'cbaa'
        ])
    })
})
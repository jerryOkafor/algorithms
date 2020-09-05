const doBFS = require("./bdfs").doBFS
// const printBFSInfo = require("./bdfs").printBFSInfo


var adjList = [
    [1],
    [0, 4, 5],
    [3, 4, 5],
    [2, 6],
    [1, 2],
    [1, 2, 6],
    [3, 5],
    []
];


describe("Test BFS on Adjacency List", () => {
    it("Should Pass", () => {
        var bfsInfo = doBFS(adjList, 3);
        expect(bfsInfo[0]).toEqual({ distance: 4, predecessor: 1 })
        expect(bfsInfo[1]).toEqual({ distance: 3, predecessor: 4 })
        expect(bfsInfo[2]).toEqual({ distance: 1, predecessor: 3 })
        expect(bfsInfo[3]).toEqual({ distance: 0, predecessor: null })
        expect(bfsInfo[4]).toEqual({ distance: 2, predecessor: 2 })
        expect(bfsInfo[5]).toEqual({ distance: 2, predecessor: 2 })
        expect(bfsInfo[6]).toEqual({ distance: 1, predecessor: 3 })
        expect(bfsInfo[7]).toEqual({ distance: null, predecessor: null })
    })
})
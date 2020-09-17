let dfs = require('./dfs').doDFS

let adjacencyList = new Map();
adjacencyList.set(1, new Set([2, 3]));
adjacencyList.set(2, new Set([3, 4]));
adjacencyList.set(3, new Set());
adjacencyList.set(4, new Set([3]));

let adjList = [
    [1],
    [0, 4, 5],
    [3, 4, 5],
    [2, 6],
    [1, 2],
    [1, 2, 6],
    [3, 5],
    []
];


describe('Test DFS', () => {
    it('Should Pass: ', () => {
        var dfsInfo = dfs(adjList, 3);
        expect(dfsInfo[0]).toEqual({ distance: 4, predecessor: 1, visited: true })
        expect(dfsInfo[1]).toEqual({ distance: 3, predecessor: 5, visited: true })
        expect(dfsInfo[2]).toEqual({ distance: 1, predecessor: 3, visited: true })
        expect(dfsInfo[3]).toEqual({ distance: 0, predecessor: null, visited: false })
        expect(dfsInfo[4]).toEqual({ distance: 4, predecessor: 1, visited: true })
        expect(dfsInfo[5]).toEqual({ distance: 2, predecessor: 6, visited: true })
        expect(dfsInfo[6]).toEqual({ distance: 1, predecessor: 3, visited: true })
        expect(dfsInfo[7]).toEqual({ distance: null, predecessor: null, visited: false })
    })
})
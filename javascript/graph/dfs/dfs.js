let Stack = require('./../../util/Stack')
/*
Graph representation as adjacency list can be implemented in two or more forms as
1. Using 2 Dimenesional arrays
2. Using HasMap and HasSet
*/

//1. Using 2 Dimensional Array:
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


//2. Using Hash-Map and Hash-Set
let adjacencyList = new Map()
adjacencyList.set(0, new Set([1]))
adjacencyList.set(1, new Set([0, 4, 5]))
adjacencyList.set(2, new Set([3, 4, 5]))
adjacencyList.set(3, new Set([2, 6]))
adjacencyList.set(4, new Set([1, 2]))
adjacencyList.set(5, new Set([1, 2, 6]))
adjacencyList.set(6, new Set([3, 5]))
adjacencyList.set(7, new Set([]))

/* 
Perform a breath-first search (DFS) on a graph using stack
@param {array} graph
@param the index of the spurce vertex
@return {array} Array of objects describing each vertex like : [{distance: _, predecessor:_}]

Note : graph is treated as connected graph

*/
const doDFS = (graph, source) => {

    let dfsInfo = [];

    for (var i = 0; i < graph.length; i++) {
        dfsInfo[i] = {
            distance: null,
            predecessor: null,
            visited: false
        };
    }

    dfsInfo[source].distance = 0
    const stack = new Stack()
    stack.push(source)

    while (stack.length) {
        //console.log('Using Stack: ', stack)
        const nodeIndex = stack.pop()
        //console.log(`Popping: ${nodeIndex}`)

        console.log(graph[nodeIndex])

        for (child of graph[nodeIndex]) {
            console.log(child)

            //console.log(`Distance: ${dfsInfo[child].distance}`)
            if (dfsInfo[child].distance === null) {

                dfsInfo[child].distance = dfsInfo[nodeIndex].distance + 1

                dfsInfo[child].predecessor = nodeIndex

                dfsInfo[child].visited = true

                //console.log(`Pushing: ${child}`)
                stack.push(child)

            }

        }
    }

    return dfsInfo
}

/* 
DFS for connected graph
*/
const dfsConnected = (graph, source) => {
    const visited = new Set();

    const visit = console.log;

    const dfs = (graph, node) => {
        //visit(node);
        visited.add(node);

        for (let child of graph.get(node)) {
            if (!visited.has(child)) {
                dfs(graph, child);
            }
        }
    };

    dfs(graph, source)
    return visited
}

/* 
DFS for disconnected graph
*/
const dfsDisconnected = (graph, source) => {
    const visited = new Set();

    const visit = console.log;

    const dfs = (graph, node) => {
        //visit(node);
        visited.add(node);

        for (let child of graph.get(node)) {
            if (!visited.has(child)) {
                dfs(graph, child);
            }
        }
    };

    dfs(graph, source)


    //Iterate over all the nodes and start dfs for each node that has not
    //been visited yet. Therefore, we visit all nodes even if they are isolated.
    for (let key of graph.keys()) {
        console.log('Key: ', key)
        if (!visited.has(key)) {
            dfs(graph, key)
        }
    }


    return visited
}


const printDFSInfo = (dfsInfo) => {
    for (var i = 0; i < adjList.length; i++) {
        console.log(`Vertex ${i} : distance  = ${dfsInfo[i].distance}, predecessor = ${dfsInfo[i].predecessor}, visited: ${dfsInfo[i].visited}`);
    }

}

module.exports = {
    doDFS,
    printDFSInfo
}


var dfsInfo = doDFS(adjList, 3);
printDFSInfo(dfsInfo)


//Do dfs as connected graph, node 7 will be ommited
console.log(dfsConnected(adjacencyList, 3)) // => Set { 3, 2, 4, 1, 0, 5, 6 }

//do dfs as disconnected graph, node 7 will be added to ensure that all node has been visited.
console.log(dfsDisconnected(adjacencyList, 3)) // => Set { 3, 2, 4, 1, 0, 5, 6, 7 }

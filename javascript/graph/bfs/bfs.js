var Queue = require('./../../util/Queue')

/*
 * Performs a breadth-first search (BFS) on a graph
 * @param {array} graph - Graph, represented as adjacency lists.
 * @param {number} source - The index of the source vertex.
 * @returns {array} Array of objects describing each vertex, like
 *     [{distance: _, predecessor: _ }]
 */
const doBFS = (graph, source) => {
    var bfsInfo = [];

    for (var i = 0; i < graph.length; i++) {
        bfsInfo[i] = {
            distance: null,
            predecessor: null
        };
    }

    bfsInfo[source].distance = 0;

    var queue = new Queue();
    queue.enqueue(source);

    // Traverse the graph
    // As long as the queue is not empty:
    while (!queue.isEmpty()) {
        console.log("Using Queue: ", queue)
        //  Repeatedly dequeue a vertex u from the queue.
        var u = queue.dequeue();
        console.log(`Dequeue ${u} : >>>`, graph[u])

        //  For each neighbor v of u that has not been visited:
        for (var i = 0; i < graph[u].length; i++) {
            var v = graph[u][i];

            //check if neighbor has been visited
            //this could be an actual value check of the search query.
            if (bfsInfo[v].distance === null) {
                //Set distance to 1 greater than u's distance
                bfsInfo[v].distance = bfsInfo[u].distance + 1;

                //Set predecessor to u
                bfsInfo[v].predecessor = u;

                //Enqueue v
                console.log(`Enqueue : ${v}`)
                queue.enqueue(v);

            }



        }
    }

    return bfsInfo;
};


const printBFSInfo = (bfsInfo) => {
    for (var i = 0; i < adjList.length; i++) {
        console.log("vertex " + i + ": distance = " + bfsInfo[i].distance + ", predecessor = " + bfsInfo[i].predecessor);
    }

}


module.exports = {
    doBFS,
    printBFSInfo
}

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


var bfsInfo = doBFS(adjList, 3);
printBFSInfo(bfsInfo)

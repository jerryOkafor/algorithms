var Queue = require("./../util/Queue")

/*
 * Performs a breadth-first search on a graph
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
        //  Repeatedly dequeue a vertex u from the queue.
        var u = queue.dequeue();

        //  For each neighbor v of u that has not been visited:
        for (var i = 0; i < graph[u].length; i++) {
            var v = graph[u][i];

            //check if neighbor has been visited
            if (bfsInfo[v].distance === null) {
                //Set distance to 1 greater than u's distance
                bfsInfo[v].distance = bfsInfo[u].distance + 1;

                //Set predecessor to u
                bfsInfo[v].predecessor = u;

                //Enqueue v
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
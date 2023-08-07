/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package core


//lambda function that accepts the visited node
//this can be used to print the node or simply mark it as
//visited for potential skipping for optimization purposes
typealias TreeNodeVisitor<T> = (TreeNode<T>) -> Unit

//Represent the node of a Tree
class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    //Implementation of Dept-First Traversal using Recursion
    //Same can also be implemented using Stack
    fun forEachDepthFirst(visit: TreeNodeVisitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    //Implementation of Breath-First Traversal or Level order
    //Using Queue
    fun forEachLevelOrder(visit: TreeNodeVisitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }

        return result
    }

    //Runs in O(n) time and space complexity
    fun printEachLevel() {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()) {
            nodesLeftInCurrentLevel = queue.count

            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            println()
        }
    }
}
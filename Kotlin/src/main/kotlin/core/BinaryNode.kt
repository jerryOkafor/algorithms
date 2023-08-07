/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package core

import kotlin.math.max

typealias BinaryNodeVisitor<T> = (BinaryNode<T>?) -> Unit

class BinaryNode<T : Comparable<T>>(var value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    //The min of any node is always on the right
    //If this is called with the rightNode, then we follow
    //the left path and find the min recursively
    val min: BinaryNode<T>?
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBST(this, min = null, max = null)

    //Uses recursion to determine if a TreeNode is Binary search tree
    //The left node must be less than the parent node and the right node
    //must  be grater than or equal to the parent not for the TreeNode to qualify as BST
    //Runs in O(n) time and space complexity
    private fun isBST(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        tree ?: return false

        if (min != null && tree.value <= min) {
            return false

        } else if (max != null && tree.value > max) {
            return false
        }

        return isBST(tree.leftChild, min, tree.value)
                && isBST(tree.rightChild, tree.value, max)
    }

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node = node.rightChild, top = "$top ", root = "$top┌──", bottom = "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    //Runs in O(n) time and space complexity
    fun traverseInOrder(visit: BinaryNodeVisitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(this)
        rightChild?.traverseInOrder(visit)
    }

    //Runs in O(n) time and space complexity
    fun traversePreOrder(visit: BinaryNodeVisitor<T>) {
        visit(this)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    //Runs in O(n) time and space complexity
    fun traversePostOrder(visit: BinaryNodeVisitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(this)
    }

    //Adding a recursive approach to finding the height of a Binary tree
    //Runs in O(n) time and space complexity
    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild), height(node.rightChild)) } ?: -1
    }

    //Serialize a binary list into an array of nullables using pre-order traversal
    //Runs in O(n) time complexity
    fun traversePreOrderWithNull(visit: BinaryNodeVisitor<T>) {
        visit(this)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    //Runs in O(n) time and O(n) space complexity
    fun serialize(node: BinaryNode<T> = this): List<T?> {
        val list = mutableListOf<T?>()
        node.traversePreOrderWithNull { list.add(it?.value) }
        return list
    }

    //Runs in O(n^2) time complexity. This is because removing the array from the front
    //will require the array to adjust one step forward in memory. It would have been better to remove from the back
    fun deserialize(list: MutableList<T?>): BinaryNode<T>? {
        val rootValue = list.removeAt(0) ?: return null

        val root = BinaryNode(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root
    }

    private fun deserializeReversed(list: MutableList<T?>): BinaryNode<T>? {
        val rootValue = list.removeAt(list.size - 1) ?: return null

        val root = BinaryNode(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root
    }

    //Runs in O(n) time and space complexity because a new list was created and we chose recursion
    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T>? {
        return deserializeReversed(list.asReversed())
    }

    //Runs in O(n) time and space complexity
    override fun equals(other: Any?): Boolean {
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value
                    && this.leftChild == other.leftChild
                    && this.rightChild == other.rightChild
        } else {
            false
        }
    }

}
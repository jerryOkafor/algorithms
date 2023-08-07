/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 05/08/2023
*/

package core

class BinarySearchTree<T : Comparable<T>> {

    var root: BinaryNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(
        node: BinaryNode<T>?, value: T
    ): BinaryNode<T> {
        node ?: return BinaryNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(
        node: BinaryNode<T>?, value: T
    ): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {

                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }

                if (node.leftChild == null) {
                    return node.rightChild
                }

                if (node.rightChild == null) {
                    return node.leftChild
                }

                node.rightChild?.min?.value?.let {
                    node.value = it
                }

                node.rightChild = remove(node.rightChild, node.value)
            }

            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

    override fun toString() = root?.toString() ?: "empty tree"

    fun contains(value: T): Boolean {
        // 1
        var current = root

        // 2
        while (current != null) {
            // 3
            if (current.value == value) {
                return true
            }

            // 4
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }

        return false
    }

    //Runs in O(n) time and space complexity because of
    //single visit to all the nodes and recursive iteration
    fun contains(subTree: BinarySearchTree<T>): Boolean {
        val set = mutableSetOf<T>()

        root?.traverseInOrder {
            it?.value?.let { it1 -> set.add(it1) }
        }

        var isEqual = true
        subTree.root?.traverseInOrder {
            isEqual = isEqual && set.contains(it?.value)
        }

        return isEqual
    }
}

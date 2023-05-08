/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 24/04/2023
*/

package linkedlist.v3

import linkedlist.Node


/**
 * LinkedList to manage [Node]
 *
 * A Linked list has the concept of head and tail which represents the
 * first and last nodes of the list respectively.
 */
class LinkedList<T> : Iterable<T>, Collection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size: Int = 0
        private set


    override fun isEmpty(): Boolean {
        return size == 0
    }

    /**
     * Adds a value at the front of the list. This is also callced
     * head-first-insertion
     *
     * We are using the Fluent interface pattern here by retuning the same
     * object so that we can have multiple chaining.
     *
     * @param value T is the value we wish to push.
     * @return [LinkedList]
     */
    fun push(value: T): LinkedList<T> {
        //replace head and make the prev value the next of the new head
        head = Node(value = value, next = head)

        if (tail == null) {
            //an initially empty list if head is not set
            tail = head
        }

        //increase size
        size++
        return this
    }

    /**
     * Adds a value at the end of the list.
     *
     * @param value T we wish to append
     * @return [LinkedList]
     */
    fun append(value: T): LinkedList<T> {

        //re-use push() function for when the list is empy
        if (isEmpty()) {
            push(value)
            return this
        }

        with(Node(value = value)) {
            //update next value of current tail
            tail?.next = this

            //make the new node the current tail
            tail = this

            //increase size
            size++
        }
        return this

    }

    /**
     * Adds a value after a particular node of the list.
     *
     * @param value T we wish to insert
     * @param afterNode [Node], is the node we wish to insert value after
     * @return [Node]
     */
    fun insert(value: T, afterNode: Node<T>): Node<T> {
        //if we are at the end of the list, we can use append to accomplish our task
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        //make the next value of the new node to be the next value of the after node
        val newNode = Node(value = value, next = afterNode.next)

        //update after node
        afterNode.next = newNode
        size++

        return newNode
    }

    /**
     * Adds value after a particular node with index
     *
     * @param value T we wish to insert
     * @param afterIndex [Int] the index after which we wish to insert a value.
     * @return [Node]
     */
    fun insert(value: T, afterIndex: Int): Node<T>? {
        val afterNode = nodeAt(afterIndex + 1)
        afterNode?.let {
            return insert(value, it)
        }
        return null

    }

    /**
     * Removes the value at the front of the list
     *
     * @return [T], the value removed from the list
     */
    fun pop(): T? {
        if (!isEmpty()) size--

        //extract the current head a keep it safe
        val output = head?.value

        //make a new head
        head = head?.next

        //Clean up -> if the above operation results to empty list,
        //we need to clear tail too
        if (isEmpty()) {
            tail = null //allow for garbage collection
        }

        return output
    }

    /**
     * Removes the value at the end of the list
     *
     * @return [T], the value removed from the list
     */
    fun removeLast(): T? {
        //if head does not exist -> empty list
        val head = head ?: return null

        //if we have just one item on the list, then head == tail
        //and head.next == null
        if (head.next == null) return pop()

        //if we are here, then we must carry out the removal operation
        size--

        var previous = head
        var current = head

        var next = current.next

        //time to find the node before the last node
        //when current.next == null, then the node of interest is previous node
        while (next != null) {
            previous = current
            current = next
            next = current.next
        }

        //disconecct the last node
        previous.next = null

        //make a new tail
        tail = previous

        //return the popped value
        return current.value
    }

    /**
     * Removes a value anywhere in the list
     *
     * @param node [Node] we wish to remove value after
     * @return [T], the value removed from the list
     */
    fun removeAfter(node: Node<T>): T? {
        //if we are at end of the list, then there is nothing to remove
        if (tail == node) return null

        val output = node.next

        if (node.next != null) {
            size--
        }

        if (node.next == tail) {
            tail = node
        }

        node.next = output?.next
        return output?.value
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            if (!contains(item)) return false
        }
        return true
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element)
                return true
        }
        return false
    }


    /**
     * Find and return the give node at the given index or null
     *
     * @param index [Int], the given index
     * @return [Node], the node at the given index.
     */
    fun nodeAt(index: Int): Node<T>? {
        //start from the head and move towards the tail until we find the corresponding node
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode

    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty Linkedlist"
        } else {
            head.toString()
        }
    }

}

/** LinkedListIterator - A custom Iterator for Linked list */
class LinkedListIterator<T>(private val list: LinkedList<T>) : Iterator<T> {
    private var currentIndex = 0
    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return currentIndex < list.size

    }

    override fun next(): T {
        //Ensure we still have elements to return. As long as hasNext() is alwasy called before
        //this , it will never throw the exception
        if (currentIndex >= list.size) throw IndexOutOfBoundsException()

        //if lastNode is not set, then we are just beginning, set the last node and
        //take the next() of the last node as the next value subsequently
        lastNode = if (currentIndex == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }

        //update/increment the index
        currentIndex++

        return lastNode!!.value
    }


}

/** LinkedListIterator - A custom Iterator for Linked list */
class MutableLinkedListIterator<T>(private val list: LinkedList<T>) : MutableIterator<T> {
    private var currentIndex = 0
    private var lastNode: Node<T>? = null
    override fun hasNext(): Boolean {
        return currentIndex < list.size

    }

    override fun next(): T {
        //Ensure we still have elements to return. As long as hasNext() is alwasy called before
        //this , it will never throw the exception
        if (currentIndex >= list.size) throw IndexOutOfBoundsException()

        //if lastNode is not set, then we are just beginning, set the last node and
        //take the next() of the last node as the next value subsequently
        lastNode = if (currentIndex == 0) {
            list.nodeAt(0)
        } else {
            lastNode?.next
        }

        //update/increment the index
        currentIndex++

        return lastNode!!.value
    }

    override fun remove() {
        if (currentIndex == 1) { //we are at the front of the list
            list.pop()
        } else {
            //we are somewhere inside the list

        }
    }


}


fun main() {
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    val node4 = Node(value = 4)
    val node5 = Node(value = 5)
    val node6 = Node(value = 6)
    val node7 = Node(value = 7)
    val node8 = Node(value = 8)
    val node9 = Node(value = 9)

    node1.next = node2
    node2.next = node3

//    val l1 = LinkedList<Int>()
//        .apply {
//            push(1)
//            push(2)
//            push(3)
//        }
//
//    val l2 = LinkedList<Int>().apply {
//        append(1)
//        append(2)
//        append(3)
//    }

    val l3 = LinkedList<Int>().apply {
        push(9)
        push(8)
        push(7)
        push(6)
        push(5)
        push(4)
        push(3)
        push(2)
        push(1)
    }

//    println(node1)
//    println(l1)
//    println(l2)

    println(l3)
    l3.pop()
    println(l3)
    l3.removeLast()

    val fifthNode = l3.nodeAt(3)
    fifthNode?.let { l3.removeAfter(it) }
    println(l3)

    //Testing Iterator
    for (item in l3) {
        println("Item: $item")
    }

}
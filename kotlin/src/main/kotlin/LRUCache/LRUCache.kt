package LRUCache

import java.util.*


/**
 * @author jerry on 25/09/2020
 * for kotlin
 **/

class Entry {
    var value = 0
    var key = 0
    var left: Entry? = null
    var right: Entry? = null
}

class LRUCache {
    private var hashmap: HashMap<Int, Entry> = HashMap()

    private var start: Entry? = null
    private var end: Entry? = null

    fun getEntry(key: Int): Int {
        if (hashmap.containsKey(key)) {
            // Key Already Exist, just update the

            val entry = hashmap[key]
            removeNode(entry)
            addAtTop(entry)
            return entry!!.value
        }
        return -1
    }

    fun putEntry(key: Int, value: Int) {
        if (hashmap.containsKey(key)) {
            // Key Already Exist, just update the value and move it to top

            val entry = hashmap[key]
            entry!!.value = value
            removeNode(entry)
            addAtTop(entry)
        } else {
            val newnode = Entry()
            newnode.left = null
            newnode.right = null
            newnode.value = value
            newnode.key = key
            if (hashmap.size > LRU_SIZE) {
                // We have reached maxium size so need to make room for new element.
                hashmap.remove(end!!.key)
                removeNode(end)
                addAtTop(newnode)
            } else {
                addAtTop(newnode)
            }
            hashmap[key] = newnode
        }
    }

    private fun addAtTop(node: Entry?) {
        node!!.right = start
        node.left = null
        if (start != null) start!!.left = node
        start = node
        if (end == null) end = start
    }

    private fun removeNode(node: Entry?) {
        if (node!!.left != null) {
            node.left!!.right = node.right
        } else {
            start = node.right
        }
        if (node.right != null) {
            node.right!!.left = node.left
        } else {
            end = node.left
        }
    }

    companion object {
        private const val LRU_SIZE = 4
    }
}


fun main(args: Array<String>) {
    // your code goes here
    val lrucache = LRUCache()
    lrucache.putEntry(1, 1)
    lrucache.putEntry(10, 15)
    lrucache.putEntry(15, 10)
    lrucache.putEntry(10, 16)
    lrucache.putEntry(12, 15)
    lrucache.putEntry(18, 10)
    lrucache.putEntry(13, 16)
    println(lrucache.getEntry(1))
    println(lrucache.getEntry(10))
    println(lrucache.getEntry(15))
}
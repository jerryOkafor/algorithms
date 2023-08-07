/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 04/08/2023
*/

package core

data class Node<T : Any>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}


data class Node2D<T : Any>(var value: T, var next: Node2D<T>? = null, var previous: Node2D<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
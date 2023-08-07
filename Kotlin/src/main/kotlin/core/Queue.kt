/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 04/08/2023
*/

package core

interface Queue<T : Any> {

    fun enqueue(element: T): Boolean

    fun dequeue(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}
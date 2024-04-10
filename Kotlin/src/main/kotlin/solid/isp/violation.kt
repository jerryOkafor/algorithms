/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/08/2023
*/

package solid.isp

interface Animal {
    fun eat()
    fun sleep()
    fun fly() //all inheriting classes must implement this even when it is not needed.
}

class Cat : Animal {
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }

    override fun fly() {
        TODO("Not yet implemented") // Cats can't fly
    }
}

class Bird : Animal {
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}
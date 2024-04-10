/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/08/2023
*/

package solid.lsp.solution

interface Shape {
    fun getArea(): Int
}
class Rectangle : Shape {
    private var width: Int = 0
    private var height: Int = 0
    override fun getArea(): Int {
        return width * height
    }
    fun setWidth(width: Int) {
        this.width = width
    }
    fun setHeight(height: Int) {
        this.height = height
    }
}

class Square : Shape {
    private var diameter: Int = 0
    override fun getArea(): Int {
        return diameter * diameter
    }
    fun setSize(diameter: Int) {
        this.diameter = diameter
    }
}

fun main() {
    val rectangle = Rectangle().apply {
        setWidth(3)
        setHeight(5)
    }
    check(rectangle.getArea() == 15) //15
    val square = Square().apply { setSize(5) }
    check(square.getArea() == 25)  //25
}
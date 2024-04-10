/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/08/2023
*/

package solid.lsp

open class Rectangle {
    private var width: Int = 0
    private var height: Int = 0
    fun getArea(): Int {
        return width * height
    }
    open fun setWidth(width: Int) {
        this.width = width
    }
    open fun setHeight(height: Int) {
        this.height = height
    }
}
//Square is a rectangle with both side equal i.e its width  == height
class Square : Rectangle() {
    override fun setWidth(width: Int) {
        super.setWidth(width)
        super.setHeight(width)
    }
    override fun setHeight(height: Int) {
        super.setWidth(height)
        super.setHeight(height)
    }
}

fun main() {
    val rectangle = Rectangle().apply {
        setWidth(3)
        setHeight(5)
    }
    check(rectangle.getArea() == 15)// 15
    val square = Square().apply {
        setWidth(3)
        setHeight(5)
    }
    check(square.getArea() == 25) // 25, expected 15
}
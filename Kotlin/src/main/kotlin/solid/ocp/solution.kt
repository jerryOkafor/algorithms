/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/08/2023
*/

package solid.ocp.solution

import solid.ocp.violation.AreaCalculator
import solid.ocp.violation.Circle
import solid.ocp.violation.Rectangle
import kotlin.math.pow
import kotlin.math.round

interface Shape {
    fun getArea(): Double
}

data class Circle(val radius: Double) : Shape {
    override fun getArea(): Double = (Math.PI * radius.pow(2.0))
}

data class Rectangle(val length: Double, val width: Double) : Shape {
    override fun getArea(): Double = length * width
}

class AreaCalculator() {
    fun calculateSumOfAreas(shapes: List<Shape>): Double =
        shapes.fold(0.0) { acc, shape -> acc + shape.getArea() }
}


fun main() {
    val shape1 = Circle(9.0)
    val shape2 = Circle(12.0)
    val shape3 = Rectangle(12.0, 12.0)
    val shape4 = Rectangle(2.0, 4.0)

    val sumOfShapes = AreaCalculator()
        .calculateSumOfAreas(listOf(shape1, shape2, shape3, shape4))
    println(round(sumOfShapes))

    check(round(sumOfShapes) == 859.0) { "Shape is not properly calculates" }
}
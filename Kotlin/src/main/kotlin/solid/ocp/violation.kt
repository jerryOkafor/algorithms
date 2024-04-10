/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 10/08/2023
*/

package solid.ocp.violation

import kotlin.math.pow
import kotlin.math.round

data class Circle(val radius: Double)
data class Rectangle(val length: Double, val width: Double)
class AreaCalculator {
    fun calculateSumOfAreas(shapes: List<Any>): Double {
        var sumOfAreas = 0.0
        for (shape in shapes) {
            sumOfAreas += when (shape) {
                is Circle -> {
                    (Math.PI * shape.radius.pow(2.0))
                }

                is Rectangle -> {
                    (shape.length * shape.width)
                }

                else -> {
                    throw RuntimeException("Shape nod supported")
                }
            }
        }
        return sumOfAreas
    }
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
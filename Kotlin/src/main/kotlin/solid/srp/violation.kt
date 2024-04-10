/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 08/08/2023
*/

package solid.srp.violation

import java.math.BigDecimal
import java.util.*

data class Employee(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val role: String,
    val salary: BigDecimal
) {
    fun save() {
        TODO("Save employee to the database")
    }

    companion object {
        fun loadFromDB(id: UUID): Employee {
            TODO("Fetch employee with id from DB")
        }
    }
}
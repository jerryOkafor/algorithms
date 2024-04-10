/*
* 
* Kotlin
* 
* @Author : Jerry Okafor 
* @Date : 08/08/2023
*/

package solid.srp.solution

import java.math.BigDecimal
import java.util.*

data class Employee(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val role: String,
    val salary: BigDecimal
)

interface DataSource
class EmployeeService(dataSource: DataSource) {
    fun upsert(employee: Employee) {
        TODO("Add employee to dataSource")
    }

    fun findById(id: UUID): Employee {
        TODO("Fetch employee with id from DB")
    }

    fun raiseSalary(
        employee: Employee,
        raise: BigDecimal
    ): Employee {
        val updatedEmployee = employee
            .copy(salary = employee.salary + raise)
        TODO("Save the updated employee")
    }
}

//we can now have
val employeeService = EmployeeService(object : DataSource {})
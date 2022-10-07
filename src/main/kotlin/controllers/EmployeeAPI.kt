package controllers

import models.Employee

var lastId = 0

internal fun getId(): Int {
    return lastId++
}
class EmployeeAPI {
    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeID == id}
    }

    fun create(employee: Employee) {
        employee.employeeID = getId()
        employees.add(employee)
    }

    fun remove(employee: Employee) {
        employee.employeeID = getId()
        employees.remove(employee)
    }

    fun count(): Int {
        val count = employees.count()
        return count
    }

    fun findAllSalary(salary: Double): Employee? {
        return employees.find {
                s -> s.grossSalary == salary
        }
    }

    fun sortByBonusAsc(): List<Employee> {
        val bonusEmployees = employees.sortedBy{it.annualBonus}
        return bonusEmployees
    }

    fun sortByBonusDesc(): List<Employee> {
        val bonusEmployees = employees.sortedByDescending{it.annualBonus}
        return bonusEmployees
    }
}
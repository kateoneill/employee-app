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
        return employees.count()
    }

    fun findAllSalary(salary: Double): Employee? {
        return employees.find {
                s -> s.grossSalary == salary
        }
    }

    fun sortByBonusAsc(): List<Employee> {
        return employees.sortedBy { it.annualBonus }
    }

    fun sortByBonusDesc(): List<Employee> {
        return employees.sortedByDescending { it.annualBonus }
    }

    fun findAllName(employeeName: String): List<Employee> {
        return employees.filter { fN -> fN.firstName == employeeName }
    }

    fun findAllSurName(employeeSurname: String): List<Employee> {
        return employees.filter { sN -> sN.surname == employeeSurname }
    }

    fun nameBeginningWith(): List<Employee> {
        return employees.filter { it.firstName.startsWith("L") }
    }

    fun findByFirstLetter(employeeFirstLetter: String): List<Employee> {
        return employees.filter { fL -> fL.firstName.startsWith(employeeFirstLetter) }
    }
}


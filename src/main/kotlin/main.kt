import controllers.EmployeeAPI
import models.Employee
import mu.KotlinLogging
import kotlin.math.round

var employees = EmployeeAPI()
val logger = KotlinLogging.logger {}

//https://discuss.kotlinlang.org/t/printing-in-colors/22492
val magenta = "\u001b[35m"
val cyan = "\u001b[36m"
val yellow = "\u001b[33m"
val reset = "\u001b[0m"

fun main(args: Array<String>){
    logger.info { "🚀Launching models.Employee App 🚀" }
    start()
}

fun twoDec(number: Double) = round(number * 100) / 100

fun menu() : Int {

    print(""" 
         |   - - - - - - - - - - - - - - - - - - - - - - -
         |              👩‍💻models.Employee Menu👨‍💻
         |   - - - - - - - - - - - - - - - - - - - - - - -
         |  $magenta _____________________________________________ $reset
         |  $magenta | $reset       $yellow WHAT DO YOU WANT TO DO? $reset         $magenta | $reset
         |  $magenta |___________________________________________| $reset
         |  $magenta | $reset $cyan [1] Add models.Employee   $reset             $magenta | $reset
         |  $magenta | $reset $cyan [2] List All Employees     $reset            $magenta | $reset
         |  $magenta | $reset $cyan [3] Search Employees   $reset                $magenta | $reset
         |  $magenta | $reset $cyan [4] Print Payslip for models.Employee $reset $magenta | $reset
         |  $magenta | $reset $cyan [5] Delete Employee $reset                   $magenta | $reset
         |  $magenta | $reset $cyan [6] Get employee by Salary $reset            $magenta | $reset
         |  $magenta | $reset $cyan [7] Count Employees     $reset               $magenta | $reset
         |  $magenta | $reset $cyan [8] Sort by bonus     $reset                 $magenta | $reset
         |  $magenta | $reset $cyan [-1] Exit  $reset                            $magenta | $reset
         |  $magenta |___________________________________________| $reset
         | $yellow Enter Option >> $reset """.trimMargin())
    return readLine()!!.toInt()
}

fun add(){
    logger.info{"You are adding an employee 👤"}
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5 -> remove()
            6 -> salarySearch()
            7 -> countEmployees()
            8 -> sortBonus()
            -99 -> dummyData()
            -1 -> logger.info{"You are exiting the app, bye bye 👋"}
            else -> logger.info{"☹️Try a different option, this one doesn't work!"}
        }
        println()
    } while (input != -1)
}


fun list(){
    logger.info{"You are listing all employees 👥"}
    employees.findAll()
        .forEach{ println(it) }
}

fun search() {
    logger.info{"You are searching for an employee 👤"}
    val employee = getEmployeeById()
    if (employee == null)
        println("🚫No employee found")
    else
        println(employee)
}

internal fun getEmployeeById(): Employee? {
    print("🔎Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

fun salarySearch() {
    logger.info{"You are searching for an employee by salary 💰"}
    val salary = getEmployeeBySalary()
    println(salary)
}
internal fun getEmployeeBySalary(): Employee? {
    print("🔎Enter a salary to search by: ")
    val salary = readLine()!!.toDouble()
    return employees.findAllSalary(salary)
}

fun paySlip(){
    logger.info{"You are printing a payslip for an employee 🧾"}
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

//count from: https://www.cosmiclearn.com/kotlin/arraylist.php
fun countEmployees(){
    logger.info{"We are counting our employees 🔢"}
    println("Number of employees= ${employees.count()}")
}

//remove employee
fun remove(){
    logger.info{"You are removing an employee ❌"}
    val employee = getEmployeeById()
    if (employee == null)
        println("That employee can not be found")
    else
        employees.remove(employee)
            if (employee != null) {
                logger.info{"⚰️You are removing ${employee.getFullName()}"}
            }
}

//sort employees by bonus
//sorting code found @ https://www.bezkoder.com/kotlin-sort-list-objects/
fun sortBonus() {
    var input: Int

    do {
        input = bonusMenu()
        when (input) {
            1 -> sortBonusAsc()
            2 -> sortBonusDesc()
            -1 -> start()
            else -> logger.info{"☹️Try a different option, this one doesn't work!"}
        }
        println()
    } while (input != -1)
}

fun bonusMenu(): Int {
    print(
        """
    |$magenta |-----------------------------------------------------------------------| $reset
    |$magenta | $reset$yellow You are in the bonus sorting menu! $reset                                 $magenta | $reset
    |$magenta | $reset$yellow Choose from these options: $reset                                         $magenta | $reset
    |$magenta |-----------------------------------------------------------------------| $reset
    |$magenta | $reset $cyan Press 1 to sort in ascending order (smallest bonus to largest)   $reset  $magenta | $reset
    |$magenta | $reset $cyan Press 2 to sort in descending order (largest bonus to smallest)   $reset $magenta | $reset
    |$magenta | $reset $cyan Press -1 to go back to employee menu                              $reset $magenta | $reset
    |$yellow Choose your option -> $reset"""
            .trimMargin())
    return readLine()!!.toInt()
}

fun sortBonusAsc() {
    logger.info{"We are now sorting employees by bonus from smallest to largest 💸"}
    employees.sortByBonusAsc().forEach{ println(it) }
}

fun sortBonusDesc() {
    logger.info{"We are now sorting employees by bonus from largest to smallest 💸"}
    employees.sortByBonusDesc().forEach{ println(it) }
}


fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
    employees.create(Employee("Lisa", "O'Neill", 'f', 0, 100000.44, 45.0, 9.0, 0.0, 0.0))
    employees.create(Employee("Mark", "Roche", 'm', 0, 19500.00, 10.0, 8.5, 10000.0, 19.90))
    employees.create(Employee("Lizzie", "Grogan", 'f', 0, 29000.90, 30.0, 8.2, 2400.0, 140.0))
    employees.create(Employee("Tia", "McLoughlin", 'f', 0, 15000.87, 25.0, 8.1, 45.0, 99.0))
    employees.create(Employee("David", "Quinn", 'm', 0, 88909.89, 45.0, 8.7, 490.0, 70.0))
}
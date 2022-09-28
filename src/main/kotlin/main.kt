import kotlin.math.round

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)

fun main(args: Array<String>){
    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 -> println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun getPayslip(): String {
        return """
        
        							     Monthly Payslip	
        								                                                                        																		
        	 Employee Name:	 ${employee.firstName.uppercase()} ${employee.surname.uppercase()} ${employee.gender.uppercase()}								 Employee ID: $employee.employeeid
        |-------------------------------------------------------------------------------|
        |	 PAYMENT DETAILS						 				                    |
        |-------------------------------------------------------------------------------|
             Salary: ${getMonthlySalary()}				 		
        	 Bonus:  ${getBonus()}		
        	                                                    Gross: ${getGrossMonthlyPay()}
        										 				
        																			
        |-------------------------------------------------------------------------------|																			
        |  DEDUCTION DETAILS	                                                        |
        |-------------------------------------------------------------------------------|
           PAYE: ${getMonthlyPAYE()} 	
           PRSI: ${getMonthlyPRSI()} 
           Cycle To work: $employee.cycleDeduction
                                                    Total Deductions: ${getTotalMonthlyDeductions()}
         
        						                                NET PAY:${getNetMonthlyPay()} 							
    """
}

fun twoDec(number: Double) = round(number * 100) / 100

fun getFullName(): String {
    return when (employee.gender){
        'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
        'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
        else ->  "${employee.firstName} ${employee.surname}"
    }
}

fun getMonthlySalary() = twoDec(employee.grossSalary/12)
fun getMonthlyPRSI() = twoDec(getMonthlySalary() * employee.prsiPercentage/100)
fun getBonus() = twoDec( employee.annualBonus/12)
fun getMonthlyPAYE() = twoDec(getMonthlySalary() * employee.payePercentage/100)
fun getGrossMonthlyPay() = twoDec(getMonthlySalary() + employee.annualBonus/12)
fun getTotalMonthlyDeductions() = twoDec( getMonthlyPAYE() + getMonthlyPAYE() + employee.cycleDeduction)
fun getNetMonthlyPay() = twoDec(getGrossMonthlyPay()- getTotalMonthlyDeductions())

fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}
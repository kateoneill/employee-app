import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = "m"
val employeeId = "6143"
val grossSalary = 67543.21
val payePercent = 38.5
val prsiPercent = 5.2
val annualBonus = 1450.50
val cycleDeduction = 54.33

fun main(args: Array<String>) {
    println(getFullName())
    println("Monthly Salary: ${getMonthlySalary()}")
    println("Monthly PRSI: ${getMonthlyPRSI()}")
    println("Monthly PAYE: ${getMonthlyPAYE()}")
    println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
    println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
    println("Monthly Net Pay: ${getNetMonthlyPay()}")
    println(getPayslip())
}

fun getPayslip(): String {
        return """
        
        							     Monthly Payslip	
        								                                                                        																		
        	 Employee Name:	 ${firstName.uppercase()} ${surname.uppercase()} ${gender.uppercase()}								 Employee ID: $employeeId
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
           Cycle To work: $cycleDeduction
                                                    Total Deductions: ${getTotalMonthlyDeductions()}
         
        						                                NET PAY:${getNetMonthlyPay()} 							
    """
}

fun twoDec(number: Double) = round(number * 100) / 100

fun title(obj: String) = when(obj) {
    "m" -> "Mr"
    "f" -> "Ms"
    else -> {"Mx"}
}

fun getFullName() = "${title(gender)} $firstName $surname"

fun getMonthlySalary() = twoDec(grossSalary/12)
fun getMonthlyPRSI() = twoDec(getMonthlySalary() * prsiPercent/100)
fun getBonus() = twoDec(annualBonus/12)
fun getMonthlyPAYE() = twoDec(getMonthlySalary() * payePercent/100)
fun getGrossMonthlyPay() = twoDec(getMonthlySalary() + annualBonus/12)
fun getTotalMonthlyDeductions() = twoDec( getMonthlyPAYE() + getMonthlyPAYE() + cycleDeduction)
fun getNetMonthlyPay() = twoDec(getGrossMonthlyPay()- getTotalMonthlyDeductions())

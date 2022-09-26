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
    payslip()
}

fun payslip() {
    val month = grossSalary/12
    val paye = month * payePercent/100
    val bonus = annualBonus/12
    val prsi = month * prsiPercent/100
    val grossSal = month + bonus
    val totalDeduct = paye + prsi + cycleDeduction
    val netPay = grossSal - totalDeduct

    println(
        """
        
        							     Monthly Payslip	
        								                                                                        																		
        	 Employee Name:	 ${firstName.uppercase()} ${surname.uppercase()} ${gender.uppercase()}								 Employee ID: $employeeId
        |-------------------------------------------------------------------------------|
        |	 PAYMENT DETAILS						 				                    |
        |-------------------------------------------------------------------------------|
             Salary: ${twoDec(month)} 				 		
        	 Bonus:  ${twoDec(bonus)}		
        	                                                    Gross: ${twoDec(grossSal)}
        										 				
        																			
        |-------------------------------------------------------------------------------|																			
        |  DEDUCTION DETAILS	                                                        |
        |-------------------------------------------------------------------------------|
           PAYE: ${twoDec(paye)} 	
           PRSI: ${twoDec(prsi)} 
           Cycle To work: $cycleDeduction
                                                    Total Deductions: ${twoDec(totalDeduct)}
         
        						                                NET PAY:${twoDec(netPay)} 							
    """
    )
}

fun twoDec(number: Double) = round(number * 100) / 100

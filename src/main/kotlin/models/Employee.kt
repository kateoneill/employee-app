package models

import twoDec
import magenta
import reset
import cyan

class Employee (
    var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
    var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
    var annualBonus: Double, var cycleDeduction: Double
) {
    fun getFullName(): String {
        return when (gender){
            'm', 'M' -> "Mr. ${firstName} ${surname}"
            'f', 'F' -> "Ms.  ${firstName} ${surname}"
            'n', 'N' -> "Mx. ${firstName} ${surname}"
            else ->  "${firstName} ${surname}"
        }
    }

    fun getMonthlySalary() = twoDec(grossSalary / 12)
    fun getMonthlyPRSI() = twoDec(getMonthlySalary() * prsiPercentage / 100)
    fun getBonus() = twoDec(annualBonus / 12)
    fun getMonthlyPAYE() = twoDec(getMonthlySalary() * payePercentage / 100)
    fun getGrossMonthlyPay() = twoDec(getMonthlySalary() + annualBonus / 12)
    fun getTotalMonthlyDeductions() = twoDec(getMonthlyPAYE() + getMonthlyPAYE() + cycleDeduction)
    fun getNetMonthlyPay() = twoDec(getGrossMonthlyPay() - getTotalMonthlyDeductions())

    fun getPayslip(): String {
        return """
        
        							     Monthly Payslip	
        								                                                                        																		
        	 models.Employee Name:	 ${firstName.uppercase()} ${surname.uppercase()} ${gender.uppercase()}								 models.Employee ID: $employeeID
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

    fun getReducedPayslip(): String {
        return """
        
        Monthly Payslip	for ${getFullName()} [${gender.uppercase()}]     ID: $employeeID
        |--------------------------------------|
        |	 PAYMENT DETAILS				   |
        |--------------------------------------|	
            Gross: ${getGrossMonthlyPay()}																	
        |--------------------------------------|																			
        |  DEDUCTION DETAILS	               |
        |--------------------------------------|
         Total Deductions: ${getTotalMonthlyDeductions()}
         --------------------------------------
         NET PAY:${getNetMonthlyPay()} 							
    """
    }

    override fun toString(): String {
        return "$cyan~~~~~~~~~~~~~~~\nEmployee #$employeeID \n~~~~~~~~~~~~~~~ $reset\n$magenta Name $reset : $firstName $surname [$gender] \n$magenta Gross Salary $reset : $grossSalary, $magenta Paye Percentage $reset: $payePercentage, $magenta PRSI Percentage $reset : $prsiPercentage, $magenta Bonus $reset : $annualBonus, $magenta Cycle to work deduction $reset : $cycleDeduction"
    }
}
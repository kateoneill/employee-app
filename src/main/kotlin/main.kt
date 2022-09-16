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
    println("\n Rounded payslip follows:\n")
    roundedPayslip()
}

fun payslip() {
    val month = grossSalary/12
    val paye = month * payePercent/100
    val bonus = annualBonus/12
    val prsi = month * prsiPercent/100
    val grossSal = month + bonus
    val totalDeduct = paye + prsi + cycleDeduction
    val netPay = grossSal - totalDeduct

    println("---------------------------------------------------------------------------------")
    println("|\t\t\t\t\t\t\t\tMonthly Payslip\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|\t Employee Name:\t"+firstName.uppercase()+" "+surname.uppercase()+"("+gender.uppercase()+")\t\t\t\t\t\t\t\t Employee ID: "+employeeId+"\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|\t PAYMENT DETAILS\t\t\t\t\t\tDEDUCTION DETAILS\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t Salary: "+month+"\t\t\t\t"+"PAYE: "+paye+"\t\t\t|")
    println("|\t Bonus:  "+bonus+"\t\t\t\t\t\t"+"PRSI: "+prsi+"\t\t\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\tCycle To work: "+cycleDeduction+"\t\t\t\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\tGross: "+grossSal+"\t\t\t\tTotal Deductions: "+totalDeduct+" |")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t NET PAY:"+netPay+"\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
}

fun roundedPayslip() {
    val month = grossSalary/12
    val paye = month * payePercent/100
    val bonus = annualBonus/12
    val prsi = month * prsiPercent/100
    val grossSal = month + bonus
    val totalDeduct = paye + prsi + cycleDeduction
    val netPay = grossSal - totalDeduct

    println("---------------------------------------------------------------------------------")
    println("|\t\t\t\t\t\t\t\tMonthly Payslip\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|\t Employee Name:\t"+firstName.uppercase()+" "+surname.uppercase()+"("+gender.uppercase()+")\t\t\t\t\t\t\t\t Employee ID: "+employeeId+"\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|\t PAYMENT DETAILS\t\t\t\t\t\tDEDUCTION DETAILS\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t Salary: "+"%.2f".format(month)+"\t\t\t\t\t\t"+"PAYE: "+"%.2f".format(paye)+"\t\t\t\t\t\t|")
    println("|\t Bonus:  "+"%.2f".format(bonus)+"\t\t\t\t\t\t\t"+"PRSI: "+"%.2f".format(prsi)+"\t\t\t\t\t\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\tCycle To work: "+cycleDeduction+"\t\t\t\t|")
    println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\tGross: "+"%.2f".format(grossSal)+"\t\t\t\t\t\t\tTotal Deductions: "+"%.2f".format(totalDeduct)+"\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
    println("|\t\t\t\t\t\t\t NET PAY:"+"%.2f".format(netPay)+"\t\t\t\t\t\t\t\t\t|")
    println("|-------------------------------------------------------------------------------|")
}

fun monthlySalary(sal : Double) {
    val salary = sal
    val monthlySalary = salary/12

    print(monthlySalary)
}



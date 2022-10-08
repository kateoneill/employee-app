# employee-app
Assignment 1 - Employee App

## Introduction
This is my employee app for Software Development Tools. Over the past 5 weeks I have completed my labs to allow functionality to add a new employee, print a payslip for them and to allow a user to search by ID.

For my assignment we had to add on additional functionality. I added functionality to delete a user, search by salary, sort by bonus(asc and desc), count employees in the system, print a reduced payslip adn filter employee by name

I used Kotlin logging throughout the app and employed the Model View Presenter architecture and split my application across a main.kt file which communicated with the user, an employee class file which dealt with each individual employee and an employeeAPI.kt which held all the functions to do with all employees.

This is my first Kotlin project and first time using Kotlin at all so this app is very minimal.

## Requirements
I used intellij to make and run this app out of.

## Functionality
- Function pulling users full name and title from function
- Menu allowing users choose what data they want to see
- All functionality pulling from external functions
- Print payslip for an employee
- Search by ID
- Remove by ID
- Get employee by Salary
- Sort employees by bonus (ascending and descending)
- Print a reduced payslip
- Filter employee by name : first name, surname and first letter
- Count employees

## References
As this was my first Kotlin project I did a ton of research to make my functions work! The link are scattered throughout the code too in comments to know exactly where i looked.

- To help me add colour to the console output I used: https://discuss.kotlinlang.org/t/printing-in-colors/22492 and to get more ASNI colour variables I used: https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html
<br>
You can see the declarations on lines 10-13 of src/main/kotlin/main.kt. The usage of these is scattered throughout the other files also
- To help me with the count function I used: https://www.cosmiclearn.com/kotlin/arraylist.php <br> This is visible on lines 31-34 of /src/main/kotlin/controllers/EmployeeAPI.kt
- To help me to sort by bonus I referred to:https://www.bezkoder.com/kotlin-sort-list-objects/ <br> This is visible on lines 41-48 of /src/main/kotlin/controllers/EmployeeAPI.kt
- To help me do all the filters I looked ar : https://kotlinlang.org/docs/collection-filtering.html#test-predicates <br> This is visible on lines 49-63 of  /src/main/kotlin/controllers/EmployeeAPI.kt

Of course, nothing worked without a ton of tweaking and troubleshooting on my behalf until things worked as expected but I looked at all those links to help understand the various functions I used throughout my project.

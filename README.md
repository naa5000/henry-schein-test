# take-home-test

EDIT: Cleaned up slightly and added "Notes" and "problem" section for example version. 

NOTES:
	This problem was difficult because the csv to be parsed has many different types of separaters that seem inconsistant with eachother and the resources were limited.
	
PROBLEM:

	Using best practices complete the following task:
	Create a restful web service that takes a string of CSV data as input and returns the data reformatted as
	shown below without using regular expressions or a 3 rd party CSV parser library.
	Example input string:
	
	"Patient Name","SSN","Age","Phone Number","Status"
	"Prescott, Zeke","542-51-6641",21,"801-555-2134","Opratory=2,PCP=1"
	"Goldstein, Bucky","635-45-1254",42,"435-555-1541","Opratory=1,PCP=1"
	"Vox, Bono","414-45-1475",51,"801-555-2100","Opratory=3,PCP=2"
	
	Return string for the above sample input
	
	[Patient Name] [SSN] [Age] [Phone Number] [Status]
	[Prescott, Zeke] [542-51-6641] [21] [801-555-2134] [Opratory=2,PCP=1]
	[Goldstein, Bucky] [635-45-1254] [42] [435-555-1541] [Opratory=1,PCP=1]
	[Vox, Bono] [414-45-1475] [51] [801-555-2100] [Opratory=3,PCP=2]

SOLUTION:

	Test by running the app, then post this body into postman using the url: http://localHost:8080/parsePatientCsv

    	"Patient Name","SSN","Age","Phone Number","Status"
    	"Prescott, Zeke","542-51-6641",21,"801-555-2134","Opratory=2,PCP=1"
    	"Goldstein, Bucky","635-45-1254",42,"435-555-1541","Opratory=1,PCP=1"
    	"Vox, Bono","414-45-1475",51,"801-555-2100","Opratory=3,PCP=2"
	
	Because the app is so small, I didn't bother to create proper MVC directories or add Unit tests.
	If the Patients were to be used elsewhere, I would have created a Patient class and parsed out Patient objects with overridden toString() methods for the solution.
	I didn't use String.split(), because Java documentation says it technically takes a regex parameter, which is off-limits.
	I'm certain there are other and better ways to do this, but because I couldn't use regex, this was the simplest solution I came up with in the provided time.

	Thanks!




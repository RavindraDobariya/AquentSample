To run the jar file use below steps.

1) make sure java and maven is installed
2) checkout the code
3) go to the code directory and run command:  mvn clean install -DSkipTests=true (we can remove once test cases will be implemented so all the test cases will run using command line)
4) once it is build sucessfully.do cd to target folder where jar is existing
5) run command: java -Droute.from=file:/input -Droute.to=file:/output -jar  order-0.0.1-SNAPSHOT.jar
4) put your file into input folder and you will get sorted file in output folder.


//assumptions
input file will have fixed length with proper padding item name and date. 1st 12 char for name and next 10 char for date.
header will not be present in input and output file


//Design decision
using apache camel as it is EIP (Enterprise integration pattern) implementation which i feel it is best for our usecase.
- we can just create new camel route for source and destination when we need to read/write into db.
- we can reuse our business logic for sorting the data
- we can also write rest endpoint which we can use for upload a file from UI.and we can reuse the logic of sorting data.
so as we are not modifying our business logic it follows the OPEN-CLOSE design pattern as design is open for
expansion and closed for modification for existing business logic.

// Expectations completed:
Mavenized project - DONE
Source code - DONE
Include test cases - PENDING
Ability to run test cases from command line - DONE (once test case are implemented we can run using maven command : mvn clean install)

Make executable jar with run instruction.- DONE (instructions are provided above)
	--think from business end-user point - user can just put file into source folder and get result in output folder so easy for business user.
	--src file location, destination file as parameter - while running jar user can pass argument for source and destination folder




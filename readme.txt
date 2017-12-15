To run the jar file use below steps.

1) make sure java is installed
2) cd to folder where jar is existing
3) run command: java -Droute.from=file:/input -Droute.to=file:/output -jar  order-0.0.1-SNAPSHOT.jar
4) put your file into input folder and you will get sorted file in output folder.


//assumptions
input file will have fixed length with proper padding item name and date. 1st 12 char for name and next 10 char for date.
header will not be present in input and output file


//Design of application
using apache camel as it is EIP (Enterprise integration pattern) implemenation which is best of our usecase
- we can just create new camel route for source and destination when we need to read/write into db.
- we can reuse our business logic for sorting the data
- we can also write rest endpoint using camel whihc will again reuse the logic of sorting data.
so as we are not modifying our business logic it follows the OPEN-CLOSE design pattern as design is open for
expansion without modifying existing business logic.



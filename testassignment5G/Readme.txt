This assignment contains 7 packages and its structure is :
testassignment5g
     |____src
     |    |_____com.five.assignment							: main application for processing.
     |    |       |______ Assignment5G.java
     |    |_____com.five.assignment.exception             	: contains all the userdefined exceptions.
     |    |       |_____FileCantReadException.java
     |    |       |_____FileDoesntExistException.java
     |    |       |_____FileEmptyException.java
     |    |       |_____InvalidCLArgumentException.java
     |    |       |_____InvalidFileException.java
     |    |_____com.five.assignment.model					: contains all model classes
     |    |       |_____Stock.java
     |    |       |_____StockNavi.java
     |    |_____com.five.assignment.service					: contains all the services ( FileOperations, StockOPerations etc.,)
     |    |       |____FileOperations.java
     |    |       |____FileOperationsImpl.java
     |    |       |____StockOperations.java
     |    |       |____StockOperationsImpl.java
     |    |_____com.fiveg.assignment.tests					: Contains all the test cases.
     |    |       |____StockServiceTests.java
     |    |_____com.fiveg.assignment.utils					: Contains required helper/ utility classes/
     |    |       |____CacheClass.java
     |    |       |____StockComparator.java
     |    |____com.fiveg.assignment.webservice				: Contains the required Webservices.
     |    |       |____NAVWebService.java
     |____lib
     |    |____all dependent jars ( json, junit, hamcrest-core )	: Contains all the dependent jars.
     |____Readme.txt				
     |____StockPortfolio.txt										: Sample stock file.
              
		Assignment5G is the root class which uses the FileOperations service, if all the file operations are success then it calls the stock Operations service.
	StockOperations service process the stock and calls the NAVWebservice to compute the total price by gettting a StockNavi object.
	
	Stock and StockNavi are model classes.
	
	MainApplications --> FileOpeations  --> StockOperations  --> NAWWebService --> calls Service and get Response from URL.
											     ^
										 		 |
										 	MapperClasses
										 		 ^
										 		 |
										 	Model Classes	
	
	
	Thanks & regards,
	G N Satyanarayana,
	99485 61699.
	
	 
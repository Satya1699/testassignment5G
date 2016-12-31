package com.fiveg.assignment;

import java.io.File;
import java.io.IOException;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.service.StockService;
import com.fiveg.assignment.service.StockServiceImpln;

public class HelloWorld {

	public static void main(String[] args) {
		StockService service = new StockServiceImpln();
		try{
			 String argFileName = service.checkCLArgument(args);
			 File fileName = service.checkFile(argFileName);
			 service.processFile(fileName);
			 System.out.println("Hello World...");
		}catch(InvalidCLArgumentException invalExp) {invalExp.getExceptionMsg(); }
		catch(IOException ioexp) { ioexp.printStackTrace(); }
	}
}

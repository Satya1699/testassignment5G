package com.fiveg.assignment.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.model.Stock;
import com.fiveg.assignment.service.FileOperations;
import com.fiveg.assignment.service.FileOperationsImpl;
import com.fiveg.assignment.service.StockOperations;
import com.fiveg.assignment.service.StockOperationsImpl;

public class StockServiceTests {
	FileOperations fileOprs = new FileOperationsImpl();
	StockOperations stkOprs = new StockOperationsImpl();
	public StockServiceTests() {}
	
	/**
	 * Method : test_checkCLArgument() tests for whether the Stock file (StockPortfolio.txt) is passed as Command line argument or not.
	 * if passed test passes otherwise fails.  
	 * */

	@Test
	public void test_checkCLArgument() {
		String fileArg= "StockPortfolio.txt";
		File actual = fileOprs.checkCLArgument(fileArg);  
		File expected = new File("StockPortfolio.txt");
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_checkCLArgumentForEmpty() {
		try{
			File actual = fileOprs.checkCLArgument("");
			String expected = "StockPortfolio.txt";
			assertEquals(expected, actual);
		}catch( InvalidCLArgumentException invalCLAExp) {}
		 catch(NullPointerException nullPExp) {}
	}

	@Test
	public void test_checkCLArgumentForNull() {
		try{
			String fileArg = null;
			File actual = fileOprs.checkCLArgument(fileArg);
			File expected = new File("Stockortfolio.txt");
			assertEquals(expected, actual);
		}catch(InvalidCLArgumentException invlCLAExp) { }
		catch(NullPointerException nullPointExp) {}
	}

	@Test
	public void test_checkCLArgumentForExceptions() {
		try{
			String args = null;
			fileOprs.checkCLArgument(args);
		}catch(Exception exp) {}
	}
	
	/**
	 * Method : test_checkFile() tests for whether the Stock file (StockPortfolio.txt) is a file or not, If it is a file is it exists, 
	 * if exits is it having data or not. If it contains data, Is it readable or not. Otherwise fails to process the file.  
	 * */
	@Test
	public void test_ischeckFileIsFile() {
		File fileName = new File("StockPortfolio.txt");
		boolean actual = fileOprs.checkFile(fileName);
		assertEquals(true, actual);
	}
	
	@Test
	public void test_checkFileForExceptions() {
		try{
			File file=null; 
			fileOprs.checkFile(file);
		}catch(Exception exp) { }
	}

}

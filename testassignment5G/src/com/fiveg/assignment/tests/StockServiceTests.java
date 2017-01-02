package com.fiveg.assignment.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.service.FileOperations;
import com.fiveg.assignment.service.FileOperationsImpl;

public class StockServiceTests {
	FileOperations fileOprs = new FileOperationsImpl();
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

	/*
	@Test
	public void test_processFile() {
		
		File fileName = new File("StockPortfolio.txt");
		try{
		service.processFile(fileName);
		}catch(Exception exp) {}
		assertEquals("StockPortfolio.txt", fileName.getName().toString());
	}

	@Test
	public void test_processFileForExceptions() {
		try{
			File fileName = new File("StockPortfolio.txt");
			service.processFile(fileName);
		}catch(Exception exp) {}
	}	
	
	@Test
	public void test_getPriceByProcessStockRow(){
		String actual = "GOOG - 50, STG - 20, MS - 10";
		String expected = "GOOG - 50, STG - 20, MS - 10";
		service.getPriceByProcessStockRow(expected, actual);
		assertEquals(expected, actual);
	} 
*/

/*
	@Test
	public void printStock() {
		List<Stock> expectedStockList = new ArrayList<Stock>();
		List<Stock> actualStockList = new ArrayList<Stock>();
		expectedStockList.add(new Stock("GOOG - 50, STG - 20, MS - 10", 909.90) );
		actualStockList.add(new Stock("GOOG - 50, STG - 20, MS - 10", 909.90) );
		service.printStock(actualStockList);
		assertEquals(expectedStockList, actualStockList);
	}
	
	@Test
	public void test_getPriceService() {
		String urlStr = "http://finance.google.com/finance/info?client=ig&q=GOOG";
		service.getPriceService(urlStr);
		assertEquals(10.10, urlStr);
	}
	
	@Test
	public void test_getPriceByProcessStockRow(final String stockRow, final String delimiter){
		service.getPriceByProcessStockRow(stockRow, delimiter);
		assertEquals("GOOG - 50, STG - 20, MS - 10", stockRow);
		assertEquals(",", delimiter);
	}
	
	@Test
	public void test_getPriceByProcessStockRow(final String stockRow, final String delimiter){
		service.getPriceByProcessStockRow(stockRow, delimiter);
		assertEquals("", stockRow);
		assertEquals("", delimiter);
	}
	
	@Test
	public void test_getPriceByProcessStockRow(final String stockRow, final String delimiter){
		service.getPriceByProcessStockRow(stockRow, delimiter);
		assertEquals(null, stockRow);
		assertEquals(null, delimiter);
	}
	
	@Test
	public void test_getPriceService(final String url) {
		service.getPriceService(url);
		assertEquals(Double.class, "http://www.google.finance.com/q=GOOG");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_getPriceService() {
		double actual = service.getPriceService("http://www.google.finance.com/q=GOOG");
		assertEquals(10.10, actual);
	}
*/
}

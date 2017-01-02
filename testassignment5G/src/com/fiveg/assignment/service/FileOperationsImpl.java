package com.fiveg.assignment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fiveg.assignment.exceptions.FileCantReadException;
import com.fiveg.assignment.exceptions.FileDoesntExistException;
import com.fiveg.assignment.exceptions.FileEmptyException;
import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.exceptions.InvalidFileException;
import com.fiveg.assignment.model.Stock;

public class FileOperationsImpl implements FileOperations {

	@Override
	public File checkCLArgument(String fileArgument) throws InvalidCLArgumentException {
		
		if(fileArgument.equals("")) {
			throw new  InvalidCLArgumentException("Invalid File argument. File argument must be not be empty and "
					+ "It must be Stock (StockPortfolio.txt) file name...");
		}else{
			if(fileArgument.trim().equals(null)) {
				throw new NullPointerException("File Argument should not be null. It must be Stock (StockPortfolio.txt) file name..");
			}else{
				return (new File(fileArgument) );
			}
		}
	}  // end of checkCLArgument(String fileArg) method.
	
	@Override
	public boolean checkFile(final File stockFile) {

		if(stockFile.isFile()) {
			System.out.print(stockFile+" File is a valid file, ");
			if(stockFile.exists()) {
				System.out.print(" it exists physically, ");
				if(stockFile.canRead()) {
					System.out.print("it is Readable");
					if( (stockFile.length() > 0) ) {
						System.out.print(" and it contains some data. (File Name : " + stockFile.getName()+" ).\n");
						return true;
					}else{
						throw new FileEmptyException(stockFile+" File is Empty (NO Data Found in the file....).");
					}
				}else{
					throw new FileCantReadException(stockFile+ " File is not Readable (File is not accessible....).");
				}
			}else {
				throw new FileDoesntExistException(stockFile+" File Doesn't Exist physically......");
			}
		}else{
			throw new InvalidFileException(stockFile+" file name maybe incorrect or Invalid File.....");
		}
	}  // end of checkFile(File stockFile) method.

	@Override
	public List<Stock> processFile(File stockFile) throws IOException, NullPointerException {
		BufferedReader br = null;
		List<Stock> stockList = new ArrayList<Stock>();
		try{
			br = new BufferedReader(new FileReader(stockFile));
			String stockRow = null;
			while( (stockRow = br.readLine()) != null) {
				System.out.println("Line : "+stockRow);
				stockList.add(new Stock(stockRow));
			}
			br.close();
		}catch(Exception exp) { exp.printStackTrace();}
		finally{
			try{
				if(br != null) 
					br.close();
			}catch(Exception exp) {exp.printStackTrace(); }
		}
		return stockList;
	}  // end of processFile(File stockFile) method.
	
		/*
		 * 			
		    int line=0;
			String portfolio = null;
			List<Stock> stockList = null;
			
	        try{
	        	//priceMapper = new HashMap<String, Double>();
	        	br = new BufferedReader(new FileReader(inputFile) );
	        	stockList = new ArrayList<Stock>();
	        	while( (portfolio = br.readLine()) != null ) {
			       	System.out.print("L-"+line+" : "+ portfolio);
			       	if(portfolio != null && portfolio.length() > 0 ) {
			       		double lineTotalPrice = getPriceByProcessStockRow(portfolio,",");
			       		System.out.println( "Line Total Items Price  :: "+ lineTotalPrice );
			       		stockList.add(new Stock(portfolio, lineTotalPrice) );	
			       	}
				    line+=1;
	        	}
	        	System.out.println("[===================================================Total "+ line +" Lines Processed=======================================]");
	        	Collections.sort(stockList, new StockComparator() );
	        	printStock(stockList);
		      }
		     	catch(IOException exp) {
		     		exp.printStackTrace();
		     	}
		      finally{
		    	 try{
		    		 if( br != null )
		    			 br.close();
		    	 	}catch(IOException exp){ 	exp.printStackTrace();    	 }  // end of catch block.
		      }
		 * */

}

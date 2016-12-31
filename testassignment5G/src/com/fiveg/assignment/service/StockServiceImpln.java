package com.fiveg.assignment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fiveg.assignment.exceptions.FileCantReadException;
import com.fiveg.assignment.exceptions.FileDoesntExistException;
import com.fiveg.assignment.exceptions.FileEmptyException;
import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.exceptions.InvalidFileException;
import com.fiveg.assignment.model.Stock;
import com.fiveg.assignment.utils.StockComparator;

public class StockServiceImpln implements StockService {

	public StockServiceImpln() { }
	
	@Override
	public void printStock(List<Stock> stockList) {
		for(Stock stock : stockList) {
			System.out.format("[ %-100s  %9.2f ]\n", stock.getStockLine(), stock.getRowPrice());
		}
	}

	@Override
	public String checkCLArgument(String... args) {
		if(args.length == 1 && !args[0].equals("") && args[0] != null) {
			System.out.println("Arguments Passed "+args.length);
			return args[0].trim();
		}else {
			throw new InvalidCLArgumentException("Invalid Command Line Argument..Filename must be passed as argument");
		}
	}

	@Override
	public File checkFile(final String fileName) {
		File file = new File(fileName);
		if(file.isFile()) {
			System.out.println("is a file...");
			if(file.exists()) {
				System.out.println("File Exists....");
				if(file.canRead()) {
					System.out.println("File is Readable...");
					if( (file.length() > 0) ) {
						System.out.println("F N : " + file.getName());
						return file;
					}else{
						throw new FileEmptyException("Given File is Empty...NO Data Found...");
					}
				}else{
					throw new FileCantReadException("Given File is not Readable...");
				}
			}else {
				throw new FileDoesntExistException("File Doesn't Exist....");
			}
		}else{
			throw new InvalidFileException("Given name is Not a File... Invalid File....");
		}
	}

	@Override
	public void processFile(final File inputFile) {
			BufferedReader br = null;
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
		     	catch(Exception exp) {
		     		exp.printStackTrace();
		     	}
		      finally{
		    	 try{
		    		 if( br != null )
		    			 br.close();
		    	 	}catch(Exception exp){ 	exp.printStackTrace();    	 }  // end of catch block.
		      }
		}   // end of processFile() method.
	
	
public double getPriceByProcessStockRow(final String stockRow, final String delimiter) {
     
	   String stockItems[] = stockRow.split(delimiter);
	   int numberOfItems = stockItems.length;
	   double price = 0.0, totalPrice=0.0;
		   
	   for(int i=0; i< numberOfItems; i+=1) {
		   String[] stock = stockItems[i].split("-");
		   if( stock.length == 2 ) {
			   String symbol = stock[0].trim();
			   int stockQuantity = Integer.valueOf(stock[1].trim());
			   
			   if(priceMapper.containsKey(symbol)) {
				   price = priceMapper.get(symbol);
				   totalPrice += price * stockQuantity;
			   }else {
				   price = getPriceService("http://www.google.finance.com/p?=GOOG"+symbol);
				   priceMapper.put(symbol,	price);
				   totalPrice += price * stockQuantity;
			   }
		   }else {
			   //throw new InvalidStockItemException();
			   return 0.0;
		   }
	   }
	   return totalPrice;
}

public double getPriceService(final String url) {
	return 10.10;
}


} // end of StockServiceImpln class.....



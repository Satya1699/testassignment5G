package com.fiveg.assignment;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.exceptions.InvalidFileException;
import com.fiveg.assignment.model.Stock;
import com.fiveg.assignment.service.FileOperations;
import com.fiveg.assignment.service.FileOperationsImpl;
import com.fiveg.assignment.service.StockOperations;
import com.fiveg.assignment.service.StockOperationsImpl;
import com.fiveg.assignment.utils.StockComparator;
/**
 *  Class : Assignment5G is the main class which takes the stock file name as Command line argument and uses FileService class to process the file 
 *  and then uses StockService class to process the stock by using NAVWebServie and Cache class.  
 * */

public class Assignment5G {

	public static void main(String... args) {
		FileOperations fileOprs = new FileOperationsImpl();
		StockOperations stkOprs = new StockOperationsImpl();
		
		if(args.length != 1) {
			throw new InvalidCLArgumentException("Invalid CLArguments... You must pass Stock (StockPortfolio.txt) as the Command line Argument....");
		}
		else {
			File stockFile = fileOprs.checkCLArgument(args[0]);
			if( stockFile != null) {
				if( fileOprs.checkFile(stockFile)) {
					try{
						System.out.println("Processing File.......");
						List<Stock> stockList = fileOprs.processFile(stockFile);
						if(stockList != null && stockList.size() > 0 ) {
							System.out.println("Stock List Before Processing is : ");
							stkOprs.printStock(stockList);
										
							stkOprs.processStockList(stockList);
							
							System.out.println("Stock List After Processing is : ");
							Collections.sort(stockList, new StockComparator() );
							stkOprs.printStock(stockList);
						}else { throw new NullPointerException("Stock List is not initiated (null)....");}
					}catch(NullPointerException nullPoinExp) { nullPoinExp.getMessage(); }
					catch(IOException ioExp) { ioExp.printStackTrace(); }
				}
				else{
					throw new InvalidFileException("");
				}
			}else{ throw new NullPointerException("File is null...."); }
		}
		System.out.println("Processing completed..................");
	}
} // end of Assignment5G class.
package com.fiveg.assignment.service;

import java.util.List;
import java.util.Map;

import com.fiveg.assignment.model.Stock;
import com.fiveg.assignment.model.StockNavi;
import com.fiveg.assignment.utils.CacheClass;
import com.fiveg.assignment.webservice.NAVWebService;


public class StockOperationsImpl implements StockOperations {
	Map<String, StockNavi> stockMapper = CacheClass.getStockMapper();
	
	@Override
	public void processStockList(List<Stock> stockList) {
		System.out.println("Processing.........");
	   for( Stock stockRow : stockList) {
		   double totalRowPrice = computeTotalPrice(stockRow);
		   System.out.println("Total Row Price : "+ totalRowPrice);
		   stockRow.setRowPrice(totalRowPrice);
	   }
	    for(Map.Entry<String, StockNavi> entries : stockMapper.entrySet()) {
	    	System.out.print(entries.getKey() + "  :::>" );
	    	entries.getValue().showData();
	    }   
	}

	
	@Override
	public double computeTotalPrice(Stock stockRow) {
		double totalPrice = 0.0;
		double itemPrice = 0.0;
			  
		System.out.println("Computing................"+stockRow);
	    String[] stock = stockRow.getStockLine().split(",");
	    for( int i=0; i< stock.length; i+=1 ) {        
		    String items[] = stock[i].split("-");
		    if( items.length == 2 ) {
			    String symbol = items[0].trim();
			    int quantity = Integer.valueOf(items[1].trim() );
			    if( stockMapper.containsKey(symbol) ) {
			    	System.out.println("Getting NAV From Mapper Class................");
			    	itemPrice = ((StockNavi)stockMapper.get(symbol)).getL();
			    	totalPrice += (itemPrice * quantity);
			    }else{
			    	System.out.println("Getting NAV from net Service..................");
			    	StockNavi stkNavi = NAVWebService.getStockNavi("http://finance.google.com/finance/info?client=ig&q="+symbol);
			    	stockMapper.put(symbol, stkNavi );
			    	itemPrice = stkNavi.getL();
			    	totalPrice += (itemPrice * quantity);
			    	System.out.println("Total Row Price..........."+totalPrice);
			    }
		    }
	    } 		// for end.
		return totalPrice;
	}
	
	@Override
	public void printStock(List<Stock> stockList) {
		System.out.println("[ =================================================== Total Customers "+ stockList.size() +" ========================================== ]");
		for( Stock stock : stockList) {
			System.out.format("[ %-100s%12.2f ]\n", stock.getStockLine(), stock.getRowPrice() );
		}
		System.out.println("[ ===================================================  end of stockList  ========================================= ]");
	}

}

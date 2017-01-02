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
	   for( Stock stockRow : stockList) {
		   double totalRowPrice = computeTotalPrice(stockRow);
		   stockRow.setRowPrice(totalRowPrice);
	   }
	    for(Map.Entry<String, StockNavi> entries : stockMapper.entrySet()) {
	    	System.out.println(entries.getKey() + " < - > " + entries.getValue().toString() );
	    }   
	}

	
	@Override
	public double computeTotalPrice(Stock stockRow) {
		double totalPrice = 0.0;
		double itemPrice = 0.0;
			  
		
	    String[] stock = stockRow.getStockLine().split(",");
	    for( int i=0; i< stock.length; i+=1 ) {        
		    String items[] = stock[i].split("-");
		    if( items.length == 2 ) {
			    String symbol = items[0].trim();
			    int quantity = Integer.valueOf(items[1].trim() );
			    if( stockMapper.containsKey(symbol) ) {
			    	itemPrice = ((StockNavi)stockMapper.get(symbol)).getL();
			    	totalPrice += (itemPrice * quantity);
			    }else{
			    	StockNavi stkNavi = NAVWebService.getStockNavi("http://finance.google.com/finance/info?client=ig&q="+symbol);
			    	stockMapper.put(symbol, stkNavi );
			    	itemPrice = stkNavi.getL();
			    	totalPrice += (itemPrice * quantity);
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

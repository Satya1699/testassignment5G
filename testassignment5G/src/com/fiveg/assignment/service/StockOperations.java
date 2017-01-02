package com.fiveg.assignment.service;

import java.util.List;

import com.fiveg.assignment.model.Stock;

public interface StockOperations {

	// this method process the Stock List.
	public void processStockList(List<Stock> stockList);
	
	// This method updates the Stock List total price..
	public double computeTotalPrice(Stock stockRow);
	
	// This method prints the stock list available.
	public void printStock(final List<Stock> stockList);	
}

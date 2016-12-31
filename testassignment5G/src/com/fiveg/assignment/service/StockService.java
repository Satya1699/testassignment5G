package com.fiveg.assignment.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fiveg.assignment.exceptions.InvalidCLArgumentException;
import com.fiveg.assignment.model.Stock;

public interface StockService {
	Map<String, Double> priceMapper = new HashMap<String, Double>();
    
	public void printStock(final List<Stock> stockList);
    
	public String checkCLArgument(final String... args) throws InvalidCLArgumentException;
	
	public File checkFile(final String fileName);
	
	public void processFile(final File fileName) throws IOException;
	
	public double getPriceByProcessStockRow(final String stockRow, final String delimiter);
	
	public double getPriceService(final String url);
	
}

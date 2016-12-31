package com.fiveg.assignment.model;

public class Stock implements Comparable<Stock> {
   String stockLine;
   double rowPrice;
   
public String getStockLine() {
	return stockLine;
}
public Stock() { }
public Stock(String stockLine, double price) {
	this.stockLine = stockLine;
	this.rowPrice = price;
}
public void setStockLine(String stockLine) {
	this.stockLine = stockLine;
}

public double getRowPrice() {
	return rowPrice;
}

public void setRowPrice(double rowPrice) {
	this.rowPrice = rowPrice;
}

@Override
public String toString() {
	return "[ "+stockLine+"    -> "+ rowPrice+" ]"; 
}
@Override
public int compareTo(Stock stockObj) {
	
	if(rowPrice > stockObj.getRowPrice())
		return 1;
	else if(rowPrice < stockObj.getRowPrice())
		return -1;
	else return 0;
}
   
}

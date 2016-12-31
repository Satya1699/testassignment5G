package com.fiveg.assignment.utils;

import java.util.Comparator;

import com.fiveg.assignment.model.Stock;

public class StockComparator implements Comparator<Stock> {

	@Override
	public int compare(Stock stk1, Stock stk2) {
		if(stk1.getRowPrice() > stk2.getRowPrice())
			return -1;
		else if(stk1.getRowPrice() < stk2.getRowPrice())
			return 1;
		else
			return 0;
	}

}

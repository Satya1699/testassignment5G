package com.fiveg.assignment.utils;

import java.util.HashMap;
import java.util.Map;

import com.fiveg.assignment.model.StockNavi;

public class CacheClass {
   public static Map<String, StockNavi> stockMapper = new HashMap<String, StockNavi>();

   public static Map<String, StockNavi> getStockMapper() {
	   return stockMapper;
   }

   public static void setStockMapper(Map<String, StockNavi> stockMapper) {
	   CacheClass.stockMapper = stockMapper;
   }
}

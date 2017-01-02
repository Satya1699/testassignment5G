package com.fiveg.assignment.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fiveg.assignment.model.StockNavi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NAVWebService {

	public static String getJSONStringResponse(String urlStr) throws MalformedURLException, IOException  {
		   String userAgent = "Mozilla/5.0;";
		   URL url=new URL(urlStr);
		   HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		   conn.setRequestMethod("GET");
		   conn.setRequestProperty("User-Agent", userAgent);
		   int resCode = conn.getResponseCode();
		   System.out.println("\n Sending GET request to url :"+url);
		   System.out.println("Response Code : "+resCode);
		   
		   BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		   StringBuffer response = new StringBuffer();
		   String inputLine;
		   while( (inputLine =in.readLine()) != null) {
			   response.append(inputLine);
		   }
		   in.close();
		   return response.toString();
	}

	public static StockNavi getStockNavi(String jsonResponse) {
		//String urlStr = "http://finance.google.com/finance/info?client=ig&q=GOOG, YHOO";
		StockNavi stkNav = null;
		try{
			String response = getJSONStringResponse(jsonResponse);
		   	System.out.println("Response :"+ response);
		   	//response = response.substring(2);
		   	Gson gson = new Gson();
		   
		   	stkNav = gson.fromJson(response, new TypeToken<StockNavi>(){}.getType());
		   
/*		   	List<StockNavi> list = gson.fromJson(response.trim(), new TypeToken<List<StockNavi>>(){ }.getType());
			System.out.println("List size : "+list.size() );
			for(StockNavi stkNav : list){
				System.out.println("Stock "+stkNav.getT()+"Navi :"+ stkNav.getL());
			}	*/
		   }catch(MalformedURLException malfUrlExp) {}
		    catch(IOException ioexp) {}
		
		   return stkNav;
	}
} 
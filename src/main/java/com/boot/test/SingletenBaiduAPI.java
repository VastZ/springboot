package com.boot.test;

import com.baidu.aip.ocr.AipOcr;


public class SingletenBaiduAPI {
		private SingletenBaiduAPI(){};
	    private static class SingletonHolder {
	    	static String APP_ID = "11555830";
	    	static String API_KEY = "WZjZdx6k4kDupMlOFNgoNzHV";
	    	static String SECRET_KEY = "5OBbMnZNq8EcfIRG8kcdTVWhOeGxYWCU";
	   private static final AipOcr INSTANCE = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
	      }  
	    public static final AipOcr getInstance() {  
	    	        return SingletonHolder.INSTANCE;  
	    	    } 
}

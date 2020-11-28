package com.stringCalculator.StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator 
{
	 public int add(String text) {
	       
		 	if (text == null || text.isEmpty()) {
	            return 0;
	        }
	        char customDelimiter = getCustomDelimiter(text.split("\n")[0]);

	        String[] number = (customDelimiter == ',') ? 
	                                text.split(",|\n") : text.split("\n|" + customDelimiter);
	        int sum = 0;
	        List<String> negatives = new ArrayList<String>();
	        int leaveFirstLine = (customDelimiter == ',') ? 0 : 2;
	        for (String currentNumber : number) {
	            if (leaveFirstLine > 0) {
	                --leaveFirstLine;
	            } else {
	                int num = Integer.parseInt(currentNumber);
	                if (num > 1000) {
	                    continue;
	                }
	                
	                if (num < 0) {
	                    negatives.add(currentNumber);
	                }
	                sum += num;
	            }
	        }
	        if (!negatives.isEmpty()) {
	            throw new IllegalArgumentException(
	                "negatives not allowed " + String.join(",", negatives));
	        }
	        return sum;
	    }


	    private char getCustomDelimiter(String line) {
	        if (line == null || line.isEmpty()) {
	            return ',';
	        }
	        if (convertStrToInt(line)) {
	            return ',';
	        }
	        if (line.length() == 1) {
	            return line.charAt(0);
	        }
	        return ',';
	    }
	    
	    private boolean convertStrToInt(String str) {
	    	try {
	    		Integer.parseInt(str);
	    	} catch (NumberFormatException nfe) {
	    		return false;
	    	}
	    	return true;
	    }
}

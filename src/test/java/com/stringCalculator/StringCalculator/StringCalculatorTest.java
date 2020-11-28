package com.stringCalculator.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest 
{
	
    @Test
    public void emptyStringShouldReturnZero() {
        StringCalculator sc = new StringCalculator();
        assertEquals(0, sc.add(""));
    }
}

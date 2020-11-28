package com.stringCalculator.StringCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void returnZeroifEmpty() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add(""));
	}

	@Test
	public void returnOneOnly() {
		StringCalculator sc = new StringCalculator();
		assertEquals(8, sc.add("8"));
	}

	@Test
	public void sumOfTwoNumber() {
		StringCalculator sc = new StringCalculator();
		assertEquals(10, sc.add("3,7"));
	}

	@Test
	public void anyNumberDigitSupport() {
		StringCalculator sc = new StringCalculator();
		assertEquals(110, sc.add("11,99"));
	}

	@Test
	public void inputOfNnumber() {
		StringCalculator sc = new StringCalculator();
		assertEquals(55, sc.add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test
	public void newLineSeparator() {
		StringCalculator sc = new StringCalculator();
		assertEquals(6, sc.add("1\n2,3"));
	}

	@Test
	public void allowCustomDelimiter() {
		StringCalculator sc = new StringCalculator();
		assertEquals(10, sc.add(";\n1;2;3;4"));
	}

	@Test
	public void negativeNotSupported() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.add("-1;4");
			fail("exception should have been thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("negatives not allowed -1", e.getMessage());
		}
	}

	@Test
	public void numbersGreaterThan1000AreIgnored() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("5,12,1001"), 17);
		assertEquals(sc.add("14124,22\n4,1214"), 26);
	}

}

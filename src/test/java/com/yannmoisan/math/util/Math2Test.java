package com.yannmoisan.math.util;

import static junit.framework.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Math2Test {
	@Test
	public void testIsInteger() {
		assertTrue(Math2.isInteger(0d));
		assertTrue(Math2.isInteger(1d));
		assertTrue(Math2.isInteger(1.0d));
		assertTrue(Math2.isInteger(1.00d));
		assertTrue(Math2.isInteger(-1d));
		assertFalse(Math2.isInteger(1.001d));
	}
	
	@Test
	public void testSumOfDigits() {
		assertEquals(0, Math2.sumOfDigits(BigInteger.ZERO));
		assertEquals(1, Math2.sumOfDigits(BigInteger.ONE));
		assertEquals(3, Math2.sumOfDigits(BigInteger.valueOf(12)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testToIntEmpty() throws Exception {
		Math2.toInt(new ArrayList<Integer>());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testToIntNull() throws Exception {
		Math2.toInt(null);
	}

	@Test
	public void testToInt() throws Exception {
		assertEquals(0, Math2.toInt(Arrays.asList(0)));
		assertEquals(1, Math2.toInt(Arrays.asList(1)));
		assertEquals(123, Math2.toInt(Arrays.asList(1,2,3)));
	}
	
	@Test
	public void testToDigits() throws Exception {
		assertEquals("[0]", Arrays.toString(Math2.toDigits(0).toArray()));
		assertEquals("[1]", Arrays.toString(Math2.toDigits(1).toArray()));
		assertEquals("[1, 2, 3]", Arrays.toString(Math2.toDigits(123).toArray()));
	}
	

}

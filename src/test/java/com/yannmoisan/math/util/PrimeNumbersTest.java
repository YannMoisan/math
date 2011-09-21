package com.yannmoisan.math.util;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeNumbersTest {
	@Test(expected=IllegalArgumentException.class)
	public void testfindPrimeNumbersZero() throws Exception {
		PrimeNumbers.findPrimeNumbers(0).toArray();
	}

	@Test
	public void testfindPrimeNumbers() throws Exception {
		assertEquals("[]", Arrays.toString(PrimeNumbers.findPrimeNumbers(1).toArray()));
		assertEquals("[2]", Arrays.toString(PrimeNumbers.findPrimeNumbers(2).toArray()));
		assertEquals("[2, 3, 5, 7]", Arrays.toString(PrimeNumbers.findPrimeNumbers(10).toArray()));
	}
	
	@Test
	public void testfindPrimeNumbersMemory() throws Exception {
		//PrimeNumbers.findPrimeNumbers(1000000000);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFindPrimeFactorsZero() throws Exception {
		PrimeNumbers.findPrimeFactors(0);
	}

	@Test
	public void testFindPrimeFactors() throws Exception {
		assertEquals("17^1 * ", PrimeNumbers.findPrimeFactors(17).toString());
		assertEquals(504, PrimeNumbers.findPrimeFactors(220).sumOfDivisors());
		assertEquals(504, PrimeNumbers.findPrimeFactors(284).sumOfDivisors());
		assertTrue(PrimeNumbers.findPrimeFactors(28).isPerfect());
		assertTrue(PrimeNumbers.findPrimeFactors(12).isAbundant());
	}

	@Test
	public void testLcm() throws Exception {
		assertEquals(720, PrimeNumbers.lcm(48, 180));
	}
	
}

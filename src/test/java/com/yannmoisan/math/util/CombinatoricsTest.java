package com.yannmoisan.math.util;

import static junit.framework.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class CombinatoricsTest {
	@Test
	public void testFactorial() {
		assertEquals(BigInteger.valueOf(1), Combinatorics.factorial(0));
		assertEquals(BigInteger.valueOf(1), Combinatorics.factorial(1));
		assertEquals(BigInteger.valueOf(120), Combinatorics.factorial(5));
	}
	
	@Test
	public void testCombination() {
		assertEquals(BigInteger.valueOf(1), Combinatorics.combination(5, 0));
		assertEquals(BigInteger.valueOf(5), Combinatorics.combination(5, 1));
		assertEquals(BigInteger.valueOf(1), Combinatorics.combination(5, 5));
		assertEquals(BigInteger.valueOf(0), Combinatorics.combination(1, 5));
		assertEquals(BigInteger.valueOf(2598960), Combinatorics.combination(52, 5));
	}
}

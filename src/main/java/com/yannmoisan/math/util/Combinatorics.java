package com.yannmoisan.math.util;

import java.math.BigInteger;

public class Combinatorics {

	/**
	 * Returns the factorial of a non-negative integer, denoted by n!. <br/>
	 * The value of 0! is 1, according to the convention for an empty product.
	 * 
	 * @param n
	 * @return
	 */
	public static BigInteger factorial(int n) {
		BigInteger in = BigInteger.ONE;
		if (n != 0) {
			for (int i = 2; i <= n; i++) {
				in = in.multiply(BigInteger.valueOf(i));
			}
		}
		return in;
	}

	/**
	 * Returns the number of k-combinations of a set of n elements.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static BigInteger combination(int n, int k) {
		return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
	}

	public static BigInteger permutationWithRepetition(int... numbers) {
		int sum = 0;
		BigInteger denominator = BigInteger.ONE;
		for (int n : numbers) {
			sum += n;
			denominator = denominator.multiply(factorial(n));
		}
		return factorial(sum).divide(denominator);
	}

}

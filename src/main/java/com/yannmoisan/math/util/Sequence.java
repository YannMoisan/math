package com.yannmoisan.math.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Sequence {
	public static List<BigInteger> findFibo(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException(
					"limit must be a positive integer");
		}
		List<BigInteger> result = new ArrayList<BigInteger>();
		result.add(BigInteger.ONE);
		if (limit > 1) {
			result.add(BigInteger.ONE);
			for (int i = 2; i < limit; i++) {
				result.add(result.get(i - 2).add(result.get(i - 1)));
			}
		}
		return result;
	}

	public static List<BigInteger> findTriangle(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException(
					"limit must be a positive integer");
		}
		List<BigInteger> result = new ArrayList<BigInteger>();
		result.add(BigInteger.ONE);

		for (int i = 2; i <= limit; i++) {
			result.add(result.get(i - 2).add(BigInteger.valueOf(i)));
		}
		return result;
	}

	public static int findCollatz(int starting) {
		int length = 1;
		while (starting != 1) {
			starting = (starting % 2 == 0) ? starting / 2 : 3 * starting + 1;
			length++;
		}
		return length;
	}
}

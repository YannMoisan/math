package com.yannmoisan.math.util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeNumbers {
	/**
	 * Find prime numbers up to the limit, using the Sieve of Eratosthenes
	 * algorithm.
	 * 
	 * @param limit
	 * @return
	 */
	public static List<Integer> findPrimeNumbers(int limit) {
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must greater than 0");
		}
		// init tab
		boolean b[] = new boolean[limit + 1];
		Arrays.fill(b, true);

		int prime = 2;

		int stopIndex = (int) Math.sqrt(limit);

		while (prime <= stopIndex) {
			for (int i = prime * 2; i <= limit; i += prime) {
				b[i] = false;
			}

			while (!b[++prime]) {
			} // go to next prime
		}

		// Export to a list
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i <= limit; i++) {
			if (b[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

	/**
	 * Trial division algorithm.
	 */
	public static PrimeFactorization findPrimeFactors(long n) {
		return findPrimeFactors(n, com.yannmoisan.math.util.Collections.toArray(findPrimeNumbers((int) Math.sqrt(n) + 1)));
		
	}		
	
	public static PrimeFactorization findPrimeFactors(long n, int[] primes) {
		if (n <= 0) {
			throw new IllegalArgumentException("n must a positive integer");
		}
		PrimeFactorization pf = new PrimeFactorization(n);
		for (int p : primes) {
			if (p * p > n)
				break;
			while (n % p == 0) {
				pf.add(p);
				n /= p;
			}
		}
		if (n > 1)
			pf.add((int) n);
		return pf;
	}

	/**
	 * Least common multiples by prime factorization.
	 * @param params
	 * @return
	 */
	public static int lcm(int... params) {
		List<PrimeFactorization> pfs = new ArrayList<PrimeFactorization>();
		Set<Integer> commons = new HashSet<Integer>();
		for (int i : params) {
			pfs.add(findPrimeFactors(i));
			commons.addAll(findPrimeFactors(i).getPrimes());
		}

		int lcm = 1;
		for (int common : commons) {
			int max = 0;
			for (int j = 0; j < params.length; j++) {
				Integer tmp = pfs.get(j).getExponent(common);
				if (tmp != null && tmp > max)
					max = tmp;
			}

			lcm *= Math.pow(common, max);
		}
		return lcm;
	}


}

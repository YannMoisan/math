package com.yannmoisan.math.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Any integer N can be expressed as follows:
 * <br>N=p1^a1 * p2^a2 * p3^a3 * ...
 * <br>where pn is a distinct prime number, and an is its exponent.
 * <br>For example, 28 = 2^2 * 7^1
 * @author yamo
 *
 */
public class PrimeFactorization {
	private long nn;
	private Map<Integer, Integer> factors = new HashMap<Integer, Integer>();

	public PrimeFactorization(long n) {
		this.nn=n;
	}
	
	public void add(Integer i) {
		Integer a = factors.get(i);
		//System.out.println(a);
		factors.put(i, a == null ? 1 : ++a);
	}

	@Override
	public String toString() {
		String r = "";
		for (Entry<Integer, Integer> e : factors.entrySet()) {
			r += e.getKey() + "^" + e.getValue() + " * ";
		}
		return r;
	}

	public int nbDivisors() {
		int nb = 1;
		for (Entry<Integer, Integer> e : factors.entrySet()) {
			nb *= e.getValue() + 1;
		}
		return nb;
	}
	
	/**
	 * http://fr.wikipedia.org/wiki/Somme_des_diviseurs
	 * @return
	 */
	public int sumOfDivisors() {
		int n = 1;
		for (Entry<Integer, Integer> e : factors.entrySet()) {
			n *= ((Math.pow(e.getKey(), e.getValue() + 1) - 1)
					/ (e.getKey() - 1));
		}
		return n;
	}
	
	public int sumOfProperDivisors() {
		return sumOfDivisors()-(int) nn;
	}
	
	public boolean isAbundant() {
		return sumOfProperDivisors() > nn;
	}

	public boolean isPerfect() {
		return sumOfProperDivisors() == nn;
	}

	public boolean isDeficient() {
		return sumOfProperDivisors() < nn;
	}

	public Set<Integer> getPrimes() {
		return factors.keySet();
	}
	
	public Integer getExponent(int i) {
		return factors.get(i);
	}

}

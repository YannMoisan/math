package com.yannmoisan.math.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Math2 {
	public static int charToInt(char c) {
		return Integer.valueOf(Character.toString(c));
	}
	
	public static List<Integer> toDigits(int n) {
		return toDigits((long) n);
	}
	
	public static List<Integer> toDigits(long n) {
		List<Integer> digits = new ArrayList<Integer>();
		if (n == 0) {
			digits.add(0);
		} else {
			while (n > 0) {
				digits.add((int) n % 10);
				n = n / 10;
			}
		}
		java.util.Collections.reverse(digits);
		return digits;
	}

	public static int toInt(List<Integer> digits) {
        if (digits == null || digits.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null or empty.");
        }
        int r = 0;
        int n = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            r += digits.get(i) * n;
            n *= 10;
        }
        return r;
    }

	public static int sumOfDigits(BigInteger a) {
		String s = a.toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += charToInt(s.charAt(i));
		}
		return sum;
	}

	public static boolean isInteger(double d) {
		return d - (int) d == 0;
	}

	public static boolean isPalindrome(int a) {
		return isPalindrome(Integer.toString(a));
	}

	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}

	public static int reverse(int n) {
		int reversed = 0;
		while (n > 0) {
			reversed = 10 * reversed + n % 10;
			n = n / 10;
		}
		return reversed;
	}
	
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
}

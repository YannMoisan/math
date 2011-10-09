package com.yannmoisan.math.util;

import java.util.ArrayList;
import java.util.List;

public class Collections {
	public static int[] toArray(List<Integer> l) {
		int [] array = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			array[i] = l.get(i);
		}
		return array;
	}
	
	
	public static List<Integer> range(int from, int to) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i=from; i<=to; i++) {
			ret.add(i);
		}
		return ret;
	}
	
	public static int sum(List<Integer> list) {
		int sum = 0;
		for (Integer integer : list) {
			sum+=integer;
		}
		return sum;
	}
	
	public static <I, O> List<O> transform(List<I> c, Function<I,O> f) {
		List<O> ret = new ArrayList<O>();
		for (I i : c) {
			ret.add(f.f(i));
		}
		return ret;
	}
	
	public static interface Function<I,O> {
		public O f(I i);
	}
	
}

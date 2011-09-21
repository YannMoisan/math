package com.yannmoisan.math.util;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

public class SequenceTest {
	@Test()
	public void testFindFibo() throws Exception {
		assertEquals("[1]", Arrays.toString(Sequence.findFibo(1).toArray()));
		assertEquals("[1, 1]", Arrays.toString(Sequence.findFibo(2).toArray()));
		assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]", Arrays.toString(Sequence.findFibo(10).toArray()));
	}

	@Test()
	public void testFindTriangle() throws Exception {
		assertEquals("[1]", Arrays.toString(Sequence.findTriangle(1).toArray()));
		assertEquals("[1, 3]", Arrays.toString(Sequence.findTriangle(2).toArray()));
		assertEquals("[1, 3, 6, 10, 15, 21, 28, 36, 45, 55]", Arrays.toString(Sequence.findTriangle(10).toArray()));
	}
}

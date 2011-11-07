package org.katas.tdd.balance.v8;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChopStrategyTest {

	@Test
	public void testMidElementIndexCalculation() {
		/*
		 * This test is design according to the lessons learned in the previous
		 * spike
		 */
		BinaryChopStrategy solver = new BinaryChopStrategy();
		int result;
		result = solver.calculateMidElement(0);
		assertEquals(0, result);
		result = solver.calculateMidElement(1);
		assertEquals(0, result);
		result = solver.calculateMidElement(2);
		assertEquals(0, result);
		result = solver.calculateMidElement(3);
		assertEquals(0, result);
		result = solver.calculateMidElement(4);
		assertEquals(1, result);
		result = solver.calculateMidElement(5);
		assertEquals(1, result);
		result = solver.calculateMidElement(6);
		assertEquals(2, result);
	}


}

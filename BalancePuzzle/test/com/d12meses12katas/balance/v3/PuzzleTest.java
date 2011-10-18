package com.d12meses12katas.balance.v3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void noMarblesSolvesInZeroTurns() {
		Marble[] marbles = new Marble[0];
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(0, turns);
		assertEquals(-1, heavierMarbleIndex);
	}

	@Test
	public void oneMarbleSolvesInZeroTurns() {
		Marble[] marbles = new Marble[1];
		marbles[0] = new Marble(1);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(0, turns);
		assertEquals(0, heavierMarbleIndex);
	}
	
	@Test
	public void twoDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = new Marble[2];
		marbles[0] = new Marble(1);
		marbles[1] = new Marble(2);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(1, heavierMarbleIndex);
	}

	@Test
	public void threeDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = new Marble[3];
		marbles[0] = new Marble(1);
		marbles[1] = new Marble(1);
		marbles[2] = new Marble(2);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(2, heavierMarbleIndex);
	}

	@Test
	public void fourDifferentMarblesSolvesInTwoTurn() {
		Marble[] marbles = new Marble[4];
		marbles[0] = new Marble(1);
		marbles[1] = new Marble(1);
		marbles[2] = new Marble(1);
		marbles[3] = new Marble(2);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(2, turns);
		assertEquals(3, heavierMarbleIndex);
	}
	
	@Test
	public void spikeOnArraysSplittingInJava() {
		int[] wholeArray = new int[] {1,2,3,4}; 
		int[] firstChop = Arrays.copyOfRange(wholeArray, 0, 2);
		assertEquals(2, firstChop.length);
		int[] secondChop = Arrays.copyOfRange(wholeArray, 2, wholeArray.length);
		assertEquals(2, secondChop.length);
		/* Lesson is: In Arrays.copyOfRange(array, fromIndex, toIndex) 
		 * fromIndex is inclusive, toIndex is exclusive
		 */
	}

	@Test
	public void testMidElementIndexCalculation() {
		/* This test is design according to the lessons learned in the previous spike */ 
		Solver solver = new Solver();
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

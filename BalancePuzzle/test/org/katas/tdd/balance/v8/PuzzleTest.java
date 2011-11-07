package org.katas.tdd.balance.v8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PuzzleTest {

	@Test
	public void noMarblesSolvesInZeroTurns() {
		Marble[] marbles = new Marble[0];
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(0, turns);
		assertEquals(-1, heavierMarbleIndex);
	}

	@Test
	public void oneMarbleSolvesInZeroTurns() {
		Marble[] marbles = new Marble[] { new Marble(1) };
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(0, turns);
		assertEquals(0, heavierMarbleIndex);
	}

	@Test
	public void twoDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = MarbleFactory.createMarblesArray(2, 1);
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(1, heavierMarbleIndex);
	}

	@Test
	public void threeDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = MarbleFactory.createMarblesArray(3, 2);
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(2, heavierMarbleIndex);
	}

	@Test
	public void fourDifferentMarblesSolvesInTwoTurn() {
		Marble[] marbles = MarbleFactory.createMarblesArray(4, 3);
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(2, turns);
		assertEquals(3, heavierMarbleIndex);
	}

	@Test
	public void spikeOnArraysSplittingInJava() {
		int[] wholeArray = new int[] { 1, 2, 3, 4 };
		int[] firstChop = Arrays.copyOfRange(wholeArray, 0, 2);
		assertEquals(2, firstChop.length);
		int[] secondChop = Arrays.copyOfRange(wholeArray, 2, wholeArray.length);
		assertEquals(2, secondChop.length);
		/*
		 * Lesson is: In Arrays.copyOfRange(array, fromIndex, toIndex) fromIndex
		 * is inclusive, toIndex is exclusive
		 */
	}

	@Test
	public void solveAllDifferentCombinationsOfMarblesUpToFour() {
		int upToHowManyMarbles = 4;
		int[] expectedTurns = new int[] { 0, 1, 1, 2 };
		for (int i = 1; i <= upToHowManyMarbles; i++) {
			for (int j = 0; j < i; j++) {
				Marble[] marbles = MarbleFactory.createMarblesArray(i, j);
				Solver solver = new RecursiveSolver();
				int heavierMarbleIndex = solver.solve(marbles);
				int turns = solver.getTurns();
				assertEquals(expectedTurns[i - 1], turns);
				assertEquals(j, heavierMarbleIndex);
			}
		}
	}

	@Test
	public void solveWithFiveMarblesHeavierNotAtLastIndex() {
		for (int i = 0; i < 4; i++) {
			Marble[] marbles = MarbleFactory.createMarblesArray(5, i);
			Solver solver = new RecursiveSolver();
			int heavierMarbleIndex = solver.solve(marbles);
			int turns = solver.getTurns();
			assertEquals(2, turns);
			assertEquals(i, heavierMarbleIndex);
		}
	}

	@Test
	public void solveWithFiveMarblesHeavierAtLastIndex() {
		Marble[] marbles = MarbleFactory.createMarblesArray(5, 4);
		Solver solver = new RecursiveSolver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(4, heavierMarbleIndex);
	}
	
	@Test
	public void solveWithEightMarblesHeaviestMarbleInAllPositions() {
		for (int i = 0; i < 8; i++) {
			Marble[] marbles = MarbleFactory.createMarblesArray(8, i);
			Solver solver = new RecursiveSolver();
			int heavierMarbleIndex = solver.solve(marbles);
			int turns = solver.getTurns();
			assertEquals(3, turns);
			assertEquals(i, heavierMarbleIndex);
		}
	}

	@Test
	public void solveWithEightMarblesInJustTwoTurns() {
		for (int i = 0; i < 8; i++) {
			Marble[] marbles = MarbleFactory.createMarblesArray(8, i);
			Solver solver = new RecursiveSolver();
			((RecursiveSolver)solver).setStrategy(new EightMarblesStrategy());
			int heavierMarbleIndex = solver.solve(marbles);
			int turns = solver.getTurns();
			assertEquals(2, turns);
			assertEquals(i, heavierMarbleIndex);
		}
	}
}

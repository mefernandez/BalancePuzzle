package org.katas.tdd.balance.v5;

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
		Marble[] marbles = new Marble[] { new Marble(1) };
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(0, turns);
		assertEquals(0, heavierMarbleIndex);
	}

	@Test
	public void twoDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = createMarblesArray(2, 1);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(1, heavierMarbleIndex);
	}

	@Test
	public void threeDifferentMarblesSolvesInOneTurn() {
		Marble[] marbles = createMarblesArray(3, 2);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(2, heavierMarbleIndex);
	}

	@Test
	public void fourDifferentMarblesSolvesInTwoTurn() {
		Marble[] marbles = createMarblesArray(4, 3);
		Solver solver = new Solver();
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
	public void testMidElementIndexCalculation() {
		/*
		 * This test is design according to the lessons learned in the previous
		 * spike
		 */
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

	private Marble[] createMarblesArray(int howMany, int indexOfHeaviest) {
		if (indexOfHeaviest < 0 || indexOfHeaviest >= howMany)
			throw new IndexOutOfBoundsException(
					"The parameter indexOfHeaviest should be in the range [0 .. howMany-1]");
		Marble[] marbles = new Marble[howMany];
		for (int i = 0; i < howMany; i++) {
			int weight = 1;
			if (i == indexOfHeaviest)
				weight = 2;
			marbles[i] = new Marble(weight);
		}
		return marbles;
	}

	@Test
	public void solveAllDifferentCombinationsOfMarblesUpToFour() {
		int upToHowManyMarbles = 4;
		int[] expectedTurns = new int[] { 0, 1, 1, 2 };
		for (int i = 1; i <= upToHowManyMarbles; i++) {
			for (int j = 0; j < i; j++) {
				Marble[] marbles = createMarblesArray(i, j);
				Solver solver = new Solver();
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
			Marble[] marbles = createMarblesArray(5, i);
			Solver solver = new Solver();
			int heavierMarbleIndex = solver.solve(marbles);
			int turns = solver.getTurns();
			assertEquals(2, turns);
			assertEquals(i, heavierMarbleIndex);
		}
	}

	@Test
	public void solveWithFiveMarblesHeavierAtLastIndex() {
		Marble[] marbles = createMarblesArray(5, 4);
		Solver solver = new Solver();
		int heavierMarbleIndex = solver.solve(marbles);
		int turns = solver.getTurns();
		assertEquals(1, turns);
		assertEquals(4, heavierMarbleIndex);
	}

}

package org.katas.tdd.balance.v1;

import static org.junit.Assert.assertEquals;

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


}

package org.katas.tdd.balance.v3;

import java.util.Arrays;


public class Solver {

	Scales scales;

	public int solve(Marble[] marbles) {
		scales = new Scales();
		return solveRecursive(marbles);
	}

	private int solveRecursive(Marble[] marbles) {
		if (marbles.length == 0) {
			return -1;
		} else if (marbles.length == 1) {
			return 0;
		}
		int marblesCount = marbles.length;
		int midElement = calculateMidElement(marblesCount);
		Marble[] firstChop = Arrays.copyOfRange(marbles, 0, midElement+1);
		scales.weighLeft(firstChop);
		Marble[] secondChop = Arrays.copyOfRange(marbles, midElement+1, 2*(midElement+1));
		scales.weighRight(secondChop);
		int balance = scales.balance();
		if (balance < 0)
			return solveRecursive(firstChop);
		else if (balance > 0)
			return firstChop.length + solveRecursive(secondChop);
		else if (marblesCount % 2 != 0)
			return marbles.length -1;
		else
			return -1;
	}

	int calculateMidElement(int marblesCount) {
		if (marblesCount < 3)
			return 0;
		return (marblesCount / 2) -1;
	}
	
	public int getTurns() {
		return scales.getTurns();
	}
}

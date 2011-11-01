package org.katas.tdd.balance.v7;

import java.util.Arrays;

public class ChopStrategy {
	
	private Marble[] firstChop;
	private Marble[] secondChop;

	public void chop(Marble[] marbles) {
		int marblesCount = marbles.length;
		int midElement = calculateMidElement(marblesCount);
		firstChop = Arrays.copyOfRange(marbles, 0, midElement+1);
		secondChop = Arrays.copyOfRange(marbles, midElement+1, 2*(midElement+1));
		
	}
	
	int calculateMidElement(int marblesCount) {
		if (marblesCount < 3)
			return 0;
		return (marblesCount / 2) -1;
	}

	public Marble[] getFirstChop() {
		return firstChop;
	}

	public Marble[] getSecondChop() {
		return secondChop;
	}
}

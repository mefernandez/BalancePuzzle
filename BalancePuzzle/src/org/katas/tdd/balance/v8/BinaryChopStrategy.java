package org.katas.tdd.balance.v8;

import java.util.Arrays;

public class BinaryChopStrategy extends ChopStrategy {
	
	public void chop(Marble[] marbles) {
		int marblesCount = marbles.length;
		int midElement = calculateMidElement(marblesCount);
		firstChop = Arrays.copyOfRange(marbles, 0, midElement+1);
		secondChop = Arrays.copyOfRange(marbles, midElement+1, 2*(midElement+1));
		theRest = Arrays.copyOfRange(marbles, 2*(midElement+1), marbles.length);
		
	}
	
	int calculateMidElement(int marblesCount) {
		if (marblesCount < 3)
			return 0;
		return (marblesCount / 2) -1;
	}
}

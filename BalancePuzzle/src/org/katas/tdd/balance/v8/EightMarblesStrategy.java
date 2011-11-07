package org.katas.tdd.balance.v8;

import java.util.Arrays;

public class EightMarblesStrategy extends BinaryChopStrategy {

	@Override
	public void chop(Marble[] marbles) {
		if (marbles.length == 8) {
			this.firstChop = Arrays.copyOfRange(marbles, 0, 3);
			this.secondChop = Arrays.copyOfRange(marbles, 3, 6);
			this.theRest = Arrays.copyOfRange(marbles, 6, 8);
		} else {
			super.chop(marbles);
		}
		
		
	}

}

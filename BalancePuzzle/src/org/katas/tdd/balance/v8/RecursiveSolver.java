package org.katas.tdd.balance.v8;

import java.util.Arrays;


public class RecursiveSolver extends Solver {
	
	// FIXME Inject this dependency
	ChopStrategy chopper = new BinaryChopStrategy();
	
	public int solve(Marble[] marbles) {
		scales = new Scales();
		return solveRecursive(marbles);
	}

	int solveRecursive(Marble[] marbles) {
		if (marbles.length == 0) {
			return -1;
		} else if (marbles.length == 1) {
			return 0;
		}
		chopper.chop(marbles);
		Marble[] firstChop = chopper.getFirstChop();
		Marble[] secondChop = chopper.getSecondChop();
		scales.weighLeft(firstChop);
		scales.weighRight(secondChop);
		int balance = scales.balance();
		if (balance < 0)
			return solveRecursive(firstChop);
		else if (balance > 0)
			return firstChop.length + solveRecursive(secondChop);
		else
			return firstChop.length + secondChop.length + solveRecursive(chopper.getTheRest());
	}

	public void setStrategy(ChopStrategy chopperStrategy) {
		this.chopper = chopperStrategy;
	}


}

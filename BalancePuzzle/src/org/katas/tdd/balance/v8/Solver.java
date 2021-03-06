package org.katas.tdd.balance.v8;

public abstract class Solver {

	protected Scales scales;

	public abstract int solve(Marble[] marbles);

	public int getTurns() {
		return scales.getTurns();
	}

}
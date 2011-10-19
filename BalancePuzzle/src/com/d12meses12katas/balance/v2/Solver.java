package com.d12meses12katas.balance.v2;


public class Solver {

	Scales scales;

	public int solve(Marble[] marbles) {
		scales = new Scales();
		if (marbles.length == 0) {
			return -1;
		} else if (marbles.length == 1) {
			return 0;
		}
		Marble[] firstChop = new Marble[] {marbles[0]};
		scales.weighLeft(firstChop);
		Marble[] secondChop = new Marble[] {marbles[1]};
		scales.weighRight(secondChop);
		int balance = scales.balance();
		if (balance < 0)
			return 0;
		else if (balance > 0)
			return 1;
		else
			return 2;
	}

	public int getTurns() {
		return scales.getTurns();
	}

}

package com.d12meses12katas.balance.v1;


public class Solver {
	
	int turns = 0;

	public int solve(Marble[] marbles) {
		if (marbles.length == 0) {
			return -1;
		} else if (marbles.length == 1) {
			return 0;
		} else { 
			turns = 1;
			return 1;
		}
	}

	public int getTurns() {
		return turns;
	}

}

package org.katas.tdd.balance.v2;

public class Scales {
	
	int turns = 0;
	Marble[] leftPlate;
	Marble[] rightPlate;

	public void weighLeft(Marble[] marbles) {
		this.leftPlate = marbles;
	}

	public void weighRight(Marble[] marbles) {
		this.rightPlate = marbles;
	}

	public int balance() {
		turns++;
		
		int diff = sumWeights(this.leftPlate) - sumWeights(this.rightPlate);
		
		if (diff > 0)
			return -1;
		else if (diff < 0)
			return 1;
		
		return 0;
	}

	int sumWeights(Marble[] marbles) {
		int sum = 0;
		if (marbles != null)
			for (int i=0; i<marbles.length; i++)
				sum += marbles[i].getWeight();
		return sum;
	}

	public int getTurns() {
		return turns;
	}

}

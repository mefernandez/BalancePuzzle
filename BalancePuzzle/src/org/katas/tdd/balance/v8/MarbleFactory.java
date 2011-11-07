package org.katas.tdd.balance.v8;

public class MarbleFactory {

	public static Marble[] createMarblesArray(int howMany, int indexOfHeaviest) {
		if (indexOfHeaviest < 0 || indexOfHeaviest >= howMany)
			throw new IndexOutOfBoundsException(
					"The parameter indexOfHeaviest should be in the range [0 .. howMany-1]");
		Marble[] marbles = new Marble[howMany];
		for (int i = 0; i < howMany; i++) {
			int weight = 1;
			if (i == indexOfHeaviest)
				weight = 2;
			marbles[i] = new Marble(weight);
		}
		return marbles;
	}

}

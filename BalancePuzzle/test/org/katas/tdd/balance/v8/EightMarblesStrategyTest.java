package org.katas.tdd.balance.v8;

import static org.junit.Assert.*;

import org.junit.Test;

public class EightMarblesStrategyTest {

	@Test
	public void testWithEightMarbles() {
		ChopStrategy strategy = new EightMarblesStrategy();
		Marble[] marbles = MarbleFactory.createMarblesArray(8, 0);
		strategy.chop(marbles);
		assertEquals(3, strategy.firstChop.length);
		assertEquals(3, strategy.secondChop.length);
	}

}

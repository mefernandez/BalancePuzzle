package org.katas.tdd.balance.v2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.katas.tdd.balance.v2.Marble;
import org.katas.tdd.balance.v2.Scales;

public class ScalesTest {
	
	

	@Test
	public void weighNoMarble() {
		Scales scales = new Scales();
		int balance = scales.balance();
		assertEquals(0, balance);
		assertEquals(1, scales.getTurns());
	}

	@Test
	public void weighOneMarble() {
		Scales scales = new Scales();
		scales.weighLeft(new Marble[] {new Marble(1)});
		int balance = scales.balance();
		assertEquals(-1, balance);
		assertEquals(1, scales.getTurns());
	}

}

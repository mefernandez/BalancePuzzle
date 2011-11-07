package org.katas.tdd.balance.v8;

public abstract class ChopStrategy {

	protected Marble[] firstChop;
	protected Marble[] secondChop;
	protected Marble[] theRest;

	public ChopStrategy() {
		super();
	}
	
	public abstract void chop(Marble[] marbles);

	public Marble[] getFirstChop() {
		return firstChop;
	}

	public Marble[] getSecondChop() {
		return secondChop;
	}

	public Marble[] getTheRest() {
		return theRest;
	}

}
package net.alepuzio.cobol2java.enumeration;

public enum EnumComparition {

	EQUAL(0),
	MORE_THAN(1),
	LESS_THAN(-1)
	;
	
	private int number = -3;
	
	private EnumComparition(int newNumber){
		this.number = newNumber;
	}

	public int number() {
		return this.number;
	}
	
}

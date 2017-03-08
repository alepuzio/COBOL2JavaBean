package net.alepuzio.cobol2java.enumeration;

public enum EnumPositionInputCOBOL {

	CYCLE_POSITION_WITHOUT_TIMES (0),

	CYCLE_POSITION_WITH_TIMES (1),
	MIDDLE_FIELD(1),
	NUMERIC_FIELD_WITH_BRACES(1),

	LAST_FIELD(2),
	TWO_FIELDS(2),
	NUMERIC_FIELD_WITH_RIGTH_BRACE_DOT(2),
	THREE_FIELDS (3),
	THIRTY(30);
	
	private  int position = 0;
	
	private EnumPositionInputCOBOL(int newPosition){
		this.position = newPosition;
	}
	
	public int position(){
		return this.position;
	}
	@Override
	public String toString(){
		return  this.getClass()+"["+this.position()+"]";
	}
}

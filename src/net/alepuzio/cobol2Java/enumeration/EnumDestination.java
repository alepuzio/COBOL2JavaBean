package net.alepuzio.cobol2java.enumeration;

public enum EnumDestination {
	FOR_HOST("ForHost", true),   
	FROM_HOST("FromHost", false)
	;

	private  String sourcecode = null;
	private  boolean directionFromTo = false;
	
	private  EnumDestination(String value, boolean isDestination){
		this.sourcecode = value;
		this.directionFromTo = isDestination;
	}
	
	public boolean directionFromTo() {
		return directionFromTo;
	}

	public String sourceCode(){
		return this.sourcecode;
	}
	@Override
	public String toString(){
		return  this.getClass()+"["+this.sourceCode()+","+directionFromTo()+"]";
	}
}

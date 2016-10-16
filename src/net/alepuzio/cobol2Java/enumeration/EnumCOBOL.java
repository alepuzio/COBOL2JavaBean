package net.alepuzio.cobol2Java.enumeration;

public enum EnumCOBOL {

	SEPARATOR("SEP-"),
	SIGN_LEADING_SEPARATE("SIGN LEADING SEPARATE"),
	WHITE_SPACES(" "),
	OCCURS(" OCCURS "),
	TIMES(" TIMES"),
	PIC_9(" PIC 9"," PIC 9\\("),
	PIC_X(" PIC X"," PIC X\\("),
	PIC_S9("PIC S9")
	;
	
	private  String sourcecode = null;
	private  String syntax = null;
	
	private  EnumCOBOL(String value){
		this.sourcecode = value;
	}

	private  EnumCOBOL(String value, String newSyntax){
		this.sourcecode = value;
		this.syntax = newSyntax;
	}
	
	public String syntax() {
		return this.syntax;
	}

	public String sourceCode(){
		return this.sourcecode;
	}
	
	@Override
	public String toString(){
		return  this.getClass()+"["+this.sourceCode()+"]";
	}

}

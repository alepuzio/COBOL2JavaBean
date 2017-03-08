package net.alepuzio.cobol2java.enumeration;

public  enum EnumXML {

	END_FIELD_MAP("\"     precision=\"0\" numericScale=\"0\" align=\"left\"  mandatory=\"1\" separator=\"\t\" occurs=\"0\" default=\"\" offset=\"\" padding=\"\"/>\n"),
	BEGIN_FIELD_MAP("\t\t\t<field-map attributeName=\""),
	MIDDLE_FIELD_MAP("\"  length=\"");
	

	
	private  String sourcecode = null;
	
	private  EnumXML(String value){
		this.sourcecode = value;
	}
	
	public  String sourceCode(){
		return this.sourcecode;
	}
	@Override
	public  String toString(){
		return  this.getClass()+"["+this.sourceCode()+"]";
	}
}

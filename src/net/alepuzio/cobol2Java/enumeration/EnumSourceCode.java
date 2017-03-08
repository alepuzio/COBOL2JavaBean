package net.alepuzio.cobol2java.enumeration;

/**
 * this class represents the enumeration and constants of XML and Java Source code
 * */
public enum EnumSourceCode {
	
	SINGLE_ATTRIBUTE("String "),
	LIST_ATTRIBUTES("List<String> "),

	BEGIN_CREATE_COMMAND_OUTPUT ("\n\n\tpublic  OutputCommand createCommandOutput() throws InfrastructureException {\n\t\treturn new "),	
	END_CREATE_COMMAND_OUTPUT("();\n\t}\n"),
	PACKAGE("package generated;\n\n\n"),
	SCOPE ("public class "),
	INHERITANCE( "Process extends TransactionProcessInterface {\n\n"),
	INPUT_COMMAND ("inputCommand"),
	BEGIN_FILL_AREA_INPUT("\n\tpublic  Object fillInputArea(InputCommandInterface "+INPUT_COMMAND.sourcecode+") throws InfrastructureException {\n"),
	END_FILL_AREA_INPUT("\t\treturn inputForHost;\n\t}\n"),
	OUTPUT_COMMAND ("outputCommand"),
	BEGIN_FILL_AREA_OUTPUT("\tpublic  void fillOutputCommand(Object host, OutputCommand "+OUTPUT_COMMAND.sourceCode()+") throws InfrastructureException {\n"),
	END_FILL_AREA_OUTPUT("\t}\n");

	private  String sourcecode = null;
	
	private  EnumSourceCode(String value){
		this.sourcecode = value;
	}
	
	public  String sourceCode(){
		return this.sourcecode;
	}
	@Override
	public String toString(){
		return  this.getClass()+"["+this.sourceCode()+"]";
	}


}

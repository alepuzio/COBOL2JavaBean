package net.alepuzio.cobol2java.generateFile.input;

import java.io.PrintWriter;
import java.util.Set;

import net.alepuzio.cobol2java.bean.Attr;
import net.alepuzio.cobol2java.enumeration.EnumDestination;
import net.alepuzio.cobol2java.enumeration.EnumIO;
import net.alepuzio.cobol2java.enumeration.EnumSourceCode;
import net.alepuzio.cobol2java.generateFile.TemplateBeanInput;

/**
 * This class
 * */
public class ConfigurationTemplateFactoryInputForHost extends TemplateBeanInput {

	private  static final EnumIO PATH = EnumIO.PATH_COPIA_BEAN_TRANSAZIONE;
	private static final EnumDestination KIND_BEAN_DESTINATION = EnumDestination.FROM_HOST;
	
	private String name = null;
	private Set<Attr> setAttibutes = null;
	

	@Override
	public  EnumIO getPATH() {
		return PATH;
	}
	@Override
	public  EnumDestination getKIND_BEAN_DESTINATION() {
		return KIND_BEAN_DESTINATION;
	}

	public ConfigurationTemplateFactoryInputForHost(String nameClass, Set<Attr> listAttributesInput){
		this.name = nameClass;
		this.setAttibutes = listAttributesInput;
	}

	@Override
	public  String getName() {
		return this.name;
	}

	@Override
	public  Set<Attr> getSetAttibutes() {
		return setAttibutes;
	}

	public  Set<Attr> getAttributesOutput() {
		throw new UnsupportedOperationException();
	}

	/***
	 * @param inputfileFortransaction: print writer of the file to write into filesystem
	 * @param att: attribute
	 * @param toPrint: source code to put into generating file
	 * */
	@Override
	public  void manageSingleAttribute(PrintWriter inputfileFortransaction,	 Attr att,  StringBuffer toPrint) {
		String formattedName = att.getNameFormattedAsAttribute();
			if (isValidNameAttribute(formattedName)) {
				toPrint.append("\tprivate  ");
				toPrint = toPrint.append(EnumSourceCode.SINGLE_ATTRIBUTE.sourceCode());
				inputfileFortransaction.write(toPrint.append(formattedName).append(";\n").toString());
			}
	}
	
}

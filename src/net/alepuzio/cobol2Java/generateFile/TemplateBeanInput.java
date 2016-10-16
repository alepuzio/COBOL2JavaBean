package net.alepuzio.cobol2Java.generateFile;

import net.alepuzio.cobol2Java.generateFile.TemplateFactoryBeanInputOuput;
/**
 * This class represents the template of a Input generated class
 * */
public abstract class TemplateBeanInput extends TemplateFactoryBeanInputOuput {

	private  static final String KIND_BEAN = "Input";
	
	/**
	 * Return the suffix of the class
	 * */
	@Override
	public  String getKindBean(){
		return KIND_BEAN;
	}
}

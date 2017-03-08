package net.alepuzio.cobol2java.generateFile;

import net.alepuzio.cobol2java.generateFile.TemplateFactoryBeanInputOuput;
/**
 * This class represents the template of a Output generated class
 * */
public abstract class TemplateBeanOutput extends TemplateFactoryBeanInputOuput {

	private  static final String KIND_BEAN = "Output";
	/**
	 * Return the suffix of the class
	 * */
	@Override
	public   String getKindBean(){
		return KIND_BEAN;
	}
}

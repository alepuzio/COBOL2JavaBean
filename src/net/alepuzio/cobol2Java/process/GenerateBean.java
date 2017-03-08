package net.alepuzio.cobol2java.process;

import java.util.Properties;
import java.util.Set;

import net.alepuzio.cobol2java.bean.Attr;
import net.alepuzio.cobol2java.enumeration.EnumDestination;
import net.alepuzio.cobol2java.generateFile.TemplateFactoryBeanInputOuput;

/**
 * This class contains the data of the Java Bena to create and runs the generation of the files
 * */
public class GenerateBean extends GenerateSuperClass {

	private  String fileName = null;

	private  Set<Attr> setAttributesInput = null;
	private  Set<Attr> setAttributesOutput = null;
	
	public GenerateBean(GenerateXML generaXML) {
		this.fileName = generaXML.getCompleteFunctionName();
		this.setAttributesInput = generaXML.getListAttributesInput();
		this.setAttributesOutput = generaXML.getListAttributesOutput();
	}
	
	private  String getFileName() {
		return fileName;
	}

	private  Set<Attr> getSetAttributesInput() {
		return setAttributesInput;
	}

	private Set<Attr> getSetAttributesOutput() {
		return setAttributesOutput;
	}


	/**
	 * It creates the input/output beans  
	 * */
	public  void makeBean() {
		String nameClassToGenerate = getFileName() + "Input";
		for (EnumDestination destination : EnumDestination.values()){
			if(!destination.directionFromTo()){
				TemplateFactoryBeanInputOuput beanToCreate = TemplateFactoryBeanInputOuput.instance(destination.sourceCode(), nameClassToGenerate, getSetAttributesInput());
				beanToCreate.makeBean();
			}
		}
		nameClassToGenerate = getFileName() + "Output";
		for (EnumDestination destination : EnumDestination.values()){
			if(!destination.directionFromTo()){
				TemplateFactoryBeanInputOuput beanToCreate = TemplateFactoryBeanInputOuput.instance(destination.sourceCode(),nameClassToGenerate, getSetAttributesOutput());
				beanToCreate.makeBean();
			}
		}
	}


	@Override
	public  Properties getProperties() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void makesListDividedForInput(Set<Attr> list) {
		this.getAttributes().divideAttributesforInputKind(list);
	}

}

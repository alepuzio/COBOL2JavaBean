package net.alepuzio.cobol2java.generateFile.output;

import java.util.Set;

import net.alepuzio.cobol2java.bean.Attr;
import net.alepuzio.cobol2java.enumeration.EnumDestination;
import net.alepuzio.cobol2java.enumeration.EnumIO;
import net.alepuzio.cobol2java.generateFile.TemplateBeanOutput;

public class ConfigurationTemplateFactoryInputFromHost extends TemplateBeanOutput {

	private  static final EnumIO PATH = EnumIO.PATH_COPIA_BEAN_TRANSAZIONE;
	private static final EnumDestination KIND_BEAN_DESTINATION = EnumDestination.FOR_HOST;
	
	private String name = null;
	private Set<Attr>  setAttributes = null;
	
	@Override
	public  EnumIO getPATH() {
		return PATH;
	}

	@Override
	public  EnumDestination getKIND_BEAN_DESTINATION() {
		return KIND_BEAN_DESTINATION;
	}

	public  ConfigurationTemplateFactoryInputFromHost(String nameClass,  Set<Attr> listAttributesOutput){
		this.name = nameClass;
		this.setAttributes = listAttributesOutput;
	}

	@Override
	public  Set<Attr>  getSetAttibutes() {
		return setAttributes;
	}

	@Override
	public  String getName() {
		return name;
	}

}

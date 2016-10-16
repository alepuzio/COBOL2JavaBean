package net.alepuzio.cobol2Java.generateFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import net.alepuzio.cobol2Java.bean.Attr;
import net.alepuzio.cobol2Java.enumeration.EnumDestination;
import net.alepuzio.cobol2Java.enumeration.EnumIO;
import net.alepuzio.cobol2Java.enumeration.EnumSourceCode;
import net.alepuzio.cobol2Java.generateFile.input.ConfigurationTemplateFactoryInputForHost;
import net.alepuzio.cobol2Java.generateFile.output.ConfigurationTemplateFactoryInputFromHost;
import net.alepuzio.cobol2Java.util.UtilFormat;
import net.alepuzio.cobol2Java.util.UtilIO;

/**
 * This class concentrates the common data and methods used into creation of Input and Output Class
 * */
public abstract class TemplateFactoryBeanInputOuput {
	
	private Logger logger = Logger.getLogger(this.getClass());

	private  static TemplateFactoryBeanInputOuput instance = null;
	private  static final String EXTENSION = ".java";
	

	 /**
	  * @return an instance of this class
	  * @param typeGeneratedFile: it defines if it's creeating a class for communication between host or between web: the possibile values are definted in
	  * net.alepuzio.cobol2Java.enumeration.EnumSourceCode
	  * @param nameClass: name of the Java Bean that has be to create
	  * @param  setAttributes: set of the attributes that have to be put into generated class
	  *  
	  * */
	public static TemplateFactoryBeanInputOuput instance(String  typeGeneratedFile, String nameClass,  Set<Attr> setAttributes){
		if(EnumDestination.FOR_HOST.sourceCode().equals(typeGeneratedFile)){
			TemplateFactoryBeanInputOuput.instance = new ConfigurationTemplateFactoryInputForHost(nameClass,setAttributes);
		} else if (EnumDestination.FROM_HOST.sourceCode().equals(typeGeneratedFile)){
			TemplateFactoryBeanInputOuput.instance = new ConfigurationTemplateFactoryInputFromHost(nameClass, setAttributes);
		}
		return TemplateFactoryBeanInputOuput.instance;
	}
	
	/**
	 * @return Input/Output
	 * */
	public  abstract String getKindBean();
	/**
	 * @return the Set of attributes
	 * */
	public  abstract Set<Attr> getSetAttibutes() ;
	/**
	 * @return name of the generated class
	 * */
	public  abstract String getName();
	/**
	 * @return from/to web or from/to host, as defined in Enum
	 * */
	public  abstract EnumDestination getKIND_BEAN_DESTINATION();
	/**
	 * @return path of generated classes
	 * */
	public  abstract EnumIO getPATH() ;
	

	/**
	 * It creates the bean in input/output
	 * */
	public  void makeBean(){
		final String nameJavaFile = getPATH().createDirectory() + getName() + getKIND_BEAN_DESTINATION().sourceCode()+ EXTENSION;
		final File inputPhysicalFile = new File(nameJavaFile);
		makePhysicalFile(inputPhysicalFile, getKIND_BEAN_DESTINATION());
	}

	/**
	 * @return source code for method set
	 * @param attr: single attribute
	 * */
	private  String buildSet(Attr attr) {
		final String nameAttribute = UtilFormat.formatAttributeNameForGetSet(attr.getName());
		final String nameParameter = formatVariableSet(attr.getNameFormattedAsAttribute());
		final StringBuffer buffer = new StringBuffer("\tpublic  void set").append(nameAttribute);
		buffer.append("(");
		buffer.append(EnumSourceCode.SINGLE_ATTRIBUTE.sourceCode());
		buffer.append(nameParameter).append(") {\n");
		buffer.append("\t\tthis.").append(attr.getNameFormattedAsAttribute()).append(" = ").append(nameParameter).append(";\n");
		return	buffer.append("\t}\n").toString();

	}
	
	/**
	 * @return source code a a list
	 * @param nameAttribute: name of attibute
	 * @return 
	 * @TODO rivedere perche semplificabile
	 * */
	private  String formatDataType(Attr nameAttribute) {
		return EnumSourceCode.SINGLE_ATTRIBUTE.sourceCode();	
	}

	/**
	 * @return source code for method get
	 * @param attr: single attribute
	 * */
	private  String buildGet(Attr attr) {
		final String att = UtilFormat.formatAttributeNameForGetSet(attr.getName());
		StringBuffer buffer = new StringBuffer("\tpublic  ").append(formatDataType(attr)).append(" get").append(att);
		buffer.append("() {\n");
		buffer.append("\t\treturn this.").append(attr.getNameFormattedAsAttribute()).append(";\n");
		return buffer.append("\t}\n").toString();
	}

	/**
	 * @return true if name is a COBOL field can be translated into Attribute of a Java class
	 * @param nome : name of COBOL field
	 * */
	protected  boolean isValidNameAttribute(String name) {
		return !name.contains("SEP-") && !name.contains("X(")	&& !name.contains("x(");
	}
	
	/**
	 * @param inputClassForTransaction: generating class
	 * It creates the set of attributes in generating class 
	 * */
	public  void buildAttributes(PrintWriter inputClassForTransaction) {
		try { 
			final Iterator<Attr> it = getSetAttibutes().iterator();
			while (it.hasNext()) {
				final Attr att = it.next();
				final String row = buildGet(att);
				inputClassForTransaction.write(row);
				inputClassForTransaction.write(buildSet(att));
			}
			inputClassForTransaction.write("\n\t}//end class");
		} catch(Exception e){
			logger.error(e);
		} finally {
			UtilIO.closePrintWriter(inputClassForTransaction);
		}
	}
	

	/**
	 * @param inputfileForTransiction: stream of output
	 * @param attribute: current attribute in elaboration
	 * @param toPrint: string to print in output stream
	 * */
	public  void manageSingleAttribute(PrintWriter inputfileForTransiction, Attr attribute, StringBuffer toPrint) {
		final String nome = attribute.getNameFormattedAsAttribute();
		if (isValidNameAttribute(nome)) {
			toPrint.append("\tpublic  ");
			toPrint.append(EnumSourceCode.SINGLE_ATTRIBUTE.sourceCode());
			inputfileForTransiction.write(toPrint.append(nome).append(";\n").toString());
		}
	}
	
	
	
	/**
	 * Write in filesytem the file
	 * @param transactionPhysicalFile: generated file into filesystem
	 * @param typeFile: type of file
	 * */
	public  void makePhysicalFile(File transactionPhysicalFile, EnumDestination typeFile)	{
		PrintWriter fileClassInputForTransaction = null;
		try {
			fileClassInputForTransaction = new PrintWriter(transactionPhysicalFile);
		} catch (FileNotFoundException e) {
			final String msgFile = (null == transactionPhysicalFile) ? "null file"  : transactionPhysicalFile.getPath();
			final String msgTypeFile = (null == typeFile) ? "null type file"  : typeFile.name();
			logger.error("Error  in managing("+ msgFile + "," +  msgTypeFile + ")",e);
		}
		buildHeader(typeFile, fileClassInputForTransaction);
		Iterator<Attr> iteratorAttributes = getSetAttibutes().iterator();
		while (iteratorAttributes.hasNext()) {
			Attr att = iteratorAttributes.next();
			StringBuffer toPrint = new StringBuffer();
			manageSingleAttribute(fileClassInputForTransaction, att, toPrint);
		}
		fileClassInputForTransaction.write("\n");

		// attributi get/set
		buildAttributes(fileClassInputForTransaction);
	}
	
	/**
	 * It makes the source code for the first part of the generated file.
	 * @param fileClassInputForTransaction: generating file into filesystem
	 * @param typeFile: type of file
	 */
	public  void buildHeader(EnumDestination typeFile, PrintWriter fileClassInputForTransaction) {
		fileClassInputForTransaction.write("package cobol." + getKindBean() + "Command;");
		fileClassInputForTransaction.write("\nimport java.util.List;\n\npublic class " + getName()	+ typeFile.sourceCode());
		fileClassInputForTransaction.write(" extends Legacy"+ getKindBean() + "Command");
		fileClassInputForTransaction.write("{\n\n\tpublic  static final long serialVersionUID = 1L;\n\n");
	}
	
	/**
	 * @return variable for set method
	 * @param attributeName: name of attribute
	 * */
	private  String formatVariableSet(String attributeName) {
		return new StringBuffer(" new").append(attributeName.substring(0,1).toUpperCase()).append(attributeName.substring(1)).toString();
	}
}

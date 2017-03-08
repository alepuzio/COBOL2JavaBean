package net.alepuzio.cobol2java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import net.alepuzio.cobol2java.enumeration.EnumIO;
import net.alepuzio.cobol2java.process.GenerateBean;
import net.alepuzio.cobol2java.process.GenerateXML;



public class GeneraXMLBEANProcess {
	
	private static Logger logger = Logger.getLogger(net.alepuzio.cobol2java.GeneraXMLBEANProcess.class);

	/**
	 * Run the program
	 * @param args: not required
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		logger.info("Started generation");
		final Properties properties = new Properties();
		properties.load(new FileInputStream(new File(EnumIO.PATH_CONF_PROPERTIES.value())));
		
		//write xml
		GenerateXML generaXML = writeXMLFile(properties);
		
		//write source code bean file
		writeSourceCodeBeanFile(generaXML);
		
		logger.info("Terminated generation");
		
	}

	/***
	 * @param properties: defined properties into configuration file  
	 * @param sorgentiCobol: list of input and output paths
	 * @throws Throwable
	 */
	public static GenerateXML writeXMLFile(final Properties properties) throws Throwable {
		GenerateXML generaXML = new GenerateXML(properties);
		generaXML.createAttributesList();
		return generaXML;
	}

	/**
	 * It generates the source code of the java Bean
	 * @param generaXML: container of the data
	 * */
	public static void writeSourceCodeBeanFile(GenerateXML generaXML)	throws Throwable {
		GenerateBean generaBean = new GenerateBean(generaXML);
		generaBean.makeBean();
	}

	
}


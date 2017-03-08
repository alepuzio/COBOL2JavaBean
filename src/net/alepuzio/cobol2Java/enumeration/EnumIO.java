package net.alepuzio.cobol2java.enumeration;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * Enumeration about filsystem Input/Ouput constants
 * */
public enum EnumIO {

	PATH_ROOT					(".\\"),
	PATH_CONF_PROPERTIES        (PATH_ROOT.value() + "confCobol2Java.properties"),

	PATH_FINALE					(PATH_ROOT.value() + "generated\\"),
	PATH_COPIA_BEAN_TRANSAZIONE (PATH_FINALE.value() + "betweenHost\\"),
	PATH_COPIA_BEAN_WEB			(PATH_FINALE.value() + "betweenWeb\\")
	;

	private  String value;
	private Logger logger = Logger.getLogger(this.getClass());
	
	private  EnumIO(String value){
		this.value = value;
	}
	/**
	 * @return file or directory
	 * */
	public String value(){
		return this.value;
	}
	@Override
	public String toString(){
		return  this.getClass()+"["+this.value()+"]";
	}

	/**
	 * @return directory of the enum
	 * */
	public  final File directory(){
		return new File(this.value());
	}

	/**
	 * @return string of the absolute path of the directory: it the directory does'nt exists, then the directory will be created
	 * @exception Exception
	 * */
	public  final String createDirectory(){
		String path = "";
		try {
			if(!this.directory().exists()){
				this.directory().mkdir();
			}else{
				path = this.directory().getCanonicalPath() + "\\";
			}
		} catch (Exception e) {
			logger.error("Exception in " + this.getClass().getCanonicalName() + ".createDirectory:", e);
		}

		return path;
	}

}

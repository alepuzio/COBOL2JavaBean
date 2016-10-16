package test.unit.net.alepuzio.cobol2Java;

import java.util.Properties;

public class PropertiesUtil {

	private static final String CONSTANT_PATH = "path";
	private static final String CONSTANT_PROGRAM = "programName";
	private static final String CONSTANT_FUNCTION = "functionName";

	private static Properties prop = null;
	
	public static final Properties instance(){
		if(null == prop){
			prop = new Properties();
			prop.setProperty(CONSTANT_PATH, "path");
			prop.setProperty(CONSTANT_PROGRAM, "programName");
			prop.setProperty(CONSTANT_FUNCTION, "functionName");
		}
		return prop;
	}

	public static String getConstantPath() {
		return CONSTANT_PATH;
	}

	public static String getConstantProgram() {
		return CONSTANT_PROGRAM;
	}

	public static String getConstantFunction() {
		return CONSTANT_FUNCTION;
	}

	
	
}

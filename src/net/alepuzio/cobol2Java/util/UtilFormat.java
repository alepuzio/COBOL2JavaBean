package net.alepuzio.cobol2java.util;

/**
 * This class concentrates the methods to format various String
 * */
public class UtilFormat {
	
	/**
	 * @return name of attribute in canonical form of Java Sun Convention
	 * @param name: name of attribute
	 * */
	public static String formatAttributeName(String name) {
		return formatName(name, true);
	}

	/**
	 * @return name of attribute in canonical form of Java Sun Convention form emthod get/set
	 * @param name: name of attribute
	 * */
	public static String formatAttributeNameForGetSet(String name) {
		return formatName(name, false);
	}

	/**
	 * @param nome: name of attribute
	 * @param isAttribute: true if the name identify an attribute of a Java class, false otherwise
	 * */
	public  static String formatName(String name, boolean isAttribute) {
		name = replaceDotAndOther(name);
		char firstCharachter = ' ';
		if(isAttribute){
			firstCharachter = Character.toLowerCase(name.charAt(0));
		}else{
			firstCharachter = Character.toUpperCase(name.charAt(0));
		}
		name = firstCharachter + name.substring(1).toLowerCase();
		return substitute(name);
	}

	/**
	 * 
	 * @param name: name to manage
	 * @return the passed name without '-' and '.', agreeing with Java Sun conventions
	 * */
	public  static String replaceDotAndOther(String name) {
		return name.replaceAll("-","_").replaceAll("\\.","");
	}

	/**
	 * @param name: name to manage
	 * @return the formatted name with Java Sun conventions
	 * */
	public  static String substitute(String name) {
		name = name.replaceAll("_a","A");
		name = name.replaceAll("_b","B");
		name = name.replaceAll("_c","C");
		name = name.replaceAll("_d","D");
		name = name.replaceAll("_e","E");
		name = name.replaceAll("_f","F");
		name = name.replaceAll("_g","G");
		name = name.replaceAll("_h","H");
		name = name.replaceAll("_i","I");
		name = name.replaceAll("_l","L");
		name = name.replaceAll("_m","M");
		name = name.replaceAll("_n","N");
		name = name.replaceAll("_o","O");
		name = name.replaceAll("_p","P");
		name = name.replaceAll("_q","Q");
		name = name.replaceAll("_r","R");
		name = name.replaceAll("_s","S");
		name = name.replaceAll("_t","T");
		name = name.replaceAll("_u","U");
		name = name.replaceAll("_v","V");
		name = name.replaceAll("_z","Z");

		name = name.replaceAll("_w","W");
		name = name.replaceAll("_k","K");
		name = name.replaceAll("_y","Y");
		name = name.replaceAll("_0","0");
		name = name.replaceAll("_1","1");
		name = name.replaceAll("_2","2");
		name = name.replaceAll("_3","3");
		name = name.replaceAll("_4","4");
		name = name.replaceAll("_5","5");
		name = name.replaceAll("_6","6");
		name = name.replaceAll("_7","7");
		name = name.replaceAll("_8","8");
		name = name.replaceAll("_9","9");
		return name;
	}
}

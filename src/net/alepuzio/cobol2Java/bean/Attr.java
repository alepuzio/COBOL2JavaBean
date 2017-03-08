package net.alepuzio.cobol2java.bean;

import net.alepuzio.cobol2java.util.UtilFormat;

/**
 * This class represents an attribute in the generated classes.
 * There are formatting method into generated class.
 *  
 * */
public class Attr implements Comparable<Attr>{

	private  String  name = null;
	private  int     length = -1;
	private boolean input = false;

	
	/**
	 * @param newName: name of the attribute
	 * @param newLength: length of the attribute, based on COBOL file
	 * @param newAlone: true if the attribute is only a string, flase if it's a list
	 * @param newInput: true if the attribute come from the input source data, else false
	 * 
	 * */
	public Attr(String newName, int newLength, boolean newInput) {
		super();
		this.name = newName.replaceAll("-", "_");
		this.length = newLength;
		this.input = newInput;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (input ? 1231 : 1237);
		result = prime * result + length;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attr other = (Attr) obj;
		if (input != other.input)
			return false;
		if (length != other.length)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attr [name=");
		builder.append(name);
		builder.append(", length=");
		builder.append(length);
		builder.append(", input=");
		builder.append(input);
		builder.append("]");
		return builder.toString();
	}

	public  String getName() {
		return name;
	}
	
	public  int getLength() {
		return length;
	}
	
	public  boolean isInput() {
		return input;
	}
	
	/**
	 * @return the name of attribute, formatted with Java Sun Conventions
	 * */
	public  String getNameFormattedAsAttribute() {
		return UtilFormat.formatAttributeName(this.getName());
	}

	/**
	 * @return the name of attribute, formatted with Java Sun Conventions, when it's used into Java methods
	 * */
	public  String getNameFormattedForMethod() {
		return UtilFormat.formatAttributeNameForGetSet(this.getName());
	}
	
	/**
	 * @return 1, 0, -1 if this has a bigger name (lexicographically) or length than other attribute secondAttribute. In the last case the input attribute is considered bigger than the output attribute.
	 * @param otherAttribute: an other attribute
	 * */
	@Override
	public int compareTo(Attr otherAttribute) {
		int res = this.getName().compareTo(otherAttribute.getName());
		if( 0 == res) {
			res = this.getLength() - otherAttribute.getLength();
		}
		if( 0 == res) {
			res = this.isInput()? 1 : -1;
		}
		return res ;
	}
}
	
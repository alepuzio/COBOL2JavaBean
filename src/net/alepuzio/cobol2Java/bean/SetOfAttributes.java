package net.alepuzio.cobol2java.bean;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class represents a list of attribute after reading the COBOL source
 * */
public class SetOfAttributes {
	
	private Set<Attr> allInputAttributes = null;
	private Set<Attr> allOutputAttributes = null;
	
	
	public SetOfAttributes(){
		this.allInputAttributes  = new TreeSet<Attr>();
		this.allOutputAttributes = new TreeSet<Attr>();
	}
	
	/**
	 * @return  the list of attributes
	 * */
	public  Set<Attr> getAllAttributes() {
		Set<Attr> set = new TreeSet<Attr>(this.getAllInputAttributes());
		set.addAll(this.getAllOutputAttributes());
		return set;
	}
	
	/**
	 * @return the list of attribute in input into COBOL source
	 * */
	public  Set<Attr> getAllInputAttributes() {
		return allInputAttributes;
	}

	/**
	 * @return the list of attribute in output into COBOL source
	 * */
	public  Set<Attr> getAllOutputAttributes() {
		return allOutputAttributes;
	}
	
	/**
	 * Add a set of Attribute in this
	 * @param newAttributes: new set of attributes
	 * */
	public void divideAttributesforInputKind(Set<Attr> newAttributes) {
		Iterator<Attr> it = newAttributes.iterator();
		while(it.hasNext()){
			Attr tmp = it.next();
			if(tmp.isInput()){
				this.getAllInputAttributes().add(tmp);
			}else{
				this.getAllOutputAttributes().add(tmp);
			}
		}
	}
	
	/**
	 * @return an Iterator of the attributes
	 * */
	public  Iterator<Attr> iterator() {
		return this.getAllAttributes().iterator();
	}
	
}


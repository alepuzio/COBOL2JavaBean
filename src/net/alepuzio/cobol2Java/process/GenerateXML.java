package net.alepuzio.cobol2Java.process;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import net.alepuzio.cobol2Java.bean.Attr;
import net.alepuzio.cobol2Java.enumeration.EnumCOBOL;
import net.alepuzio.cobol2Java.enumeration.EnumPositionInputCOBOL;
import net.alepuzio.cobol2Java.util.UtilIO;


/**
 * This class generate the file XML of mapping 
 * COBOL field <--> Java attributes class. 
 * */
public class GenerateXML extends GenerateSuperClass {

	private Set<Attr> listAttributesInput = null;
	private Set<Attr> listAttributesOutput = null;
	private Properties properties = null;

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @return the instance of GenerateXML with the properties defined in a file
	 * @param newProperties: properties in a file
	 * */
	public  GenerateXML(Properties newProperties) {
		this.properties = newProperties;
		this.listAttributesInput = new TreeSet<Attr>();
		this.listAttributesOutput = new TreeSet<Attr>();
	}

	/**
	 * It creates the list of attributesFromFiles parsing the COBOL source code file
	 * */
	public  void createAttributesList(){
		Set<Attr> attributeSet = new TreeSet<Attr>();
		String tmp = null;
		boolean isInput = false;
		BufferedReader bufferedReader = null;
		try{
			String cobolSourceCode[] = 	{getProperties().getProperty("input").trim(), getProperties().getProperty("output").trim()};
			
			for(int i = 0 ; i < cobolSourceCode.length; i++){
				bufferedReader = new BufferedReader(new FileReader(cobolSourceCode[i]));
				isInput = cobolSourceCode[i].contains("input");
				String fieldName = null;
				while(null != (tmp = bufferedReader.readLine())) {
					if(null == tmp || 0 == tmp.trim().length()) {
						fieldName= null;
						continue;
					}
					tmp = tmp.trim();
					int fieldLength = 0;					
					if(tmp.contains(EnumCOBOL.SEPARATOR.sourceCode())) {
						fieldName = null;
						continue;
					}else if(tmp.contains(EnumCOBOL.SIGN_LEADING_SEPARATE.sourceCode())) {
						fieldName = null;
						continue;
					}else if(isSimpleField(tmp)) {
						String[] fields = tmp.split(EnumCOBOL.WHITE_SPACES.sourceCode());
						fieldName = (fields.length < EnumPositionInputCOBOL.THREE_FIELDS.position()) ? fields[EnumPositionInputCOBOL.MIDDLE_FIELD.position()] : fields[EnumPositionInputCOBOL.LAST_FIELD.position()];
						fieldLength = fieldNumberPicX(tmp);
					}else if(tmp.contains(EnumCOBOL.OCCURS.sourceCode())) {
						int times = calculateTimes(tmp);
						String[] campi = tmp.split(EnumCOBOL.WHITE_SPACES.sourceCode());
						fieldName = (campi.length < EnumPositionInputCOBOL.THREE_FIELDS.position()) ? campi[EnumPositionInputCOBOL.MIDDLE_FIELD.position()] :campi[EnumPositionInputCOBOL.LAST_FIELD.position()];
						tmp = bufferedReader.readLine();
						fieldLength = fieldNumberPicX(tmp) * times;
					} else if (tmp.length() < EnumPositionInputCOBOL.THIRTY.position() && tmp.split(EnumCOBOL.WHITE_SPACES.sourceCode()).length > EnumPositionInputCOBOL.TWO_FIELDS.position()) {
							logger.info("Parsing list:" + tmp);
							fieldName = tmp.replaceAll("\\.", "");
							fieldName = tmp.split(EnumCOBOL.WHITE_SPACES.sourceCode())[2];
							String firstNumer = bufferedReader.readLine();
							if(firstNumer.contains(EnumCOBOL.OCCURS.sourceCode())) {
								int times = calculateTimes(firstNumer);
								firstNumer = bufferedReader.readLine();
								fieldLength = fieldNumberPicX(firstNumer)* times;
						}else{
							String[] fields = firstNumer.split(EnumCOBOL.PIC_9.sourceCode());
							int firstNumber = Integer.parseInt(calculateNumericPartInbraces(fields));
							String nextLine = bufferedReader.readLine();
							String[] otherFields = nextLine.split(EnumCOBOL.PIC_X.syntax());
							int secondNumber = Integer.parseInt(calculateNumericPartInbraces(otherFields));
							fieldLength = firstNumber + secondNumber;
						}
					}//else if (tmp.length()<30) 
	
					if(null != fieldName && !"".equals(fieldName.trim()) && !fieldName.contains(EnumCOBOL.SEPARATOR.sourceCode())) {
						Attr attributo = new Attr(fieldName.replaceAll("-", "_"), fieldLength, isInput);
						attributeSet.add(attributo);
					}
				}//while(null != (tmp = bufferedReader.readLine()))
			}//for(int i = 0 ; i < sorgenteCobol.length; i++)
		}catch(Throwable t) {
			logger.error(t);
		}finally{
			this.divideAttributesForInputKind(attributeSet);
			UtilIO.closeBufferedReader(bufferedReader);
		}
	}
	private boolean isSimpleField(String tmp) {
		return tmp.contains(EnumCOBOL.PIC_X.sourceCode())||tmp.contains(EnumCOBOL.PIC_9.sourceCode()) ||tmp.contains(EnumCOBOL.PIC_S9.sourceCode());
	}

	private int fieldNumberPicX(String tmp) {
		int number = 0;
		if(isSimpleField(tmp)) {
			String[] numbers = tmp.split("\\(");
			numbers[1] = calculateNumericPartInbraces(numbers);
			if(null != numbers[1] && !"".equals(numbers[1].trim()) && numbers[1].contains("0")) {
				number = Integer.parseInt(numbers[1]);
			}
		}
		return number;
	}

	private  String calculateNumericPartInbraces(String[] fields) {
		return fields[1].substring(1, fields[EnumPositionInputCOBOL.NUMERIC_FIELD_WITH_BRACES.position()].length() - EnumPositionInputCOBOL.NUMERIC_FIELD_WITH_RIGTH_BRACE_DOT.position());
	}

	private int calculateTimes(String tmp) {
		String occursTmp = tmp.split(EnumCOBOL.OCCURS.sourceCode())[EnumPositionInputCOBOL.CYCLE_POSITION_WITH_TIMES.position()];
		String numbertmp = occursTmp.split(EnumCOBOL.TIMES.sourceCode())[EnumPositionInputCOBOL.CYCLE_POSITION_WITHOUT_TIMES.position()];
		int times = Integer.parseInt(numbertmp);
		return times;
	}


	public  String getPath() {
		return getProperties().getProperty("path");
	}


	public  String getCompleteFunctionName() {
		return getProperties().getProperty("programName") + getProperties().getProperty("functionName");
	}

	@Override
	public void makesListDividedForInput(Set<Attr> list) {
		this.getAttributes().divideAttributesforInputKind(list);
	}
	
	private void divideAttributesForInputKind(Set<Attr> newAttributes) {
		Iterator<Attr> it = newAttributes.iterator();
		while(it.hasNext()){
			Attr tmp = it.next();
			if(tmp.isInput()){
				this.getListAttributesInput().add(tmp);
			}else{
				this.getListAttributesOutput().add(tmp);
			}
		}
	}


	protected  Set<Attr> getListAttributesInput() {
		return listAttributesInput;
	}

	protected  Set<Attr> getListAttributesOutput() {
		return listAttributesOutput;
	}

	@Override
	public  Properties getProperties() {
		return properties;
	}
	

}
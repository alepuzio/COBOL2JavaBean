package net.alepuzio.cobol2Java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class offers a set of methods to manage the most commons I/O operations.
 * */
public class UtilIO {
	
	/**
	 * @param bufferedReader: opened file in reader mode; it can be null
	 * */
	public final static void closeBufferedReader(BufferedReader bufferedReader){
		if(null !=	bufferedReader){
			try {
				bufferedReader.close();
			} catch (IOException e) {/*recursive try/catch*/}
		}
	}

	/**
	 * @param fileOutputStream: opened file in writing mode; it can be null
	 * */
	public final static void closePrintWriter(PrintWriter fileOutputStream){
		if(null != fileOutputStream){
			fileOutputStream.flush();
			fileOutputStream.close();
		}
	}

}

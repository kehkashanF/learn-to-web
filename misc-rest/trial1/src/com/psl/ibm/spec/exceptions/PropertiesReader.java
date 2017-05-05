package com.psl.ibm.spec.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesReader {
	/**
	 * Method will take messages in form of keys and return appropriate error
	 * message values
	 * 
	 * @param keys
	 * @return
	 */
	public List<String> getMessageValue(final List<String> keys) {
		Properties prop = new Properties();
		InputStream input = null;
		List<String> values = null;
		String source = "C:/Users/kehkashan_fazal/workspace/";
		String path = "trial/resources/ValidationMessages.properties";
		try {
			input = new FileInputStream(source + path);
			prop.load(input);
			values = new ArrayList<String>();
			for (String key : keys) {
				values.add(prop.getProperty(key));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return values;
	}

}

package com.psl.ibm.spec.exceptions;

import java.util.List;

public class EmployeeException extends Exception {

	/**
	 * Returns a List of user-defined error messages
	 */
	private static final long serialVersionUID = 1L;
	private List<String> messages;

	public EmployeeException(List<String> keys) {
		super();
		this.messages = new PropertiesReader().getMessageValue(keys);
	}

	public List<String> getMessages() {
		return messages;
	}
}

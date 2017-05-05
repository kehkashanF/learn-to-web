package com.exceptions;

public class UserNotFound extends Exception {

	private static final long serialVersionUID = 1L;

		public UserNotFound(String msg) {
			System.out.println(msg);
		}
}

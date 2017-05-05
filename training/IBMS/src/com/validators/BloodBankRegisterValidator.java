package com.validators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BloodBankRegisterValidator {
	public List<String> validate(String bName, String email, String password,
			String password1, String btoName, String contact, String lNum,
			String circle, String address, String pincode, String func) {

		List<String> errorMessages = new ArrayList<String>();
		if (bName == null || bName.equals("")) {
			errorMessages.add("Blood Bank name field cannot be empty");
		}
		if (email == null || email.equals("")) {
			errorMessages.add("Email ID field cannot be empty");
		}
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!email.matches(EMAIL_REGEX)) {
			errorMessages.add("Email ID not proper");
		}
		if (password == null || password.equals("")) {
			errorMessages.add("Password field cannot be empty");
		}
		if (password.length() <= 5) {
			errorMessages.add("Password is too short");
		}
		if (!(password.equals(password1))) {
			errorMessages.add("Passwords do not match");
		}
		if (btoName == null || btoName.equals("")) {
			errorMessages.add("B.T.O name field cannot be empty");
		}
		if (contact == null || contact.equals("")) {
			errorMessages.add("Hospital name field cannot be empty");
		}
		if (lNum == null || lNum.equals("")) {
			errorMessages.add("License Number field cannot be empty");
		}
		if (circle == null || circle.equals("")) {
			errorMessages.add("Circle field cannot be empty");
		}
		if (address == null || address.equals("")) {
			errorMessages.add("Address field cannot be empty");
		}
		if (pincode == null || pincode.equals("")) {
			errorMessages.add("Pincode field cannot be empty");
		}
		if (pincode.length() < 6 || pincode.length() > 6) {
			errorMessages.add("Pincode must have six digits");
		}

		return errorMessages;
	}
}
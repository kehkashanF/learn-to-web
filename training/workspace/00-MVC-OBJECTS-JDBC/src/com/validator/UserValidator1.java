package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pojo.User;

public class UserValidator1 implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(User.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		User user=(User) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "fname.required", "First Name cannot be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lname.required", "Last Name cannot be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.required", "Address cannot be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", "Email cannot be blank");
	}
	
}

package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pojo.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(User.class);
	}


	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		User user=(User) object;
		if(user.getFirstName().length()<2|| user.getFirstName().length()>10){
			errors.rejectValue("firstName", "fname.required", "First Name cannot be this");
		}
		
		if(user.getLastName().length()<4|| user.getLastName().length()>10){
			errors.rejectValue("lastName", "lname.required", "Last Name cannot be this");
		}
		
		if(user.getAddress().length()<4|| user.getAddress().length()>40){
			errors.rejectValue("address", "address.required", "Address cannot be this");
		}
		if(user.getEmail().length()==0){
			errors.rejectValue("email", "email.required", "Email cannot be blank");
		}
	}

}

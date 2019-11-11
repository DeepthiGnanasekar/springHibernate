package com.deeps.watercanappapi.validator;

import org.springframework.stereotype.Component;

import com.deeps.watercanappapi.exception.ValidatorException;
import com.deeps.watercanappapi.model.UserDetails;

@Component
public class UserValidator {

	public void registerValidator(UserDetails details) throws Exception {
		String name = details.getName();
		if (name == null || "".equals(name.trim())) {
			throw new ValidatorException("Invalid Name");
		}
	}

	public void validCheck(String name, String password) throws Exception {

		if (password.length() > 15 || password.length() < 8) {
			throw new ValidatorException(
					"Password should contain atleast one upper case alphabet,one lower case alphabet,atleast one number,atleast one special character and should be less than 15 and more than 8 characters in length.");
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			throw new ValidatorException("Password should contain atleast one upper case alphabet");
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			throw new ValidatorException("Password should contain atleast one lower case alphabet");
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			throw new ValidatorException("Password should contain atleast one number.");
		}
		String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
		if (!password.matches(specialChars)) {
			throw new ValidatorException("Password should contain atleast one special character");
		}
	}

	public void validateName(String name) throws ValidatorException {

		
			String values = "(.*[0-9].*)";
			if (name.matches(values)) {
				throw new ValidatorException("Name should not contains numeric values");
			}
			String specialCharacters = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
			if (name.matches(specialCharacters)) {
				throw new ValidatorException("Name should not contains special character");
			}
	}

	public void validateNumber(String number) throws ValidatorException {
		
			if (number.length() < 10 || number.length() > 10) {
				throw new ValidatorException("Enter valid phone number");

			}
			String upperCaseChars = "(.*[A-Z].*)";
			if (number.matches(upperCaseChars)) {
				throw new ValidatorException("phone_number should not contain alphabet");
			}
			String lowerCaseChars = "(.*[a-z].*)";
			if (number.matches(lowerCaseChars)) {
				throw new ValidatorException("phone_number should not contain alphabet");
			}
			String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
			if (number.matches(specialChars)) {
				throw new ValidatorException("phone_number should notcontain special character");
			}
		}
	}

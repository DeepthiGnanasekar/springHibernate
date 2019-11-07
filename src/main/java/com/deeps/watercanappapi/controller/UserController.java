package com.deeps.watercanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.deeps.watercanappapi.dto.Message;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("register")
	@ApiOperation(value = "Regiter API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Registered", response = Message.class),

			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> register(@RequestParam("name") String name, @RequestParam("mobile") Long mobile,
			@RequestParam("password") String password) {
		String errorMessage = null;
		String status = null;
		UserDetails user = new UserDetails();
		try {
			user.setName(name);
			user.setMobileNumber(mobile);
			user.setSetPassword(password);

			userService.register(user);
			status = "Registered Successfully...!!! You Can Login at any time...!!!";

		} catch (Exception e) {
			errorMessage = e.getMessage();
		}

		if (status != null) {
			Message message = new Message(status);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} else {
			Message message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("login")
	@ApiOperation(value = "Login API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = UserDetails.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> login(@RequestParam("number") Long number, @RequestParam("password") String password) {
		String errorMessage = null;
		UserDetails user = null;
		try {
			user = userService.login(number, password);
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}
		if (user != null) {
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
		Message	message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}

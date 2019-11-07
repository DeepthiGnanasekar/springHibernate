package com.deeps.watercanappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.deeps.watercanappapi.dto.Message;
import com.deeps.watercanappapi.model.AdminDetails;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.deeps.watercanappapi.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("adminLogin")
	@ApiOperation(value = "AdminLogin API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = AdminDetails.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> adminLogin(@RequestParam("name") String name, @RequestParam("password") String password) {
		String errorMessage = null;
		AdminDetails admin = null;
		try {
			admin = adminService.adminLogin(name, password);
			if (admin == null) {
				throw new Exception("Invalid Crendentials...!!!");
			}
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		Message message = null;
		String status = null;
		if (admin != null) {
			status ="Success";
			message = new Message(status);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} else {
			 message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("setCan")
	@ApiOperation(value = "Availability Stock API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Invalid", response = Message.class) })
	public ResponseEntity<?> setCan(@RequestParam("can") String can) {
		String errorMessage = null;
		String status = null;
		try {
			int cans = Integer.parseInt(can);
			adminService.setCan(cans);
			status = "Success";
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (status != null) {
			Message message = new Message();
			message.setStatus(status);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} else {
			Message message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
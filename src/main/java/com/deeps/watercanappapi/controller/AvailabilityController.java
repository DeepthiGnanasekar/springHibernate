package com.deeps.watercanappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deeps.watercanappapi.dto.Message;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.OrderDetails;
import com.deeps.watercanappapi.model.ReserveDetails;
import com.deeps.watercanappapi.service.AvailabilityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AvailabilityController {
	@Autowired
	private AvailabilityService availabilityService;
	
	@GetMapping("viewStock")
	@ApiOperation(value = "AvailableStock API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Availability.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public List<Availability> viewStock() {
		List<Availability> list = null;
		try {
			list = availabilityService.availableStock();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("viewOrders")
	@ApiOperation(value = "ViewOrders API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Availability.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public List<OrderDetails> viewOrders() {
		List<OrderDetails> list = null;
		try {
			list = availabilityService.viewOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("viewReserveOrders")
	@ApiOperation(value = "ViewReserveOrders API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Availability.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public List<ReserveDetails> viewReserveOrders() {
		List<ReserveDetails> list = null;
		try {
			list = availabilityService.viewReserveOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@GetMapping("userViewOrders")
	@ApiOperation(value = "UserViewOrders API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Availability.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public List<OrderDetails> userviewOrders() {
		List<OrderDetails> list = null;
		try {
			list = availabilityService.userViewOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("userViewReserveOrders")
	@ApiOperation(value = "UserViewReserveOrders API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Availability.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public List<ReserveDetails> userviewReserveOrders() {
		List<ReserveDetails> list = null;
		try {
			list = availabilityService.UserViewReserveOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

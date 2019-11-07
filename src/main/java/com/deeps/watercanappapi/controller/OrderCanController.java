package com.deeps.watercanappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.deeps.watercanappapi.dto.Message;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.OrderDetails;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.repository.AvailabilityRepository;
import com.deeps.watercanappapi.repository.UserRepository;
import com.deeps.watercanappapi.service.OrderCanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderCanController {
	@Autowired
	private OrderCanService orderCanService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;

	@PostMapping("orderCan")
	@ApiOperation(value = "Order Can API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = OrderDetails.class),
			@ApiResponse(code = 400, message = "Invalid", response = Message.class) })
	public ResponseEntity<?> orderCan(@RequestParam("orderCans") Integer orderCans,
			@RequestParam("number") Long number) {
		String errorMessage = null;
		UserDetails user = null;
		int id = 0;
		try {
			List<Availability> value = availabilityRepository.getStock();
			Availability availableStock = value.get(0);
			if (orderCans <= availableStock.getAvailability_List()) {
				user = userRepository.findByMobileNumber(number);
				if (user == null) {
					errorMessage = "Please enter valid mobile number";
				} else {
					id = orderCanService.orderCan(orderCans, number);
				}
			} else {
				errorMessage = "Please enter valid number of cans to order based on availability";
			}
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (id != 0) {
			return new ResponseEntity<>(id, HttpStatus.OK);
		} else {
			Message message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("cancelOrder")
	@ApiOperation(value = "Cancel OrderCan API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Invalid", response = Message.class) })
	public ResponseEntity<?> cancelOrder(@RequestParam("orderId") Integer orderId,
			@RequestParam("number") Long number) {
		String errorMessage = null;
        OrderDetails orderCan = null;
        try {
            orderCan= orderCanService.cancelOrder(orderId, number);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        if (orderCan != null) {
            return new ResponseEntity<>(orderCan, HttpStatus.OK);
        } else {
            Message message = new Message(errorMessage);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}

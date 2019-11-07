package com.deeps.watercanappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.deeps.watercanappapi.dto.Message;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.ReserveDetails;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.repository.AvailabilityRepository;
import com.deeps.watercanappapi.repository.UserRepository;
import com.deeps.watercanappapi.service.ReserveCanService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ReserveCanController {
	@Autowired
	private ReserveCanService reserveCanService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;

	@PostMapping("reserveCan")
	@ApiOperation(value = "Reserve Can API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = ReserveDetails.class),
			@ApiResponse(code = 400, message = "Invalid", response = Message.class) })
	public ResponseEntity<?> reserveCan(@RequestParam("reserveCans") Integer reserveCans,
			@RequestParam("number") Long number) {
		String errorMessage = null;
		UserDetails user = null;
		int id = 0;
		try {
			List<Availability> value = availabilityRepository.getStock();

			Availability availableStock = value.get(0);
			if (reserveCans <= availableStock.getAvailability_List()) {
				user = userRepository.findByMobileNumber(number);
				if (user == null) {
					errorMessage = "Please enter valid mobile number";
				} else {
					id = reserveCanService.reserveCan(reserveCans, number);
				}
			} else {
				errorMessage = "Please enter valid number of cans to reserve based on availability";
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
	
	@PostMapping("reserveOrderCan")
    @ApiOperation("ReserveOrderCanApi")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Order Success!!", response = Message.class),
            @ApiResponse(code = 400, message = "Order Failure") })
    public ResponseEntity<?> reserveOrderCan(@RequestParam("reserveId") Integer reserveId, @RequestParam("number") Long number)
            throws ServiceException {
        String errorMessage = null;
        ReserveDetails reserveCan = null;
        try {
        	reserveCan = reserveCanService.reserveorderCan(reserveId, number);
        } catch (ServiceException e) {
            errorMessage = e.getMessage();
        }
            if (reserveCan != null) {
                return new ResponseEntity<>(reserveCan, HttpStatus.OK);
            } 
            Message message = new Message(errorMessage);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
	
	@PostMapping("modifiedReservedCan")
    @ApiOperation("ModifiedReservedCanApi")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Order Success!!", response = Message.class),
            @ApiResponse(code = 400, message = "Order Failure") })
    public ResponseEntity<?> modifiedReservedCan(@RequestParam("number") Long number, @RequestParam("cans") Integer cans, @RequestParam("reserveId") Integer reserveId )
            throws ServiceException {
        String errorMessage = null;
        ReserveDetails orderCan = null;
        try {
            orderCan= reserveCanService.modifiedReserveCan(number, cans,reserveId);
        } catch (ServiceException e) {
            errorMessage = e.getMessage();
        }
        if (orderCan != null) {
            return new ResponseEntity<>(orderCan, HttpStatus.OK);
        } else {
            Message message = new Message(errorMessage);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
	@PostMapping("cancelReserveOrder")
	@ApiOperation(value = "CancelReserveCan API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Invalid", response = Message.class) })
	public ResponseEntity<?> cancelReserveOrder(@RequestParam("orderId") Integer orderId,
			@RequestParam("number") Long number) {
		String errorMessage = null;
		ReserveDetails reserveCan = null;
        try {
        	reserveCan= reserveCanService.cancelOrder(orderId, number);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        if (reserveCan != null) {
            return new ResponseEntity<>(reserveCan, HttpStatus.OK);
        } else {
        	errorMessage = "Invalid Reserve ID";
            Message message = new Message(errorMessage);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
    }



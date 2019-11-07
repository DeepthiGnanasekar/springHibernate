package com.deeps.watercanappapi.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.OrderDetails;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.repository.AvailabilityRepository;
import com.deeps.watercanappapi.repository.OrderCanRepository;
import com.deeps.watercanappapi.repository.UserRepository;

@Service
public class OrderCanService {

	@Autowired
	private OrderCanRepository orderCanRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;
	int id;

	@Transactional
	public Integer orderCan(Integer orderCans, Long number) throws ServiceException {
		OrderDetails canOrder = new OrderDetails();
		UserDetails canId = new UserDetails();
		canId = userRepository.findById(number);
		canOrder.setUserId(canId.getId());
		canOrder.setQuantyList(orderCans);
		canOrder.setNumber(number);
		canOrder.setStatus("ORDERED");
		canOrder.setDate(LocalDateTime.now());
		Integer orderId = null;
		OrderDetails canOrderResult;
			canOrderResult = orderCanRepository.save(canOrder);
			if( canOrderResult == null) {
				throw new ServiceException("Sorry your order has not been placed please try again...!!!");
			}
			orderId = canOrderResult.getId();
			List<Availability> value = availabilityRepository.getStock();
			Availability availableStock = value.get(0);
			int value1 = availableStock.getAvailability_List();
			int result = value1 - canOrder.getQuantyList();
			availableStock.setAvailability_List(result);
			availabilityRepository.save(availableStock);
		return orderId;
	}

	public OrderDetails cancelOrder(Integer orderId, Long number) throws ServiceException {

		OrderDetails cans = orderCanRepository.findById(orderId);
		int value2 = cans.getQuantyList();
		if (cans.getNumber() == number) {
			OrderDetails canId = new OrderDetails();
			canId.setId(orderId);
			orderCanRepository.delete(canId);
			Availability stock = new Availability();
			List<Availability> value = availabilityRepository.getStock();
			Availability availability = value.get(0);
			int value1 = availability.getAvailability_List();
			int result = value1 + value2;
			availability.setAvailability_List(result);
			stock = availabilityRepository.save(availability);
		} else if (cans.getNumber() != number)  {
			throw new ServiceException("Invalid ReserveId");
		}
		return cans;
	}
}

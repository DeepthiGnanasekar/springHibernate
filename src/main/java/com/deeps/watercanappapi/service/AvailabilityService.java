package com.deeps.watercanappapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deeps.watercanappapi.dto.MessageConstant;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.OrderDetails;
import com.deeps.watercanappapi.model.ReserveDetails;
import com.deeps.watercanappapi.repository.AvailabilityRepository;
import com.deeps.watercanappapi.repository.OrderCanRepository;
import com.deeps.watercanappapi.repository.ReserveCanRepository;

@Service
public class AvailabilityService {

	@Autowired
	private AvailabilityRepository availabilityRepository;
	@Autowired
	private OrderCanRepository orderCanRepository;
	@Autowired
	private ReserveCanRepository reserveCanRepository;
	
	@Transactional
	public List<Availability> availableStock() throws ServiceException {
		List<Availability> list = null;
		list = availabilityRepository.findAll();
		if (list == null) {
			throw new ServiceException(MessageConstant.INVALID_STOCKVIEW);
		}
		return list;
	}

	@Transactional
	public List<OrderDetails> viewOrders() throws ServiceException {
		List<OrderDetails> list = null;
		list = orderCanRepository.findAll();
		if (list == null) {
			throw new ServiceException(MessageConstant.INVALID_ORDER);
		}
		return list;
}
	@Transactional
	public List<ReserveDetails> viewReserveOrders() throws ServiceException {
		List<ReserveDetails> list = null;
		list = reserveCanRepository.findAll();
		if (list == null) {
			throw new ServiceException(MessageConstant.INVALID_RESERVEORDERS);
		}
		return list;
}
	@Transactional
	public List<OrderDetails> userViewOrders() throws ServiceException {
		List<OrderDetails> list = null;
		list = orderCanRepository.findAll();
		if (list == null) {
			throw new ServiceException(MessageConstant.INVALID_ORDER);
		}
		return list;
}
	@Transactional
	public List<ReserveDetails> UserViewReserveOrders() throws ServiceException {
		List<ReserveDetails> list = null;
		list = reserveCanRepository.findAll();
		if (list == null) {
			throw new ServiceException(MessageConstant.INVALID_RESERVEORDERS);
		}
		return list;
}
}

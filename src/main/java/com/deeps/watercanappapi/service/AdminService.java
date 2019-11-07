package com.deeps.watercanappapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deeps.watercanappapi.dto.MessageConstant;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.AdminDetails;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.repository.AdminRepository;
import com.deeps.watercanappapi.repository.AvailabilityRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;

	@Transactional
	public AdminDetails adminLogin(String number, String password) throws ServiceException {
		AdminDetails user = null;
		user = adminRepository.adminLogin(number, password);
		if (user == null) {
			throw new ServiceException(MessageConstant.INVALID_LOGIN);
		}
		return user;
	}

	public Availability setCan(int cans) throws ServiceException {
		Availability stock = null;
		List<Availability> value = availabilityRepository.getStock();
		Availability availability = value.get(0);
		int value1 = availability.getAvailability_List();
		int value2 = value1 + cans;
		availability.setAvailability_List(value2);
		stock = availabilityRepository.save(availability);
		if (stock == null) {
			throw new ServiceException(MessageConstant.INVALID_STOCK);
		}
		return stock;
	}
}

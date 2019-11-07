package com.deeps.watercanappapi.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.Availability;
import com.deeps.watercanappapi.model.ReserveDetails;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.repository.AvailabilityRepository;
import com.deeps.watercanappapi.repository.ReserveCanRepository;
import com.deeps.watercanappapi.repository.UserRepository;

@Service
public class ReserveCanService {

	@Autowired
	private ReserveCanRepository reserveCanRepository;
	@Autowired
	private AvailabilityRepository availabilityRepository;
	@Autowired
	private UserRepository userRepository;
	int id;

	@Transactional
	public Integer reserveCan(Integer reserveCans, Long number) throws ServiceException  {
		ReserveDetails canReserve = new ReserveDetails();
		UserDetails canId = new UserDetails();
		canId = userRepository.findById(number);
		canReserve.setUserId(canId.getId());
		canReserve.setReservedList(reserveCans);
		canReserve.setNumber(number);
		canReserve.setStatus("Reserved...Order Pending...!!!");
		canReserve.setDate(LocalDateTime.now());
		Integer reserveId = null;
		ReserveDetails canReserveResult;
		try {
			reserveId = reserveCanRepository.findByRepeatId(number);
			if (reserveId == null) {
				canReserveResult = reserveCanRepository.save(canReserve);
				reserveId = canReserveResult.getId();
				List<Availability> value = availabilityRepository.getStock();
				Availability availableStock = value.get(0);
				int value1 = availableStock.getAvailability_List();
				int result = value1 - canReserve.getReservedList();
				availableStock.setAvailability_List(result);
				 availabilityRepository.save(availableStock);
			}
		} catch(Exception e){
			throw new ServiceException("Sorry your cans has been already reserved  please reserve that cans until then you cannot reserve your new cans...!!!");
		}
		return reserveId;
	}

	@Transactional
	public ReserveDetails reserveorderCan(Integer reserveId, Long number) throws ServiceException {
		ReserveDetails orderCanValue = null;
		ReserveDetails cans = reserveCanRepository.findByReserveId(reserveId);
		if (cans != null) {
			int can = cans.getReservedList();
			ReserveDetails orderCan = new ReserveDetails();
			UserDetails canId = new UserDetails();
			canId = userRepository.findById(number);
			orderCan.setUserId(canId.getId());
			orderCan.setReservedOrder(can);
			orderCan.setReservedList(can);
			orderCan.setNumber(number);
			orderCan.setStatus("Ordered");
			orderCan.setDate(LocalDateTime.now());
			orderCanValue = reserveCanRepository.save(orderCan);
			ReserveDetails reserveCan = new ReserveDetails();
			reserveCan.setId(reserveId);
			reserveCanRepository.delete(reserveCan);
		} else {
			throw new ServiceException("Invalid ReserveId");
		}
		return orderCanValue;
	}

	public ReserveDetails modifiedReserveCan(Long number, Integer can, Integer reserveId) throws ServiceException {
		ReserveDetails orderCanValue = null;
		ReserveDetails result = null;
			result = reserveCanRepository.findByReserveOrderId(reserveId);
			if(result != null) {
			int reserveCan = result.getReservedList();
			if(result.getId() == reserveId) {
				if (can < reserveCan) {
					ReserveDetails orderCan = new ReserveDetails();
					UserDetails canId = new UserDetails();
					canId = userRepository.findById(number);
					orderCan.setUserId(canId.getId());
					orderCan.setReservedOrder(can);
					orderCan.setReservedList(reserveCan);
					orderCan.setNumber(number);
					orderCan.setStatus("Ordered");
					orderCan.setDate(LocalDateTime.now());
					orderCanValue = reserveCanRepository.save(orderCan);
					int balanceCan = reserveCan - can;
					List<Availability> value = availabilityRepository.getStock();
					Availability availableStock = value.get(0);
					int availableCan = availableStock.getAvailability_List();
					int totalCanAfterOrder = balanceCan + availableCan;
					availableStock.setAvailability_List(totalCanAfterOrder);
					availabilityRepository.save(availableStock);
					ReserveDetails reserveCans = new ReserveDetails();
					reserveCans.setId(reserveId);
					reserveCanRepository.delete(reserveCans);
				} else if(can > reserveCan){
					ReserveDetails orderCan = new ReserveDetails();
					UserDetails canId = new UserDetails();
					canId = userRepository.findById(number);
					orderCan.setUserId(canId.getId());
					orderCan.setReservedOrder(can);
					orderCan.setReservedList(reserveCan);
					orderCan.setNumber(number);
					orderCan.setStatus("Ordered");
					orderCan.setDate(LocalDateTime.now());
					orderCanValue = reserveCanRepository.save(orderCan);
					int balanceCan = reserveCan - can;
					List<Availability> value = availabilityRepository.getStock();
					Availability availableStock = value.get(0);
					int availableCan = availableStock.getAvailability_List();
					int totalCanAfterOrder = balanceCan - availableCan;
					availableStock.setAvailability_List(totalCanAfterOrder);
					availabilityRepository.save(availableStock);
					ReserveDetails reserveCans = new ReserveDetails();
					reserveCans.setId(reserveId);
					reserveCanRepository.delete(reserveCans);
				}
		} else {
			throw new ServiceException("Invalid Reserve ID...!!!");
		}
			}
			else {
				throw new ServiceException("Invalid Reserve ID...!!!");
			}
		return orderCanValue;
	}

	@Transactional
	public ReserveDetails cancelOrder(Integer orderId, Long number) throws ServiceException {
		ReserveDetails cans = reserveCanRepository.findByCancelId(orderId);
		int value2 = cans.getReservedList();
		if (cans.getNumber() != number && cans.getStatus()!= "Ordered") {
			ReserveDetails canId = new ReserveDetails();
			canId.setId(orderId);
			reserveCanRepository.delete(canId);
			List<Availability> value = availabilityRepository.getStock();
			Availability availability = value.get(0);
			int value1 = availability.getAvailability_List();
			int result = value1 + value2;
			availability.setAvailability_List(result);
			availabilityRepository.save(availability);
		} else if (cans.getNumber() == number && cans.getStatus()== "Ordered") {
			throw new ServiceException("Invalid ReserveId");
		}
		return cans;
	}
}
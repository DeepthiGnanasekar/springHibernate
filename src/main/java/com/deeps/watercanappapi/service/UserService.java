package com.deeps.watercanappapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deeps.watercanappapi.dto.MessageConstant;
import com.deeps.watercanappapi.exception.ServiceException;
import com.deeps.watercanappapi.model.UserDetails;
import com.deeps.watercanappapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserDetails register(UserDetails user) throws ServiceException {
		UserDetails details = null;
		details = userRepository.save(user);
		if (details == null) {
			throw new ServiceException(MessageConstant.INVALID_REGISTER);
		}
		return details;
	}

	@Transactional
	public UserDetails login(Long number, String password) throws ServiceException {
		UserDetails user = null;
		user = userRepository.login(number, password);
		if (user == null) {
			throw new ServiceException(MessageConstant.INVALID_LOGIN);
		}
		return user;
	}
}

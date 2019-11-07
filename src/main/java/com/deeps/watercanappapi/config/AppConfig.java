package com.deeps.watercanappapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.deeps.watercanappapi.service.AdminService;
import com.deeps.watercanappapi.service.AvailabilityService;
import com.deeps.watercanappapi.service.OrderCanService;
import com.deeps.watercanappapi.service.ReserveCanService;
import com.deeps.watercanappapi.service.UserService;

@Configuration
public class AppConfig {
	@Bean
	public UserService user() {
		return new UserService();
	}

	@Bean
	public AdminService admin() {
		return new AdminService();
	}

	@Bean
	public AvailabilityService availableStock() {
		return new AvailabilityService();
	}

	@Bean
	public OrderCanService canOrder() {
		return new OrderCanService();
	}

	@Bean
	public ReserveCanService reserveOrder() {
		return new ReserveCanService();
	}
}
package com.cothis.sonarqube.config;

import com.cothis.sonarqube.repository.MemoryOrderRepository;
import com.cothis.sonarqube.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	OrderRepository orderRepository() {
		return new MemoryOrderRepository();
	}
}

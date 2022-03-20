package com.cothis.sonarqube.config;

import com.cothis.sonarqube.repository.MemoryOrderRepository;
import com.cothis.sonarqube.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigTest {

	@Autowired
	OrderRepository orderRepository;

	@Test
	void orderRepository() {
		assertThat(orderRepository.getClass()).isEqualTo(MemoryOrderRepository.class);
	}
}
package com.cothis.sonarqube.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderStatusTest {

	@Test
	void create_order_status() {
		OrderStatus order = OrderStatus.ORDER;
		OrderStatus confirmed = OrderStatus.CONFIRMED;

		assertThat(order.getCode()).isEqualTo(10);
		assertThat(confirmed.getDescription()).isEqualTo("구매확정");
	}

}
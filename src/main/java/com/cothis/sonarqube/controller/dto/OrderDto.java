package com.cothis.sonarqube.controller.dto;

import com.cothis.sonarqube.domain.OrderStatus;
import com.cothis.sonarqube.domain.Order;
import lombok.Getter;

@Getter
public class OrderDto {
	private final Long id;
	private final OrderStatus status;

	public OrderDto(Order order) {
		id = order.getId();
		status = order.getStatus();
	}
}

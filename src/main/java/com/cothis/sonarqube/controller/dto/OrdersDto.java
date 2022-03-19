package com.cothis.sonarqube.controller.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrdersDto {

	private final int totalCount;
	private final List<OrderDto> orders = new ArrayList<>();

	public OrdersDto(List<OrderDto> orders) {
		totalCount = orders.size();
		this.orders.addAll(orders);
	}
}

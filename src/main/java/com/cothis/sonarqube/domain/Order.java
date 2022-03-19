package com.cothis.sonarqube.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	private Long id;
	private String member;
	private OrderStatus status;

	public Order(String member, OrderStatus status) {
		id = null;
		this.member = member;
		this.status = status;
	}
}

package com.cothis.sonarqube.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {
	ORDER(10, "주문"),
	REFUND(20, "반품"),
	CONFIRMED(30, "구매확정");

	private final int code;
	private final String description;

	OrderStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
}

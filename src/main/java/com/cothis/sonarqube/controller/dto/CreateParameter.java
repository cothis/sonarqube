package com.cothis.sonarqube.controller.dto;

import com.cothis.sonarqube.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateParameter {
	private String member;
	private OrderStatus status;
}

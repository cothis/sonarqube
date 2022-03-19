package com.cothis.sonarqube.controller;

import com.cothis.sonarqube.controller.dto.CreateParameter;
import com.cothis.sonarqube.controller.dto.OrderDto;
import com.cothis.sonarqube.controller.dto.OrdersDto;
import com.cothis.sonarqube.domain.Order;
import com.cothis.sonarqube.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

	private final OrderService orderService;

	@ExceptionHandler(IllegalArgumentException.class)
	public Result<String> handleException(IllegalArgumentException e) {
		log.error(e.getMessage(), e);
		return new Result<>(false, e.getMessage());
	}

	@GetMapping
	public Result<OrdersDto> orders() {
		return new Result<>(true, new OrdersDto(orderService
				.findAll()
				.stream().map(OrderDto::new)
				.collect(Collectors.toList())));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Result<OrderDto> create(@RequestBody CreateParameter createParameter) {
		Order order = new Order(createParameter.getMember(), createParameter.getStatus());
		return new Result<>(true, new OrderDto(orderService.create(order)));
	}

	@GetMapping("{id}")
	public Result<OrderDto> findById(@PathVariable Long id) {
		return new Result<>(true, new OrderDto(orderService.findById(id)));
	}

	@AllArgsConstructor
	@Getter
	private static class Result<T> {
		private boolean result;
		private T data;
	}
}

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
	public ResponseResult<String> handleException(IllegalArgumentException e) {
		log.error(e.getMessage(), e);
		return new ResponseResult<>(false, e.getMessage());
	}

	@GetMapping
	public ResponseResult<OrdersDto> orders() {
		return new ResponseResult<>(true, new OrdersDto(orderService
				.findAll()
				.stream().map(OrderDto::new)
				.collect(Collectors.toList())));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseResult<OrderDto> create(@RequestBody CreateParameter createParameter) {
		Order order = new Order(createParameter.getMember(), createParameter.getStatus());
		return new ResponseResult<>(true, new OrderDto(orderService.create(order)));
	}

	@GetMapping("{id}")
	public ResponseResult<OrderDto> findById(@PathVariable Long id) {
		return new ResponseResult<>(true, new OrderDto(orderService.findById(id)));
	}

	@AllArgsConstructor
	@Getter
	private static class ResponseResult<T> {
		private boolean result;
		private T data;
	}
}

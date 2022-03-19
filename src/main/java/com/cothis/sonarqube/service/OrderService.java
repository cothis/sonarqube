package com.cothis.sonarqube.service;

import com.cothis.sonarqube.domain.Order;
import com.cothis.sonarqube.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;

	public Order create(Order order) {
		Long newId = orderRepository.create(order);
		return new Order(newId, order.getMember(), order.getStatus());
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		return orderRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("입력하신 id[" + id + "]에 해당하는 주문이 없습니다."));
	}
}

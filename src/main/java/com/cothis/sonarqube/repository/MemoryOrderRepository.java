package com.cothis.sonarqube.repository;

import com.cothis.sonarqube.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryOrderRepository implements OrderRepository {
	private final Map<Long, Order> store = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong();

	@Override
	public Long create(Order order) {
		order.setId(sequence.incrementAndGet());
		store.put(order.getId(), order);
		return order.getId();
	}

	@Override
	public List<Order> findAll() {
		return new ArrayList<>(store.values());
	}

	@Override
	public Optional<Order> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}
}

package com.cothis.sonarqube.repository;

import com.cothis.sonarqube.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

	Long create(Order order);

	List<Order> findAll();

	Optional<Order> findById(Long id);
}

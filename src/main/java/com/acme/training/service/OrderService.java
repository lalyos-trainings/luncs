package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.Order;

public interface OrderService {

	void doOrder(Order o);
	List<Order> getAllOrders();
}

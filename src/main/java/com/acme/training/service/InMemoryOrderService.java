package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import com.acme.training.domain.Order;

public class InMemoryOrderService implements OrderService {

	private List<Order> orders = new ArrayList<Order>();
	
	public void doOrder(Order o) {
		// TODO Auto-generated method stub
		orders.add(o);
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return this.orders;
	}

}

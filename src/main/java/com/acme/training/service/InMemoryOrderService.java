package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Order;

public class InMemoryOrderService implements OrderService, BeanNameAware {

	private List<Order> orders = new ArrayList<Order>();
	private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
	
	public void doOrder(Order o) {
		// TODO Auto-generated method stub
		orders.add(o);
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return this.orders;
	}
	
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		logger.info("My Name is: " + arg0);
	}

}

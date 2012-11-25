package com.epam.training.service;

public interface OrderLister {
	void setOrderService(OrderService os);
	void doList();
}

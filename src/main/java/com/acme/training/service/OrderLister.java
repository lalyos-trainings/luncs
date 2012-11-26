package com.acme.training.service;

public interface OrderLister {
	void setOrderService(OrderService os);
	void doList();
}

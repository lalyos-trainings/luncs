package com.acme.training.service;

import com.acme.training.domain.Address;

public interface ShoppingCart {

	public ShoppingCart withCustomer(String customer);

	public ShoppingCart withDeliveryAddress(Address deliveryAddress);

	public ShoppingCart withBillingAddress(Address billingAddress);

	public ShoppingCart withFood(int id);

	public ShoppingCart withFood(int id, int quantity);

	public void checkout();

	public OrderService getOrderService();

	public void setOrderService(OrderService orderService);

	public void setBeanName(String name);

}
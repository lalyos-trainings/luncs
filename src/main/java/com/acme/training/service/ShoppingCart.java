package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component
public class ShoppingCart {
	
	private Address deliveringAddress;
	private Address billingAddress;
	private List<OrderItem> cart = new ArrayList<OrderItem>();
	private OrderService orderService;
	
	/*public ShoppingCart(OrderService os)
	{
		this.setOrderService(os);
	}*/
	
	public ShoppingCart() {}

	public void addFood(String foodId, int quantity)
	{
		cart.add(new OrderItem(Food.getById(foodId), quantity));
	}
	
	public List<OrderItem> getCart()
	{
		return this.cart;
	}
	
	public void checkout()
	{
		this.checkout("");
	}
	
	public void checkout(String customer)
	{
		Order o = new Order(cart);
		o.setBillingAddress(billingAddress);
		o.setDeliveringAddress(deliveringAddress);
		o.setCustomer(customer);
		this.getOrderService().doOrder(o);
	}

	public Address getDeliveringAddress() {
		return deliveringAddress;
	}

	public void setDeliveringAddress(Address deliveringAddress) {
		this.deliveringAddress = deliveringAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	
	
}

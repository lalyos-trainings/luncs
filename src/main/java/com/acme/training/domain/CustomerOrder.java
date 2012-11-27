package com.acme.training.domain;

import java.util.List;
import java.util.ArrayList;

public class CustomerOrder {
	
	private Customer customer;
	private List<RestaurantOrder> restaurantOrders = new ArrayList<RestaurantOrder>();

	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<RestaurantOrder> getRestaurantOrders() {
		return restaurantOrders;
	}
	public void setRestaurantOrders(List<RestaurantOrder> restaurantOrders) {
		this.restaurantOrders = restaurantOrders;
	}
	
	
}

package com.acme.training.domain;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class CustomerOrder {
	
	private Customer customer;
	private Collection<RestaurantOrder> restaurantOrders = new ArrayList<RestaurantOrder>();

	// ToDo: implement printing !!
	public void printBill(){
		System.out.println("NOT IMPLEMENTED YET");
	}
	
	
	public int getTotal(){
		int total = 0;
		for ( RestaurantOrder ro: restaurantOrders ){
			int roTotal = ro.getTotal();
			total += roTotal;
		}
		return total;
	}
	
	public void addRestaurantOrder( RestaurantOrder ro ){
		restaurantOrders.add(ro);
	}
	
	public String getDeliveryAddress(){
		String address = customer.getDeliveryAddress();
		return address;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<RestaurantOrder> getRestaurantOrders() {
		return restaurantOrders;
	}
	public void setRestaurantOrders(Collection<RestaurantOrder> restaurantOrders) {
		this.restaurantOrders = restaurantOrders;
	}
	
	
}

package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerOrder {
	
	private static int nextId = 0;
    private String id = String.valueOf(nextId++);

	private String customer;
	private List<RestaurantOrder> subOrders = new ArrayList<RestaurantOrder>();
	private Address deliveryAddress;
	private Address billingAddress;

	public void addRestaurantOrder(RestaurantOrder ro) {
		this.subOrders.add(ro);
	}

	public List<RestaurantOrder> getRestaurantOrders() {
		return this.subOrders;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public Collection<OrderItem> getItems()
	{
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (RestaurantOrder ro : subOrders)
			for (OrderItem oi : ro.getOrderItems())
				items.add(oi);
		
		return items;
	}

	public int getTotal() {
		int sum = 0;
		for (RestaurantOrder ro : this.subOrders)
			sum += ro.getTotal();
		return sum;
	}
	
	public void printBill()
	{
		System.out.println(String.format("=== Customer: %20s", this.customer));
		System.out.println(String.format("=== Address: %20s", this.deliveryAddress));
		System.out.println("Ordered foods:");
		for (RestaurantOrder ro : subOrders)
			ro.printBill();
	}
}

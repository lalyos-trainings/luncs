package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestaurantOrder {
	
	private static int nextId = 0;
    private String id = String.valueOf(nextId++);
    
	private Restaurant restaurant;
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public void setOrderItems(List<OrderItem> items)
	{
		for (OrderItem oi : items)
			this.items.add(oi);
	}
	
	public void addOrderItem(OrderItem item)
	{
		this.items.add(item);
	}
	
	public List<OrderItem> getOrderItems()
	{
		return this.items;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public Collection<OrderItem> getItems()
	{
		return items;
	}
	
	public int getTotal()
	{
		int sum = 0;
		for (OrderItem oi : items)
			sum += oi.getTotal();
		
		return sum;
	}
	
	public void printBill()
	{
		System.out.println(String.format("=== Restaurant: %10s", this.restaurant.getName()));
		System.out.println("Ordered foods:");
		for (OrderItem oi : items)
			System.out.println(String.format("%10d * %15s: %10d", oi.getQuantity(), oi.getFood().getName(), oi.getTotal()));
	}
}

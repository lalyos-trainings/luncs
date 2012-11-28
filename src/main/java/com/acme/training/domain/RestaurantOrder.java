package com.acme.training.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrder {
	private Restaurant restaurant;
	private List<OrderItem> orderItems;
	
	public RestaurantOrder(Restaurant restaurant) {
		orderItems = new ArrayList<OrderItem>();
		this.restaurant = restaurant;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public int getTotal() {
		int total = 0;
		for (OrderItem item : orderItems) {
			total += item.getTotal();
		}
		
		return total;
	}
	
	public String printBill() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name of the restaurant: " + restaurant.getName())
				.append("\nOrders:");
		for (OrderItem item : orderItems) {
			sb.append(item.getFood().getName())
				.append(" - nr.: ")
				.append(item.getQuantity())
				.append(" | ")
				.append(item.getTotal())
				.append(" Ft\n");
		}
		sb.append("------------------------\nTotal: ")
		.append(getTotal())
		.append("\n\n");
		
		return sb.toString();
	}
}

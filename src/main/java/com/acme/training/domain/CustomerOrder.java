package com.acme.training.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
	
	private static int NEXT_ID = 1; 
	
	private final String id;
	private String customerName;
    private Address deliveryAddress;
    private Address billingAddress;
    private List<RestaurantOrder> restaurantOrders;
    

    public CustomerOrder() {
    	id = getNextId();
		restaurantOrders = new ArrayList<RestaurantOrder>();
	}
    
    public int getTotal() {
    	int total = 0;
    	for (RestaurantOrder restaurantOrder : restaurantOrders) {
    		total += restaurantOrder.getTotal();
		}
    	
    	return total;
    }
    
    public String printBill() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n\n********** The Bill **************")
    			.append("\n Customer name: ")
    			.append(customerName)
    			.append("\n delivery address: ")
    			.append(deliveryAddress)
    			.append("\n billing address: ")
    			.append(billingAddress)
    			.append("\n");
    	for (RestaurantOrder restaurantOrder : restaurantOrders) {
			sb.append(restaurantOrder.printBill());
		}
    	sb.append("** Total: ")
    			.append(getTotal())
    			.append(" Ft **************\n\n");
    	
    	return sb.toString();
    }
    
    public String getId() {
    	return id;
    }

	public String getCustomerName() {
		return customerName;
	}
	
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	
	public List<RestaurantOrder> getRestaurantOrders() {
		return restaurantOrders;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
    
	private String getNextId() {
		return String.valueOf(++NEXT_ID);
	}

	public void addOrder(Restaurant restaurant, int quantity, Food food) {
		RestaurantOrder restaurantOrder = getRestaurantOrder(restaurant);
		OrderItem orderItem = new OrderItem(quantity, food);
		restaurantOrder.getOrderItems().add(orderItem);
	}

	private RestaurantOrder getRestaurantOrder(Restaurant restaurant) {
		for (RestaurantOrder order : restaurantOrders) {
			if(order.getRestaurant().equals(restaurant)) {
				return order;
			}
		}
		
		RestaurantOrder restaurantOrder = new RestaurantOrder(restaurant);
		restaurantOrders.add(restaurantOrder);
		
		return restaurantOrder;
	}
	
}

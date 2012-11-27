package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;


public class RestaurantOrder {

	private static int nextId = 0;
	
	private Restaurant restaurant;
	private Map<Integer,OrderItem> orderItemMap = new HashMap<Integer, OrderItem>();
	private Customer customer;
	private Integer id = nextId++;
	
	public RestaurantOrder( Restaurant restaurant, Customer customer ) {
		this.restaurant = restaurant;
		this.customer = customer;
	}
	
	public void addItem( OrderItem inItem ){
		Food food = inItem.getFood();
		OrderItem item = orderItemMap.get( food.getId() );
		if ( item !=null ){
			item.addQuantity(inItem.getQuantity());
		}else{
			orderItemMap.put(food.getId(), new OrderItem(inItem.getQuantity(), food));
		}
	}

    public String toString() {
        return "Order [id=" + id + " customer:" + customer.getName() + " " +customer.getDeliveryAddress() +" ]" + getFormattedItems();
    }
    
    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (OrderItem item : orderItemMap.values()) {
            ret.append(String.format("%n   %-25s : %3d", item.getFood().getName(), item.getQuantity()));
        }
        return ret.toString();
    }

    public int getTotal(){
    	int total = 0;
    	for( OrderItem item : orderItemMap.values() ){
    		int price = item.getFood().getPrice();
    		int quantity = item.getQuantity();
    		total += quantity * price;
    	}
    	return total;
    }
    
    
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Map<Integer, OrderItem> getItems() {
		return orderItemMap;
	}

	public Integer getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}

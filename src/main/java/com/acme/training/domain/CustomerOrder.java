package com.acme.training.domain;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class CustomerOrder {
	
    private static int nextId = 0;
    
	private Customer customer;
	private Collection<RestaurantOrder> restaurantOrders = new ArrayList<RestaurantOrder>();
	private int id = nextId++;

	public CustomerOrder(){}
	
    public CustomerOrder( String customerName, String street, String city, String zip, String country ){
        customer = new Customer( customerName, street, city, zip, country );
    }
    
    public CustomerOrder( String customerName ){
        customer = new Customer( customerName );
    }
    
	public int getId(){
	    return id;
	}
	
	public void printBill(){
		System.out.println( getBillString() );
	}

	public String getBillString(){
	    
	    String customerStr = "Customer name: " + customer.getName() + "\n" +
	    		" Delivery Address: " + customer.getDeliveryAddress().toString() + "\n" +
	    		" Billing Address: " + customer.getBillingAddress().toString();
	    
	    
	    String restOrdersStr = "";
	    for ( RestaurantOrder restOrd : restaurantOrders ){
	        restOrdersStr += restOrd.getBill(); 
	    }
	    
	    
	    String billStr = "\n ***************************** \n" +
                " ...... \n" +
	            customerStr + "\n" +
	            " ...... \n" +
	            "Restaurant Orders: " + restOrdersStr + "\n" +
                " ...... \n" +
	            "Full total: " + getTotal() + "Ft";
	            
	    
	    return billStr;
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
		String address = customer.getDeliveryAddress().toString();
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

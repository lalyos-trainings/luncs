package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerOrder {
	
    private static int nextId = 0;
    private Logger logger = LoggerFactory.getLogger( CustomerOrder.class );
    
	private Customer customer;
	// rest name, order
	private Map<String, RestaurantOrder> restaurantOrders = new HashMap<String, RestaurantOrder>();
	private int id = nextId++;

	public CustomerOrder(){}
	
    public CustomerOrder( String customerName, String street, String city, String zip, String country ){
        customer = new Customer( customerName, street, city, zip, country );
    }
    
    public CustomerOrder( String customerName ){
        customer = new Customer( customerName );
    }
    
    /**
     * add food to the proper restaurant's order
     * @param food
     * @param quantity
     */
    public void addFood( Food food, Integer quantity ){

        String restaurantName = food.getRestaurant().getName();
        
        // get restaurantorder by restaurantname
        RestaurantOrder ro = restaurantOrders.get( restaurantName );
        if ( ro==null ){
            ro = new RestaurantOrder( food.getRestaurant(), this.customer );
            restaurantOrders.put( restaurantName, ro);
            logger.info( "getRestaurantOrderByName : New RestaurantOrder added" );
        }else{
            logger.info( "getRestaurantOrderByName : RestaurantOrder found" );
        }
        
        logger.info("addFood: Restaurant order:" + ro.hashCode() );
        ro.addItem( new OrderItem(quantity, food) );
    }
    
    
	public int getId(){
	    return id;
	}
	
	public void printBill(){
		System.out.println( getBillString() );
	}

	public String getBillString(){
	    
	    // Print customer data
	    String customerStr = "";
	    try{
    	    customerStr = "Customer name: " + customer.getName() + "\n" +
    	    		" Delivery Address: " + customer.getDeliveryAddress().toString() + "\n" +
    	    		" Billing Address: " + customer.getBillingAddress().toString();
	    }catch(Exception e){
            customerStr = "Customer name: " + customer.getName() + "\n" +
                    " Delivery Address:  Not set\n" +
                    " Billing Address: Not set\n";
	    }

	    // Print restaurant orders 
	    String restOrdersStr = "";
	    int totalPrice = 0;
	    try{
    	    for ( RestaurantOrder restOrd : restaurantOrders.values() ){
    	        restOrdersStr += restOrd.getBill(); 
    	    }
    	    totalPrice = getTotal();
	    }catch(Exception e){
	        restOrdersStr = "Restaurant orders not found!";
	    }
	    
	    String billStr = "\n ***************************** \n" +
                " ...... \n" +
	            customerStr + "\n" +
	            " ...... \n" +
	            "Restaurant Orders: " + restOrdersStr + "\n" +
                " ...... \n" +
	            "Full total: " + totalPrice + "Ft";
	    
	    return billStr;
	}
	
	
	public int getTotal(){
		int total = 0;
		for ( RestaurantOrder ro: restaurantOrders.values() ){
			int roTotal = ro.getTotal();
			total += roTotal;
		}
		return total;
	}
	
	public void addRestaurantOrder( RestaurantOrder ro ){
		restaurantOrders.put( ro.getRestaurant().getName(), ro );
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

    public Map<String, RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }

    public void setRestaurantOrders(Map<String, RestaurantOrder> restaurantOrders) {
        this.restaurantOrders = restaurantOrders;
    }

	
	
}

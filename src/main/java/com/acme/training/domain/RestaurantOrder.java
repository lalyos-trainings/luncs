package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class RestaurantOrder {

	private static int nextId = 0;
    private Logger logger = LoggerFactory.getLogger( CustomerOrder.class );
	
	private Restaurant restaurant;
	private Map<Integer,OrderItem> orderItemMap = new HashMap<Integer, OrderItem>();
	private Customer customer;
	private Integer id = nextId++;

	
	public RestaurantOrder( Restaurant restaurant, Customer customer ) {
		this.restaurant = restaurant;
		this.customer = customer;
	}
	
	public void addItem( OrderItem inItem ){
	    logger.info("addItem: inItem:" + inItem + " food name:" + inItem.getFood().getName() );
		Food food = inItem.getFood();
		OrderItem item = orderItemMap.get( food.getId() );
		if ( item !=null ){
			item.addQuantity(inItem.getQuantity());
		}else{
			orderItemMap.put(food.getId(), new OrderItem(inItem.getQuantity(), food));
		}
	}

    public String toString() {
        String tmp = "";
        try{
            tmp = "Order [id=" + id + " customer:" + customer.getName() + " " +customer.getDeliveryAddress().toString() +" ]" + getFormattedItems();
        }catch( Exception e ){
            tmp = "cannot create tostring";
        }
        return tmp;
    }
    
    public String getBill() {
        String billStr = "--------------- \n" +
                    " Restaurant: " + this.getRestaurant().getName() + "     " +
                    " <Order id: " + getId() + "    Customer: " + getCustomer().getName() + " >\n" + 
                    " Ordered foods:" + getFormattedItems() + "\n" +
                    " Subtotal: " + getTotal() + "Ft\n" +
                    "--------------- \n"
                   ;
        return billStr;
    }    
    
    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (OrderItem item : orderItemMap.values()) {
            ret.append(String.format("%n   %-25s : %3d pcs  = %2$2d x %4d Ft", item.getFood().getName(), item.getQuantity(), item.getFood().getPrice() ));
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

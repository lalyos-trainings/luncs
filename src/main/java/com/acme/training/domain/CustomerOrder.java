package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;

public class CustomerOrder {
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<String, RestaurantOrder> restaurantOrders;
    private int orderId;
    private static int nextId = 0;
    
    public CustomerOrder() {
        restaurantOrders = new HashMap<String, RestaurantOrder>();
        orderId=nextId++;
    }

    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public Address getBillingAddress() {
        return billingAddress;
    }
    
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    public Map<String, RestaurantOrder> restaurantOrders() {
        return restaurantOrders;
    }
    
    public void addOrderItem(int quantity, Food food){
        String restName = food.getRestaurant().getName();
        
        if(restaurantOrders.containsKey(restName)){
            restaurantOrders.get(restName).addOrderItem(quantity, food);
        }
        else{
            RestaurantOrder restaurantOrder = new RestaurantOrder();
            restaurantOrder.addOrderItem(quantity, food);
            restaurantOrders.put(restName, restaurantOrder);            
        }
    }
    
    public int getTotal(){
        int totalPrice = 0;
        for(RestaurantOrder restOrder:restaurantOrders.values()){
            totalPrice += restOrder.getTotal();
        }
        return totalPrice;
    }

    public int getId() {
        return orderId;
    }
    
    
    
    
}

package com.acme.training.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RestaurantOrder {

    private Restaurant restaurant;
    private Map<Integer, OrderItem> orderItems;
    private double total;

    public RestaurantOrder() {
        super();
        orderItems = new HashMap<Integer, OrderItem>();
        total = 0; 
    }
    
    public void addOrderItem(Food food, int quantity){
        OrderItem tmp = orderItems.get(food.getId());
        if(tmp == null){
            orderItems.put(food.getId(), new OrderItem(quantity, food));
        }
        else{
            tmp.addQuantity(quantity);
        }
        total += (quantity * food.getPrice());
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems.values();
    }
    
    public double getTotal() {
        return total;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
//    public void printBill(){
//        //TODO
//    }
    
}

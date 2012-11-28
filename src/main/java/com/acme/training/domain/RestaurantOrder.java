package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantOrder {

    private Restaurant restaurant;
    private static int nextId = 0;
    
    private String id = String.valueOf(nextId++);
    private Map<Integer, OrderItem> itemMap = new HashMap<Integer, OrderItem>(); 
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public void addItem(OrderItem item) {
        Food food = item.getFood();
        int quantity = item.getQuantity();
        OrderItem previousItem = itemMap.get(food.getId());
        if (null == previousItem) {
            itemMap.put(food.getId(), item);
        } else {
            previousItem.addQuantity(quantity);
        }         
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public List<OrderItem> getOrderItems() {
        List<OrderItem> ret = new ArrayList<OrderItem>(itemMap.values());
        return ret;
    }
    public int getTotal() {
        int total  = 0;
        for (OrderItem item : itemMap.values()) {
            total += item.getTotal();
        }
        
        return total;
    }
    
    public void printBill() {
        System.out.println("---------- Restaurant: " + restaurant.getName() + " ----------");
        for (OrderItem item : itemMap.values()) {
            System.out.println(String.format("%-20s %6dx%d  %11d", item.getFood().getName(), item.getQuantity(), item.getFood().getPrice(), item.getQuantity() * item.getFood().getPrice()));
        }
        System.out.println(String.format("%s %23d","Restaurant subtotal:",getTotal()));
    }

}

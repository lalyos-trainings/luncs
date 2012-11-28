package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantOrder extends CustomerOrder {

    private Restaurant restaurant;
    
    private Map<Integer, OrderItem> orderItems = new HashMap<Integer, OrderItem>();

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    private OrderItem orderItem;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public RestaurantOrder(Restaurant restaurant) {
        this.restaurant=restaurant;
    }

    public Map<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }

    public int getTotal() {
        int sum = 0;
        for (OrderItem item : orderItems.values()) {
            sum += item.getFood().getPrice() * item.getQuantity();
        }
        return sum;
    }

    public void printBill() {
        for (OrderItem item : orderItems.values()) {
            System.out.println("Food: " + item.getFood().getName() + 
                               " / PriceOfOne: " + item.getFood().getPrice() +  
                               " / Quant: " + item.getQuantity() +
                               " / Sum: " + Integer.toString(item.getQuantity() * item.getFood().getPrice()));
        }
        System.out.println("Total sum from the " + restaurant.getName() + " restaurant: " + Integer.toString(getTotal()));
    }
    
    public void addItem(OrderItem item) {
        
        Food food = item.getFood();
        int quantity = item.getQuantity();
        
        OrderItem previousItem = orderItems.get(food.getId());
        if (null == previousItem) {
            orderItems.put(food.getId(), item);
        } else {
            previousItem.addQuantity(quantity);
        }
    }
    
    public List<OrderItem> getItems() {
        return new ArrayList<OrderItem>(orderItems.values());
    }
    
}
    
    



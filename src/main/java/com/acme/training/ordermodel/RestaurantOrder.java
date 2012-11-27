package com.acme.training.ordermodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

public class RestaurantOrder {

    private Restaurant restaurant;
    private Map<Integer, OrderItem> orderItems;

    public RestaurantOrder(Restaurant restaurant) {
        this.restaurant=restaurant;
        orderItems = new HashMap<Integer, OrderItem>(); 
    }

    public  Map<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
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
            System.out.println("Food: " + item.getFood().getName() + " *** Quantity: " + item.getQuantity()
                    + " *** Sum: " + Integer.toString(item.getQuantity() * item.getFood().getPrice()));
        }
        System.out.println("Total: " + Integer.toString(getTotal()));
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

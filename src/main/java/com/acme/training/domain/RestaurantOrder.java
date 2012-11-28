package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;

public class RestaurantOrder {
    private Restaurant restaurant;
    private Map<Integer, OrderItem> orderItems = new HashMap<Integer, OrderItem>(); 

    public RestaurantOrder(OrderItem orderItem) {
        super();
        this.restaurant = orderItem.getFood().getRestaurant();
        addOrderItem(orderItem);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getTotal() {
        int total = 0;
        for (OrderItem orderItem : orderItems.values()) {
            total += orderItem.getTotal();
        }
        return total;
    }

    public String printBill() {
        StringBuffer printedRestaurantOrder = new StringBuffer("===============================================\n");
        printedRestaurantOrder.append(restaurant.toString() + "\n");
        printedRestaurantOrder.append("===============================================\n");
        printedRestaurantOrder.append("Food Name             Quant. Price   Unit total\n");
        printedRestaurantOrder.append("===============================================\n");
        for (OrderItem orderItem : orderItems.values()) {
            printedRestaurantOrder.append(orderItem.printBill() + "\n");
        }
        printedRestaurantOrder.append("===============================================\n");
        printedRestaurantOrder.append("Restaurant Total: " + getTotal() + "\n\n");
        return printedRestaurantOrder.toString();
    }
    
    public void addOrderItem(OrderItem orderItem) {
        Integer foodId = orderItem.getFood().getId();
        int quantity = orderItem.getQuantity();
        OrderItem previousItem = orderItems.get(foodId);
        if (null == previousItem) {
            orderItems.put(foodId, orderItem);
        } else {
            previousItem.addQuantity(quantity);
        }
    }

    public Map<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<Integer, OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
}

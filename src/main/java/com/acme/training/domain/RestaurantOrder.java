package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantOrder {

    private final Restaurant restaurant;
    private final Map<Integer, OrderItem> orderItems = new HashMap<Integer, OrderItem>();

    public RestaurantOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Collection<OrderItem> getOrderItems() {
        List<OrderItem> result = new ArrayList<OrderItem>(orderItems.values());
        return result;
    }

    public int getTotal() {
        int total = 0;
        for (OrderItem item : orderItems.values()) {
            int price = item.getFood()
                            .getPrice();
            int quantity = item.getQuantity();
            total += price * quantity;
        }

        return total;
    }

    public void printBill() {
        System.out.println("==== Restaurant Bill");
        System.out.println(restaurant.toString());
        for (OrderItem item : orderItems.values()) {
            String foodName = item.getFood()
                                  .getName();
            System.out.println(String.format("%15s x%3d %-5d", foodName, item.getQuantity(), item.getTotal()));
        }
        System.out.println(String.format("Total: %-7d", getTotal()));
    }
}

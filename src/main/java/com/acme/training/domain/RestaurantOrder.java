package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantOrder {

    private static int nextId = 0;

    private int id = nextId++;
    private Restaurant restaurant;
    private Map<Integer, OrderItem> itemMap = new HashMap<Integer, OrderItem>();

    public RestaurantOrder(OrderItem item) {
        itemMap.put(item.getFood().getId(), item);
    }

    public List<OrderItem> getItems() {
        List<OrderItem> ret = new ArrayList(itemMap.values());
        return ret;
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

    public int getTotal() {
        int total = 0;
        for (OrderItem item : itemMap.values()) {
            int price = item.getFood().getPrice();
            int quantity = item.getQuantity();
            total += price * quantity;
        }

        return total;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }
}

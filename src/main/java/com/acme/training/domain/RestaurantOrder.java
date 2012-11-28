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
        restaurant = item.getFood().getRestaurant();
        itemMap.put(item.getFood().getId(), item);
    }

    public List<OrderItem> getOrderItems() {
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
            total += item.getTotal();
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

    public String printBill() {
        return "Restaurant name: " + restaurant.getName() + getFormattedItems();
    }

    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (OrderItem item : itemMap.values()) {
            ret.append(String.format("%n   %-25s : %3d", item.getFood().getName(), item.getQuantity()));
        }
        return ret.toString();
    }

}

package com.acme.training.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantOrder {

    private Restaurant restaurant;
    private Map<Integer, OrderItem> orderItems;
    private Integer total;

    public RestaurantOrder(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.orderItems = new HashMap<Integer, OrderItem>();
        this.total = 0;
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
        total += item.getTotal();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Integer getTotal() {
        return total;
    }
    
    public String printBill(){
        StringBuffer ret = new StringBuffer();
        ret.append(String.format("%n %-25s", restaurant));
        for (OrderItem item  : orderItems.values()) {
            ret.append(String.format("%n   %-10s : %3d", item.getFood().getName(), item.getQuantity()));
        }
        ret.append(String.format("%n   total bill for restaurant: %s",getTotal()));
        return ret.toString();
    }

    public List<OrderItem> getOrderItems() {
        List<OrderItem> ret = new ArrayList(orderItems.values());
        return ret;
    }

}

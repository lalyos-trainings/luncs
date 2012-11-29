package com.acme.training.service;

import java.util.HashSet;
import java.util.Set;

public class RestaurantOrder {
    private Set<OrderItem> foods;
    
    public Set<OrderItem> getFoods() {
        return foods;
    }

    public RestaurantOrder(CustomerOrder order) {
        foods = new HashSet<OrderItem>();
        foods.addAll( order.getCollection() );
    }
}

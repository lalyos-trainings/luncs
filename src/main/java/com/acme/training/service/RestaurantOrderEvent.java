package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.RestaurantOrder;

public class RestaurantOrderEvent extends ApplicationEvent{

    private RestaurantOrder restaurantOrder;
    
    public RestaurantOrderEvent( CustomerOrderService source, RestaurantOrder order) {
        super(source);
        this.restaurantOrder = order;
    }


    public RestaurantOrder getRestaurantOrder() {
        return restaurantOrder;
    }

}

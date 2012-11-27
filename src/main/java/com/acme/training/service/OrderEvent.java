package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.Order;

public class OrderEvent extends ApplicationEvent{

    private Order order;
    
    
    public OrderEvent(OrderService source, Order order) {
        super(source);
        this.order = order;
    }


    public Order getOrder() {
        return order;
    }

}

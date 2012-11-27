package com.acme.service;

import org.springframework.context.ApplicationEvent;

import com.acme.domain.Order;

public class OrderEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;
    private Order order;
    
    public OrderEvent(OrderService source, Order order) {
        super(source);
        this.setOrder(order);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}

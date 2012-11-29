package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

/*
 * az üzeneteket ebből kell származtatni
 */
 
public class OrderEvent extends ApplicationEvent {
    
    private static final long serialVersionUID = 1L;
    private CustomerOrder order;

    public CustomerOrder getOrder() {
        return order;
    }

    public OrderEvent(OrderService source, CustomerOrder order) {
        super(source);
        this.order = order;
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "OrderEvent [order=" + order + ", source=" + source + "]";
    }


}

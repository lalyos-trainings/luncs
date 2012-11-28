package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;

public class OrderEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CustomerOrder order;
    
    public OrderEvent(OrderService source, CustomerOrder order) {
        super(source);
        this.order = order;
    }
    
    public CustomerOrder getOrder(){
        return order;
    }

}

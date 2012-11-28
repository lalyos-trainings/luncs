package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Order;

public class OrderEvent extends ApplicationEvent {

    private CustomerOrder order;
    
    
    public OrderEvent(OrderService source, CustomerOrder order) {
        super(source);
        this.order = order;
    }


    public CustomerOrder getCustomerOrder() {
        return order;
    }

}

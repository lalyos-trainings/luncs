package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Order;

public class OrderEvent extends ApplicationEvent{

    private CustomerOrder customerOrder;
    
    
    public OrderEvent(OrderService source, CustomerOrder customerOrder) {
        super(source);
        this.customerOrder = customerOrder;
    }

    public CustomerOrder getCustomerOrder(){
        return this.customerOrder;
    }

    
}

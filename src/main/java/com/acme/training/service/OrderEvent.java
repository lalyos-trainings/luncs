package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;

public class OrderEvent extends ApplicationEvent{

    private CustomerOrder customerOrder;
    
    
    public OrderEvent(OrderService source, CustomerOrder order) {
        super(source);
        this.customerOrder = order;
    }


    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

}

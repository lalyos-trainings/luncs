package com.acme.service;

import org.springframework.context.ApplicationEvent;

import com.acme.domain.CustomerOrder;

public class OrderEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;
    private CustomerOrder customerOrder;
           
           
    public OrderEvent(OrderService source, CustomerOrder customerOrder) {
        super(source);
        this.customerOrder = customerOrder; 
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

   
}

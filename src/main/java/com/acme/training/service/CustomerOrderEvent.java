package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;

public class CustomerOrderEvent extends ApplicationEvent{

    private CustomerOrder customerOrder;
    
    public CustomerOrderEvent( CustomerOrderService source, CustomerOrder order) {
        super(source);
        this.customerOrder = order;
    }


    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

}

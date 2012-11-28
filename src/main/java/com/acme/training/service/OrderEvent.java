package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;

public class OrderEvent extends ApplicationEvent
{
    private static final long serialVersionUID = 2998775968305763516L;

    private CustomerOrder order;
    
    
    public OrderEvent(OrderService source, CustomerOrder customOrder)
    {
        super(source);
        this.order = customOrder;
    }

    public CustomerOrder getCustomerOrder()
    {
        return order;
    }
    
}

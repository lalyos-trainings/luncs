package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.domain.CustomerOrder;

public class OrderEvent extends ApplicationEvent {

    private static final long serialVersionUID = 9022146304728972161L;
    private final CustomerOrder order;

    public OrderEvent(OrderService source, CustomerOrder order) {
        super(source);
        this.order = order;
    }

    public CustomerOrder getCustomerOrder() {
        return order;
    }
}

package com.acme.training.service;

import org.springframework.context.ApplicationEvent;

import com.acme.training.ordermodel.CustomerOrder;
import com.acme.training.ordermodel.Order;

@SuppressWarnings("serial")
public class OrderEvent extends ApplicationEvent{

//    private CustomerOrder order;
//    
//    
//    public OrderEvent(OrderService source, CustomerOrder order) {
//        super(source);
//        this.order = order;
//    }
//
//
//    public CustomerOrder getCustomerOrder() {
//        return order;
//    }

    
    private Order order;
    
    
    public OrderEvent(OrderService source, Order order) {
        super(source);
        this.order = order;
    }


    public Order getOrder() {
        return order;
    }
}

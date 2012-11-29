package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InMemoryOrderService implements OrderService {
    
    @Autowired
    private ApplicationContext context;
    
    List<CustomerOrder> orders = new ArrayList<CustomerOrder>();

    public synchronized void doOrder(CustomerOrder order) {
        orders.add(order);
        OrderEvent event = new OrderEvent(this,  order);
        context.publishEvent(event);
        System.out.println("+++++++++++++ msg sent: " + event);
        
    }

    public List<CustomerOrder> getAllOrders() {
        return orders;
    }

}

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
    
    List<Order> orders = new ArrayList<Order>();

    public void doOrder(Order order) {
        orders.add(order);
        OrderEvent event = new OrderEvent(this,  order);
        context.publishEvent(event);
        System.out.println("+++++++++++++ msg sent: " + event);
        
    }

    public List<Order> getAllOrders() {
        return orders;
    }

}

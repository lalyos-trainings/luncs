package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService {

    Map<String, Order> orders = new HashMap<String, Order>();
    @Autowired
    private ApplicationContext context;
    
    public void doOrder(Order order) {
        orders.put(order.getId(), order);
        OrderEvent event = new OrderEvent(this, order);
        context.publishEvent(event);
    }
    
    public Collection<Order> getAllOrder() {
        return orders.values();
    }
    
    public Order findById(String id) {
        return orders.get(id);
    }
}

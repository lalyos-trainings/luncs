package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
@Scope("singleton")
public class InMemoryOrderService implements OrderService {
    
    private Map<String, Order> orders;
    @Autowired
    private ApplicationContext context;
    
    public InMemoryOrderService(){
        orders = new HashMap<String, Order>();
    }

    public void doOrder(Order order) {
        orders.put(order.getCustomer(), order);
        OrderEvent event = new OrderEvent(this, order);
        context.publishEvent(event);
    }

    public Collection<Order> getAllOrders() {
        return orders.values();
    }

}

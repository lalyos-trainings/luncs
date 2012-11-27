package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService {

    Map<String, Order> orders = new HashMap<String, Order>();
    
    public void doOrder(Order order) {
        orders.put(order.getId(), order);
    }
    
    public Collection<Order> getAllOrder() {
        return orders.values();
    }
    
    public Order findById(String id) {
        return orders.get(id);
    }
}

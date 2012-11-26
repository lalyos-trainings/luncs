package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InMemoryOrderService implements OrderService {
    
    List<Order> orders = new ArrayList<Order>();

    public void doOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

}

package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import com.acme.training.domain.Order;

public class InMemoryOrderService implements OrderService {
    
    private List<Order> orders;
    
    public InMemoryOrderService(){
        orders = new ArrayList<Order>();
    }

    public void doOrder(Order order) {
        orders.add(order);

    }

    public List<Order> getAllOrders() {
        return orders;
    }

}

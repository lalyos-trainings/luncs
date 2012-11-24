package com.epam.training.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.domain.Order;

public class InMemoryOrderService implements OrderService {

    List<Order> list = new ArrayList<Order>();
    
    public void doOrder(Order o) {
        list.add(o);
    }

    public List<Order> getAllOrders() {
        return list;
    }

    
    
    
}

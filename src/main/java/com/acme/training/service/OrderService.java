package com.acme.training.service;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class OrderService {
    
    private LinkedList<Order> orders;
    
    public OrderService() {
        orders = new LinkedList<Order>();
    }
    
    public void doOrder(Order order){
        orders.add(order);
    };
    
    public LinkedList<Order> getAllOrders(){
        return orders;
    };
}

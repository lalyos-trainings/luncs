package com.acme.training.service;

import java.util.LinkedList;

import com.acme.training.domain.Order;

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

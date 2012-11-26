package com.acme.service;

import java.util.ArrayList;
import java.util.Collection;

import com.acme.domain.Order;

public class InMemoryOrderService implements OrderService {
   
    private ArrayList<Order> orders = new ArrayList<Order>();
    
    
    public InMemoryOrderService(){
    }
    
    public void doOrder(Order order){
        orders.add(order);
    }

    public Collection<Order> getAllOrders() {
        return orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

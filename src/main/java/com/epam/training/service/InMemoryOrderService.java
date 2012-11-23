package com.epam.training.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.domain.Order;

public class InMemoryOrderService implements OrderService 
{
    private List<Order> orders;
    
    public InMemoryOrderService() 
    {
        orders = new ArrayList<Order>();
    }

    public void doOrder(Order order) 
    {
        orders.add(order);
        
        // TODO
        
    }

    public List<Order> getAllOrders() 
    {
        return orders;
    }
    
}

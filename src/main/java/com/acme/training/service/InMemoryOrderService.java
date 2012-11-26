package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService 
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryOrderService.class);
    
    private List<Order> orders;
    
    public InMemoryOrderService() 
    {
        orders = new ArrayList<Order>();
    }

    public void doOrder(Order order) 
    {
        orders.add(order);
        
        logger.info("order placed");
    }

    public List<Order> getAllOrders() 
    {
        return orders;
    }
}

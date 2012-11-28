package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class InMemoryOrderService implements OrderService 
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryOrderService.class);
    
    private List<CustomerOrder> orders;
    
    @Autowired
    private ApplicationContext context;
    
    
    public InMemoryOrderService() 
    {
        orders = new ArrayList<CustomerOrder>();
    }

    public void doOrder(CustomerOrder order) 
    {
        orders.add(order);

        context.publishEvent(new OrderEvent(this, order));
    }

    public List<CustomerOrder> getAllOrders() 
    {
        return orders;
    }
}

package com.acme.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.domain.CustomerOrder;

@Component
public class InMemoryOrderService implements OrderService {
   
    private ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();
    @Autowired
    private ApplicationContext context;
    
    public InMemoryOrderService(){
    }
    
    public void doOrder(CustomerOrder order){
        orders.add(order);
        OrderEvent event = new OrderEvent(this, order);
        context.publishEvent(event);
                
    }

    public Collection<CustomerOrder> getAllOrders() {
        return orders;
    }

    public ArrayList<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<CustomerOrder> orders) {
        this.orders = orders;
    }
}

package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class OrderService {
    
    private Map<Integer, CustomerOrder> orders;
    @Autowired
    private ApplicationContext ctx;     //annotacioval ugynazt erjuk el, mint ha Aware lenne
    
    public OrderService() {
        orders = new HashMap<Integer, CustomerOrder>();
    }
    
    public void doOrder(CustomerOrder order){
        orders.put(order.getId(), order);
        ctx.publishEvent(new OrderEvent(this, order));
    };
    
    public Collection<CustomerOrder> getAllOrders(){
        return orders.values();
    };
}

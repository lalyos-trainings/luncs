package com.acme.training.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class OrderService {
    
    private LinkedList<Order> orders;
    @Autowired
    private ApplicationContext ctx;     //annotacioval ugynazt erjuk el, mint ha Aware lenne
    
    public OrderService() {
        orders = new LinkedList<Order>();
    }
    
    public void doOrder(Order order){
        orders.add(order);
        ctx.publishEvent(new OrderEvent(this, order));
    };
    
    public LinkedList<Order> getAllOrders(){
        return orders;
    };
}

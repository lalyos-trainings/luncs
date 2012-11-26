package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import com.acme.training.domain.Order;

public class InMemoryOrderService implements OrderService {
    private List<Order> orderList;
    
    public InMemoryOrderService (){
        orderList = new ArrayList<Order>();
        
    }

    public void doOrder(Order o) {
       orderList.add(o);
        
    }

    public List<Order> getAllOrders() {
          return orderList;
    }

}

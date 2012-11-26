package com.acme.training.service;

import java.util.List;

public interface OrderService {
    
    public void doOrder(Order order);
    
    public List<Order> getAllOrders();

}

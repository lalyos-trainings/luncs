package com.epam.training.service;

public interface OrderService {

    void doOrder ( Order o );
    
    List<Order> getAllOrders();
    
}

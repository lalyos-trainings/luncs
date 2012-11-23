package com.epam.training.service;

import java.util.List;

import com.epam.training.domain.Order;

public interface OrderService {
    
    
       public abstract void doOrder(Order o);
       
       public abstract List<Order> getAllOrders();

}
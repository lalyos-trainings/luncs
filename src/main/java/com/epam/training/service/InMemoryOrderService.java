package com.epam.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.epam.training.domain.Order;

public class InMemoryOrderService implements OrderService {

    Map<String, Order> orders = new HashMap<String, Order>();
    
    /* (non-Javadoc)
     * @see com.epam.training.service.OrderService#doOrder(com.epam.training.service.Order)
     */
    public void doOrder(Order order) {
        orders.put(order.getId(), order);
    }
    
    /* (non-Javadoc)
     * @see com.epam.training.service.OrderService#getAllOrder()
     */
    public Collection<Order> getAllOrder() {
        return orders.values();
    }
    
    /* (non-Javadoc)
     * @see com.epam.training.service.OrderService#findById(java.lang.String)
     */
    public Order findById(String id) {
        return orders.get(id);
    }
}

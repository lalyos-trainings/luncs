package com.acme.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService {

    private List<Order> orders = new ArrayList<Order>();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.epam.training.service.OrderService#doOrder(com.epam.training.domain
     * .Order)
     */
    public void doOrder(Order o) {
        orders.add(o);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.epam.training.service.OrderService#getAllOrders()
     */
    public List<Order> getAllOrders() {
        return orders;
    }

}

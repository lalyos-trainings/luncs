package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class InMemoryOrderService implements OrderService {

    Logger logger = LoggerFactory.getLogger(InMemoryOrderService.class);
    Map<String, CustomerOrder> customerOrders = new HashMap<String, CustomerOrder>();
    @Autowired
    private ApplicationContext context;

    public void doOrder(CustomerOrder customerOrder) {
        logger.info("new Order for:" + customerOrder.getCustomer());
        customerOrders.put(customerOrder.getId(), customerOrder);
        logger.info("# of order:" + customerOrders.keySet().size());
        OrderEvent event = new OrderEvent(this, customerOrder);
        context.publishEvent(event);
    }

    public Collection<CustomerOrder> getAllOrder() {
        return customerOrders.values();
    }

    public CustomerOrder findById(String id) {
        return customerOrders.get(id);
    }
}

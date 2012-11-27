package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.ordermodel.CustomerOrder;

@Component("InMemoryOrderService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryOrderService implements OrderService {

    Map<String, CustomerOrder> custOrders = new HashMap<String, CustomerOrder>();
    @Autowired
    private ApplicationContext context;
    
    public void doOrder(CustomerOrder custOrder) {
        custOrders.put(custOrder.getId(), custOrder);
        OrderEvent event = new OrderEvent(this, custOrder);
        context.publishEvent(event);
    }
    
    public Collection<CustomerOrder> getAllOrder() {
        return custOrders.values();
    }
    
    public CustomerOrder findById(String id) {
        
        return custOrders.get(id);
    }
}

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
import com.acme.training.domain.Order;

@Component
public class InMemoryOrderService implements OrderService {

    Logger logger = LoggerFactory.getLogger(InMemoryOrderService.class);
    Map<Integer, CustomerOrder> orders = new HashMap<Integer, CustomerOrder>();
    Map<Integer,ShoppingCart> carts = new HashMap<Integer, ShoppingCart>();            
    @Autowired
    private ApplicationContext context;
    
    public void doOrder(CustomerOrder customerOrder) {
        logger.info("new Order for:" + customerOrder.getCustomer());
        orders.put(customerOrder.getId(), customerOrder);
        logger.info("# of order:" + orders.keySet().size());
        OrderEvent event = new OrderEvent(this, customerOrder);
        context.publishEvent(event);
        customerOrder.printBill();
    }
    
    public Collection<CustomerOrder> getAllOrder() {
        return orders.values();
    }
    
    public CustomerOrder findById(String id) {
        return orders.get(id);
    }

    public int addNewShoppingCart(String customer) {
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.withCustomer(customer);
        carts.put(cart.id, cart);
        return cart.id;
    }

    public ShoppingCart getShoppingCartById(int scId) {
        
        return carts.get(scId);
        
    }

   
}

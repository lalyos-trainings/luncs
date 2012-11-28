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

	private static int SHOPPING_CART_ID = 0;
	
    Logger logger = LoggerFactory.getLogger(InMemoryOrderService.class);
    Map<String, CustomerOrder> customerOrders = new HashMap<String, CustomerOrder>();
    Map<Integer, ShoppingCart> shoppingCarts = new HashMap<Integer, ShoppingCart>();
    @Autowired
    private ApplicationContext context;
    
    public void doOrder(CustomerOrder order) {
        logger.info("new Order for:" + order.getCustomerName());
        customerOrders.put(order.getId(), order);
        logger.info("# of order:" + customerOrders.keySet().size());
        OrderEvent event = new OrderEvent(this, order);
        context.publishEvent(event);
    }
    
    public Collection<CustomerOrder> getAllOrder() {
        return customerOrders.values();
    }
    
    public CustomerOrder findById(String id) {
        return customerOrders.get(id);
    }

	public int addNewShoppingCart(String customer) {
		int id = ++SHOPPING_CART_ID;
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		
		shoppingCarts.put(id, cart);
		
		return id;
	}

	public ShoppingCart getShoppingCartById(Integer cartId) {
		return shoppingCarts.get(cartId);
	}
}

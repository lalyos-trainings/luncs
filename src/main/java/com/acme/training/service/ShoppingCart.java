package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Address;

public class ShoppingCart implements BeanNameAware {
    
    private Order order;
    private static Logger logger = LoggerFactory.getLogger(ShoppingCart.class);
    
    public ShoppingCart() {
        order = new Order();
    }
    
    public void addFood(int foodId, int count) {
        OrderItem item = new OrderItem(foodId, count);
        order.addOrderItem(item);
    }
    
    public void setCustomer(String customer) {
        order.setCustomer(customer);
    }
    
    public void setDeliveryAddress(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
    }
    
    public void setBillingAddress(Address billingAddress) {
        order.setBillingAddress(billingAddress);
    }
    
    public Order checkout() {
        return order;
    }

    
    public void setBeanName(String name) {
        logger.info("\n*******************\nshoppingcart: " + name + "\n*********************");
        // TODO Auto-generated method stub
        
    }
    
}

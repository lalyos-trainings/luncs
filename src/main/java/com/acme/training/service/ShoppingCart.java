package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;

@Component("kart") //ez a neve a beannek
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //prototype a scope

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

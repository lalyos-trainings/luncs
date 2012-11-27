package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;

@Component("kart") //ez a neve a beannek
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //prototype a scope

public class ShoppingCart implements BeanNameAware {
    
    private Order order;
    private static Logger logger = LoggerFactory.getLogger(ShoppingCart.class);
    
    /* tud menni by name es by type alapjan
     * nev alapjan: @Component("name") ahol a name a valtozo neve
     * tipus alapjan csak a valtozo tipusa szamit
     */
    @Autowired
    /*
     * qualifier: ha az autowire számára nem egyértelmű, hogy melyik példányt tegye be, akkor a qualifierrel meg tudjuk
     * mondani a kívánt bean nevét (valamiért mindkét helyre kell az qualifier)
     */
    @Qualifier("memoryRepository") 
    private RestaurantRepository repository;
    
    public void setRepository(@Qualifier("memoryRepository") RestaurantRepository repository) {
        this.repository = repository;
    }

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

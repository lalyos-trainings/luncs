package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;

//@Component("kart") //ez a neve a beannek
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //prototype a scope

//public class ShoppingCart implements BeanNameAware {
public class ShoppingCart {
    
    private CustomerOrder order;
    
    public CustomerOrder getOrder() {
        return order;
    }


    private static Logger logger = LoggerFactory.getLogger(ShoppingCart.class);
    
    boolean sent = false;
    
    /* tud menni by name es by type alapjan
     * nev alapjan: @Component("name") ahol a name a valtozo neve
     * tipus alapjan csak a valtozo tipusa szamit
     */
    @Autowired
    /*
     * qualifier: ha az autowire számára nem egyértelmű, hogy melyik példányt tegye be, akkor a qualifierrel meg tudjuk
     * mondani a kívánt bean nevét (itt: *NEM A SETTEREN KERESZTÜL ADJA ÁT*)
     */
//    @Qualifier("memoryRepository") 
    
    
    
    /*
     * most: aliassal hivatkozunk, az alias az xml-ben van összedugva a fenti névvel
     */
//    @Qualifier("repository") 
 //   private RestaurantRepository repository;
    
//    public void setRepository(@Qualifier("memoryRepository") RestaurantRepository repository) {
    
    
   /* public void setRepository(@Qualifier("repository") RestaurantRepository repository) {
        this.repository = repository;
    }*/
    
    public void init() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        order = new CustomerOrder();
    }
    
/*    public ShoppingCart() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }*/
    
    public void addFood(Food food, int count) {
        OrderItem item = new OrderItem(food, count);
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
    
    public CustomerOrder checkout() {
        try {
            if ( sent ) throw new RuntimeException("order already sent");
            return order; 
        } finally {
            sent = true;
        }
    }

    
/*    public void setBeanName(String name) {
        logger.info("\n*******************\nshoppingcart: " + name + "\n*********************");
        // TODO Auto-generated method stub
        
    }*/
    
}

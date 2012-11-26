package com.acme.training.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;

public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {

    private RestaurantRepository repo;
    private Order order;
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    private Locale locale;
    
    private InMemoryShoppingCart(){
        order = new Order();
    }
    
    public static ShoppingCart getShoppingCart(){
        return new InMemoryShoppingCart();
    }
    
    public void setRepo(RestaurantRepository repo){
        this.repo = repo;
    }
    
//    public void addFood(String restiName, String foodName, int count){
//        Food food = repo.findFoodById(restiName, foodName);
//        order.addOrderItem(new OrderItem(count, food));
//    }
//    
    public ShoppingCart withFood(String foodName, int count){
        Food food = repo.findFoodById(foodName);
        order.addOrderItem(food, count);
        return this;
    }
    
    public ShoppingCart withCustomer(String name){
        order.setCustomer(name);
        return this;
    }
    
    public ShoppingCart withDeliveryAddress(Address address){
        order.setDeliveryAddress(address);
        return this;
    }
    
    public ShoppingCart withBillingAddress(Address address){
        order.setBillingAddress(address);
        return this;
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        order.setLocale(locale);
    }

    public Order checkOut(){
        return order;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninMemoryShoppingCart: {}\n*************************", name);
    }
    
}

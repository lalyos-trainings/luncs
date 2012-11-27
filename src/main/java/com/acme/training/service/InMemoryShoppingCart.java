package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;

@Component
@Scope("prototype")
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {

    @Autowired
//    @Qualifier("memoryRest")
    private RestaurantRepository repo;
    private Order order;
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    
    private InMemoryShoppingCart(){
        order = new Order();
    }
    
    public static ShoppingCart getShoppingCart(){
        return new InMemoryShoppingCart();
    }
    
    private void setRepo(RestaurantRepository repo){
        this.repo = repo;
    }
    
    public RestaurantRepository getRepo(){
        return repo;
    }
    
//    public void addFood(String restiName, String foodName, int count){
//        Food food = repo.findFoodById(restiName, foodName);
//        order.addOrderItem(new OrderItem(count, food));
//    }
//    
    public ShoppingCart withFood(String foodName, int count){
        Food food = repo.findFoodByName(foodName);
        if (food != null) {
            order.addOrderItem(food, count);
        }
        return this;
    }
    
    public ShoppingCart withFood(int foodId, int count){
        Food food = repo.findFoodById(foodId);
        if (food != null) {
            order.addOrderItem(food, count);
        }
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
    
    public Order checkOut(){
        return order;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninMemoryShoppingCart: {}\n*************************", name);
    }
    
}

package com.acme.training.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.CustomerOrder;

@Component
@Scope("prototype")
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {

    @Autowired
    private RestaurantRepository repo;
    private CustomerOrder order;
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    @Autowired
    private OrderService orderService;
    private int id;
    
    private static AtomicInteger ID = new AtomicInteger(0);
    
    private InMemoryShoppingCart(){
        order = new CustomerOrder();
        id = ID.incrementAndGet();
    }
    
    public static ShoppingCart getShoppingCart(){
        return new InMemoryShoppingCart();
    }
 
    public RestaurantRepository getRepo(){
        return repo;
    }
    
    public ShoppingCart withFood(String restiName, String foodName, int count){
        Food food = repo.findFoodByRestiAndName(restiName, foodName);
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
    
    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public int getId() {
        return id;
    }

    public CustomerOrder checkOut(){
        orderService.doOrder(order);
        return order;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninMemoryShoppingCart: {}\n*************************", name);
    }
    
}

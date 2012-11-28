package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;

//@Component
//@Scope("prototype")
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {

    private RestaurantRepository repo;
    private CustomerOrder order;
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    private OrderService orderService;
    private int id;
    
    public InMemoryShoppingCart(int id, RestaurantRepository repo, OrderService orderService){
        order = new CustomerOrder();
        order.setId(id);
        this.id = id;
        this.repo = repo;
        this.orderService = orderService;
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
        System.out.println(order);
        return order;
    }

    public void setBeanName(String name) {
        logger.info("*************************\ninMemoryShoppingCart: {}\n*************************", name);
    }

    public CustomerOrder getOrder() {
        return order;
    }
    
}

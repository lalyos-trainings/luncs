package com.acme.training.service;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

public class InMemoryShoppingCart implements ShoppingCart {

    private RestaurantRepository repo;
    private Order order;
    
    public InMemoryShoppingCart(){
        order = new Order();
    }
    
    public void setRepo(RestaurantRepository repo){
        this.repo = repo;
    }
    
//    public void addFood(String restiName, String foodName, int count){
//        Food food = repo.findFoodById(restiName, foodName);
//        order.addOrderItem(new OrderItem(count, food));
//    }
//    
    public void addFood(String foodName, int count){
        Food food = repo.findFoodById(foodName);
        order.addOrderItem(new OrderItem(count, food));
    }
    
    public void setCustomer(String name){
        order.setCustomer(name);
    }
    
    public void setDeliveryAddress(Address address){
        order.setDeliveryAddress(address);
    }
    
    public void setBillingAddress(Address address){
        order.setBillingAddress(address);
    }
    
    public Order checkOut(){
        return order;
    }

}

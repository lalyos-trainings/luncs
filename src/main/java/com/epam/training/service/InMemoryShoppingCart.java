package com.epam.training.service;

import java.util.ArrayList;

import com.epam.training.domain.Address;
import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class InMemoryShoppingCart implements ShoppingCart {
    
    private Order order;
    private RestaurantRepository repo;
    
    public InMemoryShoppingCart(Order order, RestaurantRepository repo){
        this.order = order;
        this.repo = repo;
        this.order.setOrderItems(new ArrayList<OrderItem>());
    }
    
    public void addFood(int foodId, int quantity){
        OrderItem orderItem = new OrderItem();        
        orderItem.setFood(this.repo.getFoodbyId(foodId) );
        orderItem.setQuantity(quantity);
        order.getOrderItems().add(orderItem);
    }
    
   
    public void setCustomer(String customer){
        order.setCustomer(customer);
    }
    
    
    public void setDeliveryAddress(Address address){
        order.setDeliveryAddress(address);
    }
    
   
    public void setBillingAddress(Address address){
        order.setBillingAddress(address);
    }

    public void checkout() {
        OrderService orderService = new InMemoryOrderService();        
        orderService.doOrder(order);        
    }
    
 
    
}

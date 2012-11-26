package com.acme.training.service;

import java.util.List;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

public class ShoppingCart {
    
    private Order order;
    private RestaurantRepository repo;
    
    public ShoppingCart(){
        order = new Order();
        
    }
    
    public void setRepo(RestaurantRepository repo){
        this.repo=repo;
    }
    
    public void setCustomer (String customer){
        order.setCustomer(customer);
    }
    
    public void setBillingAddress (Address addr){
        order.setBillingAddr(addr);
        
    }
    
    public void setDeliveryAddress (Address addr){
        order.setDeliveryAddr(addr);
        
    }
    public Order getOrder(){return this.order;}
   
    
    public void checkout(OrderService orderService){
        orderService.doOrder(order);
    }
    
    
    public void addFood(int foodId, int quantity){
            order.getItemList().add(new OrderItem(repo.getFoodById(foodId),quantity));
                
            }
            
        
            
    }


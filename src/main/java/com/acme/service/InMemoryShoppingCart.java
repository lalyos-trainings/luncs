package com.acme.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.domain.Address;
import com.acme.domain.Order;
import com.acme.domain.OrderItem;

public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware {
    
    private Order order;
    private RestaurantRepository repo;
    private OrderService orderService;
    private Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    
   
    
    public InMemoryShoppingCart(){
        this.order = new Order();
        this.repo = new InMemoryRestaurantRepository();
    }

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
        orderService.doOrder(order);
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setBeanName(String arg0) {
        logger.info("shopping carts name:"+arg0+" hashcode:"+this.hashCode());
    }
    
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
 
    
}

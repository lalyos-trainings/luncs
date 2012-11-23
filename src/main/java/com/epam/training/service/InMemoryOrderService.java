package com.epam.training.service;

import java.util.ArrayList;
import java.util.Collection;

import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class InMemoryOrderService implements OrderService {
   
    private static InMemoryOrderService os=null;
    private ArrayList<Order> orders;
    
    
    public InMemoryOrderService(){
      //  os = new InMemoryOrderService();
    }
    
    public static InMemoryOrderService getInstance(){
        if (os == null){
            return new InMemoryOrderService();
        }
        return os;
    }
    
    public void doOrder(Order order){
        orders.add(order);
        System.out.println("your order has the foll. details:");
        System.out.println("customer = "+order.getCustomer());
        System.out.println("orderItems");
        for (OrderItem oi: order.getOrderItems()){
            System.out.println(String.format("Food %s, quantity %d",oi.getFood(),oi.getQuantity()));
        }
        
    }

    public Collection<Order> getAllOrders() {
        
        return orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

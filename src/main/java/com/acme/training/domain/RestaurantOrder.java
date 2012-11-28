package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;


public class RestaurantOrder {
    
    private Restaurant restaurant;
    private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();
    
    public RestaurantOrder() {
        
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }
    
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Collection<OrderItem> getOrderItems(){
        return orderItems;
    }
    
    public void addItem(OrderItem item){
        OrderItem sameOrder = checkForSameOrder(item); 
        if(sameOrder != null){
            sameOrder.addQuantity(item.getQuantity());
        } else {
            orderItems.add(item);
        }
    }

    private OrderItem checkForSameOrder(OrderItem item){
        OrderItem sameOrder = null;;
        for(OrderItem oi: orderItems){
            if(oi.getFood().equals(item.getFood())){
                sameOrder = oi;
            }
        }
        return sameOrder;
    }
    
    public int getTotal(){
        int total = 0;
        for (OrderItem item : orderItems) {
            total += item.getQuantity() * item.getFood().getPrice();
        }
        return total;
    }
    
    public void printBill(){
        System.out.println(String.format("+------------------------------------------------------------\n|      %s ",restaurant.getName()));
        System.out.println("+------------------------------------------------------------");
        for(OrderItem item: orderItems){
            System.out.println(String.format("|          %s: %2d db [%5d] HUF",item.getFood().getName(), item.getQuantity(), item.getFood().getPrice()));
        }
        System.out.println("+------------------------------------------------------------");
        System.out.println(String.format("|\n|      Total: %d HUF \n|",getTotal()));
    }
    
}

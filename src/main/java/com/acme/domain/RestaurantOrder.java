package com.acme.domain;

import java.util.ArrayList;
import java.util.Collection;

public class RestaurantOrder {
    private Restaurant restaurant;
    private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();
    private int total=0;
    
    public RestaurantOrder(Restaurant restaurant){
        this.restaurant = restaurant;
    }    
    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }
    
    public int getTotal(){
        total=0;
        for (OrderItem item: orderItems){
            int price = item.getFood().getPrice();
            int quantity = item.getQuantity();
            total +=price*quantity;
        }
        return total;
    }
    
    public void printBill(){
        System.out.println("====Restaurant "+ restaurant.getName() +"====");
        for (OrderItem item : orderItems) {
            Food food= item.getFood();
            int price = food.getPrice();
            int quantity = item.getQuantity();
            
            System.out.println(String.format("Food: %s quantity: %d price %d HUF",food.getName(),quantity, price));
        }
        
        System.out.println("Restaurant subtotal:"+getTotal());
        System.out.println("===================");
    }
}

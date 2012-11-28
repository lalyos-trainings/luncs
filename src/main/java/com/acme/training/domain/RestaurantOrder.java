package com.acme.training.domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class RestaurantOrder {

    Restaurant restaurant;    
    List<OrderItem> orderItems;
      
    public RestaurantOrder(){
        orderItems = new LinkedList<OrderItem>();
    }
    
    public Collection<OrderItem> getOrderItems(){
        return orderItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    public void addOrderItem(int quantity, Food food) {
        OrderItem foundOrderItem = findOrderItem(food.getId());
        if(foundOrderItem != null){
            foundOrderItem.addQuantity(quantity);
        }
        else
            orderItems.add(new OrderItem(quantity, food));
    }
    
    public int getTotal(){
        int totalPrice = 0;
        for(int i=0; i<orderItems.size(); i++){
            totalPrice += orderItems.get(i).getTotal();
        }
        return totalPrice;
    }
    
    private OrderItem findOrderItem(int foodId){
        for (OrderItem orderItem : orderItems) {
            if(orderItem.getFood().getId() == foodId){
                return orderItem;
            }
        }
        return null;
    }
    
    void printBill(){
        System.out.println("================BILL==================");
        System.out.println("====Restaurant: " + restaurant.getName() + "====");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getFood() + "  " + orderItem.getQuantity() + "        " + orderItem.getTotal());
        }
        System.out.println("TOTAL:  " + getTotal());
        System.out.println("======================================");
       
    }
    
}

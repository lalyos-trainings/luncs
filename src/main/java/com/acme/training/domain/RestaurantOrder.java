package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestaurantOrder {




    
    
    private Restaurant restaurant;
    private Map<Integer, OrderItem> itemMap = new HashMap<Integer, OrderItem>(); 
    
    public RestaurantOrder (Restaurant restaurant){
        this.restaurant = restaurant;
    }
    
    
    public Restaurant getRestaurant() {
        return restaurant;
    }
  
    public void addItem(OrderItem item) {
        Food food = item.getFood();
        int quantity = item.getQuantity();
        OrderItem previousItem = itemMap.get(food.getId());
        if (null == previousItem) {
            itemMap.put(food.getId(), item);
        } else {
            previousItem.addQuantity(quantity);
        }         
    }
    public Collection<OrderItem> getItems() {
        Collection<OrderItem> ret = new ArrayList<OrderItem>(itemMap.values());
        return ret;
    }
    
    public int getTotal() { 
        int total = 0;
        for (OrderItem item :itemMap.values()){
              total+=item.getTotal();
            
        }
        return total;
    }
    

    public void printBill(){
            System.out.println("========= " + getRestaurant().getName() + " bill:  =============");
                    
            for (OrderItem item : itemMap.values()) {
                System.out.println(String.format("%n   %-25s [%s HUF] : %3d db  %10d HUF", item.getFood().getName(),item.getFood().getPrice(), item.getQuantity(), item.getQuantity()*item.getFood().getPrice()));
            }
            System.out.println(String.format("%n Összesen : %48d HUF", getTotal()));                        
            System.out.println();
    }
}
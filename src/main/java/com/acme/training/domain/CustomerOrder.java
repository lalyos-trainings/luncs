package com.acme.training.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerOrder {

    
    private static int nextId = 0;
    
    private String id = String.valueOf(nextId++);
    
    private String customer;
    private Address deliveryAddress;
    private Collection<RestaurantOrder> restaurantOrders = new ArrayList<RestaurantOrder>();
    
    public CustomerOrder() {}
    
    
    public String getCustomer() {
        return customer;
    }


    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public Address getDeliveryAddress() {
        return deliveryAddress;
    }


    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public int getTotal() {
        int total = 0;
        for(RestaurantOrder restOrd: restaurantOrders){
            total += restOrd.getTotal();
        }
        return total;
    }

    public String getId() {
        return id;
    }
    
    
    public void addItem(OrderItem item){
        RestaurantOrder restaurantOrder = getRestaurantOrderByName(item.getFood().getRestaurant().getName());
        if(restaurantOrder == null){
            restaurantOrder = new RestaurantOrder();
            restaurantOrder.addItem(item);
            restaurantOrder.setRestaurant(item.getFood().getRestaurant());
            restaurantOrders.add(restaurantOrder);
        } else {
            restaurantOrder.addItem(item);
        }
    }
    
    private RestaurantOrder getRestaurantOrderByName(String name){
        RestaurantOrder restaurantOrder = null;
        for(RestaurantOrder ro: restaurantOrders){
            if(ro.getRestaurant().getName().equals(name)){
                restaurantOrder = ro;
                break;
            }
        }
        return restaurantOrder;
    }

    public Collection<RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }

    public List<OrderItem> getItems() {
        List<OrderItem> ret = new ArrayList<OrderItem>();
        for(RestaurantOrder restOrd: restaurantOrders){
            ret.addAll(restOrd.getOrderItems());
        }
        return ret;
    }
    
    public void printBill(){
        System.out.println("*************************************************************");
        System.out.println("|    Customer: " + customer);
        System.out.println("|    Delivery Address: " + deliveryAddress);
        System.out.println("|    Orders by Restaurants: ");
        for(RestaurantOrder ro: restaurantOrders){
            ro.printBill();
        }
        System.out.println("*------------------------------------------------------------");
        System.out.println("|Total Price for the order:" + getTotal() + " HUF");
        System.out.println("*************************************************************\n");
    }
}

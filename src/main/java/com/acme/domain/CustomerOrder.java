package com.acme.domain;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerOrder {

    private int id;
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Collection<RestaurantOrder> restaurantOrders = new ArrayList<RestaurantOrder>();
    private double total=0;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public Collection<RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }
    
    public void addRestaurantOrder(RestaurantOrder restaurantOrder){
        restaurantOrders.add(restaurantOrder);
    }
    
    public double getTotal(){
        total = 0;
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            total += restaurantOrder.getTotal();
        }        
        return total;
    }
        
    public void printBill(){
        System.out.println("\n");
        System.out.println("=====Bill====");
        System.out.println("Customer:"+customer);
        System.out.println("Billing address:"+billingAddress);
        System.out.println("Delivery address:"+deliveryAddress);
        
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            restaurantOrder.printBill();
        }
        System.out.println("====TOTAL:"+getTotal()+"====");
    }
}

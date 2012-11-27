package com.acme.training.ordermodel;

import java.util.Collection;

import com.acme.training.domain.Address;

@SuppressWarnings("unused")
public class CustomerOrder {
    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    
    public String getCustomer(){
        
        return customer;
    }
    
    public Collection<RestaurantOrder> getRestaurantOrders(){
        
        
        
        return null;  
    }

    public int getTotal(){
        
        return 0;
    }
    
    public void printBill(){
        
        
    }
}

package com.acme.training.domain;

import java.util.List;

import com.acme.training.domain.Address;

public class Order {

    private String customerName;
    private Address billingAddress;
    private Address deliveryAddress;
    private List<OrderItem> list;
    
    public Order ( String customerName, Address billingAddress, Address deliveryAddress,  List<OrderItem> list ) {
       this.customerName=customerName; 
       this.billingAddress=billingAddress;
       this.deliveryAddress=deliveryAddress;
       this.list=list;
    }
    
    public String toString () {
        
        return String.format(" %s %n %s %n %s %n %s", customerName, billingAddress, deliveryAddress, list);
    }
    
    
}

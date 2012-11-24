package com.epam.training.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.domain.Address;
import com.epam.training.domain.Order;
import com.epam.training.domain.OrderItem;

public class ShoppingCart {

    private String customerName;
    private Address billingAddress;
    private Address deliveryAddress;
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }


    List<OrderItem> list = new ArrayList<OrderItem>();
    
    public void addFood ( int foodId, int quant ) {
        
       OrderItem temp = new OrderItem(foodId, quant);
       list.add(temp); 
    }  
    
    public Order checkout () {
        
        Order order = new Order(customerName, billingAddress, deliveryAddress, list);
        return order;
        
    }
    
}
    
    

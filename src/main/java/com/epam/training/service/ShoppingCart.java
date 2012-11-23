package com.epam.training.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
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

    List<OrderItem> list = new ArrayList<OrderItem>();
    
    void addFood ( int foodId, int quant ) {
        
       OrderItem temp = new OrderItem(foodId, quant);
       list.add(temp); 
    }  
    
    
}
    
    

package com.acme.training.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customer;
    private Address billingAddr;
    private Address deliveryAddr;
    private List<OrderItem> itemList;
    
    public Order(){
        itemList = new ArrayList<OrderItem>();
        
    };
    
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public Address getBillingAddr() {
        return billingAddr;
    }
    public void setBillingAddr(Address billingAddr) {
        this.billingAddr = billingAddr;
    }
    public Address getDeliveryAddr() {
        return deliveryAddr;
    }
    public void setDeliveryAddr(Address deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }
    public List<OrderItem> getItemList() {
        return itemList;
    }
    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
    
    public String toString(){
        
        return customer + ", " + deliveryAddr.toString(); 
    }
    
    
}

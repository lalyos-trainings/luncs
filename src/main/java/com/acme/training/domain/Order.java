package com.acme.training.domain;

import java.util.HashMap;
import java.util.Map;


public class Order{

    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<Integer, OrderItem> orderItems;
    private double total;

    public Order(String customer, Address billingAddress, Address deliveryAddress) {
        super();
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.orderItems = new HashMap<Integer, OrderItem>();
        total = 0;
    }

    public Order() {
        super();
        orderItems = new HashMap<Integer, OrderItem>();
        total = 0;
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
    
    public Map<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void addOrderItem(Food food, int quantity){
        OrderItem tmp = orderItems.get(food.getId());
        if(tmp == null){
            orderItems.put(food.getId(), new OrderItem(quantity, food));
        }
        else{
            tmp.addQuantity(quantity);
        }
        total += (quantity * food.getPrice());
    }
    
    public double countTotal(){
        double total = 0;
        for(OrderItem item: orderItems.values()){
            total += (item.getQuantity() * item.getFood().getPrice());
        }
        return total;
    }
    
    public double getTotal() {
        return total;
    }

//    public Collection<RestaurantBill> getRestaurantBills(){
//        return null;
//    }

    @Override
    public String toString() {
//        String orderMessage = applicationContext.getMessage("orderFormat", null, locale);
//        String formattedOrder = String
//                .format(orderMessage,
//                        customer, deliveryAddress, billingAddress, orderItems);
        StringBuilder oi = new StringBuilder();
        for(OrderItem item : orderItems.values()){
            oi.append(item);
            oi.append("\n");
        }
        String formattedOrder = String
                .format("%s's order\n---------------------------------\nDelivery address:\t%s\nBilling address:\t%s\nOrder items:\n%s\n----------------\nTotal: %.2f",
                        customer, deliveryAddress, billingAddress, oi.toString(), total);
        return formattedOrder;
    }

}

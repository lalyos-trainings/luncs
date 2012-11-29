package com.acme.training.domain;
import java.util.ArrayList;
import java.util.Collection;


public class CustomerOrder {
    
    private static int nextId = 0;
    
    private Integer id = nextId++;
    private String customer;
    private Address deliveryAddress;
    private Address billingAddress;
    private Collection<RestaurantOrder> restaurantOrders;
    
    /*@Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress
                + "]" + getFormattedItems();
    }
    private String getFormattedItems() {
        StringBuffer ret = new StringBuffer();
        for (OrderItem item : itemMap.values()) {
            ret.append(String.format("%n   %-25s : %3d", item.getFood().getName(), item.getQuantity()));
        }
        return ret.toString();
    }*/
    
    public CustomerOrder (){
        
        this.restaurantOrders = new ArrayList<RestaurantOrder>();
    }
    
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public void addRestaurantOrder(RestaurantOrder restaurantOrder) {
        restaurantOrders.add(restaurantOrder);
                
    }
    
    public static int getNextId() {
        return nextId;
        
    }
    public Collection<RestaurantOrder> getRestaurantOrders() {
        return restaurantOrders;
    }
    
   
    public int getTotal() { 
        int total = 0;
        for (RestaurantOrder restaurantOrder :restaurantOrders){
                total += restaurantOrder.getTotal();
                }
          
        return total;
    }
    
    
    public void printBill(){
        System.out.println("Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress + "]");
        for (RestaurantOrder restaurantOrder : restaurantOrders) {if(restaurantOrder == null){System.out.println("=====üres rest orders========");}
                  restaurantOrder.printBill();
        }
    }
        
    public void addItem(OrderItem orderItem) {
        RestaurantOrder rO = null;
               // if(restaurantOrders.isEmpty()){restaurantOrders.add(new RestaurantOrder(orderItem.getFood().getRestaurant()));}
              //  if(restaurantOrders.contains(new RestaurantOrder(orderItem.getFood().getRestaurant()))){restaurantOrders.add(new RestaurantOrder(orderItem.getFood().getRestaurant()));}
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            if(restaurantOrder.getRestaurant().getName().equals(orderItem.getFood().getRestaurant().getName())){
                //restaurantOrder.addItem(orderItem);
                rO = restaurantOrder;
            }
        }
        
        if(rO == null){
                rO = new RestaurantOrder(orderItem.getFood().getRestaurant());
                restaurantOrders.add(rO);
        }
        
        rO.addItem(orderItem);
    }
  }

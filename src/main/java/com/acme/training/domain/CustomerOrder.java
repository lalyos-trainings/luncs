package com.acme.training.domain;
import java.util.ArrayList;
import java.util.Collection;


public class CustomerOrder {
    
    private static int nextId = 0;
    
    private Integer id = nextId++;
    private Customer customer;
    private Collection<RestaurantOrder> restaurantOrders;
     
    public CustomerOrder (){
        this.customer = new Customer();
        this.restaurantOrders = new ArrayList<RestaurantOrder>();
    }
    
   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        System.out.println("Order [id=" + id + ", customer=" + customer + ", deliveryAddress=" + customer.getDeliveryAddress() + "]");
        for (RestaurantOrder restaurantOrder : restaurantOrders) {if(restaurantOrder == null){System.out.println("=====üres rest orders========");}
                  restaurantOrder.printBill();
        }
    }
        
    public void addItem(OrderItem orderItem) {
        RestaurantOrder rO = null;
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            if(restaurantOrder.getRestaurant().getName().equals(orderItem.getFood().getRestaurant().getName())){
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

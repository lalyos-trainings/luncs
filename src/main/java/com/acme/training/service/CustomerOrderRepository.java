package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class CustomerOrderRepository {

    Map< Integer, CustomerOrder > customerOrders = new HashMap< Integer, CustomerOrder>();

    
    public CustomerOrderRepository() {
        
    }
    
    // start a new order
    public int addCustomerOrder( String customerName, String street, String city, String zip, String country){
        CustomerOrder customerOrder = new CustomerOrder(customerName, street, city, zip, country);
        customerOrders.put( customerOrder.getId(), customerOrder );
        return customerOrder.getId();
    }
    
    
    public CustomerOrder getCustomerOrderById( Integer id ){
        return customerOrders.get( id );
    }
    
    public Map<Integer, CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Map<Integer, CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public int getCustomerOrderIdByName( String name ){
        return customerOrders.get( name ).getId();
    }
    
    
}

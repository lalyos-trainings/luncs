package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Restaurant;

@Component
public class CustomerOrderRepository {

    // id, CustomerOrder
    Map< Integer, CustomerOrder > customerOrders = new HashMap< Integer, CustomerOrder>();
    // name, CustomerOrder
    Map< String, CustomerOrder > customerOrdersByName = new HashMap< String, CustomerOrder>();

    public CustomerOrderRepository() {
        
    }
    
    // start a new order and return with id
    public int addCustomerOrder( String customerName, String street, String city, String zip, String country){
        CustomerOrder customerOrder = new CustomerOrder(customerName, street, city, zip, country);
        customerOrders.put( customerOrder.getId(), customerOrder );
        customerOrdersByName.put( customerName, customerOrder );
        return customerOrder.getId();
    }
    
    public int addCustomerOrder( String customerName ){
        CustomerOrder customerOrder = new CustomerOrder(customerName);
        customerOrders.put( customerOrder.getId(), customerOrder );
        customerOrdersByName.put( customerName, customerOrder );
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

    public Integer getCustomerOrderIdByName( String name ){
        CustomerOrder co = customerOrdersByName.get( name );
        if ( co != null ){
            return co.getId();
        }else{
            return null;
        }
    }
    
    public String getAllCustomerName(){
        String names = "";
        for ( CustomerOrder co : customerOrders.values() ){
            names += ", " + co.getCustomer().getName();
        }
        return names;
    }
}

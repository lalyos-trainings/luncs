package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class CustomerOrderService {
    
    private Logger logger = LoggerFactory.getLogger( CustomerOrderService.class ); 

    // id, CustomerOrder
    Map< Integer, CustomerOrder > customerOrders = new HashMap< Integer, CustomerOrder>();

    // temporary shopping cart
    Map< Integer, CustomerOrder > carts = new HashMap< Integer, CustomerOrder>();
    
    // name, CustomerOrder
    Map< String, CustomerOrder > shoppingCartMapByName = new HashMap< String, CustomerOrder>();

    public CustomerOrderService() {
        
    }

    
    public int addToShoppingCart( int scId, CustomerOrder co){
        logger.info("addToShoppingCart");
        carts.put( scId, co );
        return co.getId();
    }
    
    public CustomerOrder getShoppingCartById( Integer scId ){
        CustomerOrder co = carts.get( scId );
        return co;
    }


    public Integer getShoppingCartByName( String name ){
     
        CustomerOrder co = shoppingCartMapByName.get( name );
        if ( co != null ){
            return co.getId();
        }else{
            return null;
        }
    }
    

    public int addNewShoppingCart( String customerName ){
      logger.info("addNewShoppingCart");
      CustomerOrder customerOrder = new CustomerOrder(customerName);
      carts.put( customerOrder.getId(), customerOrder );
      shoppingCartMapByName.put( customerName, customerOrder );
      return customerOrder.getId();
    }

    public void checkout( Integer scId ){
        logger.info("checkout");
        CustomerOrder sc = getShoppingCartById( scId );
        addCustomerOrder(sc);
    }
    
    // --------- Customer Order 

    
    
    // 
    public int addCustomerOrder( CustomerOrder co ){
        shoppingCartMapByName.put( co.getCustomer().getName() , co );
        return co.getId();
    }
//    
//    // start a new order and return with id
//    public int addCustomerOrder( String customerName, String street, String city, String zip, String country){
//        CustomerOrder customerOrder = new CustomerOrder(customerName, street, city, zip, country);
//        customerOrders.put( customerOrder.getId(), customerOrder );
//        shoppingCartMapByName.put( customerName, customerOrder );
//        return customerOrder.getId();
//    }
//    
//    public int addCustomerOrder( String customerName ){
//        CustomerOrder customerOrder = new CustomerOrder(customerName);
//        customerOrders.put( customerOrder.getId(), customerOrder );
//        shoppingCartMapByName.put( customerName, customerOrder );
//        return customerOrder.getId();
//    }
//    
//    public CustomerOrder getCustomerOrderById( Integer id ){
//        CustomerOrder co = customerOrders.get( id );
//        return co;
//    }
    
//    public Map<Integer, CustomerOrder> getCustomerOrders() {
//        return customerOrders;
//    }
//
//    public void setCustomerOrders(Map<Integer, CustomerOrder> customerOrders) {
//        this.customerOrders = customerOrders;
//    }


//    // for logging
//    public String getAllCustomerName(){
//        String names = "";
//        for ( CustomerOrder co : customerOrders.values() ){
//            names += ", " + co.getCustomer().getName();
//        }
//        return names;
//    }
}

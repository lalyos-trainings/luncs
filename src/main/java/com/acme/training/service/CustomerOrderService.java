package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.RestaurantOrder;

@Component
public class CustomerOrderService {
    
    private Logger logger = LoggerFactory.getLogger( CustomerOrderService.class ); 

    // id, CustomerOrder
    Map< Integer, CustomerOrder > customerOrders = new HashMap< Integer, CustomerOrder>();

    // temporary shopping cart
    Map< Integer, CustomerOrder > carts = new HashMap< Integer, CustomerOrder>();
    
    // name, CustomerOrder
    Map< String, CustomerOrder > shoppingCartMapByName = new HashMap< String, CustomerOrder>();

    @Autowired
    private ApplicationContext ctx;
    
    
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
        callEvents( sc );
    }

    public int addCustomerOrder( CustomerOrder co ){
        shoppingCartMapByName.put( co.getCustomer().getName() , co );
        return co.getId();
    }

    
    private void callEvents( CustomerOrder co ){
        CustomerOrderEvent coEvent = new CustomerOrderEvent(this, co);
        ctx.publishEvent(coEvent);
        
        for( RestaurantOrder ro : co.getRestaurantOrders().values() ){
            RestaurantOrderEvent roEvent = new RestaurantOrderEvent(this, ro);
            ctx.publishEvent(roEvent);
        }
        
    }
    
}

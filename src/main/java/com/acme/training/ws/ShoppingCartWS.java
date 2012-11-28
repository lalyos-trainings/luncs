package com.acme.training.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.training.domain.Address;
import com.acme.training.domain.Customer;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.CustomerOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebService
@Component
public class ShoppingCartWS {

    private Logger logger = LoggerFactory.getLogger( ShoppingCartWS.class );
    
    // the "shopping carts" = "customer orders" will be stored here:
    @Autowired
    private CustomerOrderRepository custRepo;
  
    public ShoppingCartWS(){
    }
  
// INIT for testing:
//    public void init(){
//        int id = custRepo.addCustomerOrder( "Mancika", "Pek", "Debrecen", "1234", "Hungary");
//        
//        CustomerOrder co = custRepo.getCustomerOrderById(id);
//        System.out.println( "SHOPPINGCARTWS - " + co.getBillString() );
//    }
    
    
    /**
     * Returns with a shopping cart or generates a new one
     * @param customerName
     * @return
     */
    public Integer getShoppingCart( String customerName ){
        
        Integer coId = custRepo.getCustomerOrderIdByName( customerName );
        
        if ( coId == null ){
            logger.info( "Customer order not found by the name: " + customerName + " -> generate a new one" );
            logger.info( "Current customers:" + custRepo.getAllCustomerName() );
            coId = custRepo.addCustomerOrder( customerName );
        }else{
            logger.info( "Customer order found by name: " + coId );
        }
        
        System.out.println( "********" + coId );
        
//        custRepo.addCustomerOrder(customerName, street, city, zip, country)
        return coId;
    }
    
    public String addFood( int scId, int foodId, int quantity){
        
        return "Food added";
    }
    
    public String setDeliveryAddress( int scId, String city, String street, String zip, String country ){
        Customer customer = new Customer();
        customer.setDeliveryAddress( new Address(street, city, zip, country) );
//        customerOrder.setCustomer(customer);
        return "The new delivery address:";
    }
    
    public int checkout(){
        // TODO : kell az order osszeallitasa, veglegesitese
        
        return 1;
    }
   
}
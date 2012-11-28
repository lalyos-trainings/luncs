package com.acme.training.ws;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Customer;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.CustomerOrderRepository;
import com.acme.training.service.WSFoodRepository;


@WebService
@Component
public class ShoppingCartWS {

    private Logger logger = LoggerFactory.getLogger( ShoppingCartWS.class );
    
    // the "shopping carts" = "customer orders" will be stored here:
    @Autowired
    private CustomerOrderRepository custRepo;
    
    // much simpler to work from a "foods" bean 
    @Autowired
    private WSFoodRepository foodRepo;
    
  
    public ShoppingCartWS(){
    }
  
    
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

        CustomerOrder co = custRepo.getCustomerOrderById( scId );
        if ( co != null ){
            logger.info( "addFood: Shopping cart (CustomerOrder) not found" );
            return "Shopping cart not found!";
        }else{
            co.addFood( foodRepo.getFoodById(foodId), quantity );
            logger.info( "addFood: " + quantity +"pcs food with ID " + foodId + " added to cart with ID " + scId );
            return "Food added";
        }
        
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
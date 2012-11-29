package com.acme.training.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Customer;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
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
    public Integer getShoppingCart( @WebParam(name="customerName") String customerName ){
        
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
    
    public String addFood( @WebParam(name="scId") int scId, @WebParam(name="foodId") int foodId,@WebParam(name="quantity") int quantity){

        CustomerOrder co = custRepo.getCustomerOrderById( scId );
        if ( co == null ){
            logger.info( "addFood: Shopping cart (CustomerOrder) not found" );
            return "Shopping cart not found!";
        }else{
            logger.info( "addFood: " + quantity +"pcs food with ID " + foodId + " added to cart with ID " + scId );
            try{
                Food food = foodRepo.getFoodById(foodId);
                logger.info( "addFood: Food found" );
                co.addFood( food, quantity );
                logger.info( "addFood: Food added succesfully" );
            }catch( Exception e){
                logger.info( "addFood: Food not found with id" );
                return "Food not found by ID";
            }
            return "Food added";
        }
        
    }
    
    public String setDeliveryAddress( @WebParam(name="scId") int scId, @WebParam(name="city") String city, @WebParam(name="street") String street, 
                @WebParam(name="zip") String zip, @WebParam(name="country") String country ){
        Customer customer = new Customer();
        customer.setDeliveryAddress( new Address(street, city, zip, country) );
//        customerOrder.setCustomer(customer);
        return "The new delivery address:";
    }
    
    public int checkout( Integer scId ){
        
        return 0;
        
    }
   

    public String getBill( Integer scId ){
        String billString = "";
        try{
            billString = custRepo.getCustomerOrderById(scId).getBillString();
        }catch(Exception e){
            billString = "Shopping cart not found - you don't have to pay"; 
        }
        
        return billString;
    }
    
    
}
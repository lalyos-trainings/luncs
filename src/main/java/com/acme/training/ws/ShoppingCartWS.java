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
import com.acme.training.service.CustomerOrderService;
import com.acme.training.service.WSFoodRepository;


@WebService
@Component
public class ShoppingCartWS {

    private Logger logger = LoggerFactory.getLogger( ShoppingCartWS.class );
    
    // the "shopping carts" = "customer orders" will be stored here:
    @Autowired
    private CustomerOrderService custService;
    
    // it's much simplier to work from a standalone "foods" bean 
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
        
        Integer scId = custService.getShoppingCartByName( customerName );
        
        if ( scId == null ){
            logger.info( "shopping cart not found by the name: " + customerName + " -> generate a new one" );
//            logger.info( "Current customers:" + custService.getAllCustomerName() );
            scId = custService.addNewShoppingCart( customerName );
        }else{
            logger.info( "Customer order found by name: " + scId );
        }
        
        System.out.println( "********" + scId );
        
//        custService.addCustomerOrder(customerName, street, city, zip, country)
        return scId;
    }
    
    public String addFood( @WebParam(name="scId") int scId, @WebParam(name="foodId") int foodId,@WebParam(name="quantity") int quantity){

        CustomerOrder co = custService.getShoppingCartById( scId );
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
                logger.info( "addFood: unsuccesful" );
                return "Food not found by ID";
            }
            return "Food added";
        }
        
    }
    
    public String setDeliveryAddress( @WebParam(name="scId") int scId, @WebParam(name="city") String city, @WebParam(name="street") String street, 
            @WebParam(name="zip") String zip, @WebParam(name="country") String country ){
    
    CustomerOrder shoppingCart = custService.getShoppingCartById(scId);
    
    if (shoppingCart == null ){
        return "Shopping cart not found";
    }else{
        Customer customer = shoppingCart.getCustomer();
        customer.setDeliveryAddress( new Address(street, city, zip, country) );
        customer.setBillingAddress( new Address(street, city, zip, country) );
        logger.info( "setDeliveryAddress: " + shoppingCart.getCustomer().getName() + "->" + custService.getShoppingCartById(scId).getDeliveryAddress() );
        return "The new delivery address set";
    }

}

    public String getDeliveryAddress( @WebParam(name="scId") int scId ){
        return "The delivery address set to:" + custService.getShoppingCartById(scId).getDeliveryAddress();
    }


    
    
    public void checkout( Integer scId ){
        
        custService.checkout(scId);
        
    }
   

    public String getBill( @WebParam(name="scId") Integer scId ){
        String billString = "";
        try{
            CustomerOrder sc = custService.getShoppingCartById(scId);
            logger.info("getBill: Customer:" + sc + " Bill:" + sc.getBillString() );
            billString = sc.getBillString();
        }catch(Exception e){
            logger.info("getBill: NOT FOUND");
            billString = "Shopping cart not found - you don't have to pay"; 
        }
        
        return billString;
    }
    
    
}
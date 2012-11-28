package com.acme.training.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.training.domain.Address;
import com.acme.training.domain.Customer;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.CustomerOrderRepository;

@WebService
@Component
public class ShoppingCartWS {

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
    
    public Integer getShoppingCart( String customerName ){
        return custRepo.getCustomerOrderIdByName( customerName );
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
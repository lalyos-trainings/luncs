package com.acme.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.service.OrderService;

@Component
@WebService
public class ShoppingCartWS {

    @Autowired
    private OrderService os;
    
    public ShoppingCartWS(){}
    
    public void init(){
//        //generate ShoppingCarts
//        os.getShoppingCart().withCustomer("Sztike");
//        os.getShoppingCart().withCustomer("Gizi");
//        os.getShoppingCart().withCustomer("Jani");
    }
    
    @WebMethod
    public int getShoppingCartId(String customer){
        return os.getShoppingCartId(customer);
    }
    
    @WebMethod
    public void addFoodByID(int sCId, int foodId, int quantity){
        os.addFood(sCId, foodId, quantity);
    }
    
    @WebMethod
    public void addFoodByName(int sCId, String restiName, String foodName, int quantity){
        os.addFood(sCId, restiName, foodName, quantity);
    }
    
    @WebMethod
    public void setDeliveryAddress(int sCId, String city, String street, String zip, String country){
        os.setDeliveryAddress(sCId, city, street, zip, country);
    }
    
    @WebMethod
    public void setBillingAddress(int sCId, String city, String street, String zip, String country){
        os.setBillingAddress(sCId, city, street, zip, country);
    }
    
    @WebMethod
    public void setCustomer(int sCId, String customer){
        os.setCustomer(sCId, customer);
    }
    
    @WebMethod
    public int checkOut(int sCId){
        return os.checkout(sCId).getId();
    }
    
    @WebMethod
    public int getNewShoppingCart(){
        return os.getShoppingCart().getId();
    }

//    @WebMethod
//    public CustomerOrder checkOut(int sCId){
//        return os.checkout(sCId);
//    }
}

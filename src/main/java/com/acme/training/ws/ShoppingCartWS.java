package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.service.InMemoryShoppingcart;
import com.acme.training.service.ShoppingCart;

@Component
@WebService
public class ShoppingCartWS {
   @Autowired
   private ApplicationContext ctx;
   private Map<Integer, ShoppingCart> shoppingCarts;
   
   
   public ShoppingCartWS() {
       shoppingCarts = new HashMap<Integer, ShoppingCart>();
   }

   public void addFood(
           @WebParam(name="shoppingCartId")
           int shoppingCartId, 
           @WebParam(name="foodId")
           int foodId, 
           @WebParam(name="quantity")
           int quantity){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.addFood(foodId, quantity);
           }
       }
   }

   public void setDeliveryAddress(
           @WebParam(name="shoppingCartId")
           int shoppingCartId,
           @WebParam(name="city")
           String city, 
           @WebParam(name="street")
           String street, 
           @WebParam(name="zip")
           String zip, 
           @WebParam(name="country")
           String country){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.setDeliveryAddress(city, street, zip, country);
           }
       }
   }
   
   public void setBillingaddress(
           @WebParam(name="shoppingCartId")
           int shoppingCartId,
           @WebParam(name="city")
           String city, 
           @WebParam(name="street")
           String street, 
           @WebParam(name="zip")
           String zip, 
           @WebParam(name="country")
           String country){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.setBillingaddress(city, street, zip, country);
           }
       }
   }
   
   public int checkOut(
           @WebParam(name="shoppingCartId")
           int shoppingCartId){
       ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
       return shoppingCart.checkOut();
   }
   
   public int getShoppingCart(
           @WebParam(name="customer")
           String customer){ 
       ShoppingCart foundShoppingCart = findShoppingCart(customer);
       if(foundShoppingCart != null)
           return foundShoppingCart.getCartId();
       else{
           InMemoryShoppingcart shoppingcart = ctx.getBean(InMemoryShoppingcart.class);
           shoppingcart.setCustomer(customer);
           shoppingCarts.put(shoppingcart.getCartId(), shoppingcart);
           return shoppingcart.getCartId();
       }
    }   
  
    private ShoppingCart findShoppingCart(String customer){
        for (ShoppingCart shoppingCart : shoppingCarts.values()) {
            if(customer.equals(shoppingCart.getCustomer()))
                return shoppingCart;
        }
        return null;
    }
}

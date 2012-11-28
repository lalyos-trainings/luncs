package com.acme.training.ws;

import java.util.Map;

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
   
   public void addFood(int shoppingCartId, int foodId, int quantity){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.addFood(foodId, quantity);
           }
       }
   }
   
   public void setCustomer(int shoppingCartId, String customer){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.setCustomer(customer);
           }
       }
   }
   
   public void setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.setDeliveryAddress(city, street, zip, country);
           }
       }
   }
   
   public void setBillingaddress(int shoppingCartId, String city, String street, String zip, String country){
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(shoppingCart.getCartId() == shoppingCartId){
               shoppingCart.setBillingaddress(city, street, zip, country);
           }
       }
   }
   
   public int checkOut(int shoppingCartId){
       ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
       return shoppingCart.checkOut();
   }
   
   public int getShoppingCart(String customer){ 
       for (ShoppingCart shoppingCart : shoppingCarts.values()) {
           if(customer.equals(shoppingCart.getCustomer())){
               return shoppingCart.getCartId();
           }
       }
       InMemoryShoppingcart shoppingcart = new InMemoryShoppingcart();
       shoppingcart.setCustomer(customer);
       shoppingCarts.put(shoppingcart.getCartId(), shoppingcart);
       return shoppingcart.getCartId();
       }
}
                            

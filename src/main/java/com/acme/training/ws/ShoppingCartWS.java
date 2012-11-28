package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {
    
    private Map<Integer, ShoppingCart> cartMap = new HashMap<Integer, ShoppingCart>(); 
    
    public void init() {
        
    }
    
    public ShoppingCartWS() {
    }
    
    @WebMethod
    public Integer getShoppingCart(String customer) {
        ShoppingCart nextCart = new InMemoryShoppingCart();
        nextCart.withCustomer(customer);
        int cartId = nextCart.getId();
        cartMap.put(cartId, nextCart);
        
        return cartId;
    }
    
    @WebMethod
    public boolean addFood(int cartId, int foodId, int quantity) {
        ShoppingCart cart = cartMap.get(cartId);
        if (cart != null) {
            cart.withFood(foodId, quantity);
            return true;
        } else {
            return false;
        }                
    }
    
    @WebMethod
    public boolean setDeliveryAddress(int cartId, String city, String street, String zip, String country) {
        ShoppingCart cart = cartMap.get(cartId);
        if (cart != null) {
            cart.withDeliveryAddress(new Address(street, city, zip, country));
            return true;
        } else {
            return false;
        }   
    }
    
    @WebMethod
    public String checkout(int cartId) {
        ShoppingCart cart = cartMap.get(cartId);
        if (cart != null) {
            cart.checkout();
            return cart.getOrderId();
        } else {
            return null;
        }           
    }   

}

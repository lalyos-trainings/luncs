package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {
    
    Map<Integer, ShoppingCart> shoppingCarts = new HashMap<Integer, ShoppingCart>();

    @Autowired
    private ApplicationContext ac;
    
    public ShoppingCartWS() {

    }

    public void init() {
        
    }

    public Integer getShoppingCart(String customer){
        ShoppingCart shoppingCart = ac.getBean(ShoppingCart.class);
        shoppingCart = shoppingCart.withCustomer(customer);
        shoppingCarts.put(shoppingCart.getId(), shoppingCart);
        return shoppingCart.getId();
    }

    public void addFood(Integer shoppingCartId, int foodId, int quantity){
        ShoppingCart sc = this.shoppingCarts.get(shoppingCartId);
        sc.withFood(foodId, quantity);
    }

    public void setDeliveryAddress(Integer shoppingCartId, String city, String zip, String street, String country){
        ShoppingCart sc = this.shoppingCarts.get(shoppingCartId);
        sc.withDeliveryAddress(new Address(street, city, zip, country));
    }

    public String checkout(Integer shoppingCartId){
        ShoppingCart sc = this.shoppingCarts.get(shoppingCartId);
        sc.checkout();
        return sc.getOrder().getId();
    }
}

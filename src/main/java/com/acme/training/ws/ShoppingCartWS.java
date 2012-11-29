package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {
    
    @Autowired
    ApplicationContext ctx;
    private Map<Integer, ShoppingCart> carts = new HashMap<Integer, ShoppingCart>();
    private static int nextId = 0;

    public ShoppingCartWS() {
    }
    
    @WebMethod
    public Integer getShoppingCart(String customer) {
        int cartId = nextId++;
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.withCustomer(customer);
        carts.put(cartId, cart);
        return cartId;
    }
    
    @WebMethod
    public String addFood(int shoppingCartId, int foodId, int quantity) {
        ShoppingCart cart = carts.get(shoppingCartId);
        if (cart != null) {
            cart.withFood(foodId, quantity);
        }
        return quantity + " * " + foodId + " added to cart " + shoppingCartId;
    }
    
    @WebMethod
    public String setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country) {
        ShoppingCart cart = carts.get(shoppingCartId);
        if (cart != null) {
            cart.withDeliveryAddress(new Address(street, city, zip, country));
        }
        return "Delivery address (" + zip + ", " + city + " " + street + ", " + country + " set for cart " + shoppingCartId;
    }
    
    @WebMethod
    public String checkout(int shoppingCartId) {
        ShoppingCart cart = carts.get(shoppingCartId);
        if (cart != null) {
            return cart.checkout();
        }
        return "Checkout failed";
    }
}

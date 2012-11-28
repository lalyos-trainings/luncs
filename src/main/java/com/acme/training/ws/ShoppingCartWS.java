package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.service.InMemoryShoppingCart;
import com.acme.training.service.ShoppingCart;

@Component
@WebService
public class ShoppingCartWS
{
    @Autowired
    private ApplicationContext context;
    private Map<Integer, ShoppingCart> shoppingCarts;
    
    
    public ShoppingCartWS()
    {
        shoppingCarts = new HashMap<Integer, ShoppingCart>();
    }
    
    public int getShoppingCart
    (
        @WebParam(name="customer")
        String customer
    )
    {
        InMemoryShoppingCart shoppingCart = context.getBean(InMemoryShoppingCart.class);
        shoppingCart.setCustomer(customer);
        shoppingCarts.put(shoppingCart.getId(), shoppingCart);
        
        return shoppingCart.getId();
    }
    
    public void addFood
    (
        @WebParam(name="shoppingCartId")
        int shoppingCartId,
        @WebParam(name="foodId")
        int foodId,
        @WebParam(name="quantity")
        int quantity
    )
    {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        shoppingCart.addFood(foodId, quantity);
    }

    public void setDeliveryAddress
    (
        @WebParam(name="shoppingCartId")
        int shoppingCartId, 
        @WebParam(name="street")
        String street, 
        @WebParam(name="city")
        String city, 
        @WebParam(name="zip")
        String zip, 
        @WebParam(name="country")
        String country
    )
    {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        shoppingCart.setDeliveryAddress(street, city, zip, country);
    }

    public void setBillingAddress
    (
        @WebParam(name="shoppingCartId")
        int shoppingCartId, 
        @WebParam(name="street")
        String street, 
        @WebParam(name="city")
        String city, 
        @WebParam(name="zip")
        String zip, 
        @WebParam(name="country")
        String country
    )
    {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        shoppingCart.setBillingAddress(street, city, zip, country);
    }

    public int checkout
    (
        @WebParam(name="shoppingCartId")
        int shoppingCartId
    )
    {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        int orderId = shoppingCart.checkout();
        return orderId;
    }
}

package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.ShoppingCart;

@Component
@WebService
public class InMemoryShoppingCartWS implements ShoppingCartWS {
    
    @Autowired
    private ApplicationContext ctx;
    
    private Logger logger;
    
    private Map<Integer,ShoppingCart> shoppingCarts = new HashMap<Integer,ShoppingCart>();
    private Integer id = 0;
    
    
    public InMemoryShoppingCartWS() {
    }

    public void init() {
        logger = LoggerFactory.getLogger(InMemoryShoppingCartWS.class);
        shoppingCarts = new HashMap<Integer,ShoppingCart>();
        id = 0;
    }

    @WebMethod
    @Override
    public int createShoppingCart(String customerName) {
        ShoppingCart shoppingCart = ctx.getBean(ShoppingCart.class);
        shoppingCart = shoppingCart.withCustomer(customerName);
        id++;
        shoppingCarts.put(id, shoppingCart.withCustomer(customerName));
        logger.info("ShoppingCart created with id: "+id+" and name: "+customerName);
        return id;
    }

    @WebMethod
    @Override
    public void addFood(int shoppingCartId, int foodId, int quantity) {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        shoppingCarts.put(id, shoppingCart.withFood(foodId, quantity));
        logger.info("Food with foodId: "+foodId+" added to cart with id: "+shoppingCartId);
    }

    @WebMethod
    @Override
    public void setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country) {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        Address address = new Address(street, city, zip, country);
        shoppingCarts.put(id, shoppingCart.withDeliveryAddress(address));
        logger.info("Adress: "+address+" set to cart with id: "+shoppingCartId);
    }

    @WebMethod
    @Override
    public void setBillingAddress(int shoppingCartId, String city, String street, String zip, String country) {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        Address address = new Address(street, city, zip, country);
        shoppingCarts.put(id, shoppingCart.withBillingAddress(address));
        logger.info("Adress: "+address+" set to cart with id: "+shoppingCartId);
        
    }

    @WebMethod
    @Override
    public String checkout(int shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
        shoppingCart.checkout();
        return shoppingCart.getCustomerOrder().getId();
    }

}

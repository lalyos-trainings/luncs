package com.acme.training.webservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.service.ShoppingCart;

@Component
public class ShoppingCartContainer {
    
    public static class Pair {
        public Pair(Integer id, ShoppingCart cart) {
            super();
            this.id = id;
            this.cart = cart;
        }
        Integer id;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public ShoppingCart getCart() {
            return cart;
        }
        public void setCart(ShoppingCart cart) {
            this.cart = cart;
        }
        ShoppingCart cart;
    }
    
    private static int ID = 1;
    
    @Autowired
    private ApplicationContext context;
    
    private Map<Integer, ShoppingCart> container = new HashMap<Integer, ShoppingCart>();
    
    public void init() {
        System.out.println("shoppingcartcontainer init: " + context);
    }
    
    public synchronized ShoppingCart getExistingCart(int id) {
        ShoppingCart cart = container.get(id);
        if ( cart == null ) {
                throw new RuntimeException("no cart found for id " + id);
        }
        System.out.println(cart);
        return cart;
    }
    
    public synchronized Pair getCart(int id) {
        ShoppingCart cart;
        if ( id <= 0 ) {
            id = ID++;
//            cart = new ShoppingCart();
            cart = context.getBean(ShoppingCart.class);
            
            container.put(id, cart);
        } else {
            cart = container.get(id);
            if ( cart == null ) {
                throw new RuntimeException("no cart found for id " + id);
            }
        }
        
        System.out.println(cart);
        
        return new Pair(id, cart);
    }
    
    public synchronized void trash(int id) {
        container.remove(id);
    }
    
}

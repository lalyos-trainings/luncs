package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.acme.training.service.ShoppingCart;

@WebService
public class ShoppingCartWS {
    
    private static int nextId = 0;
    private String id = String.valueOf(nextId++);
    
    private Map<Integer, ShoppingCart> carts = new HashMap<Integer, ShoppingCart>();

    public ShoppingCartWS() {
    }
    
//    public Integer getShoppingCart(String customer) {
//        String cartCustomer;
//        for (Integer cartId : carts.keySet()) {
//            cartCustomer = carts.get(cartId).getCustomer();
//            if (cartCustomer.equals(customer)) {
//                return cartId;
//            }
//        }
//        carts
//    }
//    
//    public void addFood(int shoppingCartId, int foodId, int quantity) {
//        ShoppingCart cart = 
//    }
}

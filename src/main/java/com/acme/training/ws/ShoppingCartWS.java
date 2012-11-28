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
    private ApplicationContext ctx;
    private Map<Integer, ShoppingCart> shoppingCarts;

    public ShoppingCartWS() {

    }

    @WebMethod
    public Integer getShoppingCart(String customer) {
        Integer result = null;
        if (shoppingCarts != null) {
            result = putInNewShoppingCart(customer);

        } else {
            shoppingCarts = new HashMap<Integer, ShoppingCart>();
            result = putInNewShoppingCart(customer);
        }
        return result;
    }

    @WebMethod
    private Integer putInNewShoppingCart(String customer) {
        ShoppingCart initShoppingCart = ctx.getBean(ShoppingCart.class);
        shoppingCarts.put(Integer.parseInt(initShoppingCart.getCustomerOrder().getId()), initShoppingCart.withCustomer(customer));
        return Integer.parseInt(initShoppingCart.getCustomerOrder().getId());
    }

    @WebMethod
    public void addFood(Integer shoppingCartID, int foodID, int quantity) {
        shoppingCarts.get(shoppingCartID).withFood(foodID, quantity);

    }

    @WebMethod
    public void setDeliveryAddress(Integer shoppingCartID, String city, String street, String zip, String country) {
        shoppingCarts.get(shoppingCartID).withDeliveryAddress(new Address(street, city, zip, country));
    }

    @WebMethod
    public Integer checkout(Integer shoppingCartID) {
        shoppingCarts.get(shoppingCartID).checkout();
        return Integer.parseInt(shoppingCarts.get(shoppingCartID).getCustomerOrder().getId());
    }

}

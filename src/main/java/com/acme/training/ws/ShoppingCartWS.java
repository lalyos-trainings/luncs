package com.acme.training.ws;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {

    @Autowired
    ApplicationContext ctx;

    Map<String, ShoppingCart> shoppingCarts = new HashMap<String, ShoppingCart>();

    public void addFood( 
            @WebParam(name = "customer") String customer, 
            @WebParam(name = "foodId") int foodId,
            @WebParam(name = "quantity") int quantity
            ) {
            ShoppingCart cart = shoppingCarts.get(customer);

            if (cart == null) {
                cart = ctx.getBean(ShoppingCart.class);
                cart.withCustomer(customer);
                shoppingCarts.put(customer, cart);
            }
            cart.withFood(foodId, quantity);
    }

    public void setDeliveryAddress( 
            @WebParam(name = "customer") String customer,
            @WebParam(name = "street") String street, 
            @WebParam(name = "city") String city,
            @WebParam(name = "zip") String zip, 
            @WebParam(name = "country") String country
            ) {
            ShoppingCart cart = shoppingCarts.get(customer);

            if (cart == null) {
                cart = ctx.getBean(ShoppingCart.class);
                cart.withCustomer(customer);
                shoppingCarts.put(customer, cart);
            }
            cart.withDeliveryAddress(new Address(street, city, zip, country));
            cart.withBillingAddress(new Address(street, city, zip, country));
    }

    public CustomerOrder checkOut( @WebParam(name = "customer") String customer) {

        ShoppingCart cart = shoppingCarts.get(customer);

        if (cart == null) {
            return null;
        }

        // shoppingCarts.remove(customer);

        return cart.getOrder();
    }

}

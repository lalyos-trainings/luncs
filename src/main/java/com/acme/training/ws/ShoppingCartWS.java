package com.acme.training.ws;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingCartWS {

    private static int nextId = 0;

    @Autowired
    private ApplicationContext ctx;
    private final Map<Integer, ShoppingCart> carts = new HashMap<Integer, ShoppingCart>();

    public ShoppingCartWS() {
    }

    public int getShoppingCart(String customer) {
        Integer id = findEntryByCustomer(customer);
        if (null == id) {
            id = createShoppingCart(customer);
        }

        return id;
    }

    public void addFood(int scId, int foodId, int quantitiy) {
        ShoppingCart cart = carts.get(scId);
        if (null != cart) {
            cart.withFood(foodId, quantitiy);
        }
    }

    public void setDeliveryAddress(int scId, String city, String street, String zip, String country) {
        ShoppingCart cart = carts.get(scId);
        if (null != cart) {
            cart.withDeliveryAddress(new Address(street, city, zip, country));
        }
    }

    public String checkout(int scId) {
        ShoppingCart cart = carts.get(scId);
        if (null != cart) {
            cart.checkout();
            return cart.getOrderId();
        } else {
            return null;
        }
    }

    private Integer findEntryByCustomer(String customer) {
        for (Entry<Integer, ShoppingCart> entry : carts.entrySet()) {
            if (entry.getValue()
                     .getCustomer()
                     .equals(customer)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Integer createShoppingCart(String customer) {
        Integer id = nextId++;
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        carts.put(id, cart.withCustomer(customer));
        return id;
    }
}

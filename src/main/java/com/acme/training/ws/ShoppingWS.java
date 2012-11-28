package com.acme.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.ordermodel.CustomerOrder;
import com.acme.training.ordermodel.OrderItem;
import com.acme.training.ordermodel.RestaurantOrder;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class ShoppingWS {

    @Autowired
    private ShoppingCart cart;
    private RestaurantOrder rOrder;
    @SuppressWarnings("unused")
    private CustomerOrder cOder;

    public ShoppingWS() {

    }

    @WebMethod
    public void getShoppingCart(String customer) {
        try {
            cart.withCustomer(customer);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @WebMethod
    public void addFood(int shoppingCartId, int foodId, int quantity) {
        try {
            Food food = cart.getRepo().findFoodById(foodId);
            rOrder.addItem(new OrderItem(quantity, food));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @WebMethod
    public void setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country) {
        try {
            Address deliveryAddress = new Address(street, city, zip, country);
            cart.withDeliveryAddress(deliveryAddress);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    // OrderId
    @WebMethod
    public int checkout() {
        return cart.checkout();
    }
}

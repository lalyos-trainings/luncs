package com.acme.training.ws;

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

    public void init() {

    }

    public void getShoppingCart(String customer) {

        this.cart= null;
    }

    public void addFood(int scId, Food food, int quantity) {
        
        rOrder.addItem(new OrderItem(quantity, food));

    }

    public void setDeliveryAddress(int scId, String city, String street, String zip, String country) {
        Address deliveryAddress=new Address(street, city, zip, country);
        cart.withDeliveryAddress(deliveryAddress);
        
    }

    // OrderId
    public int checkout() {
       
        cart.checkout();
        return 1;

    }

}

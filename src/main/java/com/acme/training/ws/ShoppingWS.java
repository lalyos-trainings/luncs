package com.acme.training.ws;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.ordermodel.Order;
import com.acme.training.ordermodel.OrderItem;
import com.acme.training.service.ShoppingCart;

public class ShoppingWS {

    private ShoppingCart cart;
    private Order order;

    public ShoppingWS() {

    }

    public void init() {

    }

    public void getShoppingCart(String customer) {

        this.cart= null;
    }

    public void addFood(int scId, Food food, int quantity) {
        
        order.addItem(new OrderItem(quantity, food));

    }

    public void setDeliveryAddress(int scId, String city, String street, String zip, String country) {
        Address deliveryAddress=new Address(street, city, zip, country);
        cart.withDeliveryAddress(deliveryAddress);
        
    }

    // OrderId
    public int checkout() {
       
        cart.checkout();
        return 0;

    }

}

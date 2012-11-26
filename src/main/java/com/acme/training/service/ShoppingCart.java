package com.acme.training.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

public class ShoppingCart implements BeanNameAware {
    private final Order order;
    private OrderService os;
    private RestaurantRepository rr;
    private final Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    public ShoppingCart(String customer, Address billingAddress, Address deliveryAddress) {
        order = new Order(customer, billingAddress, deliveryAddress);
    }

    public String getCustomer() {
        return order.getCustomer();
    }

    public Address getBillingAddress() {
        return order.getBillingAddress();
    }

    public Address derliveryAddress() {
        return order.getDeliveryAddress();
    }

    public void addFood(int id, int quantity) {
        List<OrderItem> orders = order.getOrderItems();
        orders.add(new OrderItem(quantity, rr.getFoodById(id)));
    }

    public void checkout() {
        os.doOrder(order);
    }

    public OrderService getOs() {
        return os;
    }

    public void setOs(OrderService os) {
        this.os = os;
    }

    public RestaurantRepository getRr() {
        return rr;
    }

    public void setRr(RestaurantRepository rr) {
        this.rr = rr;
    }

    public void setBeanName(String arg0) {
        logger.info(arg0 + " " + this.hashCode());
    }
}

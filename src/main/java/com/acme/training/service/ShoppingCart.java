package com.acme.training.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart implements BeanNameAware {
    private Order order;
    private OrderService os;
    @Autowired
    private RestaurantRepository repo;
    private final Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    public ShoppingCart() {
    }

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
        orders.add(new OrderItem(quantity, repo.getFoodById(id)));
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
        return repo;
    }

    public void setRr(RestaurantRepository rr) {
        this.repo = rr;
    }

    public void setBeanName(String arg0) {
        logger.info(arg0 + " " + this.hashCode());
    }
}

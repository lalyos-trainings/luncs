package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component("cart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart implements BeanNameAware {
    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;
    private final Order order;
    private final Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    private ShoppingCart() {
        this.order = new Order();
    }

    public ShoppingCart withCustomer(String customer) {
        order.setCustomer(customer);
        return this;
    }

    public ShoppingCart withDeliveryAddress(Address deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
        return this;
    }

    public ShoppingCart withBillingAddress(Address billingAddress) {
        order.setBillingAddress(billingAddress);
        return this;
    }

    public ShoppingCart withFood(int id) {
        return withFood(id, 1);
    }

    public ShoppingCart withFood(int id, int quantity) {
        Food food = repo.getFoodById(id);
        order.addItem(new OrderItem(quantity, food));
        return this;
    }

    public void checkout() {
        orderService.doOrder(order);
        logger.info("checking out order:" + order.getId());
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setBeanName(String name) {
        logger.info("my name is: " + name);
        logger.info("my hashCode is: " + hashCode());

    }
}

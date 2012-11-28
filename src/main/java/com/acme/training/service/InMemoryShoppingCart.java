package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.OrderItem;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingCart implements BeanNameAware, ShoppingCart {
    
    private static int nextId = 0;
    
    private int id = nextId++;

    public int getId() {
        return id;
    }

    public String getOrderId() {
        return order.getId();
    }

    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;    
    private CustomerOrder order;
    private Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);

    public InMemoryShoppingCart() {
        this.order = new CustomerOrder();
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
        Food food = repo.findFoodById(id);
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

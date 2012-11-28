package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart implements BeanNameAware{

    private OrderService orderService;
    private static int nextId = 0; 
    @Autowired
    private RestaurantRepository repo;    
    private CustomerOrder customerOrder;
    private Logger logger = LoggerFactory.getLogger(ShoppingCart.class);
    public Integer id = nextId++;

    private ShoppingCart() {
        this.customerOrder = new CustomerOrder();
    }
    
    public ShoppingCart withCustomer(String customer) {
        customerOrder.setCustomer(customer);
        return this;
    }
    
    public ShoppingCart withDeliveryAddress(Address deliveryAddress) {
        customerOrder.setDeliveryAddress(deliveryAddress);
        return this;
    }

    public ShoppingCart withBillingAddress(Address billingAddress) {
        customerOrder.setBillingAddress(billingAddress);
        return this;
    }

    public ShoppingCart withFood(int id) {
        return withFood(id, 1);
    }

    public ShoppingCart withFood(int id, int quantity) {
        Food food = repo.findFoodById(id);
        customerOrder.addItem(new OrderItem(quantity, food));
        return this;
    }
    
    public int checkout() {
        orderService.doOrder(customerOrder);
        return customerOrder.getId();
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
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

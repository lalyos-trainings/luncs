package com.acme.training.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RegistrationException;
import com.acme.training.domain.UserInfo;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart implements BeanNameAware {

    @Autowired
    private InMemoryRegistrationService inMemoryRegistrationService;
    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;    
    private Order order;
    private Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    private ShoppingCart() {
        this.order = new Order();
    }
    
    public ShoppingCart withCustomer(UserInfo userInfo) {
        return withCustomer(userInfo.getUserName())
                .withBillingAddress(userInfo.getBillingAddr())
                .withDeliveryAddress(userInfo.getDeliveryAddr());
    }
    
    public ShoppingCart withCustomer(String customer) throws RegistrationException {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(customer);
        if (userInfo == null) {
            RegistrationException ex = new RegistrationException(String.format("User with name [%s] is not registered", customer));
            throw ex;
        }
        
        order.setCustomer(customer);
        order.setBillingAddress(userInfo.getBillingAddr());
        order.setDeliveryAddress(userInfo.getDeliveryAddr());
        return this;
    }
    
    public ShoppingCart withCustomer(Integer customerId) throws RegistrationException {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(customerId);
        if (userInfo == null) {
            RegistrationException ex = new RegistrationException(String.format("Nobody registered with id [%d]", customerId));
            throw ex;
        }

        String customer = userInfo.getUserName();
        return withCustomer(customer);
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
    
    public int getPrice() {
        List<OrderItem> items = order.getItems();
        int sum = 0;
        for (OrderItem orderItem : items) {
            Food food = orderItem.getFood();
            int price = food.getPrice() * orderItem.getQuantity();
            sum += price;
        }
        
        return sum;
    }
    
    public String getItems() {
        List<OrderItem> items = order.getItems();
        String s = "  +Food name------------+Quant.+-Price+";
        for (OrderItem orderItem : items) {
            Food food = orderItem.getFood();
            s = String.format("%s\n  | %-20s|%5d x%6d|", s, food.getName(), orderItem.getQuantity(), food.getPrice());
        }
        
        return String.format("%s\n  +---------------------+------+%6d+", s, getPrice());
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

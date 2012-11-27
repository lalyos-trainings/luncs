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
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);
    
    private Order order;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    @Qualifier("memory")
    private RestaurantRepository repo;

    public InMemoryShoppingCart() 
    {
        order = new Order();
    }
    
    public void addFood(int foodId, int quantity) 
    {
        Food food = repo.getFoodById(foodId);
        order.addOrderItem(quantity, food);
    }

    public void setCustomer(String customer) 
    {
        order.setCustomer(customer);
    }

    public void setDeliveryAddress(String street, String city, String zip, String country) 
    {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void setBillingAddress(String street, String city, String zip, String country) 
    {
        order.setBillingAddress(new Address(street, city, zip, country));
    }

    public void checkout() 
    {
        orderService.doOrder(order);
    }

    public void setBeanName(String beanName) 
    {
        logger.info("bean name: " + beanName);
        logger.info("bean hash: " + hashCode());
    }
    
}

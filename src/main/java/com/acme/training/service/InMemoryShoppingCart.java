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
import com.acme.training.domain.CustomerOrder;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingCart implements ShoppingCart, BeanNameAware
{
    private static Logger logger = LoggerFactory.getLogger(InMemoryShoppingCart.class);

    private static int nextId = 0;

    private int id;
    private CustomerOrder order;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private RestaurantRepository repo;

    public InMemoryShoppingCart() 
    {
        this.id = nextId++;
        order = new CustomerOrder();
    }
    
    public int getId()
    {
        return id;
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

    public int checkout() 
    {
        orderService.doOrder(order);
        return order.getId();
    }

    public void setBeanName(String beanName) 
    {
        logger.info("bean name: " + beanName);
        logger.info("bean hash: " + hashCode());
    }
    
}

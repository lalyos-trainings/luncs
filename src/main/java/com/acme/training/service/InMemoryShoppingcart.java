package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;

@Component("cart_huhu")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingcart implements ShoppingCart, BeanNameAware{
    
    private OrderService os;
    private RestaurantRepository repo;
    private Order order;
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    
    public InMemoryShoppingcart() {
        order = new Order();
    }

    
    public void setOs(OrderService os) {
        this.os = os;
    }


    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }

    public void addFood(int foodId, int quantity) {
        Food food = repo.getFoodById(foodId);
        order.addOrderItem(quantity, food);        
    }

    public void setCustomer(String customer) {
        order.setCustomer(customer);
        
    }

    public void setDeliveryAddress(String city, String street, String zip, String country) {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void setBillingaddress(String city, String street, String zip, String country) {
        order.setDeliveryAddress(new Address(street, city, zip, country));
    }

    public void checkOut() {
        os.doOrder(order);
        
    }
    
    public void setBeanName(String bean) {
        logger.info("bean:" + bean);
        logger.info("hash" + hashCode());
    }


}

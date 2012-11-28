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

@Component("cart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InMemoryShoppingcart implements ShoppingCart, BeanNameAware{
    
    @Autowired
    private OrderService os;
    @Autowired
    private RestaurantRepository repo;
    private CustomerOrder order;
    private Logger logger = LoggerFactory.getLogger(InMemoryRestaurantRepository.class);
    private int cartId;
    private static int nextId = 0;
    
    public InMemoryShoppingcart() {
        order = new CustomerOrder();
        cartId = nextId++;
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

    public int checkOut() {
        os.doOrder(order);
        return order.getId();
    }
    
    public void setBeanName(String bean) {
        logger.info("bean:" + bean);
        logger.info("hash" + hashCode());
    }

    public String getCustomer() {
        return order.getCustomer();
    }

    public int getCartId() {
        return cartId;
    }

    

}

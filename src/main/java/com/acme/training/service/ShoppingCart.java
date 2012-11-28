package com.acme.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.RestaurantOrder;

@Component("kart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart {
	
	@Autowired
	private RestaurantRepository repo;
    private OrderService orderService;
    private CustomerOrder customerOrder;
    private Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    public ShoppingCart() {
        this.customerOrder = new CustomerOrder();
    }
    
    public ShoppingCart withCustomer(String customer) {
    	customerOrder.setCustomerName(customer);
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
        Restaurant restaurant = food.getRestaurant();
        
        RestaurantOrder restaurantOrder = new RestaurantOrder(restaurant);
        OrderItem orderItem = new OrderItem(quantity, food);
		restaurantOrder.getOrderItems().add(orderItem);
		customerOrder.getRestaurantOrders().add(restaurantOrder);
        return this;
    }

    public void checkout() {
        orderService.doOrder(customerOrder);
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

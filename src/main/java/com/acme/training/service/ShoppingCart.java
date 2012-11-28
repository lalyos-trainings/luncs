package com.acme.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.ordermodel.CustomerOrder;
import com.acme.training.ordermodel.OrderItem;
import com.acme.training.repository.RestaurantRepository;

@Component("ShoppingCart")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart{

    @Autowired
    private OrderService orderService;
    @Autowired
    private RestaurantRepository repo;    
    private CustomerOrder customerOrder;
  
    private ShoppingCart() {
        this.customerOrder = new CustomerOrder();
    }
    
    // ******************************************* SETTING UP SHOPPINGCART ************************************************
    
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

    // ******************************************** FINISHING SHOPPING **************************************************
    public int checkout() {
        orderService.doOrder(customerOrder);
        return Integer.parseInt(customerOrder.getId());
    }

    // *********************************************** GETTERS ************************************************************
    public OrderService getOrderService() {
        return orderService;
    }

    public RestaurantRepository getRepo() {
        return repo;
    }
}

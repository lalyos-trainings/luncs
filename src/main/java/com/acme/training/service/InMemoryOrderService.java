package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;

@Component
@Scope("singleton")
public class InMemoryOrderService implements OrderService {
    
    private Map<String, CustomerOrder> orders;
    @Autowired
    private ApplicationContext context;
    @Autowired
    private RestaurantRepository repo;
    private int maxSCId;
    private Map<Integer, ShoppingCart> shoppingCarts;
    
    public InMemoryOrderService(){
        orders = new HashMap<String, CustomerOrder>();
        maxSCId = 0;
        shoppingCarts = new HashMap<Integer, ShoppingCart>();
    }

    public synchronized void doOrder(CustomerOrder order) {
        orders.put(order.getCustomer(), order);
        System.out.println(order);
        OrderEvent event = new OrderEvent(this, order);
        context.publishEvent(event);
    }

    public Collection<CustomerOrder> getAllOrders() {
        return orders.values();
    }

    public ShoppingCart getShoppingCart(int id) {
        return shoppingCarts.get(id);
    }

    public ShoppingCart getShoppingCart() {
        maxSCId++;
        ShoppingCart newSC = new InMemoryShoppingCart(maxSCId, repo, this);
        shoppingCarts.put(maxSCId, newSC);
        return newSC;
    }
    
    public int getShoppingCartId(String customer){
        boolean found = false;
        int r = 0;
        ShoppingCart tmp = null;
        Iterator<ShoppingCart> it = shoppingCarts.values().iterator();
        while(it.hasNext() && !found){
            tmp = it.next();
            if(tmp.getOrder().getCustomer().equals(customer)){
                r = tmp.getId();
                found = true;
            }
        }
        return r;
    }

    public void addFood(int sCId, int foodId, int quantity) {
        shoppingCarts.get(sCId).withFood(foodId, quantity);
    }

    public void addFood(int sCId, String restiName, String foodName, int quantity) {
        shoppingCarts.get(sCId).withFood(restiName, foodName, quantity);
    }

    public void setDeliveryAddress(int sCId, String city, String street, String zip, String country) {
        shoppingCarts.get(sCId).withDeliveryAddress(new Address(zip, country, city, street));
    }

    public CustomerOrder checkout(int sCId) {
        return shoppingCarts.get(sCId).checkOut();
    }

    public void setBillingAddress(int sCId, String city, String street, String zip, String country) {
        shoppingCarts.get(sCId).withBillingAddress(new Address(zip, country, city, street));
    }

    public void setCustomer(int sCId, String customer) {
        shoppingCarts.get(sCId).withCustomer(customer);
    }
    
}

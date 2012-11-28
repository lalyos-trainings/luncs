package com.acme.training.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerOrder
{
    private static final Logger logger = LoggerFactory.getLogger(CustomerOrder.class);
    
    private String customer;
    private Address billingAddress;
    private Address deliveryAddress;
    private Map<String, RestaurantOrder> restaurantOrders;

    
    public CustomerOrder() 
    {
        restaurantOrders = new HashMap<String, RestaurantOrder>();
    }

    public String getCustomer()
    {
        return customer;
    }

    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    public Address getBillingAddress()
    {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }

    public Address getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(String.format("customer         : %s%n", customer));
        buffer.append(String.format("billing address  : %s%n", billingAddress));
        buffer.append(String.format("delivery address : %s%n", deliveryAddress));

        Iterator<RestaurantOrder> iterator = restaurantOrders.values().iterator();
        
        int i = 0;
        while (iterator.hasNext() == true)
        {
            buffer.append(String.format("=== %d. restaurant order ===", i));
            
            RestaurantOrder restaurantOrder = iterator.next();
            buffer.append(restaurantOrder);
        }

        return buffer.toString();
    }

    public int getTotal()
    {
        int total = 0;

        Iterator<RestaurantOrder> iterator = restaurantOrders.values().iterator();
        
        while (iterator.hasNext() == true)
        {
            RestaurantOrder restaurantOrder = iterator.next();
            total += restaurantOrder.getTotal();
        }

        return total;
    }

    public void printBill()
    {
        logger.info("==== Megrendelés ====");
        logger.info("customer        : {}", customer);
        logger.info("deliver address : {}", deliveryAddress);
        logger.info("billing address : {}", billingAddress);
        
        
        Iterator<RestaurantOrder> iterator = restaurantOrders.values().iterator();
        while (iterator.hasNext() == true)
        {
            RestaurantOrder restaurantOrder = iterator.next();
            restaurantOrder.printBill();
        }
        
        logger.info("--------");
        logger.info("Total : " + getTotal());
    }

    public Collection<RestaurantOrder> getRestaurantOrders()
    {
        return restaurantOrders.values();
    }

    public void addOrderItem(int quantity, Food food)
    {
        Restaurant restaurant = food.getRestaurant();
        String restaurantName = restaurant.getName();
        
        RestaurantOrder restaurantOrder = restaurantOrders.get(restaurantName);
        
        if (restaurantOrder == null)
        {
            restaurantOrder = new RestaurantOrder(restaurant);
            restaurantOrders.put(restaurantName, restaurantOrder);
        }
        
        restaurantOrder.addOrderItem(quantity, food);
    }
}

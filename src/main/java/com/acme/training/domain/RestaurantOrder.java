package com.acme.training.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestaurantOrder
{
    private static final Logger logger = LoggerFactory.getLogger(RestaurantOrder.class);
    
    private Restaurant restaurant = null;
    private Map<Integer, OrderItem> orderItems;

    
    public RestaurantOrder(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        this.orderItems = new HashMap<Integer, OrderItem>();
    }

    public void addOrderItem(int quantity, Food food)
    {
        OrderItem orderItem = orderItems.get(food.getId());
        
        if (orderItem != null)
        {
            orderItem.addQuantity(quantity);
        }
        else
        {
            orderItems.put(food.getId(), new OrderItem(quantity, food));
        }
    }

    public Collection<OrderItem> getOrderItems()
    {
        return orderItems.values();
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        int i = 0;
        while (i < orderItems.size())
        {
            OrderItem item = orderItems.get(i);
            buffer.append(item);
            buffer.append("\r\n");
            i++;
        }

        return buffer.toString();
    }

    public int getTotal()
    {
        int total = 0;

        Iterator<OrderItem> iterator = orderItems.values().iterator();
        
        while (iterator.hasNext() == true)
        {
            OrderItem orderItem = iterator.next();
            total += orderItem.getTotal();
        }
        
        return total;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }
    
    public void printBill()
    {
        logger.info("**** {} étterem számlája ****", restaurant.getName());
        
        Iterator<OrderItem> iterator = orderItems.values().iterator();
        while (iterator.hasNext() == true)
        {
            OrderItem orderItem = iterator.next();
            logger.info(String.format("%20s %3d %6d", orderItem.getFood(), orderItem.getQuantity(), orderItem.getTotal()));
        }
        
        logger.info("--------");
        logger.info("Total : " + getTotal());
    }
}

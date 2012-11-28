package com.acme.training.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.OrderItem;
import com.acme.training.domain.RestaurantOrder;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>
{
    private static final Logger logger = LoggerFactory.getLogger(InMemoryStatisticService.class);

    private Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    
    private void doStatistic(OrderItem item)
    {
        int foodId = item.getFood().getId();
        
        OrderItem orderItem = foodStatistic.get(foodId);
        
        if (orderItem != null)
        {
            // TODO: klónozott order item kell ide
            orderItem.addQuantity(item.getQuantity());
        }
        else
        {
            foodStatistic.put(foodId, item);
        }
    }
    
    public void onApplicationEvent(OrderEvent event)
    {
        CustomerOrder customerOrder = event.getCustomerOrder();
        Collection<RestaurantOrder> restaurantOrders = customerOrder.getRestaurantOrders();
        
        Iterator<RestaurantOrder> restaurantOrderIterator = restaurantOrders.iterator();
        while (restaurantOrderIterator.hasNext() == true)
        {
            RestaurantOrder restaurantOrder = restaurantOrderIterator.next();
            
            Collection<OrderItem> orderItems = restaurantOrder.getOrderItems();
            Iterator<OrderItem> orderItemsIterator = orderItems.iterator();
            
            while (orderItemsIterator.hasNext() == true)
            {
                OrderItem orderItem = orderItemsIterator.next();
                doStatistic(orderItem);
            }
        }
    }

    public void printStatistic()
    {
        logger.info("=== STATISTIC ===");
        
        Iterator<OrderItem> iterator = foodStatistic.values().iterator();
        while (iterator.hasNext() == true)
        {
            OrderItem item = iterator.next();
            
            logger.info("{}", item);
        }
    }

}

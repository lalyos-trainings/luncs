package com.acme.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.domain.CustomerOrder;
import com.acme.domain.OrderItem;
import com.acme.domain.RestaurantOrder;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    private Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    
    public void onApplicationEvent(OrderEvent e) {        
        CustomerOrder customerOrder = e.getCustomerOrder();
        Collection<RestaurantOrder> restaurantOrders = customerOrder.getRestaurantOrders();
        
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
            Collection<OrderItem> orderItems = restaurantOrder.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                doStatistic(orderItem);
            }
        }
    }

    private void doStatistic(OrderItem item) {
        Integer id = item.getFood().getId();
        int quantity = item.getQuantity();
        
        OrderItem orderItem = foodStatistic.get(id);
        if(orderItem!=null){
            orderItem.addQuantity(quantity);
        }else{
            foodStatistic.put(id, new OrderItem(item));
        }
    }

    public void printStatistic(){
        System.out.println("\n");
        System.out.println("===STATISTIC===");
        for(OrderItem i:foodStatistic.values()){            
           System.out.println("Food:"+i.getFood().getName()+"("+i.getFood().getRestaurant().getName() +") quantity:"+i.getQuantity());
        }
    }
}

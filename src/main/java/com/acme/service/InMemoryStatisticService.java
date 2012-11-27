package com.acme.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.domain.OrderItem;

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent>{

    private Map<Integer, OrderItem> foodStatistic = new HashMap<Integer, OrderItem>();
    
    public void onApplicationEvent(OrderEvent e) {
        Collection<OrderItem> orderItems = e.getOrder().getOrderItems();
        for(OrderItem oi:orderItems){
         
            doStatistic(oi);
        }
    }

    private void doStatistic(OrderItem oi) {
        Integer id = oi.getFood().getId();
        int quantity = oi.getQuantity();
        
        OrderItem orderItem = foodStatistic.get(id);
        if(orderItem!=null){
            orderItem.addQuantity(quantity);
        }else{
            foodStatistic.put(id, oi);
        }
    }

    public void printStatistic(){
        System.out.println("===STATISTIC===");
        for(OrderItem i:foodStatistic.values()){            
           System.out.println("Food:"+i.getFood().getName()+"("+i.getFood().getRestaurant().getName() +") quantity:"+i.getQuantity());
        }
    }
}

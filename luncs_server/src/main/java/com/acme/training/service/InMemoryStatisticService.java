package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
 * őt kell implementálni, ha üziket akarunk fogadni
 * nem árt, ha component: a springnek kell példányosítania
 */

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent> {
    
    private Map<Integer, OrderItem> foods;
    
    public InMemoryStatisticService() {
        foods = new HashMap<Integer, OrderItem>();
    }
    
    public void onApplicationEvent(OrderEvent event) {
        CustomerOrder order = event.getOrder();
        OrderItem f;
        for ( OrderItem oi : order.getItems()) {
           if ( (f = foods.get(oi.getFoodId())) == null ) {
               foods.put(oi.getFoodId(), oi);
           } else {
               f.setCount( f.getCount() + oi.getCount() );
           }
        }
    }
    
    public void stats() {
        System.out.println("---------------------------------");
        for( Map.Entry<Integer, OrderItem> e : foods.entrySet()) {
            System.out.println(e.getValue());
        }
        System.out.println("---------------------------------");
    }

}

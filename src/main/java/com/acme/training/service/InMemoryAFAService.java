package com.acme.training.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryAFAService implements ApplicationListener<OrderEvent>{

    int total = 0;
    public void onApplicationEvent(OrderEvent event) {        
        Order order = event.getOrder();
        total += order.getTotal();
    }    
    public void doNAVStatistics(){
        System.out.println("===========AFA TOTAL===========");
        System.out.println("Osszes bevet : " + total);  
        System.out.println("AFA bevet : " + total * 0.2);
    }

}

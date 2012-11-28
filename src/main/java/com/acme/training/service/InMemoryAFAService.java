package com.acme.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class InMemoryAFAService implements ApplicationListener<OrderEvent>{
    
    @Value("${VAT}")
    double VAT;
    int total = 0;
    public void onApplicationEvent(OrderEvent event) {        
        CustomerOrder order = event.getOrder();
        total += order.getTotal();
    }    
    public void doNAVStatistics(){
        System.out.println("===========AFA TOTAL===========");
        System.out.println("Osszes bevet : " + total);  
        System.out.println("AFA bevet : " + total * VAT / 100);
    }

}

package com.acme.training.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NavService implements ApplicationListener<OrderEvent> {

    private int uberGrandTotal = 0;
    
    public void onApplicationEvent(OrderEvent event) {
        int orderTotal = event.getOrder().getGrandTotal();
        uberGrandTotal += orderTotal;
    }
    
    public int getUberGrandTotal() {
        return uberGrandTotal;
    }
    
    public double getTotalVAT() {
        return uberGrandTotal * 0.25;
    }

}

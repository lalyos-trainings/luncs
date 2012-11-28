package com.acme.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;

@Component
public class InMemoryNavService implements ApplicationListener<OrderEvent> {

    private int uberGrandTotal = 0;
    
    @Value("${vat}")
    private double vat;

    private Map<String, Integer> nav = new HashMap<String, Integer>();
    
    public void onApplicationEvent(OrderEvent event) {
        
        int orderTotal = event.getOrder().getTotal();
        
        uberGrandTotal += orderTotal;
    }
    
    public int getUberGrandTotal() {
        return uberGrandTotal;
    }
        
    public double getTotalVAT () {
        return uberGrandTotal * vat;
    }


}

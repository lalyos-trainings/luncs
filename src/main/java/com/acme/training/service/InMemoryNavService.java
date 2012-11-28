package com.acme.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;


@Component
public class InMemoryNavService implements ApplicationListener<OrderEvent> {
    
    @Value("${vat}")
    private int uberGrandTotal =0;
    private double vat;
    private Map<String, Integer> income = new HashMap<String, Integer>();
    
    public void onApplicationEvent(OrderEvent event) {
      
        int orderTotal = event.getCustomerOrder().getTotal();
        uberGrandTotal += orderTotal;
    }

    public int getUberGrandTotal() {
        return uberGrandTotal;
       
        
    }
        
    public double getTotalVAT(){
        
        return uberGrandTotal * vat;
   }

    public void printNav() {
        System.out.println("VAT: " + getTotalVAT());
        
    }    
        
}
    
    
   

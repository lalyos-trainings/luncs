package com.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InMemoryNAVService implements  ApplicationListener<OrderEvent> {

    private int uberGrandTotal;
    @Value("${vat}")
    private double vat;
    
    public void onApplicationEvent(OrderEvent event) {
        int total = event.getOrder().getGrandTotal();
        uberGrandTotal +=total;        
    }
    
    public int getUberGrandTotal(){
        return uberGrandTotal;
    }
    
    public double getTotalVAT(){
        return uberGrandTotal * vat;
    }
   
    
    public void printTotalVAT(){
        System.out.println(String.format("Total VAT:%f", getTotalVAT()));
    }

}

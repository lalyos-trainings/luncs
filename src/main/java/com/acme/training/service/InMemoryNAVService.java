package com.acme.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InMemoryNAVService implements ApplicationListener<OrderEvent>{
    
    private double totalIncome = 0;
    @Value("${vat}")
    private double vat;

    public void onApplicationEvent(OrderEvent event) {
        totalIncome += event.getOrder().getTotal();
    }

    public void printIncome() {
        System.out.println("==== NAV Statistics:");
        System.out.println(String.format("Total income: %.2f\nVAT: %.2f" , totalIncome, totalIncome * vat));
    }


}

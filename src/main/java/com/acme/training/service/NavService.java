package com.acme.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NavService implements ApplicationListener<OrderEvent> {

    @Value("${vat}")
    private double vat;
    private int uberGrandTotal = 0;

    public void onApplicationEvent(OrderEvent event) {
        int orderTotal = event.getOrder().getTotal();
        uberGrandTotal += orderTotal;
    }

    public int getUberGrandTotal() {
        return uberGrandTotal;
    }

    public double getTotalVAT() {
        return uberGrandTotal * vat;
    }

}

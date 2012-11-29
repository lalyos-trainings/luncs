package com.acme.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NavService implements ApplicationListener<RestaurantOrderEvent> {

    @Value("${vat}")
    private double vat;
    private int uberGrandTotal = 0;
    
    public void onApplicationEvent(RestaurantOrderEvent event) {
        int orderTotal = event.getRestaurantOrder().getTotal();
        uberGrandTotal += orderTotal;

        System.out.println( "****** NAVSERVICE (event) ******" );
        System.out.println( String.format( "Restaurant: %-15s  VAT total: %6s", event.getRestaurantOrder().getRestaurant().getName(), getTotalVAT() ));
    }
    
    public int getUberGrandTotal() {
        return uberGrandTotal;
    }
    
    public double getTotalVAT() {
        return uberGrandTotal * vat;
    }

}

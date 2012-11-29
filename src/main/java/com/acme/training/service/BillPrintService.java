package com.acme.training.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BillPrintService implements ApplicationListener<CustomerOrderEvent> {

    @Override
    public void onApplicationEvent(CustomerOrderEvent event) {

        System.out.println( "****** BILLSERVICE (event) ******" );
        event.getCustomerOrder().printBill();
        
    }

}

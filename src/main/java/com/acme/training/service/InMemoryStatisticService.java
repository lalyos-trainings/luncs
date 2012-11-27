package com.acme.training.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
 * őt kell implementálni, ha üziket akarunk fogadni
 * nem árt, ha component: a springnek kell példányosítania
 */

@Component
public class InMemoryStatisticService implements ApplicationListener<OrderEvent> {

    public void onApplicationEvent(OrderEvent event) {
        System.out.println("============== msg: " + event);
    }

}

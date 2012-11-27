package com.acme.training.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.OrderItem;
import com.acme.training.domain.Restaurant;

@Component
public class InMemoryNavService implements ApplicationListener<OrderEvent> {
    private final Map<Restaurant, Integer> rests = new HashMap<Restaurant, Integer>();
    @Value("${nav.vat}")
    private double vat;

    public void onApplicationEvent(OrderEvent oe) {
        for (OrderItem oi : oe.getOrder().getOrderItems()) {
            handleOrderItem(oi);
        }
    }

    private void handleOrderItem(OrderItem oi) {
        Restaurant r = oi.getFood().getRestaurant();
        Integer price = oi.getQuantity() * oi.getFood().getPrice();
        if (rests.containsKey(r)) {
            Integer oldPrice = rests.get(r);
            price += oldPrice;
        }
        rests.put(r, price);
    }

    public void printNav() {
        System.out.println("=== NAV");
        for (Restaurant r : rests.keySet()) {
            System.out.println(String.format("%20s: %6d", r.getName(), rests.get(r)));
        }
    }

    public void printVat() {
        System.out.println("=== NAV");
        for (Restaurant r : rests.keySet()) {
            System.out.println(String.format("%20s: %6f", r.getName(), rests.get(r) * vat));
        }
    }
}

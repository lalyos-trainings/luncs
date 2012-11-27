package com.acme.training.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.ordermodel.OrderItem;

@Component
public class NavService implements ApplicationListener<OrderEvent> {
    
    @Value("${vat}")
    private float vat;

    private Map<String, Integer> incomeMap = new HashMap<String, Integer>();

    public void onApplicationEvent(OrderEvent event) {
        List<OrderItem> items = event.getOrder().getItems();
        for (OrderItem item : items) {
            countIncome(item);
        }
    }

    private void countIncome(OrderItem item) {
        String resName = item.getFood().getRestaurant().getName();
        Integer incoming = item.getFood().getPrice();
        int q = item.getQuantity();

        if (incomeMap.containsKey(item.getFood().getRestaurant().getName())) {
            Integer income = incomeMap.get(resName);

            incomeMap.remove(resName);

            income += (incoming * q);
            incomeMap.put(resName, income);
        } else {
            incomeMap.put(resName, incoming*q);
        }
    }

    public void printTotal() {
        System.out.println("==== TOTAL:");
        for (String res : incomeMap.keySet()) {
            int all=incomeMap.get(res);
            System.out.println(String.format(" Restaurant: %15s [Income %8d] Vat: %6.3f", res, all, all*vat));
        }
    }
}

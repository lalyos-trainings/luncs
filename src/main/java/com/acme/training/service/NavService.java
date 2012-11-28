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
public class NavService implements ApplicationListener<OrderEvent> {

    @Value("${nav.vat}")
    private float VAT;
    Map<Restaurant, Integer> incomes = new HashMap<Restaurant, Integer>();
    public void onApplicationEvent(OrderEvent event) {
        List<OrderItem> items = event.getOrder().getItems();
        for (OrderItem item : items) {
            addIncome(item);
        }
    }
    
    private void addIncome(OrderItem item) {
       Restaurant restaurant = item.getFood().getRestaurant();
       
       if(incomes.containsKey(restaurant)){
           Integer income = incomes.get(restaurant);
           income += item.getFood().getPrice()*item.getQuantity();
           incomes.remove(restaurant);
           incomes.put(restaurant, income);
       } else {
           incomes.put(restaurant, item.getFood().getPrice()*item.getQuantity());
       }
    }
    
    public void printIncomes() {
        System.out.println("==== INCOMES:");
        int total = 0;
        for (Restaurant resti : incomes.keySet()) {
            total += incomes.get(resti);
            System.out.println(String.format(" %20s : %-4d" , resti.getName(), incomes.get(resti)));
        }
        System.out.println(String.format(" %20s : %-4d %-4s" ,"Total",total, " HUF"));
        System.out.println(String.format(" %20s : %-4.1f %-4s" ,"VAT",VAT*total, " HUF"));
    }

}

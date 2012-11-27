package com.acme.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.domain.OrderItem;
import com.acme.domain.Restaurant;

@Component
public class InMemoryNAVService implements  ApplicationListener<OrderEvent> {

    private Map<String, Integer> incomeMap = new HashMap<String, Integer>();
    private int uberGrandTotal;
    
    
    public void onApplicationEvent(OrderEvent event) {
        int total = event.getOrder().getGrandTotal();
        uberGrandTotal +=total;        
    }

    private void addToPriceList(OrderItem oi) {
        Restaurant rest = oi.getFood().getRestaurant();
        Integer price = incomeMap.get(rest);
        if(price!=null){
            incomeMap.put(rest.getName(), price+oi.getFood().getPrice());
            
        }else{
            incomeMap.put(rest.getName(), oi.getFood().getPrice());
        }
    }
    
    public int getUberGrandTotal(){
        return uberGrandTotal;
    }
    
    public double getTotalVAT(){
        return uberGrandTotal * 0.25;
    }
    
    public void printRestaurantsIncome(){
//        System.out.println("===RESTAURANT INCOME===");
//        Iterator it = incomeMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pairs = (Map.Entry)it.next();
//            System.out.println(pairs.getKey() + " = " + pairs.getValue());
//        }      
        
    }
    
    public void printTotalVAT(){
        System.out.println(String.format("Total VAT:%f", getTotalVAT()));
    }

}

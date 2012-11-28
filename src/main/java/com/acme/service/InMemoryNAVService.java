package com.acme.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.domain.RestaurantOrder;

@Component
public class InMemoryNAVService implements  ApplicationListener<OrderEvent> {

    @Value("${vat}")
    private double vat;
    private Map<String, Integer> incomeMap = new HashMap<String, Integer>();
    
    
    public void onApplicationEvent(OrderEvent event) {        
        
        Collection<RestaurantOrder> restaurantOrders = event.getCustomerOrder().getRestaurantOrders();
        for (RestaurantOrder restaurantOrder : restaurantOrders) {
           computeTotalPerRestaurant(restaurantOrder);
        }
    }
    
    private void computeTotalPerRestaurant(RestaurantOrder restaurantOrder){
        String restName = restaurantOrder.getRestaurant().getName();
        
        if (incomeMap.containsKey(restName)){
            Integer totalSoFar = incomeMap.get(restName);
            int total2 = restaurantOrder.getTotal();                
            incomeMap.put(restName, totalSoFar + total2);
        }else{            
            int total = restaurantOrder.getTotal();                
            incomeMap.put(restName, total);
        }
    }
    
    public Map<String, Integer> getTotalPerRestaurant(){
        return incomeMap;
    }
    
   
    public void printTotalVAT(){
        System.out.println("\n");
        System.out.println("====VAT====");
        for(Entry<String, Integer> entry : incomeMap.entrySet()) {
            String rest  = entry.getKey();
            Double vatValue = entry.getValue() * vat;            
            System.out.println(String.format("Restaurant:%s VAT:%f", rest,vatValue));
        }
    }

}

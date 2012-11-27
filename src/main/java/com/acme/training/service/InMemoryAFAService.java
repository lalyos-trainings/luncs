package com.acme.training.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Order;

@Component
public class InMemoryAFAService implements ApplicationListener<OrderEvent>
{
    private Map<String, Integer> incomes = new HashMap<String, Integer>(); 
    
    public void onApplicationEvent(OrderEvent event)
    {
        Order order = event.getOrder();
        String customer = order.getCustomer();
        
        Integer total = incomes.get(customer);
        
        if (total != null)
        {
            incomes.put(customer, total + order.getTotal());
        }
        else
        {
            incomes.put(customer, order.getTotal());
        }
            
    }

    public void doAFA()
    {
        System.out.println("=== ÁFA ===");
        
        Iterator<Entry<String, Integer>> iterator = incomes.entrySet().iterator();
        while (iterator.hasNext() == true)
        {
            Entry<String, Integer> next = iterator.next();
            
            int total = next.getValue();
            double afa = total * 0.27;
            
            System.out.println(String.format("%-12s : %10d    YEN ÁFA: %10g YEN", next.getKey(), total, afa));
        }
    }
}

package com.acme.training.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;

@Component
public class InMemoryAFAService implements ApplicationListener<OrderEvent>
{
    private static final Logger logger = LoggerFactory.getLogger(InMemoryAFAService.class);
    
    @Value("${vat}")
    private double vat;
    
    private Map<String, Integer> incomes = new HashMap<String, Integer>(); 
    
    public void onApplicationEvent(OrderEvent event)
    {
        CustomerOrder order = event.getCustomerOrder();
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

    public void printAFA()
    {
        logger.info("=== ÁFA ===");
        
        Iterator<Entry<String, Integer>> iterator = incomes.entrySet().iterator();
        while (iterator.hasNext() == true)
        {
            Entry<String, Integer> next = iterator.next();
            
            int total = next.getValue();
            double afa = total * vat / 100.0;
            
            logger.info(String.format("%-12s : %10d    YEN ÁFA (%.2g %%): %10g YEN", next.getKey(), total, vat, afa));
        }
    }
}

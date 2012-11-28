package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.MenuLister;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        MenuLister lister = ctx.getBean(MenuLister.class);
        
        lister.doList();
        
        InMemoryStatisticService iMSS =  ctx.getBean(InMemoryStatisticService.class);
        iMSS.printStatistic();
        
    }

}

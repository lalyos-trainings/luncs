package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.MenuLister;

public class BundlePlay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml",
                "orders.xml");
        MenuLister ml = ctx.getBean(MenuLister.class);

        ml.doList();
    }
}

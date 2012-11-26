package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.service.MenuLister;

public class BundlePlay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "chinchung.xml");
        MenuLister ml = ctx.getBean(MenuLister.class);

        String msg = ctx.getMessage("welcome", null, new Locale("hu"));
        System.out.println(msg);

        ml.doList();
    }
}

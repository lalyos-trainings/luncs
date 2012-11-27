package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Restaurant;


public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware {

    private PrintWriter writer;
    
    @Autowired
    @Qualifier("xmlRepository")
    private RestaurantRepository repo;
    private ApplicationContext context;
    
    /*
     * String, locale, meg alap típusnak számító típusnak lehet kezdő értéket adni
     * ekkor a setter meg a getter *nem* *fut* *le*!!!
     * 
     */
    @Value("de")
    private Locale locale;
    
/*    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        System.out.println("************************>>>>>>>>>>> " + locale);
    }*/

    public PrintWriterMenuLister(PrintWriter writer) {
        this.writer = writer;
    }
    
    public void doList() {
        System.out.println(context.getMessage("welcome", null, locale));
        for (Restaurant restaurant : repo.getAllRestaurants()) {
            writer.println("=== " + context.getMessage("next_restaurant", null, locale) + ": " + restaurant);
        }
    }

    public RestaurantRepository getRepo() {
        return repo;
    }

    public void setRepo(@Qualifier("xmlRepository") RestaurantRepository repo) {
        this.repo = repo;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}

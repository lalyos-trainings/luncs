package com.acme.training.service;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;

@Component("printWriter")
public class PrintWriterMenuLister implements MenuLister, ApplicationContextAware{

    @Autowired
    @Qualifier("memoryRest")
    private RestaurantRepository repo;
    private PrintWriter printWriter;
    @Value("hu")
    private Locale locale;
    private ApplicationContext applicationContext;
    
    public PrintWriterMenuLister(){
        super();
    }
    
    public PrintWriterMenuLister(PrintWriter printWriter){
        this.printWriter = printWriter;
    }
    
    public void setRepo(RestaurantRepository repo) {
        this.repo = repo;
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void doList() {
        String msg = applicationContext.getMessage("welcome", null, locale);
        printWriter.println(msg);
        for(Restaurant restaurant :  repo.getAllRestaurants()){
            printWriter.println("============================");
            printWriter.println(restaurant);
            printWriter.println("----------------------------");
            printWriter.println(restaurant.getMenu());
            Collection<Food> foods = restaurant.getMenu().getFoods();
            for(Food food : foods){
                printWriter.println(food);
            }
            printWriter.println();
        }
        printWriter.flush();
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

}

package com.acme.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Food;
import com.acme.training.service.MenuLister;
import com.acme.training.service.RestaurantRepository;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        
        MenuLister lister = ctx.getBean(MenuLister.class);
        
        lister.doList();
        
        RestaurantRepository repository = (RestaurantRepository)ctx.getBean("xmlRepo");
        System.out.println("Repo.class : " + repository.getClass());
        int foodId = 101;
        Food food = repository.findFoodById(foodId);
        System.out.format("Food with id: %d = %s", foodId, food.getName());
        
    }

}

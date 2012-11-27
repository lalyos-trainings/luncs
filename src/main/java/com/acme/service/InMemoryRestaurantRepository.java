package com.acme.service;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.acme.domain.Food;
import com.acme.domain.Menu;
import com.acme.domain.Restaurant;

@Component("memoryRepo")
@Qualifier("memory")
public class InMemoryRestaurantRepository extends AbstractRestaurantRepository implements BeanNameAware {

    public InMemoryRestaurantRepository() {
        addRestaurant(createResti1());
        addRestaurant(createResti2());        
    }
    
    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        Food f1 = new Food(1, "pacal", 500);
        Food f2 = new Food(2, "toltott kaposzta",750);
        Food f3 = new Food(3, "bableves", 690);
        m1.getFoods().add(f1);
        m1.getFoods().add(f2);
        m1.getFoods().add(f3);
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        
        Food f1 = new Food(4, "lencse leves", 400);
        Food f2 = new Food(5, "gyros",850);
        Food f3 = new Food(6, "baklava", 300);
        
        m1.getFoods().add(f1);
        m1.getFoods().add(f2);
        m1.getFoods().add(f3);
        foodList.add(f1);
        foodList.add(f2);
        foodList.add(f3);
        return r1;
    }

    public void setBeanName(String arg0) {
        // TODO Auto-generated method stub
        
    }
}

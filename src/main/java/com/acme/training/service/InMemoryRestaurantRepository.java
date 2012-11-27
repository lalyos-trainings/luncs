package com.acme.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

@Component("memoryRest")
@Scope("singleton")
public class InMemoryRestaurantRepository extends AbstractRestaurantRepository implements BeanNameAware {

    private Locale locale;

    public InMemoryRestaurantRepository() {
        super();
        generateTestInstances();
    }

    public void addRestaurant(String key, Restaurant restaurant) {
        restaurantMap.put(key, restaurant);
        registerFoods(restaurant);
    }

    public void removeRestaurant(String key) {
        restaurantMap.remove(key);
    }

//    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
//        this.restaurantMap = restaurantMap;
//    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    private void generateTestInstances() {
        Restaurant r1 = new Restaurant("Csing-csang");
        Address a1 = new Address("1082", "Ulloi ut");
        r1.setAddress(a1);
        Collection<Food> foods1 = new ArrayList<Food>();
        foods1.add(new Food("szezamos csirke", 850, "Csirkemell darabok szezamos-mezes-csipos bundaban.", r1));
        foods1.add(new Food("edes-savanyu", 650, "-", r1));
        foods1.add(new Food("leves", 350, "Kinai leves.", r1));
        Menu m1 = new Menu(foods1, 1);
        r1.setMenu(m1);

        Restaurant r2 = new Restaurant("KFC");
        Address a2 = new Address("1082", "Corvin negyed");
        r2.setAddress(a2);
        Collection<Food> foods2 = new ArrayList<Food>();
        foods2.add(new Food("csirkeszarny", 750, "Csirkeszarny csipos bundaban.", r2));
        foods2.add(new Food("csirkecomb", 950, "Rantott csirkecomb.", r2));
        foods2.add(new Food("libamaj", 1450, "Sult libamaj.", r2));
        Menu m2 = new Menu(foods2, 1);
        r2.setMenu(m2);
        
        addRestaurant("elso", r1);
        addRestaurant("masodik", r2);
    }


}

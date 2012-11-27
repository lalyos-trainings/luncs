package com.acme.training.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

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
    }

    public void removeRestaurant(String key) {
        restaurantMap.remove(key);
    }

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    private void generateTestInstances() {
        Address a1 = new Address("1082", "Ulloi ut");
        Collection<Food> foods1 = new ArrayList<Food>();
        foods1.add(new Food("szezamos csirke", 850, "Csirkemell darabok szezamos-mezes-csipos bundaban."));
        foods1.add(new Food("edes-savanyu", 650, "-"));
        foods1.add(new Food("leves", 350, "Kinai leves."));
        Menu m1 = new Menu(foods1, 1);
        Restaurant r1 = new Restaurant("Csing-csang", a1, m1);

        Address a2 = new Address("1082", "Corvin negyed");
        Collection<Food> foods2 = new ArrayList<Food>();
        foods2.add(new Food("csirkeszarny", 750, "Csirkeszarny csipos bundaban."));
        foods2.add(new Food("csirkecomb", 950, "Rantott csirkecomb."));
        foods2.add(new Food("libamaj", 1450, "Sult libamaj."));
        Menu m2 = new Menu(foods2, 1);
        Restaurant r2 = new Restaurant("KFC", a2, m2);

        restaurantMap.put("elso", r1);
        restaurantMap.put("masodik", r2);
    }


}

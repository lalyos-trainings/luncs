package com.acme.training.service;

import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;

@Component("repo")
public class InMemoryRestaurantRepository extends AbstractRestaurantRepository implements BeanNameAware {

    public InMemoryRestaurantRepository() {
        addRestaurant(createResti1());
        addRestaurant(createResti2());
    }

    private void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getName(), restaurant);
        registerFoods(restaurant);
    }

    private Restaurant createResti1() {
        Restaurant r1 = new Restaurant("Ancsa", "Futo utca 52", "1082");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("pacal", 500));
        m1.getFoods().add(new Food("toltott kaposzta", 750));
        m1.getFoods().add(new Food("bableves", 690));
        return r1;
    }

    private Restaurant createResti2() {
        Restaurant r1 = new Restaurant("Szeraj ", "Korut 99", "1122");
        Menu m1 = new Menu();
        r1.setMenu(m1);
        m1.setWeek(34);
        m1.getFoods().add(new Food("lencse leves", 400));
        m1.getFoods().add(new Food("gyros", 850));
        m1.getFoods().add(new Food("baklava", 300));
        return r1;
    }
}

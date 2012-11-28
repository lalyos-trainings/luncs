package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.Food;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.RestaurantRepository;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class OrderWS {

    @Autowired
    private RestaurantRepository repo;

    @Autowired
    private ApplicationContext ctx;

    private List<Food> foods = new ArrayList<Food>();
    private List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
    private Map<Integer, ShoppingCart> shoppingCarts = new HashMap<Integer, ShoppingCart>();
    private Logger logger = LoggerFactory.getLogger(InMemoryStatisticService.class);

    public void init() {

        Collection<Restaurant> restaurants = repo.getAllRestaurants();
        for (Restaurant restaurant : restaurants) {
            Collection<Food> foods2 = restaurant.getMenu().getFoods();
            for (Food food : foods2) {
                foods.add(food);
            }
        }
    }

    public OrderWS() {
    }

    @WebMethod
    public Integer getShoppingCart(String customer) {
        ShoppingCart cart = ctx.getBean(ShoppingCart.class);
        cart.withCustomer(customer);
        shoppingCarts.put(cart.getId(), cart);
        return cart.getId();
    }

    @WebMethod
    public boolean addFood(Integer scId, Integer foodId, Integer quantity) {
        logger.info("cart ID: " + scId + " food: " + foodId + " quantity: " + quantity);
        ShoppingCart cart = shoppingCarts.get(scId);
        if (cart != null) {
            cart.withFood(foodId, quantity);
            return true;
        } else {
            return false;
        }
    }

    @WebMethod
    public boolean setDeliveryAddress(Integer scId, String street, String city, String zip, String country) {
        logger.info("cart ID: " + scId);
        ShoppingCart cart = shoppingCarts.get(scId);
        if (cart != null) {
            cart.withDeliveryAddress(new Address(street, city, zip, country));
            return true;
        } else {
            return false;
        }
    }

    @WebMethod
    public List<Food> getFoods() {
        return foods;
    }

    @WebMethod
    public Integer checkout(Integer scId) {
        ShoppingCart cart = shoppingCarts.get(scId);
        return cart.checkout();
    }

}

package com.acme.training.ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Order;
import com.acme.training.domain.Restaurant;
import com.acme.training.domain.UserInfo;
import com.acme.training.service.InMemoryRegistrationService;
import com.acme.training.service.OrderService;
import com.acme.training.service.RestaurantRepository;
import com.acme.training.service.ShoppingCart;

@WebService
@Component
public class MenuWS {

    @Autowired
    private RestaurantRepository repo;
    @Autowired
    private InMemoryRegistrationService inMemoryRegistrationService;
    @Autowired
    OrderService orderService;
    @Autowired
    ApplicationContext ctx;
    private List<Food> foods = new ArrayList<Food>();
    private Map<String, ShoppingCart> carts = new HashMap<String, ShoppingCart>();
    
        
    public void init() {
        Collection<Restaurant> restaurants = repo.getAllRestaurants();
        for (Restaurant restaurant : restaurants) {
            Collection<Food> foods2 = restaurant.getMenu().getFoods();
            for (Food food : foods2) {
                foods.add(food);
            }
        }        
    }

    @WebMethod(action="act_getFoods")
    public List<Food> getFoods() {
        return foods;
    }
    
    @WebMethod(action="act_registerUser_1")
    public String registerUser_oneAddr(
            @WebParam(name = "wp_userName")             String userName,

            @WebParam(name = "wp_addr_street")          String addr_street,
            @WebParam(name = "wp_addr_city")            String addr_city,
            @WebParam(name = "wp_addr_zip")             String addr_zip,
            @WebParam(name = "wp_addr_country")         String addr_country
            ) {
        return registerUser_twoAddr(userName,
                                addr_street, addr_city, addr_zip, addr_country,
                                addr_street, addr_city, addr_zip, addr_country);
    }

    private void newShoppingCart(UserInfo userInfo) {
        carts.remove(userInfo.getUserName());
        
        ShoppingCart newCart = ctx.getBean(ShoppingCart.class);
        newCart.withCustomer(userInfo);
        carts.put(userInfo.getUserName(), newCart);
    }
    
    @WebMethod(action="act_registerUser_2")
    public String registerUser_twoAddr(
            @WebParam(name = "wp_userName")             String userName,
            
            @WebParam(name = "wp_billingAddr_street")   String billingAddr_street,
            @WebParam(name = "wp_billingAddr_city")     String billingAddr_city,
            @WebParam(name = "wp_billingAddr_zip")      String billingAddr_zip,
            @WebParam(name = "wp_billingAddr_country")  String billingAddr_country,
            
            @WebParam(name = "wp_deliveryAddr_street")  String deliveryAddr_street,
            @WebParam(name = "wp_deliveryAddr_city")    String deliveryAddr_city,
            @WebParam(name = "wp_deliveryAddr_zip")     String deliveryAddr_zip,
            @WebParam(name = "wp_deliveryAddr_country") String deliveryAddr_country
            ) {
        Integer userId = inMemoryRegistrationService.registerUser(
                                userName,
                                new Address(billingAddr_street, billingAddr_city, billingAddr_zip, billingAddr_country), 
                                new Address(deliveryAddr_street, deliveryAddr_city, deliveryAddr_zip, deliveryAddr_country));
        
        if (userId == null) {
            return String.format("Registration for [%s] failed. Please try with a different user name.", userName);
        } else {
            UserInfo userInfo = inMemoryRegistrationService.getUserInfo(userName);
            newShoppingCart(userInfo);
            
            return String.format("Registration for [%s] succeeded. Id: [%d]", userName, userId);
        }
    }

    @WebMethod(action="act_setBillingAddr")
    public String setBillingAddr(
            @WebParam(name = "wp_userName")             String userName,

            @WebParam(name = "wp_addr_street")          String newAddr_street,
            @WebParam(name = "wp_addr_city")            String newAddr_city,
            @WebParam(name = "wp_addr_zip")             String newAddr_zip,
            @WebParam(name = "wp_addr_country")         String newAddr_country) {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(userName);
        if (userInfo == null) {
            return String.format("Nobody registered as [%s]", userName);
        }
        
        Address addr = userInfo.getBillingAddr();
        addr.setStreet(newAddr_street);
        addr.setCity(newAddr_city);
        addr.setZip(newAddr_zip);
        addr.setCountry(newAddr_country);
        
        return "Billing address successfully changed";
    }

    @WebMethod(action="act_setDeliveryAddr")
    public String setDeliveryAddr(
            @WebParam(name = "wp_userName")             String userName,

            @WebParam(name = "wp_addr_street")          String newAddr_street,
            @WebParam(name = "wp_addr_city")            String newAddr_city,
            @WebParam(name = "wp_addr_zip")             String newAddr_zip,
            @WebParam(name = "wp_addr_country")         String newAddr_country) {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(userName);
        if (userInfo == null) {
            return String.format("Nobody registered as [%s]", userName);
        }
        
        Address addr = userInfo.getDeliveryAddr();
        addr.setStreet(newAddr_street);
        addr.setCity(newAddr_city);
        addr.setZip(newAddr_zip);
        addr.setCountry(newAddr_country);
        
        return "Delivery address successfully changed";
    }

    @WebMethod(action="act_listShoppingChart")
    public String listShoppingChart(
            @WebParam(name = "wp_userName")             String userName
            ) {
        ShoppingCart cart = carts.get(userName);
        
        return String.format("%s's cart contains the following foods:\n%s", userName, cart.getItems());
    }

    @WebMethod(action="act_addShoppingCart_1")
    public String addShoppingCart_1(
            @WebParam(name = "wp_userName")             String userName,
            @WebParam(name = "wp_foodId")               int foodId
            ) {
        return addShoppingCart_x(userName, foodId, 1);
    }

    @WebMethod(action="act_addShoppingCart_x")
    public String addShoppingCart_x(
            @WebParam(name = "wp_userName")             String userName,
            @WebParam(name = "wp_foodId")               int foodId,
            @WebParam(name = "wp_quantity")             int quantity
            ) {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(userName);
        if (userInfo == null) {
            return String.format("Nobody registered as [%s]", userName);
        }
        ShoppingCart cart = carts.get(userInfo.getUserName());
        
        cart.withFood(foodId, quantity);
        
        return listShoppingChart(userName);
    }

    @WebMethod(action="act_checkOutOrder")
    public String checkOutOrder(
            @WebParam(name = "wp_userName")             String userName
            ) {
        UserInfo userInfo = inMemoryRegistrationService.getUserInfo(userName);
        if (userInfo == null) {
            return String.format("Nobody registered as [%s]", userName);
        }
        String overall = listShoppingChart(userName) +
                "\n  - Delivery addr.: " + userInfo.getDeliveryAddr() +
                "\n  - Billing addr.:  " + userInfo.getBillingAddr();
        
        carts.get(userInfo.getUserName()).checkout();
        
        newShoppingCart(userInfo);
        
        return overall;
    }
    
}

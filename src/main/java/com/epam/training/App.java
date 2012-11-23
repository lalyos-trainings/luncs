package com.epam.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.domain.Address;
import com.epam.training.domain.Food;
import com.epam.training.domain.Menu;
import com.epam.training.domain.Restaurant;
import com.epam.training.service.InMemoryOrderService;
import com.epam.training.service.MenuLister;
import com.epam.training.service.Order;
import com.epam.training.service.OrderService;
import com.epam.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "meki.xml");
        
//        MenuLister lister = context.getBean(MenuLister.class);
        
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        
        cart.setCustomer("joska");
        cart.setDeliveryAddress(new Address("ahol lakom", "bp", "1032", "hun"));
        cart.setBillingAddress(new Address("ahol lakom", "bp", "1032", "hun"));
        
        OrderService os = context.getBean(InMemoryOrderService.class);
        
        Restaurant kfc = (Restaurant) context.getBean("kfc");
        Menu kfc_menu = kfc.getMenu();
        Food f = kfc_menu.getFood(1);
        cart.addFood(f.getId(), 3);
        
        os.doOrder( cart.checkout() );
        
        cart = context.getBean(ShoppingCart.class);
        cart.setCustomer("geza");
        cart.setDeliveryAddress(new Address("ahol geza lakik", "bp", "1032", "hun"));
        cart.setBillingAddress(new Address("ahol geza lakik", "bp", "1032", "hun"));
        
        Restaurant meki = (Restaurant) context.getBean("meki");
        Menu meki_menu = meki.getMenu();
        f = meki_menu.getFood(0);
        cart.addFood(f.getId(), 2);
        
        os.doOrder( cart.checkout() );
        
        List<Order> l = os.getAllOrders();
        
        for (Order o : l) {
            System.out.println(
                    String.format("%n%norder: %s", o)
            );
        }
        
        
    }

}

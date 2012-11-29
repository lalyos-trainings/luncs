package com.acme.training;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.domain.Address;
import com.acme.training.domain.Food;
import com.acme.training.domain.Menu;
import com.acme.training.domain.Restaurant;
import com.acme.training.service.InMemoryBillingService;
import com.acme.training.service.InMemoryOrderService;
import com.acme.training.service.InMemoryStatisticService;
import com.acme.training.service.MenuLister;
import com.acme.training.service.CustomerOrder;
import com.acme.training.service.OrderService;
import com.acme.training.service.ShoppingCart;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "meki.xml");
        
        
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        
        cart.setCustomer("joska");
        cart.setDeliveryAddress(new Address("ahol lakom", "bp", "1032", "hun"));
        cart.setBillingAddress(new Address("ahol lakom", "bp", "1032", "hun"));
        OrderService os = context.getBean(InMemoryOrderService.class);
        
        Restaurant kfc = (Restaurant) context.getBean("kfc");
        Menu kfc_menu = kfc.getMenu();
        Food f = kfc_menu.getFood(1);
        
        
        cart.addFood(f, 3);
        
        System.out.println( cart.checkout() );
        
        os.doOrder( cart.checkout() );
        
        cart = context.getBean(ShoppingCart.class);
        cart.setCustomer("geza");
        cart.setDeliveryAddress(new Address("ahol geza lakik", "bp", "1032", "hun"));
        cart.setBillingAddress(new Address("ahol geza lakik", "bp", "1032", "hun"));
        
        Restaurant meki = (Restaurant) context.getBean("meki");
        Menu meki_menu = meki.getMenu();
        f = meki_menu.getFood(0);
        cart.addFood(f, 2);
        
        os.doOrder( cart.checkout() );
        
        System.out.println(context.getMessage("welcome", null, new Locale("hu_RO")));
        
        MenuLister lister = (MenuLister) context.getBean("menuLister");
        lister.doList();
        
        for (CustomerOrder o : os.getAllOrders()) {
            System.out.println(
                    String.format("%n%norder: %s", o)
            );
        }
        
        InMemoryStatisticService stats = context.getBean(InMemoryStatisticService.class);
        stats.stats();
        
        InMemoryBillingService bill = context.getBean(InMemoryBillingService.class);
        bill.stats();
        
    }

}

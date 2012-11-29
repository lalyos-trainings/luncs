package com.acme.training;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.RestaurantWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");

        // MenuWS menuWS = ctx.getBean(MenuWS.class);
        // Endpoint.publish("http://localhost:8081/menu", menuWS);

        // RestaurantWS restiWS = ctx.getBean(RestaurantWS.class);
        // Endpoint.publish("http://localhost:8080/resti", restiWS);

        ShoppingCartWS scWS = ctx.getBean(ShoppingCartWS.class);
        Endpoint.publish("http://localhost:8082/sc", scWS);

    }

}
package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {
	
    public static void main(String[] args) throws UnknownHostException{
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
    	
    	MenuWS menuWS = ctx.getBean(MenuWS.class);
    	ShoppingCartWS cartWS = ctx.getBean(ShoppingCartWS.class);
        
		String urlMenu = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/menu";
		String urlCart = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/cart";
		System.out.format("A menu a %s címen figyel\n\n", urlMenu);
		System.out.format("A cart a %s címen figyel\n\n", urlCart);
		
		Endpoint.publish(urlMenu, menuWS).publish(urlCart, cartWS);
    }

}
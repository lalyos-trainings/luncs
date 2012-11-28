package com.acme.training;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.MenuWS;
import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MenuWS menuWs = new MenuWS();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
		
		MenuWS menuWs = context.getBean(MenuWS.class);
		Endpoint.publish("http://localhost:8080/menu", menuWs);
		
		ShoppingCartWS scWS = context.getBean(ShoppingCartWS.class);
		Endpoint.publish("http://localhost:8080/sc", scWS);
	}

}

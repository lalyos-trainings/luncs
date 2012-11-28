package com.acme.training;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.training.ws.ShoppingCartWS;

public class WebServiceBootStrap {

    /**
     * @param args
     * @throws UnknownHostException 
     */
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "kfc.xml", "csing.xml");
        ShoppingCartWS scws = context.getBean(ShoppingCartWS.class);
        
//        Integer scId1 = scws.getShoppingCart("Csaba");
//        Integer scId2 = scws.getShoppingCart("Ödön");
//
//        
//        scws.addFood(scId1, 101, 5);
//        scws.addFood(scId1, 101, 5);
//        scws.addFood(scId1, 202, 3);
//        scws.setDeliveryAddress(scId1, "Budapest", "1084", "Futo", "H");
//        scws.checkout(scId1);
//        
//        scws.addFood(scId2, 101, 5);
//        scws.addFood(scId2, 101, 5);
//        scws.addFood(scId2, 202, 3);
//        scws.setDeliveryAddress(scId2, "Budapest", "1043", "Aradi", "H");
//        scws.checkout(scId2);
        
        InetAddress local = InetAddress.getLocalHost();
        Endpoint.publish("http://" +local.getHostAddress() +":8080/menu", scws);
        System.out.println(local.getHostAddress());
        
        
//        OrderService orderService = context.getBean(OrderService.class);
//        for (CustomerOrder order : orderService.getAllOrder()) {
//            order.printBill();
//        }
    }

}

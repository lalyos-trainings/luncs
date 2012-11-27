package com.acme.training;

import javax.xml.ws.Endpoint;

import com.acme.training.ws.MenuWebService;

public class WebServiceBootStrap {

    public static void main(String[] args) {
        MenuWebService menuWebService = new MenuWebService();
        Endpoint.publish("http://localhost:8081/menu", menuWebService);
    }
}

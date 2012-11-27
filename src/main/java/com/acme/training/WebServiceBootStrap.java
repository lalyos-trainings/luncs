package com.acme.training;

import com.acme.training.ws.MenuWS;

public class WebServiceBootStrap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MenuWS menuWS = new MenuWS();
        Endpoint.publish("http://localhost:8080/menu", new AddressesWS(menuService));

    }

}

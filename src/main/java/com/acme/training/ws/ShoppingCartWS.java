package com.acme.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService
@Component
public class ShoppingCartWS {
    public void init() {
        
    }
    
    public ShoppingCartWS() {
    }
    
    @WebMethod
    public boolean isTheCakeALie() {
        return true;
    }

}

package com.acme.training.ws;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.service.OrderService;

@WebService
@Component
public class OrdersWS {
    
    @Autowired
    private ApplicationContext context;
    
    private Logger logger = LoggerFactory.getLogger(ShoppingCartWS.class);
    
    public void init() {
        
    }
    
    public OrdersWS() {
        
    }
    
    @WebMethod   
    @WebResult(name="CartID")
    public Collection<CustomerOrder> getAllCustomerOrdersRaw() {
        OrderService orderService = context.getBean(OrderService.class);
        return orderService.getAllOrder();        
    }

}

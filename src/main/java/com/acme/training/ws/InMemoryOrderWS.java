package com.acme.training.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.training.domain.CustomerOrder;
import com.acme.training.domain.CustomerOrder.Status;
import com.acme.training.service.OrderService;

@Component
@WebService
public class InMemoryOrderWS implements OrderWS {
    
    @Autowired
    private OrderService orderService;

    @WebMethod
    @Override
    public String getStatus(String orderId) {
        CustomerOrder customerOrder = orderService.findById(orderId);
        System.out.println(customerOrder);
        return customerOrder.getStatus().name();
    }

    @WebMethod
    @Override
    public void setStatus(String orderId, int statusId) {
        CustomerOrder customerOrder = orderService.findById(orderId);
        Status status = Status.values()[statusId];
        customerOrder.setStatus(status);
    }
    
    

}

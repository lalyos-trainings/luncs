package com.acme.training.ws;

public interface OrderWS {
    
    public String getStatus(String orderId);
    public void setStatus(String orderId, int statusId);
    public String getOrderContent(String orderId);

}

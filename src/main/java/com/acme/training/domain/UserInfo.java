package com.acme.training.domain;

public class UserInfo {
    private String userName;
    private int userId;
    private Address billingAddr;
    private Address deliveryAddr;
    
    public UserInfo(String userName, int userId, Address billingAddr, Address deliveryAddr) {
        this.userName = userName;
        this.userId = userId;
        this.billingAddr = billingAddr;
        this.deliveryAddr = deliveryAddr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Address getBillingAddr() {
        return billingAddr;
    }

    public void setBillingAddr(Address billingAddr) {
        this.billingAddr = billingAddr;
    }

    public Address getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(Address deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

}

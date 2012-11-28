package com.acme.training.domain;

public class Customer {
	private Address billingAddress;
	private Address deliveryAddress;
	private String name;

	public Customer(){
	    
	}
	
    public Customer( String name, String street, String city, String zip, String country ){
        this.name = name;
        this.billingAddress = new Address(street, city, zip, country);
        this.deliveryAddress = new Address(street, city, zip, country);
    }
    
    public Customer( String name ){
        this.name = name;
    }
    
    public Address getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	

}

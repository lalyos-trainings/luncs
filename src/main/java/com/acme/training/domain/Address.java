package com.acme.training.domain;

public class Address {

    private String zipCode;
    private String country;
    private String city;
    private String street;

    public Address(String zipCode, String country, String city, String street) {
        super();
        this.zipCode = zipCode;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Address(String zip, String street){
        this(zip, "Magyarország", "Budapest", street);
    }
    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        StringBuffer addressString = new StringBuffer();
        addressString.append(zipCode);
        addressString.append(" ");
        addressString.append(city);
        addressString.append(", ");
        addressString.append(street);
        return addressString.toString();
    }
    
}

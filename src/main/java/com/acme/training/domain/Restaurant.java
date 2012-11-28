package com.acme.training.domain;


public class Restaurant {

    private String name;
    private Address address;
    private Menu menu;
    private int id;

    public Restaurant(){
        super();
    }
    
    public Restaurant(String name, Address address, Menu menu) {
        super();
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public Restaurant(String name) {
        super();
        this.name = name;
    }

    public Restaurant(String name, String street, String zip) {
        super();
        this.name = name;
        this.address = new Address(zip, "Magyarország", "Budapest", street);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
//        return "Restaurant [name=" + name + ", address=" + address + ", menu=" + menu + "]";
        String formattedResti = String.format("%s\n%s", name, address.toString());
        return formattedResti;
    }

}

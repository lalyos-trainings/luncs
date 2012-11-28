package com.acme.training.ws;


public interface ShoppingCartWS {
    
    public int getShoppingCart(String customerName);
    public void addFood(int shoppingCartId, int foodId, int quantity);
    public void setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country);
    public void setBillingAddress(int shoppingCartId, String city, String street, String zip, String country);
    public String checkout(int shoppingCartId);

}

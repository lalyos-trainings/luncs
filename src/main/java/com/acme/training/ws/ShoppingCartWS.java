package com.acme.training.ws;


public interface ShoppingCartWS {
    
    public int createShoppingCart(String customerName);
    public void addFood(int shoppingCartId,int foodId, int quantity);
    public void setDeliveryAddress(int shoppingCartId, String city, String street, String zip, String country);
    public void setbillingAddress(int shoppingCartId, String city, String street, String zip, String country);
    public int checkout(int shoppingCartId);

}

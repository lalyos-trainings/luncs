package com.acme.training.service;

public interface ShoppingCartWebService {
    
    public ShoppingCart getShoppingCart(String shoppingCartName);
    public void addFood(String shoppingcartId,int food_id,int quantity);
    public void setDeliveryAddress(String shoppingcartId);
    public String doOrder(String shoppingcartId);

}

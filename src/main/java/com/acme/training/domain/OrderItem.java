package com.acme.training.domain;

public class OrderItem {

		private int quantity;
	private Food food;
	
	public OrderItem() {}
	public OrderItem(Food f, int quantity)
	{
		this.food = f;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Food getFood() {
		return food;
	}
	private void setFood(Food food) {
		this.food = food;
	}
	
	public String toString()
	{
		return String.format("%dx %s [%d]", this.quantity, this.food.getName(), this.food.getPrice() * this.quantity);
	}
}

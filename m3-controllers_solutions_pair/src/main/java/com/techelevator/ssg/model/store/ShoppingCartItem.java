package com.techelevator.ssg.model.store;

public class ShoppingCartItem {

	private Product product;
	private long quantity;
	
	public ShoppingCartItem(Product product) {
		this.product = product;
		this.quantity = 0;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}

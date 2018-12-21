package com.techelevator.ssg.model.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

	private Map<Long, ShoppingCartItem> items = new HashMap<>();

	public Map<Long, ShoppingCartItem> getShoppingCart() {
		return items;
	}
	
	public BigDecimal total() {
		double total = 0;
		for(ShoppingCartItem sci : items.values()) {
			total = sci.getProduct().getPrice().doubleValue() * sci.getQuantity();
		}
		return new BigDecimal(total);
	}
	
	public void addToCart(Product product, int quantity) {
		if (items.containsKey(product.getId())) {
			ShoppingCartItem sci = items.get(product.getId());
			sci.setQuantity(sci.getQuantity() + quantity);
		}
		else {
			ShoppingCartItem sci = new ShoppingCartItem(product);
			sci.setQuantity(quantity);
			items.put(product.getId(), sci);
		}
	}
}

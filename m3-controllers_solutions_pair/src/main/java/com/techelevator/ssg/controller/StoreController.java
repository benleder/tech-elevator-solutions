package com.techelevator.ssg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;
import com.techelevator.ssg.model.store.ShoppingCart;

@Controller
public class StoreController {

	@Autowired
	private ProductDao productDao;
	
	private final String SHOPPING_CART = "ShoppingCart";
	
	@RequestMapping("/store")
	public String displayStore(ModelMap modelMap) {
		List<Product> products = productDao.getAllProducts();
		modelMap.addAttribute("products", products);
		return "store";
	}
	
	@RequestMapping("/productDetail")
	public String displayProductDetail(@RequestParam long id,ModelMap modelMap) {
		Product product = productDao.getProductById(id);
		modelMap.addAttribute("product", product);
		return "/productDetail";
	}
	
	@RequestMapping("/shoppingCart")
	public String displayShoppingCart(HttpSession session, ModelMap modelMap) {
		modelMap.addAttribute("shoppingCart", ((ShoppingCart)session.getAttribute(SHOPPING_CART)).getShoppingCart());
		return "/shoppingCart";
	}
	
	@RequestMapping(path="/shoppingCart", method=RequestMethod.POST)
	public String addToCart(@RequestParam long id, @RequestParam int quantity, HttpSession session) {
		Product product = productDao.getProductById(id);
		ShoppingCart sc = getShoppingCart(session);
		sc.addToCart(product, quantity);
		return "redirect:/store";
	}
	
	private ShoppingCart getShoppingCart(HttpSession session) {
		ShoppingCart sc = null;
		if (session.getAttribute(SHOPPING_CART) == null) {
			sc = new ShoppingCart();
			session.setAttribute(SHOPPING_CART, sc);
		}
		else {
			sc = (ShoppingCart)session.getAttribute(SHOPPING_CART);
		}
		return sc;
	}
}
